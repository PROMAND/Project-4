package pl.byd.wsg.promand.project4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marika on 18.03.14.
 */
public class MyCareerUserDao {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {
        MySQLiteHelper.COLUMN_ID,
        MySQLiteHelper.COLUMN_FIRSTNAME,
        MySQLiteHelper.COLUMN_LASTNAME,
        MySQLiteHelper.COLUMN_AGE,
        MySQLiteHelper.COLUMN_GENDER,
        MySQLiteHelper.COLUMN_TRAININGS,
        MySQLiteHelper.COLUMN_EDUCATION,
        MySQLiteHelper.COLUMN_INTERESTS,
        MySQLiteHelper.COLUMN_STRONGS
};

        //Constructor
        public MyCareerUserDao (Context context) {
            dbHelper = new MySQLiteHelper(context);
        }

        public void open() throws SQLException {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

        public int updateUser(MyCareerUser myUser){

            // get reference to writable DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // updating row
            int i = db.update(MySQLiteHelper.TABLE_USERS, //table
                    makeUserRow(myUser), // column/value
                    MySQLiteHelper.COLUMN_ID + " = ?", // selections
                    new String[]{String.valueOf(myUser.getId())});

            return i;
        }

        public void createUser(MyCareerUser myUser) {
            // get reference to writable DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // insert
            db.insert(MySQLiteHelper.TABLE_USERS, // table
                    null, //nullColumnHack
                    makeUserRow(myUser)); // key/value -> keys = column names/ values = column values

        }

        public void deleteUser(MyCareerUser user) {
            // get reference to writable DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // delete
            db.delete(MySQLiteHelper.TABLE_USERS, //table name
                    MySQLiteHelper.COLUMN_ID+" = ?",  // selections
                    new String[] { String.valueOf(user.getId()) }); //selections args

        }

        public List<MyCareerUser> getAllUsers() {
            List<MyCareerUser> users = new LinkedList<MyCareerUser>();

            // 1. build the query
            String query = "SELECT  * FROM " + MySQLiteHelper.TABLE_USERS;

            // 2. get reference to writable DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);

            // 3. go over each row, build book and add it to list
            MyCareerUser user = null;
            if (cursor.moveToFirst()) {
                do {
                    user = new MyCareerUser();
                    user.setId(cursor.getLong(0));
                    user.setFirstName(cursor.getString(1));
                    user.setLastName(cursor.getString(2));
                    user.setAge(cursor.getInt(3));
                    user.setGender(cursor.getString(4));
                    user.setTrainings(cursor.getString(5));
                    user.setEducation(cursor.getString(6));
                    user.setInterests(cursor.getString(7));
                    user.setStrongSides(cursor.getString(8));

                    // Add book to books
                    users.add(user);
                } while (cursor.moveToNext());
            }

            //Log.d("getAllBooks()", users.toString());

            // return books
            return users;
        }

        public MyCareerUser getUser() {
            // 1. get reference to readable DB
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            // 2. build query
            Cursor cursor = database.query(MySQLiteHelper.TABLE_USERS, allColumns, null, null, null, null, null);

            // 3. if we got results get the first one
            if (cursor != null)
                cursor.moveToFirst();

            MyCareerUser user = new MyCareerUser();
            try {
                user.setId(cursor.getLong(0));
                user.setFirstName(cursor.getString(1));
                user.setLastName(cursor.getString(2));
                user.setAge(cursor.getInt(3));
                user.setGender(cursor.getString(4));
                user.setTrainings(cursor.getString(5));
                user.setEducation(cursor.getString(6));
                user.setInterests(cursor.getString(7));
                user.setStrongSides(cursor.getString(8));
                cursor.close();
            }
            catch (Exception e)
            {


            }
            // make sure to close the cursor
            return user;


        }

    // helper method to pack a product for the convenience methods
    private ContentValues makeUserRow(MyCareerUser myUser) {
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.COLUMN_FIRSTNAME, myUser.getFirstName());
        values.put(MySQLiteHelper.COLUMN_LASTNAME, myUser.getLastName());
        values.put(MySQLiteHelper.COLUMN_AGE, myUser.getAge());
        values.put(MySQLiteHelper.COLUMN_GENDER, myUser.getGender());
        values.put(MySQLiteHelper.COLUMN_TRAININGS, myUser.getTrainings());
        values.put(MySQLiteHelper.COLUMN_EDUCATION, myUser.getEducation());
        values.put(MySQLiteHelper.COLUMN_INTERESTS, myUser.getInterests());
        values.put(MySQLiteHelper.COLUMN_STRONGS, myUser.getStrongSides());

        return values;
    }
}
