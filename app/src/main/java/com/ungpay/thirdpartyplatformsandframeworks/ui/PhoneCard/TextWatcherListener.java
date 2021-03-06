package com.ungpay.thirdpartyplatformsandframeworks.ui.PhoneCard;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TextWatcherListener {
    private EditText editText;

    private TextWatcher watcher;

    private static final int TEXT_WATCHER_STATES = 1;
    public static final String TEXT_WATCHER_PHONE = "phoneNum";
    public static final String TEXT_WATCHER_IDCARD = "idCard";

    public TextWatcherListener(String state, EditText editText) {
        this.editText = editText;
        if (TEXT_WATCHER_PHONE.equals(state)) {
            watcher = phoneWatcher;
        }
        if (TEXT_WATCHER_IDCARD.equals(state)) {
            watcher = idCardWatcher;
        }
        editText.addTextChangedListener(watcher);
    }

    TextWatcher phoneWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (count == TEXT_WATCHER_STATES) {
                int textLength = s.toString().length();
                if (textLength == 3 || textLength == 8) {
                    editText.setText(s + " ");
                    editText.setSelection(editText.getText().toString().length());
                }
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    TextWatcher idCardWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (count == TEXT_WATCHER_STATES) {
                int textLength = s.toString().length();
                if (textLength == 4 || textLength == 9 || textLength == 14 || textLength == 18) {
                    editText.setText(s + " ");
                    editText.setSelection(editText.getText().toString().length());
                }
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
