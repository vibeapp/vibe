package com.ffl.vibe.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ffl.vibe.Models.ClubEntity;
import com.ffl.vibe.R;

import java.util.ArrayList;

/**
 * Created by PJS on 9/29/2017.
 */

public class AllclubAdapter  extends ArrayAdapter<ClubEntity> {
    private static class ViewHolder {
        TextView tvClubName;
        TextView tvClubAddress;
        TextView tvClubcity;
    }
    public AllclubAdapter(Context context, ArrayList<ClubEntity> club) {
        super(context, 0, club);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        ClubEntity club= getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.item_allclub, parent, false);


            viewHolder.tvClubName = (TextView) convertView.findViewById(R.id.tvclubname);
            viewHolder.tvClubAddress= (TextView) convertView.findViewById(R.id.tvclubadress);
            viewHolder.tvClubcity= (TextView) convertView.findViewById(R.id.tvclubcity);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);

        }else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvClubName.setText(club.Club_name);
        viewHolder.tvClubAddress.setText(club.Club_address);
        viewHolder.tvClubcity.setText(club.Club_city);

        return convertView;
    }
}
