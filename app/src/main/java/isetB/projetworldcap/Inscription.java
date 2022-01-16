package isetB.projetworldcap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Inscription extends AppCompatActivity {
    Button registerbtn,connexion;
    EditText e1 ,e2 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        registerbtn = findViewById(R.id.registerbtn);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(Inscription.this, " Add Your Account Here ", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Inscription.this, register.class);
                startActivity(i);
            }
        });
        connexion = findViewById(R.id.loginbtn);
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1 = findViewById(R.id.username);
                e2 = findViewById(R.id.password);
                String log = e1.getText().toString();
                String pw = e2.getText().toString();
                if (log.equals("") || pw.equals(""))
                    Toast.makeText(Inscription.this, "champs vides", Toast.LENGTH_SHORT).show();
                else {
                    SharedPreferences sp = getSharedPreferences("MyInfo", MODE_PRIVATE);
                    String login = sp.getString("email", "error");
                    String password = sp.getString("password", "error");
                    if (!log.equals(login) || !pw.equals(password))
                        Toast.makeText(Inscription.this, "login ou password inccorect", Toast.LENGTH_SHORT).show();


                    else {
                        Toast.makeText(Inscription.this, "Conexion", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Inscription.this, MainActivity.class);

                        startActivity(intent);

                    }
                }

            }
        });
    }
}