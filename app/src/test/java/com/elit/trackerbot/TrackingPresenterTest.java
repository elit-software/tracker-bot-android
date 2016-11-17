package com.elit.trackerbot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
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
        final String information = "Did track project XXX";
        final TrackingPresenter presenter = new TrackingPresenter(view, service);
        doAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                presenter.didTrack(information);
                return "";
            }
        }).when(service).track(presenter);

        presenter.track();

        verify(view).showTrackInformation(information);
    }
}