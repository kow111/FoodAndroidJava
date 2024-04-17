package com.pro.foodorder.prefs;

import android.content.Context;

public class MySharedPreferences {
    private static final String FRUITY_DROID_PREFERENCES = "MY_PREFERENCES";
    private Context mContext;

    private MySharedPreferences() {
    }

    public MySharedPreferences(Context mContext) {
        this.mContext = mContext;
    }

    public void putStringValue(String key, String s) {
        android.content.SharedPreferences pref = mContext.getSharedPreferences(
                FRUITY_DROID_PREFERENCES, 0);
        android.content.SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, s);
        editor.apply();
    }

    public String getStringValue(String key) {
        android.content.SharedPreferences pref = mContext.getSharedPreferences(
                FRUITY_DROID_PREFERENCES, 0);
        return pref.getString(key, "");
    }
}
