package com.example.aplicativoskysmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class adapterrecview extends RecyclerView.Adapter<adapterrecview.myviewholder> {
    private ArrayList<modelrecview> datalist;
    private Context context;

    public adapterrecview(ArrayList<modelrecview> datalist, Context context){
        this.datalist=datalist;
        this.context=context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_listausuariosactivos, parent, false);
        return new myviewholder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        String urluser=datalist.get(position).getUrluser();
        if(!urluser.equals("vacio")){
            Glide.with(context).load(urluser).centerCrop().into(holder.circleview);
        }else{
            Glide.with(context).load(R.drawable.img).centerCrop().into(holder.circleview);
        }
        holder.nameuser.setText(datalist.get(position).getNameuser());
        holder.tipouser.setText(datalist.get(position).getTipouser());
        holder.ultconexion.setText(datalist.get(position).getUltconexion());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    static class myviewholder extends RecyclerView.ViewHolder{
        private CircleImageView circleview;
        private TextView nameuser, tipouser, ultconexion;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            circleview=itemView.findViewById(R.id.circleviewsinglerow);
            nameuser=itemView.findViewById(R.id.txtviewnamesinglerow);
            tipouser=itemView.findViewById(R.id.txtviewtipousersinglerow);
            ultconexion=itemView.findViewById(R.id.txtviewultconexionsinglerow);
        }
    }
}
