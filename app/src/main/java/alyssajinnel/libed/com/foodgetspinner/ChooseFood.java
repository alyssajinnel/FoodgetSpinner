package alyssajinnel.libed.com.foodgetspinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChooseFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosefood);


        Button ricemeal = (Button) findViewById(R.id.ricemeal);
        ricemeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), ChoosePlace.class);
                startActivity(moveSecond);
            }
        });

        Button desserts = (Button) findViewById(R.id.desserts);
        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), ChoosePlace.class);
                startActivity(moveSecond);
            }
        });


        Button snacks = (Button) findViewById(R.id.snacks);
        snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), ChoosePlace.class);
                startActivity(moveSecond);
            }
        });


        Button beverages = (Button) findViewById(R.id.beverages);
        beverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), ChoosePlace.class);
                startActivity(moveSecond);
            }
        });


    }

}
