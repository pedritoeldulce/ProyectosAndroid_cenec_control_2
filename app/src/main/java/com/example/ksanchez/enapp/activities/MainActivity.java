package com.example.ksanchez.enapp.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.NumericKeyBoardTransformationMethod;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.pojos.Respuesta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static android.os.Environment.getExternalStorageDirectory;

public class MainActivity extends AppCompatActivity {

    EditText txtToken;
    Button btnIngresar;


    private final static int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private static String[] PERMISOS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtToken = (EditText) findViewById(R.id.txtToken);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        FileInputStream fis = null;

        txtToken.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        txtToken.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        permisos();

        try {
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "CENEC_CONTROL_2");

            File file = new File(nuevaCarpeta, "xfs088.xml");
            FileInputStream fileInputStream = new FileInputStream(file);
            fis = new FileInputStream(file);
            mostrarMensaje("Ya se dió una prueba en esta tablet");
        } catch (IOException e) {
            e.printStackTrace();
            //Toast.makeText(MainActivity.this, "Ya se dió una prueba en esta tablet", Toast.LENGTH_SHORT).show();


        }

        Data data = new Data(MainActivity.this);
        data.open();


        if ( data.consultarregistro()){
            btnIngresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String token = txtToken.getText().toString();

                    if(!token.equals("")){
                        if(token.equals("0o28zrq2")){
                            Intent intent = new Intent(MainActivity.this, UsuarioActivity.class);
                            startActivity(intent);
                            finish();
                        }else Toast.makeText(MainActivity.this, "Token incorrecto", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(MainActivity.this, "Debe indicar token", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            Toast.makeText(MainActivity.this, "Ya se dió una prueba en esta tablet", Toast.LENGTH_SHORT).show();
        }
        data.close();

    }


    private void permisos(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(permissionCheck!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this, PERMISOS,MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        String mensaje = "";

        if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            mensaje = "Permiso Concedido";
        }else{
            mensaje="Permiso Denegado";
        }
        toast = Toast.makeText(this, mensaje, Toast.LENGTH_LONG);
        toast.show();
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                dialog.dismiss();
                finish();
            }
        });
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    }


