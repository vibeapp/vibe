package com.ffl.vibe.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ffl.vibe.Models.EventEntity;
import com.ffl.vibe.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PJS on 9/30/2017.
 */

public class LiveeventAdapter extends ArrayAdapter<EventEntity> {

    private static class ViewHolder {
        TextView tvEventNamelive;
        TextView tvEventdatelive;
        TextView tvEventClublive;
        ImageView imgposterlive;

    }
    public LiveeventAdapter(Context context, ArrayList<EventEntity> event) {
        super(context, 0, event);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        EventEntity event= getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        // Check if an existing view is being reused, otherwise inflate the view
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.item_liveevent, parent, false);


            viewHolder.tvEventNamelive = (TextView) convertView.findViewById(R.id.tveventnamelive);
            viewHolder.tvEventClublive = (TextView) convertView.findViewById(R.id.tveventclublive);
            viewHolder.imgposterlive= (ImageView) convertView.findViewById(R.id.imgposterlive);
            viewHolder.tvEventdatelive= (TextView) convertView.findViewById(R.id.tveventdatelive);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);

        }else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.tvEventNamelive.setText(event.Event_name);
        viewHolder.tvEventClublive.setText(event.Event_club);
        viewHolder.tvEventdatelive.setText(event.Event_date);
        Picasso.with(getContext()).load(event.getEvent_poster()).into(viewHolder.imgposterlive);

        // Return the completed view to render on screen
        return convertView;
    }
}