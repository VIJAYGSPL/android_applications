package com.example.vijay.roomdatabaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHandler extends SQLiteOpenHelper {
    EmpDetails empDetails;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EmployeeManager";
    private static final String TABLE_EMP_DETAILS = "empdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ORGANIZATION = "organization";
    private static final String KEY_ROLE = "role";

    Context context;
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    // Creating Table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + TABLE_EMP_DETAILS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_ROLE + " TEXT,"
                + KEY_ORGANIZATION + " TEXT)";
        db.execSQL(CREATE_EMPLOYEE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMP_DETAILS);

        // Create tables again
        onCreate(db);
    }
    void addEmployee(EmpDetails empDetails) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID,empDetails.get_id());
        values.put(KEY_NAME, empDetails.get_name());
        values.put(KEY_ROLE, empDetails.get_role());
        values.put(KEY_ORGANIZATION, empDetails.get_organization());

        // Inserting Row
       long result =  db.insert(TABLE_EMP_DETAILS, null,values);
        //2nd argument is String containing nullColumnHack

        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added successfully..!", Toast.LENGTH_SHORT).show();
        }
    }
    // Deleting single contact
    public void deleteContact(EmpDetails empDetails) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMP_DETAILS, KEY_ID + " = ?",
                new String[] { String.valueOf(empDetails.get_id()) });
        db.close();
    }

}
