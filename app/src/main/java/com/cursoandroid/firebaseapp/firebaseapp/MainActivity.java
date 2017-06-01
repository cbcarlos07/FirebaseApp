package com.cursoandroid.firebaseapp.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference(); //getReference() retorna para a raiz
    private DatabaseReference usuarioReferencia = databaseReferencia.child("usuarios");
    private DatabaseReference produtoReferencia = databaseReferencia.child("produtos").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*child
         banco
           |_ pontos

           child().child()
           banco
           |_ usuarios
                     |_ 001
                          |_ nome

         */

      //  databaseReferencia.child("pontos").setValue("100");

        /*Usuario usuario = new Usuario();
        usuario.setNome("Carlos Alberto");
        usuario.setSobrenome("Brito");
        usuario.setIdade(3);
        usuario.setSexo("Masculino");*/

        //usuarioReferencia.child("003").setValue( usuario );

        /*Produto produto = new Produto();
        produto.setDescricao("Blu");
        produto.setFabricante("Blu");
        produto.setCor("Branco");

        produtoReferencia.child("003").setValue( produto );
*/
        usuarioReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString() );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
