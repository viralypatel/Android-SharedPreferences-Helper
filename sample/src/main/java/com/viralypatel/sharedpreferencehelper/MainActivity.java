package com.viralypatel.sharedpreferencehelper;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.viralypatel.sharedpreferencehelper.lib.SharedPreferenceHelper;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    SharedPreferenceHelper sph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleMethodCalls();
    }

    private void exampleMethodCalls(){


        // use one of the following ways to instantiate
        sph = new SharedPreferenceHelper(this); //this will use default shared preferences
        sph = new SharedPreferenceHelper(this, "myappprefs"); // this will create a named shared preference file
        sph = new SharedPreferenceHelper(this, "myappprefs", 0); // this will allow you to specify a mode

        // putting values
        sph.putBoolean("boolKey", true);
        sph.putInt("intKey", 123);
        sph.putString("stringKey", "string value");
        sph.putLong("longKey", 456876451);
        sph.putFloat("floatKey", 1.51f);

        // putStringSet is supported only for android versions above HONEYCOMB
        Set name = new HashSet();
        name.add("Viral");
        name.add("Patel");
        sph.putStringSet("name", name);

        //getting values
        sph.getBoolean("boolKey");
        sph.getInt("intKey");
        sph.getString("stringKey");
        sph.getLong("longKey");
        sph.getFloat("floatKey");

        // getStringSet is supported only for android versions above HONEYCOMB
        sph.getStringSet("name");


        // getting values with custom default per key
        sph.getBoolean("boolKey", true);
        sph.getInt("intKey", -1);
        sph.getString("stringKey", "my custom default string");
        sph.getLong("longKey", -222);
        sph.getFloat("floatKey", -13.76f);

        // getStringSet is supported only for android versions above HONEYCOMB
        sph.getStringSet("name", new HashSet<String>());


        //changing default calues for each datatype
        sph.setBoolDefaultVal(true);
        sph.setFloatDefaultVal(-3.6f);
        sph.setIntDefaultVal(-3);
        sph.setLongDefaultVal(-999);
        sph.setStringDefaultVal("custom default string");
        sph.setStringSetDefaultVal(new HashSet<String>());


        //regisering a listener
        SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                // do what you got to do here
            }
        };

        sph.registerListener(listener);

        //unregistering the listener
        sph.unregisterListener(listener);

    }
}
