package com.example.christiandegenova.quietnight_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * QUiet Night Application
 * Created by Janine Jay and Christian DeGenova
 * DatabaseHelper.java
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //Variables
    public static final String DB_NAME = "Database";
    private static final int DB_VERSION = 1;

    //Blank Constructor
    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        //Create the Hot Spot table
        db.execSQL("CREATE TABLE HOTSPOT2 (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER, " + "ADDRESS TEXT, " + "WEBSITE TEXT, " +
                "HOURS TEXT, " + "DESCRIPTION TEXT);");
        insertHotSpot(db, "Aunchie", R.mipmap.ic_aunchies, "3931 Whitney Ave, Hamden, CT 06518",
                "http://www.auntchilada.com/",
                "Sun-Thur 11:00 am – 1:00 am\nFri-Sat 11:00 am – 2:00 am",
                "There's occasional live entertainment at this casual eatery proffering" +
                        " Mexican and some Tex-Mex grub.");
        insertHotSpot(db, "Bar", R.mipmap.ic_bar, "254 Crown Street, New Haven, CT",
                "http://www.barnightclub.com", "Sun 11:30 am - 1:00 am\n" +
                        "Mon-Thurs 4:00 pm - 1:00 am\n" + "Fri  4:00 pm - 2:00 am\n" +
                        "Sat 11:30am - 2:00am",
                "Buzzing bar & dance club with indie rock shows staged in " +
                        "industrial-chic environs with cozy nooks.");
        insertHotSpot(db, "Box 63", R.mipmap.ic_box, "338 Elm Street, New Haven, CT 06511",
                "http://www.box63.com", "Sun- Sat 11:00 pm–11:30 pm",
                "Vintage-inspired eatery featuring creative comfort cooking, plus " +
                        "a patio & a DJ-fueled dance floor.");
        insertHotSpot(db, "Dick's", R.mipmap.ic_dicks, "3307 Whitney Ave, Hamden, CT 06518",
                "http://hamdenct.areaguides.net/ypcyellowdetail/andale_mexican_restaurant_5588597.html?what=bars",
                "Mon-Sat 5:00 pm - 1:00 am",
                "A hole in the wall very close to main campus, " +
                        "the real name for this restaurant/pub is Andale's Mexican Restaurant");
        insertHotSpot(db, "Elevate", R.mipmap.ic_elevate, "215 Crown Street, New Haven, CT 06511",
                "https://www.facebook.com/AlchemyElevate/timeline", "Fri-Sat: 9:00 pm - 2:00 am",
                "Formally known as Elevate & Alchemy includes a night club, bar, and lounge");
        insertHotSpot(db, "Empire", R.mipmap.ic_empire, "84 Orange Street, New Haven, CT 06510",
                "https://www.facebook.com/Empire-Gotham-Citi-Cafe-Nightclub-231364633575819/timeline",
                "Tue-Sat: 7:00 pm - 2:00 am",
                "New Havens Landmark Nightclub since 1996, has moved to an all new state of the art " +
                        "entertainment complex, CT's only avalong sound system, formally known " +
                        "as Empire-Gotham Citi Cafe");
        insertHotSpot(db, "Ixtapa", R.mipmap.ic_ixtapa, "2547 Whitney Ave, Hamden, CT 06518",
                "https://www.facebook.com/pages/Ixtapa-Grill-Family-Mexican-Restaurant/116218661735439",
                "Mon-Sun: 10:00 am - 10:00 pm",
                "Intimate Mexican eatery with a festive ambiance serving standard dishes such as " +
                        "tacos & burritos.");
        insertHotSpot(db, "Odies", R.mipmap.ic_odies, "3352 Whitney Ave, Hamden, CT 06518",
                "https://www.facebook.com/OdiesPlaceOnWhitney/",
                "Sun-Thur 11:00 am - 1:00 am\nFri-Sat 11:00 am – 2:00 am",
                "Odie's Place is open everyday at 11 am. They have an amazing menu and known for a " +
                        "wide variety of specialty pizza. Always a good time with great service!");
        insertHotSpot(db, "Side Street", R.mipmap.ic_side, "15 Dickerman Street, Hamden, CT 06518",
                "http://www.sidestreetgrille.com", "Mon-Tues 4:30 pm – 1:00 am\n" +
                        "Wed-Thur 11:30am – 1:00 am\n" + "Fri-Sat 11:30 am – 2:00 am\n" +
                        "Sun 11:30am – 1:00 am", "Lunch, Dinner and late night fare\n" +
                        "Over 70 beers and a 19-Tap Beer Tower\n" +
                        "Catering & Private Parties");
        insertHotSpot(db, "Toads", R.mipmap.ic_toads, "300 York Street, New Haven, CT 06511",
                "http://www.toadsplace.com", "Fri-Sat 9:00 pm - 2:00 am",
                "Toad's Place is a concert venue and nightclub. If you do not go to Toad's every " +
                        "saturday night do you even go to QU?");



        //Create the Sports table
        db.execSQL("CREATE TABLE SPORTS (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "TEAM TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER, " + "DATE TEXT, " + "TIME TEXT, " +
                "OPPONENT TEXT, " + "PLACE TEXT);");

        //Men's Hockey Information
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "02-20-16", "7:00pm",
                "QU vs. Union College", "Messa Rink, Schnectady, NY");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "02-26-16", "7:00pm",
                "QU vs. Brown University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "02-27-16", "7:00pm",
                "QU vs. Yale University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "03-11-16", "7:00pm",
                "QU vs. Cornell University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "03-12-16", "7:00pm",
                "QU vs. Cornell University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "03-13-16", "4:00pm",
                "QU vs. Cornell University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "03-18-16", "4:00pm",
                "QU vs. Dartmouth College", "Herb Brooks Arena, Lake Placid, NY");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "03-19-16", "7:00pm",
                "QU vs. Harvard University", "Herb Brooks Arena, Lake Placid, NY");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "03-26-16", "4:00pm",
                "QU vs. RIT", "Times Union Center, Albany, NY");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "03-27-16", "7:30pm",
                "QU vs. UMass Lowell", "Times Union Center, Albany, NY");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "04-07-16", "5:00pm",
                "QU vs. Boston College", "Amalie Arena, Tampa, FL");
        insertSport(db, "Men's Hockey", R.mipmap.qu_icehockey, "04-09-16", "8:00pm",
                "QU vs. University of North Dakota", "Amalie Arena, Tampa, FL");

        //Women's Hockey information
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "01-30-16", "3:00pm",
                "QU vs. Dartmouth College", "Thompson Arena, Hanover, NH");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "02-05-16", "7:00pm",
                "QU vs. Cornell University", "Lynah Rink, Ithaca, NY");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "02-06-16", "4:00pm",
                "QU vs. Colgate University", "Starr Arena, Hamilton, NY");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "02-12-16", "5:00pm",
                "QU vs. St. Lawrence University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "02-13-16", "4:00pm",
                "QU vs. Clarkson University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "02-19-16", "7:00pm",
                "QU vs. Union College", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "02-20-16", "4:00pm",
                "QU vs. Rensselaer Polytechnic Institute", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "02-26-16", "2:00pm",
                "QU vs. Rensselaer Polytechnic Institute", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "02-27-16", "2:00pm",
                "QU vs. Rensselaer Polytechnic Institute", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "03-05-16", "1:00pm",
                "QU vs. St. Lawrence University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "03-06-16", "2:00pm",
                "QU vs. Clarkson University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Hockey", R.mipmap.qu_icehockey, "03-12-16", "2:00pm",
                "QU vs. Clarkson University", "TD Bank Sport Center, Hamden, CT");

        //Men's Basketball Information
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "01-30-16", "2:00pm",
                "QU vs. Niagara University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-01-16", "7:00pm",
                "QU vs. Fairfield University", "Webster Bank Arena, Bridgeport, CT");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-04-16", "7:00pm",
                "QU vs. Marist College", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-08-16", "7:00pm",
                "QU vs. St. Peter's University", "Yanitelli Center, Jersey City, NJ");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-11-16", "8:00pm",
                "QU vs. Manhattan College", "Draddy Gymnasium, Riverdale, NY");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-13-16", "2:00pm",
                "QU vs. Fairfield University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-15-16", "7:00pm",
                "QU vs. Iona College", "Hynes Athletic Center, New Rochelle, NY");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-18-16", "8:00pm",
                "QU vs. St. Peter's University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-21-16", "2:00pm",
                "QU vs. Manhattan College", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-26-16", "7:00pm",
                "QU vs. Marist College", "McCann Field House, Poughkeepsie, NY");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "02-28-16", "2:00pm",
                "QU vs. Siena College", "Times Union Center, Albany, NY");
        insertSport(db, "Men's Basketball", R.mipmap.qu_bball, "03-03-16", "5:00pm",
                "QU vs. Rider University", "Times Union Center, Albany, NY");

        //Women's Basketball Information
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "02-12-16", "7:00pm",
                "QU vs. Iona College", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "02-14-16", "12:00pm",
                "QU vs. St. Peter's University", "Yanitelli Center, Jersey City, NJ");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "02-18-16", "5:00pm",
                "QU vs. Marist College", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "02-21-16", "2:00pm",
                "QU vs. Rider University", "Alumni Gymnasium, Lawrenceville, NJ");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "02-23-16", "5:00pm",
                "QU vs. Manhattan College", "Draddy Gymnasium, Riverdale, NJ");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "02-26-16", "5:00pm",
                "QU vs. Fairfield University", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "02-28-16", "1:00pm",
                "QU vs. Iona College", "Hynes Athletic Center, New Rochelle, NY");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "03-04-16", "12:00pm",
                "QU vs. Niagara University", "Times Union Center, Albany, NY");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "03-06-16", "11:00am",
                "QU vs. Monmouth University", "Times Union Center, Albany, NY");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "03-07-16", "2:30pm",
                "QU vs. Iona College", "Times Union Center, Albany, NY");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "03-18-16", "7:00pm",
                "QU vs. University of Maine", "TD Bank Sport Center, Hamden, CT");
        insertSport(db, "Women's Basketball", R.mipmap.qu_bball, "03-20-16", "2:00pm",
                "QU vs. Temple University", "TD Bank Sport Center, Hamden, CT");
    }

    //Method to upgrade a database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Method to insert a hot spot into the HotSpot database
    private static void insertHotSpot (SQLiteDatabase db, String name, int resourceId, String address,
                                       String website, String hours, String description) {
        ContentValues hotValues = new ContentValues();
        hotValues.put("NAME", name);
        hotValues.put("IMAGE_RESOURCE_ID", resourceId);
        hotValues.put("ADDRESS", address);
        hotValues.put("WEBSITE", website);
        hotValues.put("HOURS", hours);
        hotValues.put("DESCRIPTION", description);
        db.insert("HOTSPOT2", null, hotValues);
    }

    //Method to insert a sport game into the Sports database
    private static void insertSport (SQLiteDatabase db, String team, int resourceId, String date,
                                     String time, String opponent, String place) {
        ContentValues sportValues = new ContentValues();
        sportValues.put("TEAM", team);
        sportValues.put("IMAGE_RESOURCE_ID", resourceId);
        sportValues.put("DATE", date);
        sportValues.put("TIME", time);
        sportValues.put("OPPONENT", opponent);
        sportValues.put("PLACE", place);
        db.insert("SPORTS", null, sportValues);
    }
}