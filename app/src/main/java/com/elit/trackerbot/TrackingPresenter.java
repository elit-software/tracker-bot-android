package com.elit.trackerbot;

public class TrackingPresenter {
    private final TrackingService service;

    public TrackingPresenter(TrackingService service) {
        this.service = service;
    }

    public void track() {
        service.track();
    }
}
