package com.example.ksanchez.enapp.fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ksanchez.enapp.R;

import com.example.ksanchez.enapp.BaseDatosTemporal;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;


/**
 * A simple {@link Fragment} subclass.
 */
public class eval1_p1 extends Fragment {


    RadioGroup rgP1;
    RadioGroup rgP2;
    RadioGroup rgP3;
    RadioGroup rgP4;
    RadioGroup rgP5;

    Context contexto;
    String dni;

    private String P1;
    private String P2;
    private String P3;
    private String P4;
    private String P5;

    public eval1_p1() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public eval1_p1(Context contexto, String dni) {
        this.contexto = contexto;
        this.dni = dni;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_eval1_p1, container, false);

        rgP1 = (RadioGroup) rootView.findViewById(R.id.ev1_p1_rg1);
        rgP2 = (RadioGroup) rootView.findViewById(R.id.ev1_p2_rg1);
        rgP3 = (RadioGroup) rootView.findViewById(R.id.ev1_p3_rg1);
        rgP4 = (RadioGroup) rootView.findViewById(R.id.ev1_p4_rg1);
        rgP5 = (RadioGroup) rootView.findViewById(R.id.ev1_p5_rg1);

        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
    }

    public void cargarDatos(){
        Data data =  new Data(contexto);
        data.open();
        Respuesta respuesta =  data.getRespuesta(dni);
        data.close();


        if(respuesta != null){
            if (!respuesta.getP1().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP1());
                ((RadioButton) rgP1.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP2().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP2());
                ((RadioButton) rgP2.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP3().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP3());
                ((RadioButton) rgP3.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP4().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP4());
                ((RadioButton) rgP4.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP5().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5());
                ((RadioButton) rgP5.getChildAt(childPos)).setChecked(true);
            }
        }
        
    }


    public boolean validarFragment(){
        boolean correcto = true;
        return correcto;
    }
    public void guardarFragment(){
        ContentValues contentValues =  new ContentValues();
        if(rgP1.indexOfChild(rgP1.findViewById(rgP1.getCheckedRadioButtonId())) >= 0){
            P1 = rgP1.indexOfChild(rgP1.findViewById(rgP1.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P1, P1);
        }

        if(rgP2.indexOfChild(rgP2.findViewById(rgP2.getCheckedRadioButtonId())) >= 0){
            P2 = rgP2.indexOfChild(rgP2.findViewById(rgP2.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P2, P2);
        }

        if(rgP3.indexOfChild(rgP3.findViewById(rgP3.getCheckedRadioButtonId())) >= 0){
            P3 = rgP3.indexOfChild(rgP3.findViewById(rgP3.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P3, P3);
        }

        if(rgP4.indexOfChild(rgP4.findViewById(rgP4.getCheckedRadioButtonId())) >= 0){
            P4 = rgP4.indexOfChild(rgP4.findViewById(rgP4.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P4, P4);
        }

        if(rgP5.indexOfChild(rgP5.findViewById(rgP5.getCheckedRadioButtonId())) >= 0){
            P5 = rgP5.indexOfChild(rgP5.findViewById(rgP5.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P5, P5);
        }

        if(contentValues.size() > 0){
            Data data =  new Data(contexto);
            data.open();
            data.actualizarRespuestas(dni,contentValues);
            data.close();
        }
    }

}
