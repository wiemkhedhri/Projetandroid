package isetB.projetworldcap;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class signin extends Activity {


    public void onClick(View v) {
        Toast.makeText(signin.this,"Connex ...", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(signin.this,MainActivity.class);
        startActivity(i);
    }

}


