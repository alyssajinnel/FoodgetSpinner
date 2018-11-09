package alyssajinnel.libed.com.foodgetspinner;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class dinerList extends AppCompatActivity {
    private static final String TAG = "diner_list";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diner_list);

        mListView = (ListView)findViewById(R.id.ListView1);
        mDatabaseHelper = new DatabaseHelper(this);
        populateListView();

    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        String data1;
        listData.add("LOCATION     TYPE       DINER     PRICE RANGE");
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            data1 = data.getString(1)+ "        " + data.getString(2) + "     " + data.getString(3)+ "     " + data.getString(4);
            listData.add(data1);
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);


    }
}