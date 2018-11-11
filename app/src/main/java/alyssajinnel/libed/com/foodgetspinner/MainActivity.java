package alyssajinnel.libed.com.foodgetspinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


       /** Button searchBtn0 = (Button) findViewById(R.id.searchBtn0);
        searchBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), viewAct.class);
                startActivity(moveSecond);
            }
        });

        **/

        Button plusBtn0 = (Button) findViewById(R.id.plusBtn0);
        plusBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), AddDiner.class);
                startActivity(moveSecond);
            }
        });

        Button viewBtn0 = (Button) findViewById(R.id.viewBtn0);
        viewBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveView = new Intent(getApplicationContext(), dinerList.class);
                startActivity(moveView);
            }
        });

        Button chooseBtn0 = (Button) findViewById(R.id.chooseBtn0);
        chooseBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveView = new Intent(getApplicationContext(), ChooseBudget.class);
                startActivity(moveView);
            }
        });

        Button spinner0 = (Button) findViewById(R.id.spinner0);
        spinner0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveView = new Intent(getApplicationContext(), Spinner.class);
                startActivity(moveView);
            }
        });
    }
}


///recycler view