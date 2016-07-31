package com.alosatriani.contactosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatosContactoActivity extends AppCompatActivity {

    private String dia;
    private String mes;
    private String anio;

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDesc;
    private TextView tvFhNacimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_contacto);


        Bundle bdl = getIntent().getExtras();
        String nombre = (String) bdl.get("NombreContacto");
        String telefono = (String) bdl.get("Telefono");
        String email = (String) bdl.get("Email");
        String descripcion = (String) bdl.get("Descripcion");
        dia = (String) bdl.get("dia");
        mes = (String) bdl.get("mes");
        anio = (String) bdl.get("anio");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDescripcion);
        tvFhNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;

        try {
            fecha = sdf.parse(dia+"/"+(Integer.parseInt(mes)+1)+"/"+anio);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        tvNombre.setText(nombre);
        tvFhNacimiento.setText(sdf.format(fecha));
        tvTelefono.setText(" " + telefono);
        tvEmail.setText(" "+email);
        tvDesc.setText(" "+descripcion);

    }

    public void regresarPagina(View v){

        Intent intent = new Intent(DatosContactoActivity.this, MainActivity.class);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDescripcion);
        tvFhNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);

        intent.putExtra("NombreContacto2", tvNombre.getText().toString());
        intent.putExtra("Telefono2", tvTelefono.getText().toString());
        intent.putExtra("Email2", tvEmail.getText().toString());
        intent.putExtra("Descripcion2", tvDesc.getText().toString());
        intent.putExtra("dia", dia);
        intent.putExtra("mes", mes);
        intent.putExtra("anio", anio);

        startActivity(intent);

    }
}
