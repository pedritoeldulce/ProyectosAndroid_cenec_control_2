package com.example.ksanchez.enapp.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ksanchez.enapp.IOHelper;
import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.Solucionario;
import com.example.ksanchez.enapp.fragments.eval1_p1;
import com.example.ksanchez.enapp.fragments.eval1_p2;
import com.example.ksanchez.enapp.fragments.eval1_p3;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Timer;
import java.util.TimerTask;

import static android.os.Environment.getExternalStorageDirectory;

public class EvaluacionActivity extends AppCompatActivity {

    Button btnFinalizar, btnSiguiente, btnAnterior;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragmentActual;
    String dni = "";
    int contador = 1;
    final int TIEMPO = 20;
    TextView reloj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnAnterior = (Button) findViewById(R.id.btnAnterior);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        reloj = (TextView) findViewById(R.id.reloj);

        Bundle bundle = getIntent().getExtras();
        dni = bundle.getString("dni");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contador + 1 <=2){
                    if(validarFragment(contador)){
                        guardarFragment(contador);
                        contador++;
                        setFragment(contador,1);
                    }

                }
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contador - 1 > 0) {
                    guardarFragment(contador);
                    contador--;setFragment(contador,-1);
                }
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                //calcular nota


                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(EvaluacionActivity.this);
                dialogo1.setTitle("Mensaje de Confirmación");
                dialogo1.setMessage("¿Está seguro que desea finalizar la evaluación?");
                dialogo1.setCancelable(false);


                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {


                        if(validarFragment(contador)){
                            guardarFragment(contador);
                            contador++;
                            setFragment(contador,1);
                            finalizar();
                        }

                        //aceptar();
                    }
                });

                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //cancelar();
                    }
                });
                dialogo1.show();

            }
        });

        setFragment(1,1);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                finalizar();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, TIEMPO*60*1000+5*1000);

        CountDownTimer cTimer = null;
        cTimer = new CountDownTimer(TIEMPO*60*1000+5*1000, 1000) {
            public void onTick(long millisUntilFinished) {
                //Long.toString(millisUntilFinished);
                reloj.setText(String.format(" " + millisUntilFinished/(1000*60)));
                reloj.append(String.format(" : " ));

                if ((millisUntilFinished/1000)%60 <10){
                    reloj.append(String.format("0" + (millisUntilFinished/1000)%60));
                }else{
                    reloj.append(String.format("" + (millisUntilFinished/1000)%60));
                }

            }
            public void onFinish() {
            }
        };
        cTimer.start();
    }



    public boolean validarFragment(int numFragment){
        boolean correcto = false;
        switch (numFragment){
            case 1:
                eval1_p1 eval1_p1 = (eval1_p1) fragmentActual;
                correcto=eval1_p1.validarFragment();
                break;
            case 2:
                eval1_p3 eval1_p3 = (eval1_p3) fragmentActual;
                correcto=eval1_p3.validarFragment();
                break;

        }
        return correcto;
    }


    void escribirCampoXml(XmlSerializer s, String campo,String valor){
        try {
            s.startTag("", campo);
            if(valor != null) s.text(valor);
            else s.text("");
            s.endTag("", campo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFragment(int numFragment,int direccion){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if(direccion > 0){
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        }else{
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        }
        switch (numFragment){
            case 1:
                btnFinalizar.setVisibility(View.GONE);
                btnSiguiente.setVisibility(View.VISIBLE);
                fragmentActual = new eval1_p1(EvaluacionActivity.this, dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina1");
                break;
            case 2:
                btnFinalizar.setVisibility(View.VISIBLE);
                btnSiguiente.setVisibility(View.GONE);
                fragmentActual = new eval1_p3(EvaluacionActivity.this,dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina2");
                break;
        }
        fragmentTransaction.commit();
    }

    public void guardarFragment(int numFragment){
        switch (numFragment){
            case 1:
                eval1_p1 eval1_p1 = (eval1_p1) fragmentActual;
                eval1_p1.guardarFragment();
                break;
            case 2:
                eval1_p3 eval1_p3 = (eval1_p3) fragmentActual;
                eval1_p3.guardarFragment();
                break;

        }
    }

    @SuppressLint("NewApi")
    public void finalizar(){
        guardarFragment(contador);
        Data data = new Data(EvaluacionActivity.this);
        data.open();
        Respuesta respuesta = data.getRespuesta(dni);

        double nota = 0;


        respuesta.setNOTA(String.valueOf(nota));
        data.actualizarRespuestas(dni,respuesta.toValues());

        data.close();
        String nombreArchivo =  respuesta.getDNI()+ "C2"+ ".xml";
        String dni_nombre = respuesta.getDNI()+"_"+respuesta.getNOMBRES()+".txt";
        String last_name = respuesta.getNOMBRES();

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "RESPUESTAS");
            serializer.attribute("", "dni", respuesta.getDNI());
            escribirCampoXml(serializer, SQLConstantes.CENEC_DNI, respuesta.getDNI());
            escribirCampoXml(serializer, SQLConstantes.CENEC_NOMBRES, respuesta.getNOMBRES());
           // escribirCampoXml(serializer, SQLConstantes.CENEC_APELLIDOS, respuesta.getAPELLIDOS());
            escribirCampoXml(serializer, SQLConstantes.CENEC_AULA, respuesta.getAULA());
            escribirCampoXml(serializer, SQLConstantes.CENEC_SEDE, respuesta.getSEDE());
            escribirCampoXml(serializer, SQLConstantes.CENEC_CARGO, respuesta.getCARGO());
         //   escribirCampoXml(serializer, SQLConstantes.CENEC_NOTA, respuesta.getNOTA());

            escribirCampoXml(serializer, SQLConstantes.CENEC_P1, respuesta.getP1());
            escribirCampoXml(serializer, SQLConstantes.CENEC_P2, respuesta.getP2());

            escribirCampoXml(serializer, SQLConstantes.CENEC_P3, respuesta.getP3());
            escribirCampoXml(serializer, SQLConstantes.CENEC_P4, respuesta.getP4());
            escribirCampoXml(serializer, SQLConstantes.CENEC_P5, respuesta.getP5());

            escribirCampoXml(serializer, SQLConstantes.CENEC_P6_1, respuesta.getP6_1());
            escribirCampoXml(serializer, SQLConstantes.CENEC_P6_2, respuesta.getP6_2());
            escribirCampoXml(serializer, SQLConstantes.CENEC_P6_3, respuesta.getP6_3());
            escribirCampoXml(serializer, SQLConstantes.CENEC_P6_4, respuesta.getP6_4());
            escribirCampoXml(serializer, SQLConstantes.CENEC_P6_5, respuesta.getP6_5());



            serializer.endTag("", "RESPUESTAS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "CENEC_CONTROL_2"+"_"+last_name);
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            File file2 = new File(nuevaCarpeta, "xfs088.xml");
            File file3 = new File(nuevaCarpeta, dni_nombre);

            IOHelper.writeToFile(file,result);
            IOHelper.writeToFile(file2,"result");
            IOHelper.writeToFile(file3,"result");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finishAffinity();
    }

    @Override
    public void onBackPressed(){

        android.app.AlertDialog.Builder dialogo1 = new android.app.AlertDialog.Builder(EvaluacionActivity.this);
        dialogo1.setTitle("AVISO");
        dialogo1.setMessage("Usted NO debes presionar el botón atrás");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

                ok();
            }
        });

        dialogo1.show();

    }

    public void ok() {
        Toast t=Toast.makeText(this,"USTED A REGRESADO A LA EVALUACION", Toast.LENGTH_SHORT);
        t.show();
    }

}
