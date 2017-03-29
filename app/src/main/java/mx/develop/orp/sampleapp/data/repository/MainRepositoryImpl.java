package mx.develop.orp.sampleapp.data.repository;

import java.util.List;

import mx.develop.orp.sampleapp.data.database.LocalBuildList;
import mx.develop.orp.sampleapp.data.rest.RestServiceFactory;
import mx.develop.orp.sampleapp.data.rest.endpoint.MainRestService;
import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;
import rx.Observable;

/**
 * Created by oscar on 16/03/17.
 */

public class MainRepositoryImpl implements MainRepository {
    @Override
    public Observable<InfiniteFeedInfo> getMainRemote(InfiniteFeedInfo request) {
        MainRestService mainRestService = RestServiceFactory
                .createRetrofitService(MainRestService.class,  MainRestService.SERVICE_ENDPOINT);
        return mainRestService.doMain(request);
    }

    @Override
    public Observable<List<InfiniteFeedInfo>> getMainLocal(InfiniteFeedInfo request) {
        return Observable.just(new LocalBuildList().getList());
    }
}
