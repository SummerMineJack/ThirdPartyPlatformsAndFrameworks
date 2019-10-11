
package com.ungpay.thirdpartyplatformsandframeworks.ui.customKeyBoard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.ungpay.ungpayapp.R;


/**
 * 自定义Verification验证码View
 * Create by HuangJian on 2019/9/5
 */
public class VerificationCodeInput extends ViewGroup {

    private final static String TYPE_NUMBER = "number";
    private final static String TYPE_TEXT = "text";
    private final static String TYPE_PASSWORD = "password";
    private final static String TYPE_PHONE = "phone";
    private final static String TYPE_NUMBER_PASSWORD = "numberPassword";

    private static final String TAG = "VerificationCodeInput";
    private int box = 4;
    private int boxWidth = 120;
    private int textSize;
    private int boxHeight = 120;
    private int childHPadding = 14;
    private int childVPadding = 14;
    private String inputType = TYPE_PASSWORD;
    private Drawable boxBgFocus = null;
    private Drawable boxBgNormal = null;
    private Listener listener;


    public VerificationCodeInput(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.vericationCodeInput);
        box = a.getInt(R.styleable.vericationCodeInput_box, 4);

        childHPadding = (int) a.getDimension(R.styleable.vericationCodeInput_child_h_padding, 0);
        childVPadding = (int) a.getDimension(R.styleable.vericationCodeInput_child_v_padding, 0);
        textSize = (int) a.getDimension(R.styleable.vericationCodeInput_text_size, 10);
        boxBgFocus = a.getDrawable(R.styleable.vericationCodeInput_box_bg_focus);
        boxBgNormal = a.getDrawable(R.styleable.vericationCodeInput_box_bg_normal);
        inputType = a.getString(R.styleable.vericationCodeInput_inputType);
        boxWidth = (int) a.getDimension(R.styleable.vericationCodeInput_child_width, boxWidth);
        boxHeight = (int) a.getDimension(R.styleable.vericationCodeInput_child_height, boxHeight);
        initViews();

    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.e("~~~dispatchKeyEvent", " event:" + event.getKeyCode());
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private void initViews() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                } else {
                    focus();
                    checkAndCommit();
                }

            }

        };

        OnKeyListener onKeyListener = new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.e("~~~", "keyCode:" + keyCode + " event:" + event.getKeyCode());
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    backFocus();
                }
                return false;
            }
        };
        for (int i = 0; i < box; i++) {
            EditText editText = new EditText(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(boxWidth, boxHeight);
            layoutParams.bottomMargin = childVPadding;
            layoutParams.topMargin = childVPadding;
            layoutParams.leftMargin = childHPadding;
            layoutParams.rightMargin = childHPadding;
            layoutParams.gravity = Gravity.CENTER;
            if (i == 0) {
                editText.requestFocus();
                KeyboardUtils.showSoftInput(editText);
            }
            setBg(editText, false);
            editText.setTextColor(Color.BLACK);
            editText.setLayoutParams(layoutParams);
            editText.setGravity(Gravity.CENTER);
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            if (TYPE_NUMBER.equals(inputType)) {
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            } else if (TYPE_PASSWORD.equals(inputType)) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else if (TYPE_TEXT.equals(inputType)) {
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
            } else if (TYPE_PHONE.equals(inputType)) {
                editText.setInputType(InputType.TYPE_CLASS_PHONE);
            } else if (TYPE_NUMBER_PASSWORD.equals(inputType)) {
                editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD );
            }
            editText.setTextColor(getResources().getColor(R.color.registe_success_btn_text_color_pressed));
            editText.setTextSize(24);
            editText.setId(i);
            editText.setEms(1);
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.addTextChangedListener(textWatcher);
            editText.setOnKeyListener(onKeyListener);
            addView(editText, i);
        }
    }

    /**
     * 输错验证码进行清空EditText并初始化
     */
    public void clearEditText() {
        int count = getChildCount();
        EditText editText;
        for (int i = count - 1; i >= 0; i--) {
            editText = (EditText) getChildAt(i);
            editText.getText().clear();
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.setEnabled(true);
            editText.requestFocus();
        }
    }

    /**
     * 点击删除键的操作
     */
    private void backFocus() {
        int count = getChildCount();
        EditText editText;
        for (int i = count - 1; i >= 0; i--) {
            editText = (EditText) getChildAt(i);
            if (editText.getText().length() == 1) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.setEnabled(true);
                editText.requestFocus();
                editText.setSelection(1);
                return;
            }
        }
    }

    /**
     * 每输入完一个验证码数字就设置一下
     */
    private void focus() {
        int count = getChildCount();
        EditText editText;
        for (int i = 0; i < count; i++) {
            editText = (EditText) getChildAt(i);
            String content = editText.getText().toString();
            if (content.length() == 0) {
                editText.requestFocus();
                return;
            } else {
                editText.setFocusable(false);
                editText.setFocusableInTouchMode(false);
            }

        }
    }

    private void setBg(EditText editText, boolean focus) {
        if (boxBgNormal != null && !focus) {
            editText.setBackground(boxBgNormal);
        } else if (boxBgFocus != null && focus) {
            editText.setBackground(boxBgFocus);
        }
    }

    /**
     * 第六位验证码输入完成后的提交
     */
    private void checkAndCommit() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean full = true;
        for (int i = 0; i < box; i++) {
            EditText editText = (EditText) getChildAt(i);
            String content = editText.getText().toString();
            if (content.length() == 0) {
                full = false;
                break;
            } else {
                stringBuilder.append(content);
            }

        }
        if (full) {
            if (listener != null) {
                listener.onComplete(stringBuilder.toString());
                setEnabled(false);
            }
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            child.setEnabled(enabled);
        }
    }

    public void setOnCompleteListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LinearLayout.LayoutParams(getContext(), attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int parentWidth = getLayoutParams().width;
        if (parentWidth == LayoutParams.MATCH_PARENT) {
            parentWidth = ScreenUtils.getScreenWidth();
        }
        Log.d(getClass().getName(), "onMeasure width " + parentWidth);

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            this.measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
        if (count > 0) {
            View child = getChildAt(0);
            int cWidth = child.getMeasuredWidth();
            if (parentWidth != LayoutParams.WRAP_CONTENT) {
                // 重新计算padding
                childHPadding = (parentWidth - cWidth * count) / (count + 1);
            }

            int cHeight = child.getMeasuredHeight();

            int maxH = cHeight + 2 * childVPadding;
            int maxW = (cWidth) * count + childHPadding * (count + 1);
            setMeasuredDimension(resolveSize(maxW, widthMeasureSpec),
                    resolveSize(maxH, heightMeasureSpec));
        }


    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d(getClass().getName(), "onLayout width = " + getMeasuredWidth());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            child.setVisibility(View.VISIBLE);
            int cWidth = child.getMeasuredWidth();
            int cHeight = child.getMeasuredHeight();
            int cl = childHPadding + (i) * (cWidth + childHPadding);
            int cr = cl + cWidth;
            int ct = childVPadding;
            int cb = ct + cHeight;
            child.layout(cl, ct, cr, cb);
        }
    }

    public interface Listener {
        void onComplete(String content);
    }

}

