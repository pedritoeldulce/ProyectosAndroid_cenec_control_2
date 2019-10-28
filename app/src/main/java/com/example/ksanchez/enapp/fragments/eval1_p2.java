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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ksanchez.enapp.BaseDatosTemporal;
import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.activities.UsuarioActivity;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;



/**
 * A simple {@link Fragment} subclass.
 */
public class eval1_p2 extends Fragment {

    RadioGroup rgP6_1,rgP6_2,rgP6_3,rgP6_4,rgP6_5,rgP6_6,rgP6_7,rgP6_8,rgP6_9,rgP6_10;

    Context contexto;
    String dni;

    private String P6_1,P6_2,P6_3,P6_4,P6_5,P6_6,P6_7,P6_8,P6_9,P6_10;

    public eval1_p2() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public eval1_p2(Context contexto, String dni) {
        this.contexto = contexto;
        this.dni = dni;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_eval1_p2, container, false);
        rgP6_1 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_1_rg1);
        rgP6_2 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_2_rg1);
        rgP6_3 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_3_rg1);
        rgP6_4 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_4_rg1);
        rgP6_5 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_5_rg1);
        rgP6_6 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_6_rg1);
        rgP6_7 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_7_rg1);
        rgP6_8 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_8_rg1);
        rgP6_9 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_9_rg1);
        rgP6_10 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_10_rg1);

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
            if (!respuesta.getP6_1().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_1());
                ((RadioButton) rgP6_1.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6_2().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_2());
                ((RadioButton) rgP6_2.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6_3().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_3());
                ((RadioButton) rgP6_3.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6_4().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_4());
                ((RadioButton) rgP6_4.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6_5().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_5());
                ((RadioButton) rgP6_5.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6_6().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_6());
                ((RadioButton) rgP6_6.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6_7().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_7());
                ((RadioButton) rgP6_7.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6_8().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_8());
                ((RadioButton) rgP6_8.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6_9().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_9());
                ((RadioButton) rgP6_9.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6_10().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6_10());
                ((RadioButton) rgP6_10.getChildAt(childPos)).setChecked(true);
            }
        }

    }


    public boolean validarFragment(){
        boolean correcto = true;
        return correcto;
    }
    public void guardarFragment(){
        ContentValues contentValues =  new ContentValues();
        if(rgP6_1.indexOfChild(rgP6_1.findViewById(rgP6_1.getCheckedRadioButtonId())) >= 0){
            P6_1 = rgP6_1.indexOfChild(rgP6_1.findViewById(rgP6_1.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_1, P6_1);
        }

        if(rgP6_2.indexOfChild(rgP6_2.findViewById(rgP6_2.getCheckedRadioButtonId())) >= 0){
            P6_2 = rgP6_2.indexOfChild(rgP6_2.findViewById(rgP6_2.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_2, P6_2);
        }

        if(rgP6_3.indexOfChild(rgP6_3.findViewById(rgP6_3.getCheckedRadioButtonId())) >= 0){
            P6_3 = rgP6_3.indexOfChild(rgP6_3.findViewById(rgP6_3.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_3, P6_3);
        }

        if(rgP6_4.indexOfChild(rgP6_4.findViewById(rgP6_4.getCheckedRadioButtonId())) >= 0){
            P6_4 = rgP6_4.indexOfChild(rgP6_4.findViewById(rgP6_4.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_4, P6_4);
        }

        if(rgP6_5.indexOfChild(rgP6_5.findViewById(rgP6_5.getCheckedRadioButtonId())) >= 0){
            P6_5 = rgP6_5.indexOfChild(rgP6_5.findViewById(rgP6_5.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_5, P6_5);
        }

        if(rgP6_6.indexOfChild(rgP6_6.findViewById(rgP6_6.getCheckedRadioButtonId())) >= 0){
            P6_6 = rgP6_6.indexOfChild(rgP6_6.findViewById(rgP6_6.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_6, P6_6);
        }

        if(rgP6_7.indexOfChild(rgP6_7.findViewById(rgP6_7.getCheckedRadioButtonId())) >= 0){
            P6_7 = rgP6_7.indexOfChild(rgP6_7.findViewById(rgP6_7.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_7, P6_7);
        }

        if(rgP6_8.indexOfChild(rgP6_8.findViewById(rgP6_8.getCheckedRadioButtonId())) >= 0){
            P6_8 = rgP6_8.indexOfChild(rgP6_8.findViewById(rgP6_8.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_8, P6_8);
        }

        if(rgP6_9.indexOfChild(rgP6_9.findViewById(rgP6_9.getCheckedRadioButtonId())) >= 0){
            P6_9 = rgP6_9.indexOfChild(rgP6_9.findViewById(rgP6_9.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_9, P6_9);
        }

        if(rgP6_10.indexOfChild(rgP6_10.findViewById(rgP6_10.getCheckedRadioButtonId())) >= 0){
            P6_10 = rgP6_10.indexOfChild(rgP6_10.findViewById(rgP6_10.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.CENEC_P6_10, P6_10);
        }


        if(contentValues.size() > 0){
            Data data =  new Data(contexto);
            data.open();
            data.actualizarRespuestas(dni,contentValues);
            data.close();
        }


    }
}
