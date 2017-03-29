package mx.develop.orp.sampleapp.domain;

import java.util.List;

import mx.develop.orp.sampleapp.data.repository.MainRepository;
import mx.develop.orp.sampleapp.data.repository.MainRepositoryImpl;
import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by oscar on 16/03/17.
 */

public class MainInteractorImpl implements MainInteractor {
    @Override
    public Observable<Boolean> getMainRemote(String request) {
        //Build request

        ///////
        MainRepository mainRepository = new MainRepositoryImpl();
        return mainRepository.getMainRemote(new InfiniteFeedInfo())
                .flatMap(new Func1<InfiniteFeedInfo, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(InfiniteFeedInfo infiniteFeedInfo) {
                        return Observable.just(true);
                    }
                });
    }

    @Override
    public Observable<List<InfiniteFeedInfo>> getMainLocal(String request) {
        MainRepository mainRepository = new MainRepositoryImpl();
        return mainRepository.getMainLocal(new InfiniteFeedInfo());
    }
}
