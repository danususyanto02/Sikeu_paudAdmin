package com.adminsikeu.paud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

public class regis extends AppCompatActivity {
    private static final String TAG = "Taskssample";
    EditText userEmail,userName,noHp,userPassword;
    Button btn_daftar;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;

    //Deklarasi Variable [Hidepassword]
    private EditText PassInput;
    private CheckBox ShowPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        userEmail = findViewById(R.id.userEmail);
        userName = findViewById(R.id.userName);
        noHp = findViewById(R.id.noHp);
        btn_daftar = findViewById(R.id.btn_daftar);
        userPassword = findViewById(R.id.userPassword);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        //[HidePassword]
        PassInput = findViewById(R.id.userPassword);
        ShowPass = findViewById(R.id.showPass);


        //Set onClickListener, untuk menangani kejadian saat Checkbox diklik [Hidepassword]
        ShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ShowPass.isChecked()){
                    //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan [Hidepassword]
                    PassInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    //Jika tidak, maka password akan di sembuyikan [Hidepassword]
                    PassInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = userEmail.getText().toString().trim();
                String password = userPassword.getText().toString().trim();
                final String namapanjang = userName.getText().toString().trim();
                final String nohape = noHp.getText().toString().trim();


                if (TextUtils.isEmpty(email)){
                    userEmail.setError("Harap Masukkan Email");
                }
                if (TextUtils.isEmpty(password)){
                    userPassword.setError("Harap Masukkan Password");
                }
                if (password.length()<6){
                    userPassword.setError("Password Harus Lebih Dari 6 Karakter");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(regis.this, "User Baru Berhasil Terinput", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("admins").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("id",userID);
                            user.put("Password",password);
                            user.put("Nama",namapanjang);
                            user.put("NoTelp",nohape);
                            user.put("Email",email);

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "Berhasil mendaftar akun baru " + userID);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        }
                        else {
                            Toast.makeText(regis.this, "Gagal Membuat User Baru" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
    }
}