package com.adminsikeu.paud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotAct extends AppCompatActivity {

    private EditText masukemail;
    private Button reset;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        masukemail = findViewById(R.id.masukemail);
        reset = findViewById(R.id.reset);

        auth = FirebaseAuth.getInstance();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }
    private void resetPassword(){
        String email = masukemail.getText().toString().trim();
        if (email.isEmpty()){
            masukemail.setError("Kolom harus diisi");
            masukemail.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(forgotAct.this, "Menigirim Form Lupa Password Ke Email Anda.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(forgotAct.this, "Gagal, Coba Cek Kembali Email Anda", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}