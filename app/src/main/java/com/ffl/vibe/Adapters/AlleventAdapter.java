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
 * Created by PJS on 9/25/2017.
 */

public class AlleventAdapter extends ArrayAdapter<EventEntity> {

    private static class ViewHolder {
        TextView tvEventName;
        TextView tvEventdate;
        TextView tvEventClub;
        ImageView imgposter;
    }
    public AlleventAdapter(Context context, ArrayList<EventEntity> event) {
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
        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.item_allevent, parent, false);


            viewHolder.tvEventName = (TextView) convertView.findViewById(R.id.tveventname);
            viewHolder.tvEventClub = (TextView) convertView.findViewById(R.id.tveventclub);
            viewHolder.imgposter= (ImageView) convertView.findViewById(R.id.imgposter);
            viewHolder.tvEventdate= (TextView) convertView.findViewById(R.id.tveventdate);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);

        }else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.tvEventName.setText(event.Event_name);
        viewHolder.tvEventClub.setText(event.Event_club);
        viewHolder.tvEventdate.setText(event.Event_date);
        Picasso.with(getContext()).load(event.getEvent_poster()).placeholder(R.drawable.vibe_logo).into(viewHolder.imgposter);
       // Picasso.with(getContext()).load(event.getEvent_poster()).into(viewHolder.imgposter);

        // Return the completed view to render on screen
        return convertView;
    }
}
