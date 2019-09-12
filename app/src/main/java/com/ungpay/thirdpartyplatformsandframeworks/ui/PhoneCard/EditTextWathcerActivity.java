package com.ungpay.thirdpartyplatformsandframeworks.ui.PhoneCard;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.R;

public class EditTextWathcerActivity extends AppCompatActivity {


    private EditText edtPhone;
    private EditText edtIdcard;
    private int start, count, before;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_wathcer);

        edtPhone = findViewById(R.id.edt_phone);
        edtIdcard = findViewById(R.id.edt_idcard);

        edtPhone.addTextChangedListener(phoneWatcher);

        edtIdcard.addTextChangedListener(BankWatcher);
    }

    TextWatcher phoneWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            EditTextWathcerActivity.this.start = i;
            EditTextWathcerActivity.this.before = i1;
            EditTextWathcerActivity.this.count = i2;

        }

        @Override
        public void afterTextChanged(Editable editable) {
            TextWatcherUtils.getInstance().MobilePhoneNumberWatcher(editable, start, before, count, 0, edtPhone, phoneWatcher);
        }
    };

    TextWatcher BankWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            EditTextWathcerActivity.this.start = i;
            EditTextWathcerActivity.this.before = i1;
            EditTextWathcerActivity.this.count = i2;
        }

        @Override
        public void afterTextChanged(Editable editable) {
            TextWatcherUtils.getInstance().MobilePhoneNumberWatcher(editable, start, before, count, 1, edtIdcard, BankWatcher);
        }
    };

}
