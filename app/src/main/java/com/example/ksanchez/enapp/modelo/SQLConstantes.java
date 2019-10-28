package com.example.ksanchez.enapp.modelo;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class SQLConstantes {
    public static final String dbName = "cenec_c2.db";
    public static final String tablaRespuestas = "respuestas_c2";

    //COLUMNAS
    public static final String CENEC_DNI = "DNI";
    public static final String CENEC_NOMBRES = "NOMBRES";
    public static final String CENEC_APELLIDOS = "APELLIDOS";
    public static final String CENEC_AULA = "AULA";

    public static final String CENEC_SEDE = "SEDE";
    public static final String CENEC_CARGO = "CARGO";

    public static final String CENEC_NOTA = "NOTA";

    public static final String CENEC_P1 = "P1";
    public static final String CENEC_P2 = "P2";

    public static final String CENEC_P3 = "P3";
    public static final String CENEC_P4 = "P4";
    public static final String CENEC_P5 = "P5";

    public static final String CENEC_P6_1 = "P6_1";
    public static final String CENEC_P6_2 = "P6_2";
    public static final String CENEC_P6_3 = "P6_3";
    public static final String CENEC_P6_4 = "P6_4";
    public static final String CENEC_P6_5 = "P6_5";
    public static final String CENEC_P6_6 = "P6_6";
    public static final String CENEC_P6_7 = "P6_7";
    public static final String CENEC_P6_8 = "P6_8";
    public static final String CENEC_P6_9 = "P6_9";
    public static final String CENEC_P6_10 = "P6_10";

    public static final String CENEC_P6 = "P6";
    public static final String CENEC_P7 = "P7";
    public static final String CENEC_P8 = "P8";
    public static final String CENEC_P9_1 = "P9_1";
    public static final String CENEC_P9_2 = "P9_2";
    public static final String CENEC_P9_3 = "P9_3";
    public static final String CENEC_P9_4 = "P9_4";
    public static final String CENEC_P9_5 = "P9_5";
    public static final String CENEC_P9_6 = "P9_6";
    public static final String CENEC_P9_7 = "P9_7";
    public static final String CENEC_P9_8 = "P9_8";

    public static final String SQL_CREATE_TABLA_PREGUNTAS =
            "CREATE TABLE " + tablaRespuestas + "(" +
                    CENEC_DNI + " TEXT PRIMARY KEY," +
                    CENEC_NOMBRES + " TEXT," +
                    CENEC_APELLIDOS + " TEXT," +
                    CENEC_AULA + " TEXT," +
                    CENEC_SEDE + " TEXT," +
                    CENEC_CARGO + " TEXT," +
                    CENEC_NOTA + " TEXT," +

                    CENEC_P1 + " TEXT," +
                    CENEC_P2 + " TEXT," +

                    CENEC_P3 + " TEXT," +
                    CENEC_P4 + " TEXT," +
                    CENEC_P5 + " TEXT," +

                    CENEC_P6_1 + " TEXT," +
                    CENEC_P6_2 + " TEXT," +
                    CENEC_P6_3 + " TEXT," +
                    CENEC_P6_4 + " TEXT," +
                    CENEC_P6_5 + " TEXT," +
                    CENEC_P6_6 + " TEXT," +
                    CENEC_P6_7 + " TEXT," +
                    CENEC_P6_8 + " TEXT," +
                    CENEC_P6_9 + " TEXT," +
                    CENEC_P6_10 + " TEXT," +

                    CENEC_P6 + " TEXT," +
                    CENEC_P7 + " TEXT," +
                    CENEC_P8 + " TEXT," +
                    CENEC_P9_1 + " TEXT," +
                    CENEC_P9_2 + " TEXT," +
                    CENEC_P9_3 + " TEXT," +
                    CENEC_P9_4 + " TEXT," +
                    CENEC_P9_5 + " TEXT," +
                    CENEC_P9_6 + " TEXT," +
                    CENEC_P9_7 + " TEXT," +

                    CENEC_P9_8 + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_TABLA_PREGUNTAS = "DROP TABLE " + tablaRespuestas;

    public static final String WHERE_CLAUSE_DNI = "DNI=?";


}
