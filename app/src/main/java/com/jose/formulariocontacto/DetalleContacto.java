package com.jose.formulariocontacto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by XI318865 on 09/09/2016.
 */
public class DetalleContacto extends AppCompatActivity {
    TextView tvNombre;
    TextView tvFecha;
    TextView tvTelefono;
    TextView tvCorreo;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_contacto);

        Bundle b = new Bundle();
        b = getIntent().getExtras();

        String nombre = b.getString("Nombre");
        String fecha = b.getString("Fecha");
        String telefono = b.getString("Telefono");
        String correo = b.getString("Correo");
        String descripcion = b.getString("Descripcion");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvCorreo = (TextView) findViewById(R.id.tvCorreo);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvCorreo.setText(correo);
        tvDescripcion.setText(descripcion);

        // Referencia Botón
        Button botonAceptar = (Button) findViewById(R.id.boton_enviar);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Formulario();
            }
        });

    }


    private void Formulario() {
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvCorreo = (TextView) findViewById(R.id.tvCorreo);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvDescripcion = (TextView) findViewById(R.id.tvTelefono);

        // OK, se pasa a la siguiente acción
        Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
        intent.putExtra("Nombre", tvNombre.getText().toString());
        intent.putExtra("Fecha", tvFecha.getText().toString());
        intent.putExtra("Telefono", tvTelefono.getText().toString());
        intent.putExtra("Correo", tvCorreo.getText().toString());
        intent.putExtra("Descripcion", tvDescripcion.getText().toString());
        startActivity(intent);
    }
}
