package alyssajinnel.libed.com.foodgetspinner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "database_table";
    private static final String column1 = "ID";
    private static final String column2 = "location";
    private static final String column3 = "type";
    private static final String column4 = "dinername";
    private static final String column5 = "pricerange";
    private EditText dinerEditText2;
    private  String diner1;


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                column2 +" TEXT " + " , " + column3 + " TEXT " + " , " + column4 + " TEXT " + " , " + column5 + " TEXT " + ");" ;
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item1, String item2, String item3, String item4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column2, item1);
        contentValues.put(column3, item2);
        contentValues.put(column4, item3);
        contentValues.put(column5, item4);

        Log.d(TAG, "addData: Adding " + item1 + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + item2 + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + item3 + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + item4 + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns all the data from database
     * @return
     */
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    public Cursor getData1(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + column1 + " = " + id + ";";
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    /**
     * Returns only the ID that matches the name passed in
     * @param name
     * @return
     */
    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + column1 + " FROM " + TABLE_NAME +
                " WHERE " + column2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Updates the name field
     * @param newName
     * @param id
     * @param oldName
     */
    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + column2 +
                " = '" + newName + "' WHERE " + column1 + " = '" + id + "'" +
                " AND " + column2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    public void updateEmail(String newEmail, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + column3 +
                " = '" + newEmail + "' WHERE " + column1 + " = '" + id + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newEmail);
        db.execSQL(query);
    }



    /**
     * Delete from database
     * @param id
     * @param name
     */
    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + column1 + " = '" + id + "'" +
                " AND " + column2 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }

    public void deleteId(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + column1 + " = '" + id + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + id + " from database.");
        db.execSQL(query);
    }

    public Cursor getResults(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME+ " WHERE " + column5 + " = '50-99'" ;
        Cursor res = db.rawQuery(query, null);
        return res;
    }
    public Cursor getResults1 (){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME+ " WHERE " + column5 + " = '100++'" ;
        Cursor res1 = db.rawQuery(query, null);
        return res1;
    }

    public Cursor getSearch(){
        SQLiteDatabase db = this.getWritableDatabase();
        diner1 =  dinerEditText2.getText().toString();
        String query = "SELECT * FROM " + TABLE_NAME+ " WHERE " + column4 + " = '" + diner1 + "'";
        Cursor res = db.rawQuery(query, null);
        return res;
    }


}