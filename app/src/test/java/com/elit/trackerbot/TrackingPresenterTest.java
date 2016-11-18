package com.elit.trackerbot;

import com.elit.trackerbot.core.TrackingPresenter;
import com.elit.trackerbot.core.TrackingService;
import com.elit.trackerbot.core.TrackingView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TrackingPresenterTest {

    @Mock
    private TrackingService service;

    @Mock
    private TrackingView view;

    @Test public void
    delegates_to_service_when_track_is_called() throws Exception {
        TrackingPresenter presenter = new TrackingPresenter(view, service);

        presenter.track();

        verify(service).track(presenter);
    }

    @Test public void
    notifies_view_when_track_is_completed() throws Exception {
        final String anInformation = "Did track project XXX";
        final TrackingPresenter presenter = new TrackingPresenter(view, service);

        presenter.didTrack(anInformation);

        verify(view).showTrackInformation(anInformation);
    }
}