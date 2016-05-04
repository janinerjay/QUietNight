package com.example.christiandegenova.quietnight_1;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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
 * HotSpotDetailFragment.java
 */

public class HotSpotDetailFragment extends Fragment {

    //Variables
    public static final String HOT_SPOT = "hotId";
    private ShareActionProvider shareActionProvider;
    String text = "QUietNight is the best app! You are able to view info on any Hot Spots in the Quinnipiac area " +
            "You can also view schedules for the Quinnipiac sports teams! Never have a QUiet Night at QU!";
    private int hotId;

    //Blank Constructor
    public HotSpotDetailFragment() {}

    //Set the hotID method
    public void setHotID(int id) {this.hotId = id;}

    //Inflate the view of the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot_spot_detail, container, false);
    }

    //Populate the view with the information requested in the HotSpotActivity
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {

            //Create a cursor
            try {
                SQLiteOpenHelper hotSpotDatabaseHelper = new DatabaseHelper(getActivity());
                SQLiteDatabase db = hotSpotDatabaseHelper.getReadableDatabase();
                Cursor cursor = db.query("HOTSPOT2", new String[] {"NAME", "IMAGE_RESOURCE_ID",
                                "ADDRESS", "WEBSITE", "HOURS", "DESCRIPTION"}, "_id = ?",
                        new String [] {Integer.toString(hotId)}, null, null, null);

                //Move to the first record in the Cursor
                if (cursor.moveToFirst()) {

                    //Get venue details from cursor
                    String nameText = cursor.getString(0);
                    int photoId = cursor.getInt(1);
                    String addressText = cursor.getString(2);
                    String websiteText = cursor.getString(3);
                    String hoursText = cursor.getString(4);
                    String descriptionText = cursor.getString(5);

                    //Populate the venue name
                    TextView name = (TextView) view.findViewById(R.id.hotSpotName);
                    name.setText(nameText);

                    //Populate the venue image
                    ImageView photo = (ImageView) view.findViewById(R.id.hotSpotPhoto);
                    photo.setImageResource(photoId);
                    photo.setContentDescription(nameText);

                    //Populate the venue address
                    TextView address = (TextView) view.findViewById(R.id.hotSpotAddress);
                    address.setText(addressText);

                    //Populate the venue website
                    TextView myWebview = (TextView) view.findViewById(R.id.hotSpotWebsite);
                    myWebview.setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) view.findViewById(R.id.hotSpotWebsite)).setText(Html.fromHtml(websiteText));

                    //Populate the venue hours
                    TextView hours = (TextView) view.findViewById(R.id.hotSpotHours);
                    hours.setText(hoursText);

                    //Populate the venue description
                    TextView description = (TextView) view.findViewById(R.id.hotSpotDescription);
                    description.setText(descriptionText);
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
}

