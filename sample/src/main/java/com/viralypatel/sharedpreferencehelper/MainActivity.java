package com.viralypatel.sharedpreferencehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.viralypatel.sharedpreferencehelper.lib.SharedPreferenceHelper;

public class MainActivity extends AppCompatActivity {

    SharedPreferenceHelper sph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create an instance of the SharedPreferenceHelper
        sph = new SharedPreferenceHelper(this);
    }
}
