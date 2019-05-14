package com.nikvay.sumotors.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nikvay.sumotors.R;
import com.nikvay.sumotors.ui.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText edit_login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        find_All_IDs();

        events();

    } //======= End onCreate () ============

    private void find_All_IDs() {
        edit_login_password = findViewById(R.id.edit_login_password);
        btn_login = findViewById(R.id.btn_login);
    }

    private void events() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doValidation();
            }
        });

        //============== edit text action done ================
        edit_login_password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    //do what you want on the press of 'done'
//                    btn_sign_in.performClick();
                    doValidation();
                }
                return false;
            }
        });
    }

    private void doValidation() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
        finish();
    }
}
