package com.elit.trackerbot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    @Mock
    private TrackingService service;

    @Test public void
    calls_tracking_service_when_track_is_called() throws Exception {
        TrackingPresenter presenter = new TrackingPresenter(service);

        presenter.track();

        verify(service).track();
    }
}