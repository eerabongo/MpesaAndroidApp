package com.esau.mpesatrial.api;

import android.content.Context;
import android.content.SharedPreferences;

public class StoreKey {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;
    private static final String SHARED_PREFER_FILE_NAME = "keys";

    /**
     * Retrieve data from preference:
     */
    public StoreKey(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(SHARED_PREFER_FILE_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Setting values in Preference:
     */
    public void createKey(String key_name) {
        editor.putString("key_name", key_name);
        editor.commit();
    }

}
