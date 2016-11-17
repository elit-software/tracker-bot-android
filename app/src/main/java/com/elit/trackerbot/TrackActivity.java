package com.elit.trackerbot;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TrackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView trackTextView = (TextView) findViewById(R.id.trackTextView);

        findViewById(R.id.trackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
