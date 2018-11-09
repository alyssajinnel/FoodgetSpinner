package alyssajinnel.libed.com.foodgetspinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddDiner extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    private Button saveBtn;
    private Button nextBtn;
    private Button updateBtn;
    private EditText locEditText;
    private EditText typeEditText;
    private EditText dinerEditText;
    private EditText priceEditText;
    private  String loc, type, diner, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_diner);



        saveBtn = (Button)findViewById(R.id.saveBtn);
        nextBtn = (Button)findViewById(R.id.nextBtn);
        updateBtn = (Button)findViewById(R.id.updateBtn);
        locEditText = (EditText)findViewById(R.id.locEditText);
        typeEditText = (EditText)findViewById(R.id.typeEditText);
        dinerEditText = (EditText)findViewById(R.id.dinerEditText);
        priceEditText = (EditText)findViewById(R.id.priceEditText);


        mDatabaseHelper = new DatabaseHelper(this);


        loc = locEditText.getText().toString();
        type = typeEditText.getText().toString();
        diner =  dinerEditText.getText().toString();
        price =  priceEditText.getText().toString();


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loc = locEditText.getText().toString();
                type = typeEditText.getText().toString();
                diner =  dinerEditText.getText().toString();
                price =  priceEditText.getText().toString();
                int duration = Toast.LENGTH_SHORT;


                if (loc.length() != 0 && type.length() != 0 && diner.length() != 0) {
                    AddData1(loc, type, diner, price);
                    locEditText.setText("");
                    typeEditText.setText("");
                    dinerEditText.setText("");
                    priceEditText.setText("");
                } else {
                    dinerEditText.setText("");
                    toastMessage("You must put something in the text field!");
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveView = new Intent(getApplicationContext(), dinerList.class);
                startActivity(moveView);
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveView1 = new Intent(getApplicationContext(), viewAct.class);
                startActivity(moveView1);
            }
        });
    }

    public void AddData1(String item1, String item2, String item3, String item4) {
        boolean insertData = mDatabaseHelper.addData(item1, item2, item3, item4);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}