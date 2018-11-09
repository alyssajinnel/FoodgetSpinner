package alyssajinnel.libed.com.foodgetspinner;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Results extends AppCompatActivity {
    private static final String TAG = "results";
    /**
    private Button Espana;
    private Button Dapitan;
    private Button PNoval;
    private Button Lacson;
    private Button USTCarpark;
    private Button budget1;
    private Button budget2;
    private String espana, dapitan, pnoval, lacson, carpark, highbudget, lowbudget;
     **/

    DatabaseHelper mDatabaseHelper;

    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        /**Espana = (Button)findViewById(R.id.Espana);
        Dapitan = (Button)findViewById(R.id.Dapitan);
        PNoval = (Button)findViewById(R.id.PNoval);
        Lacson = (Button)findViewById(R.id.Lacson);
        USTCarpark= (Button)findViewById(R.id.USTCarpark);
        budget1 = (Button)findViewById(R.id.budget1);
        budget2 = (Button)findViewById(R.id.budget2);**/


        listview = (ListView)findViewById(R.id.listview);
        mDatabaseHelper = new DatabaseHelper(this);
        populateListView();

    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying res in the ListView.");

        /**espana = Espana.getText().toString();
        dapitan = Dapitan.getText().toString();
        pnoval = PNoval.getText().toString();
        lacson = Lacson.getText().toString();
        carpark = USTCarpark.getText().toString();
        lowbudget = budget1.getText().toString();
        highbudget = budget2.getText().toString();
         **/



            //get the res and append to a list
            Cursor res = mDatabaseHelper.getResults();
            ArrayList<String> listData = new ArrayList<>();
            String res1;
            listData.add("LOCATION     TYPE       DINER     PRICE RANGE");
            while(res.moveToNext()){
                //get the value from the database in column 1
                //then add it to the ArrayList
                res1 = res.getString(1)+ "        " + res.getString(2) + "     " + res.getString(3)+ "     " + res.getString(4);
                listData.add(res1);
            }
            //create the list adapter and set the adapter
            ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
            listview.setAdapter(adapter);






    }
}