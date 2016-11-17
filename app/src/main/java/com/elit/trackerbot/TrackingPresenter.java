package com.elit.trackerbot;

public class TrackingPresenter implements TrackingServiceDelegate {

    private final TrackingView view;
    private final TrackingService service;

    public TrackingPresenter(TrackingView view, TrackingService service) {
        this.view = view;
        this.service = service;
    }

    public void track() {
        service.track(this);
    }

    @Override
    public void didTrack(String information) {
        view.showTrackInformation(information);
    }
}
