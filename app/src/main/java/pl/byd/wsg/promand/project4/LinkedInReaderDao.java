package pl.byd.wsg.promand.project4;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Marika on 20.03.14.
 */
public class LinkedInReaderDao {

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

    public LinkedInReaderDao (Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public int getCount()
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor mCount= db.rawQuery("select count(*) from Linkedin", null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();

        return count;
    }


    public LinkedInReader getLinkedinReader() {
        // 1. get reference to readable DB
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // 2. build query
        Cursor cursor = database.query(MySQLiteHelper.TABLE_LINKEDIN, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        LinkedInReader linkedin = new LinkedInReader();

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
}
