package com.adminsikeu.paud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Nullable;


public class MainActivity extends AppCompatActivity {

    private EditText mNama,mNis,mEmail,mNotelp,
            mTgn1,mTgn2,mTgn3,mTgn4,mTgn5,mTgn6,mTgn7,mTgn8,mTgn9,mTgn10,mTgn11,mTgn12,
            mKdtghn1,mKdtghn2,mKdtghn3,mKdtghn4,mKdtghn5,mKdtghn6,mKdtghn7,mKdtghn8,mKdtghn9,mKdtghn10,mKdtghn11,mKdtghn12;
    private Button show,save;
    private FirebaseFirestore db;
    private String uId,uName,uNis,uTelp,uEmail,uTghn1,uTghn2,uTghn3,uTghn4,uTghn5,uTghn6,uTghn7,uTghn8,uTghn9,uTghn10,uTghn11,uTghn12,uKdtghn1,uKdtghn2,uKdtghn3,uKdtghn4,uKdtghn5,uKdtghn6,uKdtghn7,uKdtghn8,uKdtghn9,uKdtghn10,uKdtghn11,uKdtghn12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //layout
        mNama =findViewById(R.id.edit_nama);
        mNis = findViewById(R.id.edit_nis);
        mEmail = findViewById(R.id.edit_email);
        mNotelp = findViewById(R.id.edit_telp);
        save = findViewById(R.id.save);
        show = findViewById(R.id.show);

        //Tagihan
        mTgn1 =findViewById(R.id.tagn1);
        mTgn2 =findViewById(R.id.tagn2);
        mTgn3 =findViewById(R.id.tagn3);
        mTgn4 =findViewById(R.id.tagn4);
        mTgn5 =findViewById(R.id.tagn5);
        mTgn6 =findViewById(R.id.tagn6);
        mTgn7 =findViewById(R.id.tagn7);
        mTgn8 =findViewById(R.id.tagn8);
        mTgn9 =findViewById(R.id.tagn9);
        mTgn10 =findViewById(R.id.tagn10);
        mTgn11 =findViewById(R.id.tagn11);
        mTgn12 =findViewById(R.id.tagn12);

        //Kode tagihan
        mKdtghn1 =findViewById(R.id.kd_tghn1);
        mKdtghn2 =findViewById(R.id.kd_tghn2);
        mKdtghn3 =findViewById(R.id.kd_tghn3);
        mKdtghn4 =findViewById(R.id.kd_tghn4);
        mKdtghn5 =findViewById(R.id.kd_tghn5);
        mKdtghn6 =findViewById(R.id.kd_tghn6);
        mKdtghn7 =findViewById(R.id.kd_tghn7);
        mKdtghn8 =findViewById(R.id.kd_tghn8);
        mKdtghn9 =findViewById(R.id.kd_tghn9);
        mKdtghn10 =findViewById(R.id.kd_tghn10);
        mKdtghn11 =findViewById(R.id.kd_tghn11);
        mKdtghn12 =findViewById(R.id.kd_tghn12);


        db = FirebaseFirestore.getInstance();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            save.setText("Update");
            uName = bundle.getString("uName");
            uId = bundle.getString("uId");
            uNis = bundle.getString("uNis");
            uTelp = bundle.getString("uTelp");
            uEmail = bundle.getString("uEmail");
            uTghn1 = bundle.getString("uTghn1");
            uTghn2 = bundle.getString("uTghn2");
            uTghn3 = bundle.getString("uTghn3");
            uTghn4 = bundle.getString("uTghn4");
            uTghn5 = bundle.getString("uTghn5");
            uTghn6 = bundle.getString("uTghn6");
            uTghn7 = bundle.getString("uTghn7");
            uTghn8 = bundle.getString("uTghn8");
            uTghn9 = bundle.getString("uTghn9");
            uTghn10 = bundle.getString("uTghn10");
            uTghn11 = bundle.getString("uTghn11");
            uTghn12 = bundle.getString("uTghn12");

            uKdtghn1 = bundle.getString("uKdtghn1");
            uKdtghn2 = bundle.getString("uKdtghn2");
            uKdtghn3 = bundle.getString("uKdtghn3");
            uKdtghn4 = bundle.getString("uKdtghn4");
            uKdtghn5 = bundle.getString("uKdtghn5");
            uKdtghn6 = bundle.getString("uKdtghn6");
            uKdtghn7 = bundle.getString("uKdtghn7");
            uKdtghn8 = bundle.getString("uKdtghn8");
            uKdtghn9 = bundle.getString("uKdtghn9");
            uKdtghn10 = bundle.getString("uKdtghn10");
            uKdtghn11 = bundle.getString("uKdtghn11");
            uKdtghn12 = bundle.getString("uKdtghn12");

