package mx.develop.orp.sampleapp.data.repository;

import java.util.List;

import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;
import rx.Observable;

/**
 * Created by oscar on 16/03/17.
 */

public interface MainRepository {

    Observable<InfiniteFeedInfo> getMainRemote(InfiniteFeedInfo request);
    Observable<List<InfiniteFeedInfo>> getMainLocal(InfiniteFeedInfo request);
}
