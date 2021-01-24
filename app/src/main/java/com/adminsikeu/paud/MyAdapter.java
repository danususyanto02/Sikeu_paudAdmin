package com.adminsikeu.paud;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ShowActivity activity;
    private List<Model> MList;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public MyAdapter(ShowActivity activity, List<Model> MList){
        this.activity = activity;
        this.MList = MList;
    }

    public void updateData(int position){
        Model item = MList.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("uId", item.getId());
        bundle.putString("uName", item.getNama());
        bundle.putString("uNis", item.getNis());
        bundle.putString("uTelp", item.getNotelp());
        bundle.putString("uEmail", item.getEmail());
        bundle.putString("uTghn1", item.getThgn1());
        bundle.putString("uTghn2", item.getThgn2());
        bundle.putString("uTghn3", item.getThgn3());
        bundle.putString("uTghn4", item.getThgn4());
        bundle.putString("uTghn5", item.getThgn5());
        bundle.putString("uTghn6", item.getThgn6());
        bundle.putString("uTghn7", item.getThgn7());
        bundle.putString("uTghn8", item.getThgn8());
        bundle.putString("uTghn9", item.getThgn9());
        bundle.putString("uTghn10", item.getThgn10());
        bundle.putString("uTghn11", item.getThgn11());
        bundle.putString("uTghn12", item.getThgn12());

        bundle.putString("uKdtghn1", item.getKdtgh1());
        bundle.putString("uKdtghn2", item.getKdtgh2());
        bundle.putString("uKdtghn3", item.getKdtgh3());
        bundle.putString("uKdtghn4", item.getKdtgh4());
        bundle.putString("uKdtghn5", item.getKdtgh5());
        bundle.putString("uKdtghn6", item.getKdtgh6());
        bundle.putString("uKdtghn7", item.getKdtgh7());
        bundle.putString("uKdtghn8", item.getKdtgh8());
        bundle.putString("uKdtghn9", item.getKdtgh9());
        bundle.putString("uKdtghn10", item.getKdtgh10());
        bundle.putString("uKdtghn11", item.getKdtgh11());
        bundle.putString("uKdtghn12", item.getKdtgh12());
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public void deleteData(int position){
        Model item = MList.get(position);
        db.collection("users").document(item.getId()).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
               if (task.isSuccessful()){
                   notifyRemoved(position);
                   Toast.makeText(activity, "Data berhasil terhapus", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(activity, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    private void notifyRemoved(int position){
        MList.remove(position);
        notifyItemRemoved(position);
        activity.showData();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama.setText(MList.get(position).getNama());
        holder.nis.setText(MList.get(position).getNis());
        holder.notelp.setText(MList.get(position).getNotelp());
        holder.email.setText(MList.get(position).getEmail());
        holder.tagih1.setText(MList.get(position).getThgn1());
        holder.tagih2.setText(MList.get(position).getThgn2());
        holder.tagih3.setText(MList.get(position).getThgn3());
        holder.tagih4.setText(MList.get(position).getThgn4());
        holder.tagih5.setText(MList.get(position).getThgn5());
        holder.tagih6.setText(MList.get(position).getThgn6());
        holder.tagih7.setText(MList.get(position).getThgn7());
        holder.tagih8.setText(MList.get(position).getThgn8());
        holder.tagih9.setText(MList.get(position).getThgn9());
        holder.tagih10.setText(MList.get(position).getThgn10());
        holder.tagih11.setText(MList.get(position).getThgn11());
        holder.tagih12.setText(MList.get(position).getThgn12());

        holder.kdtagih1.setText(MList.get(position).getKdtgh1());
        holder.kdtagih2.setText(MList.get(position).getKdtgh2());
        holder.kdtagih3.setText(MList.get(position).getKdtgh3());
        holder.kdtagih4.setText(MList.get(position).getKdtgh4());
        holder.kdtagih5.setText(MList.get(position).getKdtgh5());
        holder.kdtagih6.setText(MList.get(position).getKdtgh6());
        holder.kdtagih7.setText(MList.get(position).getKdtgh7());
        holder.kdtagih8.setText(MList.get(position).getKdtgh8());
        holder.kdtagih9.setText(MList.get(position).getKdtgh9());
        holder.kdtagih10.setText(MList.get(position).getKdtgh10());
        holder.kdtagih11.setText(MList.get(position).getKdtgh11());
        holder.kdtagih12.setText(MList.get(position).getKdtgh12());
    }

    @Override
    public int getItemCount() {
        return MList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama,nis,notelp,email,
                tagih1,tagih2,tagih3,tagih4,tagih5,tagih6,tagih7,tagih8,tagih9,tagih10,tagih11,tagih12,
                kdtagih1,kdtagih2,kdtagih3,kdtagih4,kdtagih5,kdtagih6,kdtagih7,kdtagih8,kdtagih9,kdtagih10,kdtagih11,kdtagih12;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            nama = itemView.findViewById(R.id.name);
            nis = itemView.findViewById(R.id.nissu);
            email = itemView.findViewById(R.id.email);
            notelp = itemView.findViewById(R.id.notelp);
            tagih1 = itemView.findViewById(R.id.tagihan1);
            tagih2 = itemView.findViewById(R.id.tagihan2);
            tagih3 = itemView.findViewById(R.id.tagihan3);
            tagih4 = itemView.findViewById(R.id.tagihan4);
            tagih5 = itemView.findViewById(R.id.tagihan5);
            tagih6 = itemView.findViewById(R.id.tagihan6);
            tagih7 = itemView.findViewById(R.id.tagihan7);
            tagih8 = itemView.findViewById(R.id.tagihan8);
            tagih9 = itemView.findViewById(R.id.tagihan9);
            tagih10 = itemView.findViewById(R.id.tagihan10);
            tagih11 = itemView.findViewById(R.id.tagihan11);
            tagih12 = itemView.findViewById(R.id.tagihan12);

            kdtagih1 = itemView.findViewById(R.id.kdtghn1);
            kdtagih2 = itemView.findViewById(R.id.kdtghn2);
            kdtagih3 = itemView.findViewById(R.id.kdtghn3);
            kdtagih4 = itemView.findViewById(R.id.kdtghn4);
            kdtagih5 = itemView.findViewById(R.id.kdtghn5);
            kdtagih6 = itemView.findViewById(R.id.kdtghn6);
            kdtagih7 = itemView.findViewById(R.id.kdtghn7);
            kdtagih8 = itemView.findViewById(R.id.kdtghn8);
            kdtagih9 = itemView.findViewById(R.id.kdtghn9);
            kdtagih10 = itemView.findViewById(R.id.kdtghn10);
            kdtagih11 = itemView.findViewById(R.id.kdtghn11);
            kdtagih12 = itemView.findViewById(R.id.kdtghn12);

        }
    }
}
