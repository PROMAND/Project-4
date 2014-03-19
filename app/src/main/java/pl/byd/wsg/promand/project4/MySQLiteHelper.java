package pl.byd.wsg.promand.project4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Marika on 18.03.14.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    //Tables names
    public static final String TABLE_USERS = "User";
    public static final String TABLE_EXPERIENCES = "Experience";

    //Table columns
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FIRSTNAME = "firstName";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_TRAININGS = "trainings";
    public static final String COLUMN_EDUCATION = "education";
    public static final String COLUMN_INTERESTS = "interests";
    public static final String COLUMN_STRONGS = "strongSides";

    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_EXPERIENCE = "name";
    public static final String COLUMN_SELECTED = "selected";

    //Database name and version
    private static final String DATABASE_NAME = "MyCareer.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_USERS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_FIRSTNAME
            + " text not null, " + COLUMN_LASTNAME
            + " text not null, " + COLUMN_AGE
            + " text not null, " + COLUMN_GENDER
            + " text not null, " + COLUMN_TRAININGS
            + " text null, " + COLUMN_EDUCATION
            + " text null, " + COLUMN_INTERESTS
            + " text null, " + COLUMN_STRONGS
            + " text null);";

    private static final String CREATE_TABLE_EXPERIENCE =
            " create table " + TABLE_EXPERIENCES +
                    " (" + COLUMN_CODE
                    + " integer primary key autoincrement," + COLUMN_EXPERIENCE
                    + " text not null, " + COLUMN_SELECTED
                    + " text not null);";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
        database.execSQL(CREATE_TABLE_EXPERIENCE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data"
        );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPERIENCES);
        onCreate(db);
    }
}