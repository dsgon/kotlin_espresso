package com.kotlin.espresso.views;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kotlin.espresso.R;
import com.kotlin.espresso.core.helper.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    EditText inputUsername = null;
    EditText inputEmail = null;
    EditText inputPassword = null;
    EditText inputConfirmPass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inputUsername   = findViewById(R.id.input_user);
        inputEmail      = findViewById(R.id.input_email);
        inputPassword   = findViewById(R.id.input_password);
        inputConfirmPass= findViewById(R.id.input_password2);

        TextView linkLogin = findViewById(R.id.link_login);
        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void registerUser(View v){
        if (validateForm()) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, ErrorMessage.GENERAL_ERROR,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private boolean validateForm(){
        return validateInputUser() && validateInputEmail()
                && validatePassword() && validateConfirmPassword() ;
    }

    private boolean validateInputUser() {
        Pattern pattern = Pattern.compile(RegExHelper.REGEX_NOT_SPECIAL_CHARS);
        Matcher matcher = pattern.matcher(inputUsername.getText().toString());
        if (TextUtils.isEmpty(inputUsername.getText())) {
            inputUsername.setError(ErrorMessage.USERNAME_EMPTY_ERROR);
            return false;
        } else if(matcher.find()){
            inputUsername.setError(ErrorMessage.USERNAME_SPECIAL_CHARS_ERROR);
            return false;
        }
        return true;
    }

    private boolean validateInputEmail(){
        if (TextUtils.isEmpty(inputEmail.getText())) {
            inputEmail.setError(ErrorMessage.EMAIL_EMPTY_ERROR);
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(inputEmail.getText().toString()).matches()) {
            inputEmail.setError(ErrorMessage.EMAIL_INVALID_ERROR);
            return false;
        }
        return true;
    }

    private boolean validatePassword(){
        if (TextUtils.isEmpty(inputPassword.getText())) {
            inputPassword.setError(ErrorMessage.PASS_EMPTY_ERROR);
            return false;
        } else if(inputPassword.getText().length() < 8) {
            inputPassword.setError(ErrorMessage.PASS_LENGTH_ERROR);
            return false;
        }
        return true;
    }

    private boolean validateConfirmPassword(){
        if (TextUtils.isEmpty(inputConfirmPass.getText())) {
            inputConfirmPass.setError(ErrorMessage.REPEAT_PASS_EMPTY_ERROR);
            return false;
        } else if(!inputConfirmPass.getText().toString().equals(inputPassword.getText().toString())){
            inputConfirmPass.setError(ErrorMessage.REPEAT_PASS_DOESNT_MATCH_ERROR);
            return false;
        }
        return true;
    }

}
