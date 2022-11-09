package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView btn;
    EditText inputEmail, inputPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail=findViewById(R.id.InputEmail);
        inputPassword=findViewById(R.id.InputPassword);
        btn=findViewById(R.id.textviewsignup);
        btnLogin=findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCrededentials();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,WelcomeActivity.class);
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

    }

    private void checkCrededentials() {
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();

    if (email.isEmpty() || !email.contains("@")){
            showError(inputEmail,"El Email no es Valido!!!");
        }
        else if (password.isEmpty() || password.length()<7){
            showError(inputPassword,"La Contraseña Debe Tener 7 Caracteres");
        }
        else {
            Toast.makeText(this, "Se Conecto!!! ", Toast.LENGTH_LONG).show();
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

}