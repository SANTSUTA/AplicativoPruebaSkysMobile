package com.example.aplicativoskysmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import com.example.aplicativoskysmobile.databinding.VityresumenusuariosBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class vityresumenusuarios extends AppCompatActivity {
    private VityresumenusuariosBinding binding;
    private FirebaseFirestore mFirestore;
    private ArrayList<modelrecview> datalist;
    private adapterrecview adapter;
    private CustomProgressDialog customdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=VityresumenusuariosBinding.inflate(getLayoutInflater());
        View vista=binding.getRoot();
        setContentView(vista);
        mtd_ini();
        customdialog.show();
        customdialog.updateText("Cargando");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mtdgetresumen_usuarios();
                mtdini_recview();
                mtddatos_recview();
                mtd_otros();
                customdialog.dismiss();
            }
        },1000);

    }
    private void mtd_ini(){
        mFirestore=FirebaseFirestore.getInstance();
        customdialog=new CustomProgressDialog(vityresumenusuarios.this);
    }
    private void mtdgetresumen_usuarios(){
        mFirestore.collection("resumen-de-usuarios").document("resumen").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    String varadmin=task.getResult().getString("Admin");
                    String varacomerciales=task.getResult().getString("Asesores Comerciales");
                    String varacliente=task.getResult().getString("Asesores Cliente");
                    String varuserplataforma=task.getResult().getString("Usuarios Plataforma");
                    binding.txtviewadmin.setText(varadmin);
                    binding.txtviewasesorcomercial.setText(varacomerciales);
                    binding.txtviewasesorcliente.setText(varacliente);
                    binding.txtviewusuariosplaforma.setText(varuserplataforma);
                }else{
                    Toast.makeText(vityresumenusuarios.this, "Error#", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void mtdini_recview(){
        binding.recview.setLayoutManager(new LinearLayoutManager(vityresumenusuarios.this));
        datalist=new ArrayList<>();
        adapter=new adapterrecview(datalist, vityresumenusuarios.this);
        binding.recview.setAdapter(adapter);
    }
    private void mtddatos_recview(){
        mFirestore.collection("usuarios").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    List<DocumentSnapshot> documents=task.getResult().getDocuments();
                    for(DocumentSnapshot d:documents){
                        modelrecview obj=d.toObject(modelrecview.class);
                        datalist.add(obj);
                    }
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(vityresumenusuarios.this, "Error#", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void mtd_otros(){
        binding.btonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}