package com.example.ksanchez.enapp.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ksanchez.enapp.pojos.Respuesta;
import com.example.ksanchez.enapp.modelo.DBHelper;
import com.example.ksanchez.enapp.modelo.SQLConstantes;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class Data {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public Data(Context contexto) {
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelper(contexto);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public long getNumeroItemsRespuestas(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantes.tablaRespuestas);
    }

    public void insertarRespuesta(Respuesta respuesta){
        sqLiteDatabase.insert(SQLConstantes.tablaRespuestas,null,respuesta.toValues());
    }

    public Respuesta getRespuesta(String dni){
        Respuesta respuesta = null;
        String[] whereArgs = new String[]{dni};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaRespuestas, null,SQLConstantes.WHERE_CLAUSE_DNI,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                respuesta = new Respuesta();
                respuesta.setDNI(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_DNI)));
                respuesta.setNOMBRES(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_NOMBRES)));

                respuesta.setAPELLIDOS(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_APELLIDOS)));
                respuesta.setAULA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_AULA)));

                respuesta.setSEDE(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_SEDE)));
                respuesta.setCARGO(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_CARGO)));

                respuesta.setNOTA(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_NOTA)));

                respuesta.setP1(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P1)));
                respuesta.setP2(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P2)));

                respuesta.setP3(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P3)));
                respuesta.setP4(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P4)));

                respuesta.setP5(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P5)));

                respuesta.setP6_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_1)));
                respuesta.setP6_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_2)));
                respuesta.setP6_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_3)));
                respuesta.setP6_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_4)));
                respuesta.setP6_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_5)));
                respuesta.setP6_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_6)));
                respuesta.setP6_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_7)));
                respuesta.setP6_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_8)));
                respuesta.setP6_9(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_9)));
                respuesta.setP6_10(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6_10)));

                respuesta.setP6(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P6)));

                respuesta.setP7(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P7)));
                respuesta.setP8(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P8)));

                respuesta.setP9_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P9_1)));
                respuesta.setP9_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P9_2)));
                respuesta.setP9_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P9_3)));
                respuesta.setP9_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P9_4)));
                respuesta.setP9_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P9_5)));
                respuesta.setP9_6(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P9_6)));
                respuesta.setP9_7(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P9_7)));
                respuesta.setP9_8(cursor.getString(cursor.getColumnIndex(SQLConstantes.CENEC_P9_8)));

            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return respuesta;
    }

    public void actualizarRespuestas(String dni, ContentValues contentValues){
        String[] whereArgs = new String[]{dni};
        sqLiteDatabase.update(SQLConstantes.tablaRespuestas,contentValues,SQLConstantes.WHERE_CLAUSE_DNI,whereArgs);
    }

    public boolean consultarregistro(){


        boolean correcto = true;
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaRespuestas,null,null,null,null,null,null);

            if (cursor !=null) {
                if (cursor.getCount() > 0) {


                    correcto = false;

                }
            }
        }
        finally{
            if(cursor != null) cursor.close();
        }

        return correcto;

    }

}
