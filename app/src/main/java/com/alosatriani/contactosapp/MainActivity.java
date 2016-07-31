package com.alosatriani.contactosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private DatePicker dpFhNacimiento;
    private EditText etNombreContacto;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setearDatos(getIntent());
    }

    public void siguientePagina(View v) {

        Intent intent = new Intent(MainActivity.this, DatosContactoActivity.class);


        dpFhNacimiento = (DatePicker)findViewById(R.id.dpFhNacimiento);
        etNombreContacto = (EditText) findViewById(R.id.etNombreContacto);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);


        intent.putExtra("NombreContacto", etNombreContacto.getText().toString());
        intent.putExtra("Telefono", etTelefono.getText().toString());
        intent.putExtra("Email", etEmail.getText().toString());
        intent.putExtra("Descripcion", etDescripcion.getText().toString());
        intent.putExtra("dia", ""+dpFhNacimiento.getDayOfMonth());
        intent.putExtra("mes", ""+dpFhNacimiento.getMonth());
        intent.putExtra("anio", ""+dpFhNacimiento.getYear());

        startActivity(intent);

    }

    public void setearDatos(Intent intent){

        if(intent != null && intent.getExtras()!= null){


            Bundle  bdl = intent.getExtras();

            String nombre = (String) bdl.get("NombreContacto2");
            String telefono = (String) bdl.get("Telefono2");
            String email = (String) bdl.get("Email2");
            String descripcion = (String) bdl.get("Descripcion2");
            String dia = (String) bdl.get("dia");
            String mes = (String) bdl.get("mes");
            String anio = (String) bdl.get("anio");

            dpFhNacimiento = (DatePicker)findViewById(R.id.dpFhNacimiento);
            etNombreContacto = (EditText) findViewById(R.id.etNombreContacto);
            etTelefono = (EditText) findViewById(R.id.etTelefono);
            etEmail = (EditText) findViewById(R.id.etEmail);
            etDescripcion = (EditText) findViewById(R.id.etDescripcion);

            etNombreContacto.setText(nombre);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);

            dpFhNacimiento.updateDate(Integer.parseInt(anio),Integer.parseInt(mes),Integer.parseInt(dia));

        }

    }
}
