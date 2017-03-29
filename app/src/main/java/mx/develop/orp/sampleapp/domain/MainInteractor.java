package mx.develop.orp.sampleapp.domain;

import java.util.List;

import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;
import rx.Observable;

/**
 * Created by oscar on 16/03/17.
 */

public interface MainInteractor {

    Observable<Boolean> getMainRemote(String request);
    Observable<List<InfiniteFeedInfo>> getMainLocal(String request);
}
