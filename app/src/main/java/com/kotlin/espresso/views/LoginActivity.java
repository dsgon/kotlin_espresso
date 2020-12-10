package com.kotlin.espresso.views;

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
import com.kotlin.espresso.core.helper.ErrorMessage;


public class LoginActivity extends AppCompatActivity {

    EditText inputEmail;
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail      = findViewById(R.id.input_email);
        inputPassword   = findViewById(R.id.input_password);

        TextView registerOption = (TextView) findViewById(R.id.link_register);

        registerOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
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

    private boolean validateForm(){
        return validateInputEmail() && validatePassword();
    }

    public void login(View v){
        if (validateForm()){
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        } else {
           Toast.makeText(this,ErrorMessage.LOGIN_ERROR,Toast.LENGTH_LONG).show();
        }
    }
}
