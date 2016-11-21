package com.elit.trackerbot;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


import com.elit.TrackingPresenter;
import com.elit.TrackingView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_track)
public class TrackActivity extends Activity implements TrackingView {

    @ViewById(R.id.trackTextView)
    TextView trackTextView;

    TrackingPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        presenter = new TrackingPresenter(this, new FakeTrackingService());
    }

    @Click
    public void trackButton() {
        presenter.track();
    }

    @Override
    public void showTrackInformation(String information) {
        trackTextView.setText(information);
    }
}
