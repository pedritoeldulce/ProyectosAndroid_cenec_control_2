package com.example.ksanchez.enapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.NumericKeyBoardTransformationMethod;
import com.example.ksanchez.enapp.pojos.Respuesta;

public class UsuarioActivity extends AppCompatActivity {

    EditText txtDni, txtNombres, txtApellidos;
    Spinner txtAula,txtCargo,txtSede;
    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        txtDni = (EditText) findViewById(R.id.txtDni);
        txtNombres = (EditText) findViewById(R.id.txtNombres);
        txtAula = (Spinner) findViewById(R.id.txtAula);

        txtSede = (Spinner) findViewById(R.id.txtSede);
        txtCargo = (Spinner) findViewById(R.id.txtCargo);


        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        txtDni.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        txtDni.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dni = txtDni.getText().toString();
                String nombres = txtNombres.getText().toString();

                String aula= txtAula.getSelectedItemPosition() + "";
                String cargo= txtCargo.getSelectedItemPosition() + "";
                String sede= txtSede.getSelectedItemPosition() + "";

                if (dni.equals("") || aula.equals("") || dni.length()!=8){
                    Toast.makeText(UsuarioActivity.this, "Debe llenar los campos y el DNI debe ser de 8 digitos", Toast.LENGTH_SHORT).show();

                } else {
                    Data data = new Data(UsuarioActivity.this);
                    data.open();
                    Respuesta respuesta = data.getRespuesta(dni);
                    if(respuesta == null){
                        respuesta = new Respuesta();
                        respuesta.setDNI(dni);
                        respuesta.setAULA(aula);
                        respuesta.setNOMBRES(nombres);
                        respuesta.setSEDE(sede);
                        respuesta.setCARGO(cargo);
                        data.insertarRespuesta(respuesta);
                        Intent intent = new Intent(UsuarioActivity.this, EvaluacionActivity.class);
                        intent.putExtra("dni",dni);
                        startActivity(intent);
                    }else{
                        Toast.makeText(UsuarioActivity.this, "USTED YA REALIZÓ LA ENCUESTA", Toast.LENGTH_SHORT).show();
                    }
                    data.close();
                }

            }
        });
    }
}
