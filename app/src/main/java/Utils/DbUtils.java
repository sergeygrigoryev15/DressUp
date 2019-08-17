package Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Map;

import static testapp.sergey.myapplication.MainActivity.LOG_TAG;

public class DbUtils extends SQLiteOpenHelper {

    private final String sqlCreateItemsTable = String.format("CREATE table %s (" +
            "id integer primary key autoincrement," +
            "name text);", DbTables.ITEMS.toString());

    private final String sqlCreateOutfitsTable = String.format("CREATE table %s (" +
            "id integer primary key autoincrement," +
            "name text);", DbTables.OUTFITS.toString());

    private final static String dbName = "DressUpDb";

    public DbUtils(Context context) {
        super(context, dbName, null, 1);
    }

    private ContentValues parseValues(Map<String, String> dict) {
        ContentValues cv = new ContentValues();
        for (String key : dict.keySet()) {
            cv.put(key, dict.get(key));
        }
        return cv;
    }

    public SQLiteDatabase readDB() {
        return this.getReadableDatabase();
    }

    private SQLiteDatabase writeDB() {
        return this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreateItemsTable);
        sqLiteDatabase.execSQL(sqlCreateOutfitsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<String> getItems(){
        ArrayList<String> items = new ArrayList<>();
        Cursor c = readDB().query(DbTables.ITEMS.toString(), null, null,
                null, null, null, null);
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            do {
                items.add(c.getString(nameColIndex));
            } while (c.moveToNext());
        } else
            Log.d(LOG_TAG, "0 rows");
        c.close();
        return items;
    }

    public DbUtils addItem(String key, String value) {
        ContentValues cv = new ContentValues();
        cv.put(key, value);
        long rowId = writeDB().insert(DbTables.ITEMS.toString(), null, cv);
        return this;
    }

    public DbUtils addItem(Map<String, String> dict) {
        long rowId = writeDB().insert(DbTables.ITEMS.toString(), null, parseValues(dict));
        return this;
    }

    public DbUtils addItem(Item item) {
        long rowId = writeDB().insert(DbTables.ITEMS.toString(), null, parseValues(item.toDict()));
        return this;
    }
}
