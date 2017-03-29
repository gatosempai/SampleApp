package mx.develop.orp.sampleapp.data.rest.endpoint;

import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by oscar on 16/03/17.
 */

public interface MainRestService {
    String SERVICE_ENDPOINT = "https://algo.net";

    @POST("login")
    Observable<InfiniteFeedInfo> doMain(@Body InfiniteFeedInfo request);
}
