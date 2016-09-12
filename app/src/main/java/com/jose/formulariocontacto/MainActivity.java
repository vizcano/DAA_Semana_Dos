package com.jose.formulariocontacto;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilNombre, tilTelefono, tilCorreo, tilDescripcion, tilFecha;
    private EditText campo_nombre, campo_telefono, campo_correo, campo_descripcion, campo_fecha;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        // Referencias TILs
        tilNombre = (TextInputLayout) findViewById(R.id.til_nombre);
        tilFecha = (TextInputLayout) findViewById(R.id.til_fecha);
        tilTelefono = (TextInputLayout) findViewById(R.id.til_telefono);
        tilCorreo = (TextInputLayout) findViewById(R.id.til_correo);
        tilDescripcion = (TextInputLayout) findViewById(R.id.til_descripcion);

        // Referencias EditText
        campo_nombre = (EditText) findViewById(R.id.campo_nombre);
        campo_fecha = (EditText) findViewById(R.id.date);
        campo_telefono = (EditText) findViewById(R.id.campo_telefono);
        campo_correo = (EditText) findViewById(R.id.campo_correo);
        campo_descripcion = (EditText) findViewById(R.id.campo_descripcion);

        // perform click event on edit text
        campo_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                campo_fecha.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        Bundle b = new Bundle();
        b = getIntent().getExtras();

        if (b!= null) {
            campo_nombre.setText(b.getString("Nombre"));
            campo_fecha.setText(b.getString("Fecha"));
            campo_telefono.setText(b.getString("Telefono"));
            campo_correo.setText(b.getString("Correo"));
            campo_descripcion.setText(b.getString("Descripcion"));
        }

        // Referencia Botón
        Button botonAceptar = (Button) findViewById(R.id.boton_aceptar);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Detalle();
            }
        });

    }

    private void Detalle() {
        String nombre = tilNombre.getEditText().getText().toString();
        String fecha = tilFecha.getEditText().getText().toString();
        String telefono = tilTelefono.getEditText().getText().toString();
        String correo = tilCorreo.getEditText().getText().toString();
        String descripcion = tilDescripcion.getEditText().getText().toString();

        // OK, se pasa a la siguiente acción
        Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
        intent.putExtra("Nombre", nombre);
        intent.putExtra("Fecha", fecha);
        intent.putExtra("Telefono", telefono);
        intent.putExtra("Correo", correo);
        intent.putExtra("Descripcion", descripcion);
        startActivity(intent);
    }
}
