package com.example.christiandegenova.quietnight_1;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * QUiet Night Application
 * Created by Janine Jay and Christian DeGenova
 * MusicManager.java
 */

public class MusicManager {

    //Variables
    static final int MUSIC_PREVIOUS = -1;
    private static final String TAG = "MusicManager";
    static MediaPlayer mp;
    private static int currentMusic = -1;
    private static int previousMusic = -1;

    //Start the Music
    public static void start(Context context, int music) {
        start(context, music, false);
    }

    //Start the Music
    public static void start(Context context, int music, boolean force) {
        if (!force && currentMusic > -1) {
            // already playing some music and not forced to change
            return;
        }

        if (music == MUSIC_PREVIOUS) {
            Log.d(TAG, "Using previous music [" + previousMusic + "]");
            music = previousMusic;
        }
        if (currentMusic == music) {
            // already playing this music
            return;
        }
        if (currentMusic != -1) {
            previousMusic = currentMusic;
            // playing some other music, pause it and change
            pause();
        }
        currentMusic = music;
        if (mp != null) {
            if (!mp.isPlaying()) {mp.start();}
        } else {
            mp = MediaPlayer.create(context, R.raw.lastfridaynight); //Ur BackGround Music
        }

        if (mp == null) {
            Log.e(TAG, "player was not created successfully");
        } else {
            try {
                mp.setLooping(true);
                mp.start();
            } catch (Exception e) {Log.e(TAG, e.getMessage(), e);}
        }
    }

    //Pause the Music
    public static void pause() {
        if (mp != null) {
            if (mp.isPlaying()) {mp.pause();}
        }

        // previousMusic should always be something valid
        if (currentMusic != -1) {
            {previousMusic = currentMusic;}
            currentMusic = -1;}
    }

    //Stop playing the song
    public static void release() {
        try {
            if (mp != null) {
                if (mp.isPlaying()) {mp.stop();}
                mp.release();
            }
        } catch (Exception e) {Log.e(TAG, e.getMessage(), e);}

        if (currentMusic != -1) {previousMusic = currentMusic;}
        currentMusic = -1;
    }
}