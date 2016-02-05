package com.viralypatel.sharedpreferencehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.viralypatel.sharedpreferencehelper.lib.SharedPreferenceHelper;

public class MainActivity extends AppCompatActivity {

    SharedPreferenceHelper sph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleMethodCalls();
    }

    private void exampleMethodCalls(){

        // create an instance of the SharedPreferenceHelper
        sph = new SharedPreferenceHelper(this);

        // trying to get not existing preferences gets default values

        boolean noexistbool = sph.getBoolean("doesnotexist");
        Log.w("DEFAULTVAL", String.valueOf(noexistbool));

        sph.putBoolean("bool", true);
        boolean boolval = sph.getBoolean("bool");
        Log.w("SETVAL", String.valueOf(boolval));

    }
}
