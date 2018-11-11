package alyssajinnel.libed.com.foodgetspinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChoosePlace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseplace);


        Button Espana = (Button) findViewById(R.id.Espana);
        Espana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), Results.class);
                startActivity(moveSecond);
            }
        });

        Button Lacson = (Button) findViewById(R.id.Lacson);
        Lacson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), Results.class);
                startActivity(moveSecond);
            }
        });

        Button Dapitan = (Button) findViewById(R.id.Dapitan);
        Dapitan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), Results.class);
                startActivity(moveSecond);
            }
        });

        Button PNoval = (Button) findViewById(R.id.PNoval);
        PNoval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), Results.class);
                startActivity(moveSecond);
            }
        });


    }



}
