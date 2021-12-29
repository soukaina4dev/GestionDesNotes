package com.example.gestiondesnotes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

import android.widget.TextView;
import android.widget.Toast;

import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mynote =(EditText) findViewById(R.id.id_note);
        Button btn = findViewById(R.id.btn);
        Spinner module = findViewById(R.id.spinner);
        TextView moyen = findViewById(R.id.id_moyen);
        //ImageView img1 = findViewById(R.id.imageView2);
        final ListView listView = (ListView) findViewById(R.id.id_Monliste);

        List<Note> lesNotes = new ArrayList<>();
        lesNotes.add( new Note(17,"maths")) ;
        lesNotes.add( new Note(18,"chimie")) ;

        //listView.setAdapter(new NoteAdapter(this,lesNotes));
        NoteAdapter noteAdapter = new NoteAdapter(this, lesNotes);
        listView.setAdapter(noteAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String moduleName = module.getSelectedItem().toString();
                double n = Double.parseDouble(mynote.getText().toString());
                Note NoteInputed = new Note(n,moduleName);
                double somme = 0;
                for(int i = 0 ;i< lesNotes.size();i++){
                    if(lesNotes.get(i).getModule()== NoteInputed.getModule()){
                        Toast.makeText(MainActivity.this,"Attention c'est une note double !",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        lesNotes.add(NoteInputed);
                        //listView.setAdapter(noteAdapter);
                    }
                    somme +=lesNotes.get(i).getNote();
                }
                double moyenne = somme/lesNotes.size();

                moyen.setText("la moyenne générale est : "+moyenne);

            }
        });


    }



}