package com.ffl.vibe.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ffl.vibe.Models.EventEntity;
import com.ffl.vibe.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by PJS on 10/27/2017.
 */

public class MyeventAdapter extends RecyclerView.Adapter<MyeventAdapter.ViewHolder> {

    List<EventEntity> listmyevent = Collections.emptyList();
    Context mContext;

    public MyeventAdapter(List<EventEntity> list, Context context) {
        this.listmyevent = list;
        this.mContext = context;
    }
    // Define listener member variable
    private OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView tvEventNamemy;
        public  TextView tvEventdatemy;
        public  TextView tvEventClubmy;
        public  ImageView imgpostermy;

        public ViewHolder(final View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            imgpostermy = (ImageView)itemView.findViewById(R.id.imgpostermy);
            tvEventNamemy = (TextView)itemView.findViewById(R.id.tveventnamemy);
            tvEventdatemy = (TextView)itemView.findViewById(R.id.tveventdatemy);
            tvEventClubmy = (TextView)itemView.findViewById(R.id.tveventclubmy);

            // Setup the click listener
        /*    itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });*/
        }

    }

    @Override
    public MyeventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View myeventView = inflater.inflate(R.layout.item_myevent, parent, false);

        // Return a new holder instance
        MyeventAdapter.ViewHolder viewHolder = new MyeventAdapter.ViewHolder(myeventView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EventEntity event = listmyevent.get(position);

        // Populate data into the template view using the data object
        holder.tvEventNamemy.setText(event.getEvent_name());
        holder.tvEventdatemy.setText(event.getEvent_date());
        holder.tvEventClubmy.setText(event.getEvent_club());
        Glide.with(getContext())
                .load(Uri.parse(event.getEvent_poster()))
                .placeholder(R.drawable.vibe_logo)
                .into(holder.imgpostermy);
        // Return the completed view to render on screen
    }

    @Override
    public int getItemCount() {
        return listmyevent.size();
    }
    private Context getContext() {
        return mContext;
    }
}
