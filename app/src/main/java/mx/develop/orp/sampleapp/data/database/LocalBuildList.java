package mx.develop.orp.sampleapp.data.database;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;

/**
 * Created by oscar on 16/03/17.
 */

public class LocalBuildList {

    public List<InfiniteFeedInfo> getList() {
        List<InfiniteFeedInfo> list = new ArrayList<>();
        InfiniteFeedInfo feed1 = new InfiniteFeedInfo();
        feed1.setTitle("Gas 1");
        feed1.setCaption("56.3");
        feed1.setTime("1236");
        feed1.setImageUrl("http://ia.media-imdb.com/images/M/MV5BMjA2NTE0NzkyMF5BMl5BanBnXkFtZTgwMjAwMzg5NjE@._V1._SY140_.jpg");
        list.add(feed1);
        InfiniteFeedInfo feed2 = new InfiniteFeedInfo();
        feed2.setTitle("Gas 1");
        feed2.setCaption("56.3");
        feed2.setTime("1236");
        feed2.setImageUrl("http://ia.media-imdb.com/images/M/MV5BMzEzOTk4OTQ2OF5BMl5BanBnXkFtZTYwMzkyODQ2._V1._SY140_.jpg");
        list.add(feed2);
        InfiniteFeedInfo feed3 = new InfiniteFeedInfo();
        feed3.setTitle("Gas 1");
        feed3.setCaption("56.3");
        feed3.setTime("1236");
        feed3.setImageUrl("http://ia.media-imdb.com/images/M/MV5BMjA2NTE0NzkyMF5BMl5BanBnXkFtZTgwMjAwMzg5NjE@._V1._SY140_.jpg");
        list.add(feed3);
        InfiniteFeedInfo feed4 = new InfiniteFeedInfo();
        feed4.setTitle("Gas 1");
        feed4.setCaption("56.3");
        feed4.setTime("1236");
        feed4.setImageUrl("http://ia.media-imdb.com/images/M/MV5BMzEzOTk4OTQ2OF5BMl5BanBnXkFtZTYwMzkyODQ2._V1._SY140_.jpg");
        list.add(feed4);

        return list;
    }
}
