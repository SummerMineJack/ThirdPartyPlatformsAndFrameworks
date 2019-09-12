package com.ungpay.thirdpartyplatformsandframeworks.ui.PhoneCard;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TextWatcherUtils {
    private static TextWatcherUtils textWatcherUtils;

    private TextWatcherUtils() {

    }

    public static synchronized TextWatcherUtils getInstance() {
        if (textWatcherUtils == null) {
            textWatcherUtils = new TextWatcherUtils();
        }
        return textWatcherUtils;
    }

    private boolean isSpace(int length, int contentType) {
        if (contentType == 0) {
            return isSpacePhone(length);
        } else if (contentType == 1) {
            return isSpaceCard(length);
        } else if (contentType == 2) {
            return isSpaceIDCard(length);
        }
        return false;
    }

    private boolean isSpacePhone(int length) {
        return length >= 4 && (length == 4 || (length + 1) % 5 == 0);
    }

    private boolean isSpaceCard(int length) {
        return length % 5 == 0;
    }

    private boolean isSpaceIDCard(int length) {
        return length > 6 && (length == 7 || (length - 2) % 5 == 0);
    }

    public void MobilePhoneNumberWatcher(Editable s, int start, int before, int count, int type, EditText editText, TextWatcher textWatcher) {
        if (s == null) {
            return;
        }
        //判断是否是在中间输入，需要重新计算
        boolean isMiddle = (start + count) < (s.length());
        //在末尾输入时，是否需要加入空格
        boolean isNeedSpace = false;
        if (!isMiddle && isSpace(s.length(), type)) {
            isNeedSpace = true;
        }
        if (isMiddle || isNeedSpace || count > 1) {
            String newStr = s.toString();
            newStr = newStr.replace(" ", "");
            StringBuilder sb = new StringBuilder();
            int spaceCount = 0;
            for (int i = 0; i < newStr.length(); i++) {
                sb.append(newStr.substring(i, i + 1));
                //如果当前输入的字符下一位为空格(i+1+1+spaceCount)，因为i是从0开始计算的，所以一开始的时候需要先加1
                if (isSpace(i + 2 + spaceCount, type)) {
                    sb.append(" ");
                    spaceCount += 1;
                }
            }
            editText.removeTextChangedListener(textWatcher);
            s.replace(0, s.length(), sb);
            //如果是在末尾的话,或者加入的字符个数大于零的话（输入或者粘贴）
            if (!isMiddle || count > 1) {
                if (s.length() > 0 && count == 0) {
                    int emptyPosition = editText.getSelectionEnd() - 1;
                    if (String.valueOf(s.charAt(emptyPosition)).equals(" ")) {
                        String subString = sb.substring(0, emptyPosition);
                        s.replace(0, s.length(), subString);
                    }
                }
                editText.setSelection(s.length());
            } else {
                //如果是删除
                if (count == 0) {
                    //如果删除时，光标停留在空格的前面，光标则要往前移一位
                    if (isSpace(start - before + 1, type)) {
                        editText.setSelection((start - before) > 0 ? start - before : 0);
                    } else {
                        editText.setSelection((start - before + 1) > s.length() ? s.length() : (start - before + 1));
                    }
                }
                //如果是增加
                else {
                    if (isSpace(start - before + count, type)) {
                        editText.setSelection((start + count - before + 1) < s.length() ? (start + count - before + 1) : s.length());
                    } else {
                        editText.setSelection(start + count - before);
                    }
                }
            }
            editText.addTextChangedListener(textWatcher);
        }
    }
}
