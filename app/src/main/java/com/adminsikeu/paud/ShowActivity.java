package com.adminsikeu.paud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private MyAdapter adapter;
    private List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);


        ItemTouchHelper touchHelper = new ItemTouchHelper(new TouchHelper(adapter));
        touchHelper.attachToRecyclerView(recyclerView);
        showData();

    }

    public void showData() {
        db.collection("users").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for (DocumentSnapshot snapshot : task.getResult()){
                            Model model = new Model (snapshot.getString("id"), snapshot.getString("Nama"),snapshot.getString("Nis"), snapshot.getString("Email"),snapshot.getString("NoTelp"),
                                    snapshot.getString("Tagihan1"),
                                    snapshot.getString("Tagihan2"),
                                    snapshot.getString("Tagihan3"),
                                    snapshot.getString("Tagihan4"),
                                    snapshot.getString("Tagihan5"),
                                    snapshot.getString("Tagihan6"),
                                    snapshot.getString("Tagihan7"),
                                    snapshot.getString("Tagihan8"),
                                    snapshot.getString("Tagihan9"),
                                    snapshot.getString("Tagihan10"),
                                    snapshot.getString("Tagihan11"),
                                    snapshot.getString("Tagihan12"),
                                    snapshot.getString("KodeTagihan1"),
                                    snapshot.getString("KodeTagihan2"),
                                    snapshot.getString("KodeTagihan3"),
                                    snapshot.getString("KodeTagihan4"),
                                    snapshot.getString("KodeTagihan5"),
                                    snapshot.getString("KodeTagihan6"),
                                    snapshot.getString("KodeTagihan7"),
                                    snapshot.getString("KodeTagihan8"),
                                    snapshot.getString("KodeTagihan9"),
                                    snapshot.getString("KodeTagihan10"),
                                    snapshot.getString("KodeTagihan11"),
                                    snapshot.getString("KodeTagihan12")
                                    );
                            list.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ShowActivity.this, "Ooops.. Ada kesalahan", Toast.LENGTH_SHORT).show();
            }
        });

    }


}