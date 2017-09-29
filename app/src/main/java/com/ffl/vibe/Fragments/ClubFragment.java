package com.ffl.vibe.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.ffl.vibe.Adapters.AllclubAdapter;
import com.ffl.vibe.Models.ClubEntity;
import com.ffl.vibe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by PJS on 9/22/2017.
 */

public class ClubFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    ListView lvAllclub;
    ArrayList<ClubEntity> listClub;
    AllclubAdapter adapterclub;
    public static ClubFragment newInstance(int page) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ClubFragment fragment = new ClubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_allclub, container, false);


        setHasOptionsMenu(true);
        lvAllclub=(ListView)view.findViewById(R.id.lvallclub);
        listClub=new ArrayList<>();
        adapterclub=new AllclubAdapter(getContext(),listClub);
        lvAllclub.setAdapter(adapterclub);

        IDataStore<Map> clubstore= Backendless.Data.of("club");
        clubstore.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                adapterclub.addAll(ClubEntity.fromListMap(response));
                adapterclub.notifyDataSetChanged();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.getCode());
                Toast.makeText(getContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        lvAllclub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClubEntity club=listClub.get(position);
                Toast.makeText(getContext(), "Click on"+club.Club_name, Toast.LENGTH_SHORT).show();
            }
        });
        return view;}
}
