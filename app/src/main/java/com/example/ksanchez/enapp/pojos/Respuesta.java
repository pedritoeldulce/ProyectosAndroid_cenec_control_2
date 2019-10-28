package com.example.ksanchez.enapp.pojos;

import android.content.ContentValues;

import com.example.ksanchez.enapp.modelo.SQLConstantes;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class Respuesta {
    private String DNI;
    private String NOMBRES;
    private String APELLIDOS;
    private String AULA;

    private String SEDE;
    private String CARGO;

    private String NOTA;

    private String P1;
    private String P2;

    private String P3;
    private String P4;
    private String P5;
    private String P6_1;
    private String P6_2;
    private String P6_3;
    private String P6_4;
    private String P6_5;
    private String P6_6;
    private String P6_7;
    private String P6_8;
    private String P6_9;
    private String P6_10;
    private String P6;
    private String P7;
    private String P8;
    private String P9_1;
    private String P9_2;
    private String P9_3;
    private String P9_4;
    private String P9_5;
    private String P9_6;
    private String P9_7;
    private String P9_8;

    public Respuesta() {
        this.DNI = "";
        this.NOMBRES = "";
        this.APELLIDOS = "";
        this.AULA = "";
        this.SEDE = "";
        this.CARGO = "";
        this.NOTA = "";

        P1 = "";
        P2 = "";
        P3 = "";
        P4 = "";
        P5 = "";
        P6_1 = "";
        P6_2 = "";
        P6_3 = "";
        P6_4 = "";
        P6_5 = "";
        P6_6 = "";
        P6_7 = "";
        P6_8 = "";
        P6_9 = "";
        P6_10 = "";
        P6 = "";
        P7 = "";
        P8 = "";
        P9_1 = "";
        P9_2 = "";
        P9_3 = "";
        P9_4 = "";
        P9_5 = "";
        P9_6 = "";
        P9_7 = "";
        P9_8 = "";
    }

    public Respuesta(String DNI, String NOMBRES, String APELLIDOS, String AULA, String SEDE, String CARGO, String NOTA, String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9_1, String p9_2, String p9_3, String p9_4, String p9_5, String p9_6, String p9_7, String p9_8) {
        this.DNI = DNI;
        this.NOMBRES = NOMBRES;
        this.APELLIDOS = APELLIDOS;
        this.AULA = AULA;
        this.SEDE = SEDE;
        this.CARGO = CARGO;
        this.NOTA = NOTA;
        P1 = p1;
        P2 = p2;
        P3 = p3;
        P4 = p4;
        P5 = p5;
        P6 = p6;
        P7 = p7;
        P8 = p8;
        P9_1 = p9_1;
        P9_2 = p9_2;
        P9_3 = p9_3;
        P9_4 = p9_4;
        P9_5 = p9_5;
        P9_6 = p9_6;
        P9_7 = p9_7;
        P9_8 = p9_8;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getAULA() {
        return AULA;
    }

    public void setAULA(String AULA) {
        this.AULA = AULA;
    }

    public String getSEDE() {
        return SEDE;
    }

    public void setSEDE(String SEDE) {
        this.SEDE = SEDE;
    }

    public String getCARGO() {
        return CARGO;
    }

    public void setCARGO(String CARGO) {
        this.CARGO = CARGO;
    }

    public String getNOTA() {
        return NOTA;
    }

    public void setNOTA(String NOTA) {
        this.NOTA = NOTA;
    }

    public String getP1() {
        return P1;
    }

    public void setP1(String p1) {
        P1 = p1;
    }

    public String getP2() {
        return P2;
    }

    public void setP2(String p2) {
        P2 = p2;
    }

    public String getP3() {
        return P3;
    }

    public void setP3(String p3) {
        P3 = p3;
    }

    public String getP4() {
        return P4;
    }

    public void setP4(String p4) {
        P4 = p4;
    }

    public String getP5() {
        return P5;
    }

    public void setP5(String p5) {
        P5 = p5;
    }

    public String getP6_1() {
        return P6_1;
    }

    public void setP6_1(String p6_1) {
        P6_1 = p6_1;
    }

    public String getP6_2() {
        return P6_2;
    }

    public void setP6_2(String p6_2) {
        P6_2 = p6_2;
    }

    public String getP6_3() {
        return P6_3;
    }

    public void setP6_3(String p6_3) {
        P6_3 = p6_3;
    }

    public String getP6_4() {
        return P6_4;
    }

    public void setP6_4(String p6_4) {
        P6_4 = p6_4;
    }

    public String getP6_5() {
        return P6_5;
    }

    public void setP6_5(String p6_5) {
        P6_5 = p6_5;
    }

    public String getP6_6() {
        return P6_6;
    }

    public void setP6_6(String p6_6) {
        P6_6 = p6_6;
    }

    public String getP6_7() {
        return P6_7;
    }

    public void setP6_7(String p6_7) {
        P6_7 = p6_7;
    }

    public String getP6_8() {
        return P6_8;
    }

    public void setP6_8(String p6_8) {
        P6_8 = p6_8;
    }

    public String getP6_9() {
        return P6_9;
    }

    public void setP6_9(String p6_9) {
        P6_9 = p6_9;
    }

    public String getP6_10() {
        return P6_10;
    }

    public void setP6_10(String p6_10) {
        P6_10 = p6_10;
    }

    public String getP6() {
        return P6;
    }

    public void setP6(String p6) {
        P6 = p6;
    }

    public String getP7() {
        return P7;
    }

    public void setP7(String p7) {
        P7 = p7;
    }

    public String getP8() {
        return P8;
    }

    public void setP8(String p8) {
        P8 = p8;
    }

    public String getP9_1() {
        return P9_1;
    }

    public void setP9_1(String p9_1) {
        P9_1 = p9_1;
    }

    public String getP9_2() {
        return P9_2;
    }

    public void setP9_2(String p9_2) {
        P9_2 = p9_2;
    }

    public String getP9_3() {
        return P9_3;
    }

    public void setP9_3(String p9_3) {
        P9_3 = p9_3;
    }

    public String getP9_4() {
        return P9_4;
    }

    public void setP9_4(String p9_4) {
        P9_4 = p9_4;
    }

    public String getP9_5() {
        return P9_5;
    }

    public void setP9_5(String p9_5) {
        P9_5 = p9_5;
    }

    public String getP9_6() {
        return P9_6;
    }

    public void setP9_6(String p9_6) {
        P9_6 = p9_6;
    }

    public String getP9_7() {
        return P9_7;
    }

    public void setP9_7(String p9_7) {
        P9_7 = p9_7;
    }

    public String getP9_8() {
        return P9_8;
    }

    public void setP9_8(String p9_8) {
        P9_8 = p9_8;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.CENEC_DNI,DNI);
        contentValues.put(SQLConstantes.CENEC_NOMBRES,NOMBRES);
        contentValues.put(SQLConstantes.CENEC_APELLIDOS,APELLIDOS);
        contentValues.put(SQLConstantes.CENEC_AULA,AULA);

        contentValues.put(SQLConstantes.CENEC_SEDE,SEDE);
        contentValues.put(SQLConstantes.CENEC_CARGO,CARGO);
        contentValues.put(SQLConstantes.CENEC_NOTA,NOTA);

        contentValues.put(SQLConstantes.CENEC_P1,P1);
        contentValues.put(SQLConstantes.CENEC_P2,P2);

        contentValues.put(SQLConstantes.CENEC_P3,P3);
        contentValues.put(SQLConstantes.CENEC_P4,P4);
        contentValues.put(SQLConstantes.CENEC_P5,P5);

        contentValues.put(SQLConstantes.CENEC_P6_1,P6_1);
        contentValues.put(SQLConstantes.CENEC_P6_2,P6_2);
        contentValues.put(SQLConstantes.CENEC_P6_3,P6_3);
        contentValues.put(SQLConstantes.CENEC_P6_4,P6_4);
        contentValues.put(SQLConstantes.CENEC_P6_5,P6_5);
        contentValues.put(SQLConstantes.CENEC_P6_6,P6_6);
        contentValues.put(SQLConstantes.CENEC_P6_7,P6_7);
        contentValues.put(SQLConstantes.CENEC_P6_8,P6_8);
        contentValues.put(SQLConstantes.CENEC_P6_9,P6_9);
        contentValues.put(SQLConstantes.CENEC_P6_10,P6_10);

        contentValues.put(SQLConstantes.CENEC_P6,P6);
        contentValues.put(SQLConstantes.CENEC_P7,P7);
        contentValues.put(SQLConstantes.CENEC_P8,P8);
        contentValues.put(SQLConstantes.CENEC_P9_1,P9_1);
        contentValues.put(SQLConstantes.CENEC_P9_2,P9_2);
        contentValues.put(SQLConstantes.CENEC_P9_3,P9_3);
        contentValues.put(SQLConstantes.CENEC_P9_4,P9_4);
        contentValues.put(SQLConstantes.CENEC_P9_5,P9_5);
        contentValues.put(SQLConstantes.CENEC_P9_6,P9_6);
        contentValues.put(SQLConstantes.CENEC_P9_7,P9_7);
        contentValues.put(SQLConstantes.CENEC_P9_8,P9_8);

        return contentValues;
    }
}
