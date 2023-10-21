package com.example.bendezu_gutierrez_pa02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText codigo, titulo, ISBN, editorial, autor, genero, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigo = (EditText) findViewById(R.id.editTextCodigo);
        titulo = (EditText) findViewById(R.id.editTextTitulo);
        ISBN = (EditText) findViewById(R.id.editTextISBN);
        editorial = (EditText) findViewById(R.id.editTextEditorial);
        autor = (EditText) findViewById(R.id.editTextAutor);
        genero = (EditText) findViewById(R.id.editTextGenero);
        precio = (EditText) findViewById(R.id.editTextPrecio);

    }

    public void grabar(View view){
        String codigoli, titulocompleto, ISBNli, editoriallibro, autorli, generoli, precioli;

        codigoli=codigo.getText().toString();
        titulocompleto=titulo.getText().toString();
        ISBNli=ISBN.getText().toString();
        editoriallibro=editorial.getText().toString();
        autorli=autor.getText().toString();
        generoli=genero.getText().toString();
        precioli=precio.getText().toString();

        SharedPreferences preferences = getSharedPreferences( "Libro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(codigoli,titulocompleto);

        editor.putString("ISBN" + codigoli, ISBNli);
        editor.putString("editorial" + codigoli, editoriallibro);
        editor.putString("autor" + codigoli, autorli);
        editor.putString("genero" + codigoli,generoli);
        editor.putString("precio" + codigoli,precioli);
        editor.commit();
        Toast.makeText(this, "Datos guardados con éxito", Toast.LENGTH_LONG).show();

    }

    public void buscar(View view){
        String codigobuscar;

        codigobuscar=codigo.getText().toString();
        SharedPreferences prefe=getSharedPreferences("Libro", Context.MODE_PRIVATE);
        String d=prefe.getString(codigobuscar,"");

        String da=prefe.getString("ISBN" + codigobuscar, "");
        String db=prefe.getString("editorial" + codigobuscar, "");
        String dc=prefe.getString("autor" + codigobuscar, "");
        String dd=prefe.getString("genero" + codigobuscar, "");
        String de=prefe.getString("precio" + codigobuscar, "");

        if(d.length()==0){
            Toast.makeText(this, "Datos no encontrados",Toast.LENGTH_LONG).show();} else{
            titulo.setText(d);
            ISBN.setText(da);
            editorial.setText(db);
            autor.setText(dc);
            genero.setText(dd);
            precio.setText(de);
        }

    }
}