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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_wathcer);
        edtPhone = findViewById(R.id.edt_phone);
        edtIdcard = findViewById(R.id.edt_idcard);
        edtIdcard.addTextChangedListener(cardWatcher);
        edtPhone.addTextChangedListener(phoneWatcher);
    }

    TextWatcher phoneWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int length = s.toString().length();
            StringBuilder stringBuilder = new StringBuilder();
            if (count == 0) {

            } else if (count == 1) {
                for (int i = 0; i < length; i++) {
                    if (i != 3 && i != 8 && s.charAt(i) == ' ') {
                        continue;
                    } else {
                        stringBuilder.append(s.charAt(i));
                        if ((stringBuilder.length() == 4 || stringBuilder.length() == 9)
                                && stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                            stringBuilder.insert(stringBuilder.length() - 1, ' ');
                        }
                    }
                }
            }
            edtPhone.setText(stringBuilder.toString());
            edtPhone.setSelection(edtPhone.getText().toString().length());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    TextWatcher cardWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
