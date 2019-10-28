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
import android.widget.Toast;

import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;

/**
 * A simple {@link Fragment} subclass.
 */
public class eval1_p3 extends Fragment {


    Spinner spP6sp1;
    Spinner spP6sp2;
    Spinner spP6sp3;
    Spinner spP6sp4;
    Spinner spP6sp5;

    private String P6_1 = "";
    private String P6_2= "";
    private String P6_3= "";
    private String P6_4= "";
    private String P6_5= "";


    Context contexto;
    String dni;



    public eval1_p3() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public eval1_p3(Context contexto, String dni) {
        this.contexto = contexto;
        this.dni = dni;
    }

    @SuppressLint("ValidFragment")


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_eval1_p3, container, false);

        spP6sp1 = (Spinner) rootView.findViewById(R.id.eval1_p6_sp1);
        spP6sp2 = (Spinner) rootView.findViewById(R.id.eval1_p6_sp2);
        spP6sp3 = (Spinner) rootView.findViewById(R.id.eval1_p6_sp3);
        spP6sp4 = (Spinner) rootView.findViewById(R.id.eval1_p6_sp4);
        spP6sp5 = (Spinner) rootView.findViewById(R.id.eval1_p6_sp5);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
    }


    public void cargarDatos(){
        Data data = new Data(contexto);
        data.open();
        Respuesta respuesta = data.getRespuesta(dni);



        if(!respuesta.getP6_1().equals("")){
            spP6sp1.setSelection(Integer.parseInt(respuesta.getP6_1()));
        }
        if(!respuesta.getP6_2().equals("")){
            spP6sp2.setSelection(Integer.parseInt(respuesta.getP6_2()));
        }
        if(!respuesta.getP6_3().equals("")){
            spP6sp3.setSelection(Integer.parseInt(respuesta.getP6_3()));
        }
        if(!respuesta.getP6_4().equals("")){
            spP6sp4.setSelection(Integer.parseInt(respuesta.getP6_4()));
        }

        if(!respuesta.getP6_5().equals("")){
            spP6sp5.setSelection(Integer.parseInt(respuesta.getP6_5()));
        }

        data.close();


    }

    public boolean validarFragment(){
        boolean correcto = true;

        if ( spP6sp1.getSelectedItemPosition()==spP6sp2.getSelectedItemPosition()
                || spP6sp1.getSelectedItemPosition() ==spP6sp3.getSelectedItemPosition() || spP6sp1.getSelectedItemPosition()==spP6sp4.getSelectedItemPosition() || spP6sp1.getSelectedItemPosition()==spP6sp5.getSelectedItemPosition()
                || spP6sp2.getSelectedItemPosition()==spP6sp3.getSelectedItemPosition() || spP6sp2.getSelectedItemPosition()==spP6sp4.getSelectedItemPosition() || spP6sp2.getSelectedItemPosition()==spP6sp5.getSelectedItemPosition()
                || spP6sp3.getSelectedItemPosition()==spP6sp4.getSelectedItemPosition() || spP6sp3.getSelectedItemPosition()==spP6sp5.getSelectedItemPosition()
                || spP6sp4.getSelectedItemPosition()==spP6sp5.getSelectedItemPosition() )
        {
            correcto=false;
            Toast.makeText(getActivity(),"Las respuestas no deben coincidir",Toast.LENGTH_SHORT).show();
        }

        return correcto;
    }
    


    public void guardarFragment(){
        ContentValues contentValues = new ContentValues();


        P6_1 = spP6sp1.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.CENEC_P6_1, P6_1);
        P6_2 = spP6sp2.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.CENEC_P6_2, P6_2);
        P6_3 = spP6sp3.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.CENEC_P6_3, P6_3);
        P6_4 = spP6sp4.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.CENEC_P6_4, P6_4);
        P6_5 = spP6sp5.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.CENEC_P6_5, P6_5);

        if(contentValues.size() > 0){
            Data data =  new Data(contexto);
            data.open();
            data.actualizarRespuestas(dni,contentValues);
            data.close();
        }
    }
}
