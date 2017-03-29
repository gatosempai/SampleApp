package mx.develop.orp.sampleapp.presentation.presenter;

import android.util.Log;

import java.util.List;

import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;
import mx.develop.orp.sampleapp.domain.MainInteractor;
import mx.develop.orp.sampleapp.domain.MainInteractorImpl;
import mx.develop.orp.sampleapp.presentation.fragment.MainFragmentView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by oscar on 16/03/17.
 */

public class MainPresenter {

    private MainFragmentView mainFragmentView;

    public MainPresenter(MainFragmentView mainFragmentView) {
        this.mainFragmentView = mainFragmentView;
    }

    public void getMainStuff(String something) {
        Log.i("Presenter", "getMainStuff");
        mainFragmentView.showProgress();
        MainInteractor interactor = new MainInteractorImpl();
        interactor.getMainLocal(something)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<InfiniteFeedInfo>>() {
                    @Override
                    public void onCompleted() {
                        Log.i("Presenter", "getMainStuff onComplete");
                        mainFragmentView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainFragmentView.hideProgress();
                    }

                    @Override
                    public void onNext(List<InfiniteFeedInfo> list) {
                        Log.i("Presenter", "getMainStuff onNext");
                        for (InfiniteFeedInfo feed : list) mainFragmentView.onResponse(feed);
                    }
                });
    }
}
