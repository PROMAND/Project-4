package pl.byd.wsg.promand.project4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marika on 18.03.14.
 */
public class ExperienceClassDao {
        private SQLiteDatabase database;
        private MySQLiteHelper dbHelper;
        private String[] allColumns = {
            MySQLiteHelper.COLUMN_CODE,
            MySQLiteHelper.COLUMN_EXPERIENCE,
            MySQLiteHelper.COLUMN_SELECTED
        };

        //Constructor
        public ExperienceClassDao(Context context) {
            dbHelper = new MySQLiteHelper(context);
        }

        public void open() throws SQLException {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

        public int updateExperience(ExperienceClass experience){

            // get reference to writable DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // updating row
            int i = db.update(MySQLiteHelper.TABLE_EXPERIENCES, //table
                    makeExperienceRow(experience), // column/value
                    MySQLiteHelper.COLUMN_CODE + " = ?", // selections
                    new String[]{String.valueOf(experience.getCode())});

            return i;
        }

        public void updateAllExperiences(ArrayList<ExperienceClass> experiencesList){

        // get reference to writable DB
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // updating each row
        for(int k = 0; k < experiencesList.size(); k++)
        {
            int i = db.update(MySQLiteHelper.TABLE_EXPERIENCES, //table
                    makeExperienceRow(experiencesList.get(k)), // column/value
                    MySQLiteHelper.COLUMN_CODE + " = ?", // selections
                    new String[]{String.valueOf(experiencesList.get(k).getCode())});
        }
    }

        public void createExperience(ExperienceClass experience) {
            // get reference to writable DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // insert
            db.insert(MySQLiteHelper.TABLE_EXPERIENCES, // table
                    null, //nullColumnHack
                    makeExperienceRow(experience)); // key/value -> keys = column names/ values = column values

        }

        public void deleteExperience(ExperienceClass experience) {
            // get reference to writable DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // delete
            db.delete(MySQLiteHelper.TABLE_EXPERIENCES, //table name
                    MySQLiteHelper.COLUMN_CODE + " = ?",  // selections
                    new String[]{String.valueOf(experience.getCode())}); //selections args

        }
//comm
        public void insertExperiencesList(List<String> experiencesList){
            // get reference to writable DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // insert all
            for(int i = 0; i < experiencesList.size(); i++)
            {
                ExperienceClass experience = new ExperienceClass();
                experience.setCode(i);
                experience.setName(experiencesList.get(i).toString());
                experience.setSelected(false);
                db.insert(MySQLiteHelper.TABLE_EXPERIENCES, // table
                        null, //nullColumnHack
                        makeExperienceRow(experience)); // key/value -> keys = column names/ values = column values
            }

        }

        public ArrayList<ExperienceClass> getAllExperiences() {
            ArrayList<ExperienceClass> experiences = new ArrayList<ExperienceClass>();

            // build the query
            String query = "SELECT  * FROM " + MySQLiteHelper.TABLE_EXPERIENCES;

            // get reference to writable DB
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);

            // go over each row, build experience and add it to list
            ExperienceClass experience = null;
            if (cursor.moveToFirst()) {
                do {
                    experience = new ExperienceClass();
                    experience.setCode(cursor.getInt(0));
                    experience.setName(cursor.getString(1));
                    experience.setSelected(Boolean.valueOf(cursor.getString(2)));

                    // Add experience to experiences
                    experiences.add(experience);
                } while (cursor.moveToNext());
            }

            Log.d("getAllExperiences()", experiences.toString());

            // return experiences
            return experiences;
        }

        public ExperienceClass getExperience() {
            // get reference to readable DB
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            // build query
            Cursor cursor = database.query(MySQLiteHelper.TABLE_EXPERIENCES, allColumns, null, null, null, null, null);

            // if we got results get the first one
            if (cursor != null)
                cursor.moveToFirst();

            ExperienceClass experience = new ExperienceClass();
            experience.setCode(cursor.getInt(0));
            experience.setName(cursor.getString(1));
            experience.setSelected(Boolean.valueOf(cursor.getString(2)));

            // make sure to close the cursor
            cursor.close();

            return experience;
        }

    // helper method to pack an experience for the convenience methods
    private ContentValues makeExperienceRow(ExperienceClass experience) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_EXPERIENCE, experience.getName());

        if(experience.isSelected() == true)
        {
            values.put(MySQLiteHelper.COLUMN_SELECTED, "true");
        }
        else {
            values.put(MySQLiteHelper.COLUMN_SELECTED, "false");
        }

        return values;
    }
}
