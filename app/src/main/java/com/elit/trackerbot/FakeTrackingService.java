package com.elit.trackerbot;

import com.elit.TrackingService;
import com.elit.TrackingServiceObserver;

public class FakeTrackingService implements TrackingService {
    @Override
    public void track(TrackingServiceObserver observer) {
        observer.didTrack("You tracked Project XXX");
    }
}
