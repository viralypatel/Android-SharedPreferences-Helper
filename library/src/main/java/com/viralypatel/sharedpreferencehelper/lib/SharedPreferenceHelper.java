package com.viralypatel.sharedpreferencehelper.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.Map;
import java.util.Set;

/**
 * Created by Viral Patel on 01-Feb-16.
 */
public class SharedPreferenceHelper {

    SharedPreferences settings;
    SharedPreferences.Editor editor;

    //region Default Values for various types
    private int intDefaultVal = 0;
    private long longDefaultVal = 0;
    private float floatDefaultVal = 0;
    private boolean boolDefaultVal = false;
    private String stringDefaultVal = "";
    private Set<String> stringSetDefaultVal = null;
    //endregion

    //region Getters and Setters for default Values
    public int getIntDefaultVal() {
        return intDefaultVal;
    }

    public void setIntDefaultVal(int intDefaultVal) {
        this.intDefaultVal = intDefaultVal;
    }

    public long getLongDefaultVal() {
        return longDefaultVal;
    }

    public void setLongDefaultVal(long longDefaultVal) {
        this.longDefaultVal = longDefaultVal;
    }

    public float getFloatDefaultVal() {
        return floatDefaultVal;
    }

    public void setFloatDefaultVal(float floatDefaultVal) {
        this.floatDefaultVal = floatDefaultVal;
    }

    public boolean isBoolDefaultVal() {
        return boolDefaultVal;
    }

    public void setBoolDefaultVal(boolean boolDefaultVal) {
        this.boolDefaultVal = boolDefaultVal;
    }

    public String getStringDefaultVal() {
        return stringDefaultVal;
    }

    public void setStringDefaultVal(String stringDefaultVal) {
        this.stringDefaultVal = stringDefaultVal;
    }

    public Set<String> getStringSetDefaultVal() {
        return stringSetDefaultVal;
    }

    public void setStringSetDefaultVal(Set<String> stringSetDefaultVal) {
        this.stringSetDefaultVal = stringSetDefaultVal;
    }
    //endregion

    //region Constructors
    /**
     * Uses the default shared preferences
     */
    public SharedPreferenceHelper(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * creates a new preference file with specified name
     * @param context
     * @param preferenceFileName
     */
    public SharedPreferenceHelper(Context context, String preferenceFileName) {
        SharedPreferences settings = context.getSharedPreferences(preferenceFileName, 0);
    }

    /**
     * creates a new preference file with specified name and mode
     * @param context
     * @param preferenceFileName
     * @param mode
     */
    public SharedPreferenceHelper(Context context, String preferenceFileName, int mode) {
        SharedPreferences settings = context.getSharedPreferences(preferenceFileName, mode);
    }
    //endregion

    //region Put Methods
    public void putInt(String key, int val) {
        editor = settings.edit();
        editor.putInt(key, val);
        editor.commit();
    }

    public void putString(String key, String val) {
        editor = settings.edit();
        editor.putString(key, val);
        editor.commit();
    }

    public void putBoolean(String key, boolean val) {
        editor = settings.edit();
        editor.putBoolean(key, val);
        editor.commit();
    }

    public void putFloat(String key, float val) {
        editor = settings.edit();
        editor.putFloat(key, val);
        editor.commit();
    }

    public void putLong(String key, long val) {
        editor = settings.edit();
        editor.putLong(key, val);
        editor.commit();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void putStringSet(String key, Set<String> val) {
        editor = settings.edit();
        editor.putStringSet(key, val);
        editor.commit();
    }
    //endregion

    //region Get Methods
     public Map<String, ?> getAll(){
        return settings.getAll();
     }

    public int getInt(String key, int defaultValue) {
        return settings.getInt(key, defaultValue);
    }
    public int getInt(String key) {
        return settings.getInt(key, intDefaultVal);
    }

    public String getString(String key, String defaultValue) {
        return settings.getString(key, defaultValue);
    }
    public String getString(String key) {
        return settings.getString(key, stringDefaultVal);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return settings.getBoolean(key, defaultValue);
    }
    public boolean getBoolean(String key) {
        return settings.getBoolean(key, boolDefaultVal);
    }

    public float getFloat(String key, float defaultValue) {
        return settings.getFloat(key, defaultValue);
    }
    public float getFloat(String key) {
        return settings.getFloat(key, floatDefaultVal);
    }

    public long getLong(String key, long defaultValue) {
        return settings.getLong(key, defaultValue);
    }
    public long getLong(String key) {
        return settings.getLong(key, longDefaultVal);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public Set<String> getStringSet(String key, Set<String> defaultValue) {
        return settings.getStringSet(key, defaultValue);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public Set<String> getStringSet(String key) {
        return settings.getStringSet(key, stringSetDefaultVal);
    }
    //endregion

    //region Listener registering and unregistering methods
    public void registerListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        settings.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        settings.unregisterOnSharedPreferenceChangeListener(listener);
    }
    //endregion
}
