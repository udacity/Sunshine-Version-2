package com.example.android.sunshine.app.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.sunshine.app.R;

/**
 * Created by sergey on 05.07.15.
 */
public class LocationEditTextPreference extends EditTextPreference {

    private static final int DEFAULT_MIN_LENGTH = 3;
    private int mMinLength = 0;

    public LocationEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LocationEditTextPreference, 0, 0);
        try {
            mMinLength = a.getInteger(R.styleable.LocationEditTextPreference_minLength, DEFAULT_MIN_LENGTH);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);
        final EditText editText = getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Dialog dialog = getDialog();
                if (dialog instanceof AlertDialog) {
                    Button okButton = ((AlertDialog) dialog).getButton(Dialog.BUTTON_POSITIVE);
                    okButton.setEnabled(s.toString().length() >= mMinLength);
                }
            }
        });
    }
}
