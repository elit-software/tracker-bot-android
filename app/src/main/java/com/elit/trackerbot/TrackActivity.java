package com.elit.trackerbot;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.elit.trackerbot.core.TrackingPresenter;
import com.elit.trackerbot.core.TrackingView;

public class TrackActivity extends Activity implements TrackingView {

    TrackingPresenter presenter;
    TextView trackTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new TrackingPresenter(this, new FakeTrackingService());

        trackTextView = (TextView) findViewById(R.id.trackTextView);

        findViewById(R.id.trackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.track();
            }
        });
    }

    @Override
    public void showTrackInformation(String information) {
        trackTextView.setText(information);
    }
}
