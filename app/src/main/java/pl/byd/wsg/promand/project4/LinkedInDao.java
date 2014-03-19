package pl.byd.wsg.promand.project4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Marika on 19.03.14.
 */
public class LinkedInDao {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {
            MySQLiteHelper.COLUMN_LID,
            MySQLiteHelper.COLUMN_LFIRSTNAME,
            MySQLiteHelper.COLUMN_LLASTNAME,
            MySQLiteHelper.COLUMN_LEDUCATION,
            MySQLiteHelper.COLUMN_LINTERESTS,
            MySQLiteHelper.COLUMN_LBIRTH,
            MySQLiteHelper.COLUMN_LCERTIFICATIONS,
            MySQLiteHelper.COLUMN_LINDUSTRY,
            MySQLiteHelper.COLUMN_LLANGUAGES,
            MySQLiteHelper.COLUMN_LADDRESS,
            MySQLiteHelper.COLUMN_LSKILLS,
            MySQLiteHelper.COLUMN_LSPECIALITIES
    };

    public LinkedInDao (Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public int updateLinkedin(DataFromLinkedin linkedin){

        // get reference to writable DB
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // updating row
        int i = db.update(MySQLiteHelper.TABLE_LINKEDIN, //table
                makeLinkedinRow(linkedin), // column/value
                MySQLiteHelper.COLUMN_LID + " = ?", // selections
                new String[]{String.valueOf(linkedin.getId())});

        return i;
    }

    public void createLinkedin(DataFromLinkedin linkedin) {
        // get reference to writable DB
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // insert
        db.insert(MySQLiteHelper.TABLE_LINKEDIN, // table
                null, //nullColumnHack
                makeLinkedinRow(linkedin)); // key/value -> keys = column names/ values = column values

    }

    public void deleteUser(DataFromLinkedin linkedin) {
        // get reference to writable DB
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // delete
        db.delete(MySQLiteHelper.TABLE_LINKEDIN, //table name
                MySQLiteHelper.COLUMN_LID+" = ?",  // selections
                new String[] { String.valueOf(linkedin.getId()) }); //selections args

    }

    public DataFromLinkedin getLinkedin() {
        // 1. get reference to readable DB
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // 2. build query
        Cursor cursor = database.query(MySQLiteHelper.TABLE_LINKEDIN, allColumns, null, null, null, null, null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        DataFromLinkedin linkedin = new DataFromLinkedin();
        linkedin.setId(cursor.getLong(0));
        linkedin.setFirstName(cursor.getString(1));
        linkedin.setLastName(cursor.getString(2));
        linkedin.setEducation(cursor.getString(3));
        linkedin.setInterests(cursor.getString(4));
        linkedin.setDateOfBirth(cursor.getString(5));
        linkedin.setCertifications(cursor.getString(6));
        linkedin.setIndusty(cursor.getString(7));
        linkedin.setLanguages(cursor.getString(8));
        linkedin.setMainAddress(cursor.getString(9));
        linkedin.setSkills(cursor.getString(10));
        linkedin.setSpecialities(cursor.getString(11));

        // make sure to close the cursor
        cursor.close();

        return linkedin;
    }

    // helper method to pack a product for the convenience methods
    private ContentValues makeLinkedinRow(DataFromLinkedin linkedin) {
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.COLUMN_LFIRSTNAME, linkedin.getFirstName());
        values.put(MySQLiteHelper.COLUMN_LLASTNAME, linkedin.getLastName());
        values.put(MySQLiteHelper.COLUMN_LEDUCATION, linkedin.getEducation());
        values.put(MySQLiteHelper.COLUMN_LINTERESTS, linkedin.getInterests());
        values.put(MySQLiteHelper.COLUMN_LBIRTH, linkedin.getDateOfBirth());
        values.put(MySQLiteHelper.COLUMN_LCERTIFICATIONS, linkedin.getCertifications());
        values.put(MySQLiteHelper.COLUMN_LINDUSTRY, linkedin.getIndusty());
        values.put(MySQLiteHelper.COLUMN_LLANGUAGES, linkedin.getLanguages());
        values.put(MySQLiteHelper.COLUMN_LADDRESS, linkedin.getMainAddress());
        values.put(MySQLiteHelper.COLUMN_LSKILLS, linkedin.getSkills());
        values.put(MySQLiteHelper.COLUMN_LSPECIALITIES, linkedin.getSpecialities());

        return values;
    }

}
