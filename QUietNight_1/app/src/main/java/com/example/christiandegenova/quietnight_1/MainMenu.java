package com.example.christiandegenova.quietnight_1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ShareActionProvider;

/**
 * QUiet Night Application
 * Created by Janine Jay and Christian DeGenova
 * MainMenu.java
 */

public class MainMenu extends Activity {

    //Variables
    private ShareActionProvider shareActionProvider;
    String text = "QUietNight is the best app! You are able to view info on any Hot Spots in the Quinnipiac area " +
            "You can also view schedules for the Quinnipiac sports teams! Never have a QUiet Night at QU!";
    boolean continueBGMusic;

    //Create the view of the Main Menu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //Pause the music when the activity is paused
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

    //Set the Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        setIntent(text);
        return super.onCreateOptionsMenu(menu);
    }

    //Set code for each option in the Action Bar
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

    //Go to the SportsActivity if you click the sports button
    public void onClickSport (View view) {
        Intent intent = new Intent(this, SportsActivity.class);
        startActivity(intent);
    }

    //Go to the HotSpotActivity if you click the hotSpot button
    public void onClickHot (View view) {
        Intent intent1 = new Intent(this, HotSpotActivity.class);
        startActivity(intent1);
    }

}
