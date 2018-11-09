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
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.budget1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), ChooseFood.class);
                startActivity(moveSecond);
            }
        });

        Button plusBtn= (Button) findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveSecond = new Intent(getApplicationContext(), AddDiner.class);
                startActivity(moveSecond);
            }
        });

        Button viewBtn = (Button) findViewById(R.id.viewBtn);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveView = new Intent(getApplicationContext(), dinerList.class);
                startActivity(moveView);
            }
        });
    }
}
