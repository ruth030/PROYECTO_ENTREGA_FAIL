package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView btn;

    private
    EditText inputUsername, inputPassword, inputEmail, inputConformPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputUsername=findViewById(R.id.InputUsername);
        inputEmail=findViewById(R.id.InputEmail);
        inputPassword=findViewById(R.id.InputPassword);
        inputConformPassword=findViewById(R.id.InputConformPassword);
        btn=findViewById(R.id.alreadyHaveAcount);

        btnRegister=findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCrededentials();
            }
        });

        checkCrededentials();
        
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    private void checkCrededentials() {
        String username=inputUsername.getText().toString();
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String conformPasword=inputConformPassword.getText().toString();

        if (username.isEmpty() || username.length()<7 ){
            showError(inputUsername,"El Nombre de Usuario no es Valido!!!");
        }
        else if (email.isEmpty() || !email.contains("@")){
            showError(inputEmail,"El Email no es Valido!!!");
        }
        else if (password.isEmpty() || password.length()<7){
            showError(inputPassword,"La Contraseña Debe Tener 7 Caracteres");
        }
        else if (conformPasword.isEmpty() || !conformPasword.equals(password)){
            showError(inputConformPassword,"La Contraseña No Coincide!!!");
        }
        else {
            Toast.makeText(this, "Se Registro Exitosamente", Toast.LENGTH_LONG).show();
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(RegisterActivity.this,WelcomeActivity.class);
                    startActivity(i);
                }
            });
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}