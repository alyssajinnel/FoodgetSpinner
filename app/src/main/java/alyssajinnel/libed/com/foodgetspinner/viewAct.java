package alyssajinnel.libed.com.foodgetspinner;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class viewAct extends AppCompatActivity {

    private static final String TAG = "viewtAct";
    private String loc, type, diner,oldName,newName;
    private Button searchBtn;
    private Button deleteBtn;
    private Button updateBtn;
    private EditText locEditText2;
    private EditText typeEditText2;
    private EditText dinerEditText2;
    private EditText priceEditText2;
    private EditText idEditText;
    private int id;


    private ListView list;

    DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mDatabaseHelper = new DatabaseHelper(this);

   //     locEditText2 = (EditText)findViewById(R.id.locEditText2);
   //     typeEditText2 = (EditText)findViewById(R.id.typeEditText2);
        dinerEditText2 = (EditText)findViewById(R.id.dinerEditText2);
   //     priceEditText2 = (EditText)findViewById(R.id.priceEditText2);
        Button searchBtn = (Button)findViewById(R.id.searchBtn);
   //     Button updateBtn = (Button)findViewById(R.id.updateBtn);
   //     Button deleteBtn = (Button)findViewById(R.id.deleteBtn);
   //     idEditText = (EditText)findViewById(R.id.idEditText);

        list = (ListView)findViewById(R.id.list);
        mDatabaseHelper = new DatabaseHelper(this);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**String diner = dinerEditText2.getText().toString();
                Cursor data = mDatabaseHelper.getData1(diner);
                data.moveToFirst();

               locEditText2.setText(data.getString(1));
               typeEditText2.setText(data.getString(2));
                dinerEditText2.setText(data.getString(3));
                priceEditText2.setText(data.getString(4));**/

                populatelistView();

            }
        });




        /**

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int test = Integer.valueOf(idEditText.getText().toString());
                String test2 = typeEditText2.getText().toString();
                mDatabaseHelper.updateEmail(test2, test);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int test = Integer.valueOf(idEditText.getText().toString());
                mDatabaseHelper.deleteId(test);
            }
        });

         **/
    }

    private void populatelistView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getSearch();
        ArrayList<String> listData = new ArrayList<>();
        String data1;
        listData.add("NO LOCATION     TYPE       DINER     PRICE RANGE");
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            data1 = data.getString(0)+ "        " +data.getString(1)+ "        " + data.getString(2) + "     " + data.getString(3)+ "     " + data.getString(4);
            listData.add(data1);
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        list.setAdapter(adapter);


    }
}