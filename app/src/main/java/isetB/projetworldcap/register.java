package isetB.projetworldcap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    Button loginbtn;
    EditText t1 , t2 ,t3, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginbtn = findViewById(R.id.loginbtn);
t1=findViewById(R.id.username);
t2=findViewById(R.id.email);
t3=findViewById(R.id.password);
        t4=findViewById(R.id.R);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("MyInfo", MODE_PRIVATE) ;
                SharedPreferences.Editor esp=  sp.edit();
                String u = t1.getText().toString() ;
                esp.putString("nom",u);

                String email = t2.getText().toString() ;
                esp.putString("email",email);
                String password = t3.getText().toString() ;
                esp.putString("password",password);
                String comfpass = t4.getText().toString() ;
                if (password.equals(comfpass)){
                    esp.commit();
                    Intent intent = new Intent(register.this, signin.class);
                    startActivity(intent);

            }
                else
                    Toast.makeText(register.this, "password non confirme", Toast.LENGTH_SHORT).show();
            }


        });



    }
    }
