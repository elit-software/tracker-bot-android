package test;

import com.elit.TrackingPresenter;
import com.elit.TrackingService;
import com.elit.TrackingView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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

        Mockito.verify(service).track(presenter);
    }

    @Test public void
    notifies_view_when_track_is_completed() throws Exception {
        final String anInformation = "Did track project XXX";
        final TrackingPresenter presenter = new TrackingPresenter(view, service);

        presenter.didTrack(anInformation);

        Mockito.verify(view).showTrackInformation(anInformation);
    }
}