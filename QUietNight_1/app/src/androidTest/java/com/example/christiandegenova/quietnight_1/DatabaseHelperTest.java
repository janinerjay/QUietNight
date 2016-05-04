package com.example.christiandegenova.quietnight_1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.junit.Assert.assertEquals;

/**
 * QUiet Night Application
 * Created by Janine Jay and Christian DeGenova
 * DatabaseHelperTest.java
 */

@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest {

    //Variables for test
    private SQLiteDatabase db;
    private DatabaseHelper databaseHelper;
    private Cursor cursor;

    //Create a database to work with
    @Before
    public void setUp() throws Exception {
        getTargetContext().deleteDatabase(DatabaseHelper.DB_NAME);
        databaseHelper = new DatabaseHelper(getTargetContext());
        db = databaseHelper.getReadableDatabase();
    }

    //Test the insertHotSpot method
    @Test
    public void testInsertHotSpot() throws Exception {
        //Create a new hot spot to insert into hot spot table
        ContentValues hotValues = new ContentValues();
        hotValues.put("NAME", "Dunkin");
        hotValues.put("IMAGE_RESOURCE_ID", R.mipmap.ic_dicks);
        hotValues.put("ADDRESS", "2490 Whitney Ave, Hamden, CT 06518");
        hotValues.put("WEBSITE", "https://www.dunkindonuts.com/dunkindonuts/en.html/");
        hotValues.put("HOURS", "Open 24 Hours!");
        hotValues.put("DESCRIPTION", "This eternally famous eatery is located right between Main and York Hill Campus. Come in for your coffee and donut fix!");
        long newRowId = db.insert("HOTSPOT2", null, hotValues);

        //Create query for the hot spot "Dunkin"
        cursor = db.query("HOTSPOT2", new String[]{"_id", "NAME"}, "NAME LIKE ?",
                new String [] {"Dunkin"}, null, null, null);
        cursor.moveToFirst();

        //count of cursor =1
        assertEquals(cursor.getCount(), 1);

        //parse info in cursor and assert that its same value as above
        assertEquals(cursor.getString(1), "Dunkin");
    }

    //Test the insertSport method
    @Test
    public void testInsertSport() throws Exception {
        //Create a new game to insert into sports table
        ContentValues sportValues = new ContentValues();
        sportValues.put("TEAM", "Women's Basketball");
        sportValues.put("IMAGE_RESOURCE_ID", R.mipmap.qu_bball);
        sportValues.put("DATE", "04-30-16");
        sportValues.put("TIME", "12:00pm");
        sportValues.put("OPPONENT", "Quinnipiac");
        sportValues.put("PLACE", "TD Bank Sports Center, Hamden, CT");
        db.insert("SPORTS", null, sportValues);

        //Create query for the opponent "Quinnipiac"
        cursor = db.query("SPORTS", new String[]{"_id","OPPONENT"}, "OPPONENT LIKE ?",
                new String [] {"Quinnipiac"}, null, null, null);
        cursor.moveToFirst();

        //count of cursor =1
        assertEquals(cursor.getCount(), 1);

        //parse info in cursor and assert that its same value as above
        assertEquals(cursor.getString(1), "Quinnipiac");
    }
}