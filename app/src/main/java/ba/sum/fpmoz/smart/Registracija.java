package ba.sum.fpmoz.smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registracija extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    private Button button;
    private EditText regOznaka;
    public static String Reg;

    Registracija r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);
        button = findViewById(R.id.registracija);
        regOznaka = findViewById(R.id.regOznaka);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistracija();
            }
        });


        }
    public void openRegistracija(){
        String registracija = regOznaka.getText().toString();
        if(registracija.equals("")){
            button.setText("Unesite Registracijsku oznaku automobila!");
            return;
        }
         //ovdje se pamti registracija automobila
        Reg = registracija;

        DatabaseReference referenca = database.getReference("registracije");


        Intent intent = new Intent(this,ParkingMap.class);
        startActivity(intent);

    }



}
