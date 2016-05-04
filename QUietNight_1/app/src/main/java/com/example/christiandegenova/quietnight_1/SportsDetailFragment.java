package com.example.christiandegenova.quietnight_1;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

/**
 * QUiet Night Application
 * Created by Janine Jay and Christian DeGenova
 * SportsDetailFragment.java
 */

public class SportsDetailFragment extends Fragment {

    //Variables
    public static final String SPORT = "sportId";
    private ShareActionProvider shareActionProvider;
    String text = "QUietNight is the best app! You are able to view info on any Hot Spots in the Quinnipiac area " +
            "You can also view schedules for the Quinnipiac sports teams! Never have a QUiet Night at QU!";
    private int sportId;
    boolean continueBGMusic;

    //Empty Constructor
    public SportsDetailFragment() {}

    //Set the layout for the SportsDetailFragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null) {
            sportId = savedInstanceState.getInt("sportId");
        }
        return inflater.inflate(R.layout.fragment_sports_detail, container, false);
    }

    //Pause the music when the activity is paused
    public void onPause() {
        super.onPause();
        if(!continueBGMusic)
            MusicManager.pause();
    }

    //Resume the activity when the activity is resumed
    public void onResume() {
        super.onResume();

        continueBGMusic=false;
        MusicManager.start(getActivity().getApplicationContext(), R.raw.lastfridaynight);
    }

    //Populate the detail fragment
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {

            //Create a cursor
            try {
                SQLiteOpenHelper databaseHelper = new DatabaseHelper(getActivity());
                SQLiteDatabase db = databaseHelper.getReadableDatabase();
                Cursor cursor = db.query("SPORTS", new String[] {"TEAM", "IMAGE_RESOURCE_ID",
                                "DATE", "TIME", "OPPONENT", "PLACE"}, "_id = ?",
                        new String [] {Integer.toString(sportId)}, null, null, null);

                //Move to the first record in the Cursor
                if (cursor.moveToFirst()) {

                    //Get venue details from cursor
                    String teamText = cursor.getString(0);
                    int photoId = cursor.getInt(1);
                    String dateText = cursor.getString(2);
                    String timeText = cursor.getString(3);
                    String opponentText = cursor.getString(4);
                    String placeText = cursor.getString(5);

                    //Populate the sport image
                    ImageView photo = (ImageView) view.findViewById(R.id.sportDetailImage);
                    photo.setImageResource(photoId);
                    photo.setContentDescription(teamText);

                    //Populate the date text
                    TextView date = (TextView) view.findViewById(R.id.Date);
                    date.setText(dateText);

                    //Populate the time text
                    TextView time = (TextView) view.findViewById(R.id.Time);
                    time.setText(timeText);

                    //Populate the opponent name
                    TextView opponent = (TextView) view.findViewById(R.id.Opponent);
                    opponent.setText(opponentText);

                    //Populate the place name
                    TextView place = (TextView) view.findViewById(R.id.Place);
                    place.setText(placeText);
                }

                //Close the cursor and the database
                cursor.close();
                db.close();

            } catch (SQLiteException e){
                Toast toast = Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    //Save the sportId
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("sportId", sportId);
    }

    //Set method for the sportId
    public void setSportID(int id) {
        this.sportId = id;
    }
}