package mx.develop.orp.sampleapp.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mx.develop.orp.sampleapp.R;
import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;

/**
 * Created by oscar on 16/03/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder>{

    private Context context;
    private AdapterCallBack mItemListener;
    private List<InfiniteFeedInfo> feedList;

    public MainAdapter(Context context, AdapterCallBack mItemListener, List<InfiniteFeedInfo> feedList) {
        this.mItemListener = mItemListener;
        this.feedList = feedList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_main_item_info_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InfiniteFeedInfo feedInfo = feedList.get(position);
        holder.titleTextView.setText(feedInfo.getTitle());
        holder.captionsTextView.setText(feedInfo.getCaption());
        holder.distanceTextView.setText(feedInfo.getTime());
        Glide.with(context).load(feedInfo.getImageUrl()).into(holder.imageView);
    }

    public interface AdapterCallBack {
        void onItemClicked(InfiniteFeedInfo feedInfo);
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView, captionsTextView, distanceTextView;
        ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.tv_main_item_title);
            captionsTextView = (TextView) itemView.findViewById(R.id.tv_main_item_caption);
            distanceTextView = (TextView) itemView.findViewById(R.id.tv_main_item_footer);
            imageView = (ImageView) itemView.findViewById(R.id.iv_main_item_image);
            itemView.setOnClickListener(clickListener);
        }

        private View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemListener.onItemClicked(feedList.get(getPosition()));
            }
        };
    }
}