            mNama.setText(uName);
            mNis.setText(uNis);
            mNotelp.setText(uTelp);
            mEmail.setText(uEmail);

            //Tagihan
            mTgn1.setText(uTghn1);
            mTgn2.setText(uTghn2);
            mTgn3.setText(uTghn3);
            mTgn4.setText(uTghn4);
            mTgn5.setText(uTghn5);
            mTgn6.setText(uTghn6);
            mTgn7.setText(uTghn7);
            mTgn8.setText(uTghn8);
            mTgn9.setText(uTghn9);
            mTgn10.setText(uTghn10);
            mTgn11.setText(uTghn11);
            mTgn12.setText(uTghn12);

            //KodeTagihan
            mKdtghn1.setText(uKdtghn1);
            mKdtghn2.setText(uKdtghn2);
            mKdtghn3.setText(uKdtghn3);
            mKdtghn4.setText(uKdtghn4);
            mKdtghn5.setText(uKdtghn5);
            mKdtghn6.setText(uKdtghn6);
            mKdtghn7.setText(uKdtghn7);
            mKdtghn8.setText(uKdtghn8);
            mKdtghn9.setText(uKdtghn9);
            mKdtghn10.setText(uKdtghn10);
            mKdtghn11.setText(uKdtghn11);
            mKdtghn12.setText(uKdtghn12);


        }else{
            save.setText("Save");
        }

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShowActivity.class));
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = mNama.getText().toString();
                String nis = mNis.getText().toString();
                String notelp = mNotelp.getText().toString();
                String email = mEmail.getText().toString();
                String tagihannn1 = mTgn1.getText().toString();
                String tagihannn2 = mTgn2.getText().toString();
                String tagihannn3 = mTgn3.getText().toString();
                String tagihannn4 = mTgn4.getText().toString();
                String tagihannn5 = mTgn5.getText().toString();
                String tagihannn6 = mTgn6.getText().toString();
                String tagihannn7 = mTgn7.getText().toString();
                String tagihannn8 = mTgn8.getText().toString();
                String tagihannn9 = mTgn9.getText().toString();
                String tagihannn10 = mTgn10.getText().toString();
                String tagihannn11= mTgn11.getText().toString();
                String tagihannn12 = mTgn12.getText().toString();

                String kodetagihan1 = mKdtghn1.getText().toString();
                String kodetagihan2 = mKdtghn2.getText().toString();
                String kodetagihan3 = mKdtghn3.getText().toString();
                String kodetagihan4 = mKdtghn4.getText().toString();
                String kodetagihan5 = mKdtghn5.getText().toString();
                String kodetagihan6 = mKdtghn6.getText().toString();
                String kodetagihan7 = mKdtghn7.getText().toString();
                String kodetagihan8 = mKdtghn8.getText().toString();
                String kodetagihan9 = mKdtghn9.getText().toString();
                String kodetagihan10 = mKdtghn10.getText().toString();
                String kodetagihan11 = mKdtghn11.getText().toString();
                String kodetagihan12 = mKdtghn12.getText().toString();


                Bundle bundle1 = getIntent().getExtras();
                if (bundle1 != null){
                    String id = uId;
                    updateToFirestore(id,nama,nis,notelp,email,
                            tagihannn1, tagihannn2,tagihannn3,tagihannn4,tagihannn5,tagihannn6,tagihannn7,tagihannn8,tagihannn9,tagihannn10,tagihannn11,tagihannn12,
                            kodetagihan1,kodetagihan2,kodetagihan3,kodetagihan4,kodetagihan5,kodetagihan6,kodetagihan7,kodetagihan8,kodetagihan9,kodetagihan10,kodetagihan11,kodetagihan12);
                }else{
                    String id = UUID.randomUUID().toString();
                    saveToFireStore(id,nama,nis, notelp,email,tagihannn1, tagihannn2,tagihannn3,tagihannn4,tagihannn5,tagihannn6,tagihannn7,tagihannn8,tagihannn9,tagihannn10,tagihannn11,tagihannn12,
                            kodetagihan1,kodetagihan2,kodetagihan3,kodetagihan4,kodetagihan5,kodetagihan6,kodetagihan7,kodetagihan8,kodetagihan9,kodetagihan10,kodetagihan11,kodetagihan12);
                }

            }
        });
    }

    private void updateToFirestore(String id, String name, String ni,String notelp,String email,
                                   String tagihannn1,String tagihannn2,String tagihannn3,String tagihannn4,String tagihannn5,String tagihannn6,String tagihannn7,String tagihannn8,String tagihannn9,String tagihannn10,String tagihannn11,String tagihannn12,
                                   String kodetagihan1,String kodetagihan2,String kodetagihan3,String kodetagihan4,String kodetagihan5,String kodetagihan6,String kodetagihan7,String kodetagihan8,String kodetagihan9,String kodetagihan10,String kodetagihan11,String kodetagihan12) {
        db.collection("users").document(id).update("Nama" , name , "Nis" , ni,"Email",email,"NoTelp",notelp,
                "Tagihan1",tagihannn1,
                "Tagihan2",tagihannn2,
                "Tagihan3",tagihannn3,
                "Tagihan4",tagihannn4,
                "Tagihan5",tagihannn5,
                "Tagihan6",tagihannn6,
                "Tagihan7",tagihannn7,
                "Tagihan8",tagihannn8,
                "Tagihan9",tagihannn9,
                "Tagihan10",tagihannn10,
                "Tagihan11",tagihannn11,
                "Tagihan12",tagihannn12,

                "KodeTagihan1",kodetagihan1,
                "KodeTagihan2",kodetagihan2,
                "KodeTagihan3",kodetagihan3,
                "KodeTagihan4",kodetagihan4,
                "KodeTagihan5",kodetagihan5,
                "KodeTagihan6",kodetagihan6,
                "KodeTagihan7",kodetagihan7,
                "KodeTagihan8",kodetagihan8,
                "KodeTagihan9",kodetagihan9,
                "KodeTagihan10",kodetagihan10,
                "KodeTagihan11",kodetagihan11,
                "KodeTagihan12",kodetagihan12)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Data Terupdate", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Error : " +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveToFireStore(String id, String nama, String nis,String notelp,String email,
                                 String tagihannn1,String tagihannn2,String tagihannn3,String tagihannn4,String tagihannn5,String tagihannn6,String tagihannn7,String tagihannn8,String tagihannn9,String tagihannn10,String tagihannn11,String tagihannn12,
                                 String kodetagihan1,String kodetagihan2,String kodetagihan3,String kodetagihan4,String kodetagihan5,String kodetagihan6,String kodetagihan7,String kodetagihan8,String kodetagihan9,String kodetagihan10,String kodetagihan11,String kodetagihan12) {
        if (!nama.isEmpty() && !nis.isEmpty()){
            HashMap<String,Object> map = new HashMap<>();
            map.put("id",id);
            map.put("Nama",nama);
            map.put("Nis",nis);
            map.put("Email",email);
            map.put("NoTelp",notelp);
            map.put("Tagihan1",tagihannn1);
            map.put("Tagihan2",tagihannn2);
            map.put("Tagihan3",tagihannn3);
            map.put("Tagihan4",tagihannn4);
            map.put("Tagihan5",tagihannn5);
            map.put("Tagihan6",tagihannn6);
            map.put("Tagihan7",tagihannn7);
            map.put("Tagihan8",tagihannn8);
            map.put("Tagihan9",tagihannn9);
            map.put("Tagihan10",tagihannn10);
            map.put("Tagihan11",tagihannn11);
            map.put("Tagihan12",tagihannn12);

            map.put("KodeTagihan1",kodetagihan1);
            map.put("KodeTagihan2",kodetagihan2);
            map.put("KodeTagihan3",kodetagihan3);
            map.put("KodeTagihan4",kodetagihan4);
            map.put("KodeTagihan5",kodetagihan5);
            map.put("KodeTagihan6",kodetagihan6);
            map.put("KodeTagihan7",kodetagihan7);
            map.put("KodeTagihan8",kodetagihan8);
            map.put("KodeTagihan9",kodetagihan9);
            map.put("KodeTagihan10",kodetagihan10);
            map.put("KodeTagihan11",kodetagihan11);
            map.put("KodeTagihan12",kodetagihan12);


            db.collection("users").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "Data Gagal Tersimpan", Toast.LENGTH_SHORT).show();
                }
            });


        }else
            Toast.makeText(this, "Semua form wajib diisi", Toast.LENGTH_SHORT).show();
    }
}