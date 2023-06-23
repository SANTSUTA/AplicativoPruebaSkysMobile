package com.example.aplicativoskysmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;


public class CustomProgressDialog extends ProgressDialog {

    private TextView txtmessage;


    public CustomProgressDialog(Context context) {
        super(context);
        setCancelable(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customdialog);
        getWindow().setBackgroundDrawableResource(R.drawable.customdialogcorners);
        txtmessage=findViewById(R.id.txtviewcustomdialog);
    }

    public void updateText(String text) {
        txtmessage.setText(text);
    }

    public void updateProgress(int progress) {
        // Actualiza el progreso del ProgressDialog
    }

    public void show() {
        super.show();
    }
}
