package com.example.cobeosijek.carsapp.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cobeosijek.carsapp.car_showroom.CarsActivity;
import com.example.cobeosijek.carsapp.R;
import com.example.cobeosijek.carsapp.utilities.StringUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button submitBTN;
    EditText emailInputET;
    EditText passwordInputET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUI();
    }

    private void setUI() {
        submitBTN = findViewById(R.id.submitLogin);
        emailInputET = findViewById(R.id.emailInput);
        passwordInputET = findViewById(R.id.passwordInput);

        submitBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitLogin:
                checkUserInput(emailInputET.getText().toString().trim(), passwordInputET.getText().toString().trim());
                break;
        }
    }

    private void checkUserInput(String email, String password) {
        if (!StringUtils.isValidEmail(email)) {
            emailInputET.setError(getString(R.string.login_email_error_text));
            return;
        }
        if (password.length() < 6) {
            passwordInputET.setError(getString(R.string.login_password_error_text));
            return;
        }

        emailInputET.getText().clear();
        passwordInputET.getText().clear();
        startActivity(CarsActivity.getLaunchIntent(this, email));
    }
}
