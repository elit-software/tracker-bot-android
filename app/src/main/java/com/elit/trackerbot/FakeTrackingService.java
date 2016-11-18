package com.elit.trackerbot;

import com.elit.trackerbot.core.TrackingService;
import com.elit.trackerbot.core.TrackingServiceObserver;

public class FakeTrackingService implements TrackingService {
    @Override
    public void track(TrackingServiceObserver observer) {
        observer.didTrack("You tracked Project XXX");
    }
}
