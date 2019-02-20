package com.example.permisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCAMARA).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
        {
            //Toast.makeText(this, "No tiene permiso", Toast.LENGTH_SHORT).show();
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA))/*si el permiso fue cancelado anteriormente*/
            {
                Toast.makeText(this, "Necesitas asignar permisos", Toast.LENGTH_SHORT).show();
                String[] ListaPermisos = new String[]{Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(this,ListaPermisos, 1);
            }

           else{
                String[] ListaPermisos = new String[]{Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(this,ListaPermisos, 1);
            }//id de la ventana


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {//las respuestas
        switch (requestCode)
        {
            case 1:
                if (grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){

                }
                break;

        }
    }

    public void onClick2(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
        {
            //Toast.makeText(this, "No tiene permiso", Toast.LENGTH_SHORT).show();
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA))/*si el permiso fue cancelado anteriormente*/
            {
                Toast.makeText(this, "Necesitas asignar permisos", Toast.LENGTH_SHORT).show();
            }

            String[] ListaPermisos = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(this,ListaPermisos, 2);//id de la ventana


        }


    }

    //android.media.action.IMAGE_CPATURE
}
