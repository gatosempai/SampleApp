package mx.develop.orp.sampleapp.presentation.fragment;

import java.util.List;

import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;

/**
 * Created by oscar on 16/03/17.
 */

public interface MainFragmentView {

    void showProgress();
    void hideProgress();

    void onResponse(InfiniteFeedInfo response);
}
