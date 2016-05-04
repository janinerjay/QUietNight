package com.example.christiandegenova.quietnight_1;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * QUiet Night Application
 * Created by Janine Jay and Christian DeGenova
 * SportsList.java
 */

public class SportsList extends ListActivity {

    //Variables
    private SQLiteDatabase db;
    private Cursor cursor;
    private ShareActionProvider shareActionProvider;
    String text = "QUietNight is the best app! You are able to view info on any Hot Spots in the " +
            "Quinnipiac area. You can also view schedules for the Quinnipiac sports teams! " +
            "Never have a QUiet Night at QU!";
    boolean continueBGMusic;

    //Creat the layout of the Sports List
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        continueBGMusic=true;
        ListView listSports = getListView();

        Intent intent = getIntent();
        int teamId = intent.getIntExtra("teamId", 0);

        //Populate the list with the team games selected in the SportsActivity
        switch (teamId) {
            case 1:
                try {
                    SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
                    db = databaseHelper.getReadableDatabase();

                    cursor = db.query("SPORTS", new String[]{"_id", "DATE", "OPPONENT", "IMAGE_RESOURCE_ID"}, "TEAM = ?",
                            new String [] {"Men's Hockey"}, null, null, "DATE ASC");
                    CursorAdapter listAdapter = new SimpleCursorAdapter(this, R.layout.sports_listview_layout,
                            cursor, new String[]{"DATE", "OPPONENT", "IMAGE_RESOURCE_ID"},
                            new int[]{R.id.Sport, R.id.versus, R.id.sportPhoto}, 0);

                    listSports.setAdapter(listAdapter);
                } catch (SQLiteException e) {
                    Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

            case 2:
                try {
                    SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
                    db = databaseHelper.getReadableDatabase();

                    cursor = db.query("SPORTS", new String[]{"_id", "DATE", "OPPONENT", "IMAGE_RESOURCE_ID"}, "TEAM = ?",
                            new String [] {"Women's Hockey"}, null, null, "DATE ASC");
                    CursorAdapter listAdapter = new SimpleCursorAdapter(this, R.layout.sports_listview_layout,
                            cursor, new String[]{"DATE", "OPPONENT", "IMAGE_RESOURCE_ID"},
                            new int[]{R.id.Sport, R.id.versus, R.id.sportPhoto}, 0);
                    listSports.setAdapter(listAdapter);
                } catch (SQLiteException e) {
                    Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

            case 3:
                try {
                    SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
                    db = databaseHelper.getReadableDatabase();

                    cursor = db.query("SPORTS", new String[]{"_id", "DATE", "OPPONENT", "IMAGE_RESOURCE_ID"}, "TEAM = ?",
                            new String [] {"Men's Basketball"}, null, null, "DATE ASC");
                    CursorAdapter listAdapter = new SimpleCursorAdapter(this, R.layout.sports_listview_layout,
                            cursor, new String[]{"DATE", "OPPONENT", "IMAGE_RESOURCE_ID"},
                            new int[]{R.id.Sport, R.id.versus, R.id.sportPhoto}, 0);
                    listSports.setAdapter(listAdapter);
                } catch (SQLiteException e) {
                    Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

            case 4:
                try {
                    SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
                    db = databaseHelper.getReadableDatabase();

                    cursor = db.query("SPORTS", new String[]{"_id", "DATE", "OPPONENT", "IMAGE_RESOURCE_ID"}, "TEAM = ?",
                            new String[]{"Women's Basketball"}, null, null, "DATE ASC");
                    CursorAdapter listAdapter = new SimpleCursorAdapter(this, R.layout.sports_listview_layout,
                            cursor, new String[]{"DATE", "OPPONENT", "IMAGE_RESOURCE_ID"},
                            new int[]{R.id.Sport, R.id.versus, R.id.sportPhoto}, 0);
                    listSports.setAdapter(listAdapter);
                } catch (SQLiteException e) {
                    Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
        }

        //Set the Action Bar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //Pause the music when the activity is resumed
    public void onPause() {
        super.onPause();
        if(!continueBGMusic)
            MusicManager.pause();
    }

    //Resume the music when the activity is resumed
    public void onResume() {
        super.onResume();

        continueBGMusic=false;
        MusicManager.start(this, R.raw.lastfridaynight);
    }

    //Close the cursor and the database when the activity is closed
    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    //Open the SportsDetailFragment with the item selected in the Sports List
    @Override
    public void onListItemClick (ListView listView, View itemView, int position, long id) {
        SportsDetailFragment fragment = new SportsDetailFragment();
        fragment.setSportID((int) id);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(android.R.id.content, fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    //Set the Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        setIntent(text);
        return super.onCreateOptionsMenu(menu);
    }

    //Set the code for the options in the Action Bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {

            case R.id.about_us:
                //code to navigate to the about us activity
                Intent intent = new Intent(this,AboutUsActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_settings:
                if (item.isChecked() == true) {
                    item.setChecked(false);
                    View root = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
                    root.setBackgroundColor(Color.parseColor("#080d29"));
                } else {
                    item.setChecked(true);
                    View root = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
                    root.setBackgroundColor(Color.WHITE);
                }

                return true;

            case R.id.action_share:
                //code to run action share
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Create an intent extras for the shareAction button in action bar
    private void setIntent(String Intent){
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }
}

