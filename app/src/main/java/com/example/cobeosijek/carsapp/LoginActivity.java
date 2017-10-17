package com.example.cobeosijek.carsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        submitBTN = (Button) findViewById(R.id.submitLogin);
        emailInputET = (EditText) findViewById(R.id.emailInput);
        passwordInputET = (EditText) findViewById(R.id.passwordInput);

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
        if (!isValidEmail(email)) {
            emailInputET.setError("Invalid email");
            return;
        }
        if (password.length() < 6) {
            passwordInputET.setError("Password must contain minimum 6 characters!");
            return;
        }

        startActivity(CarsActivity.getLaunchIntent(this, email));
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
