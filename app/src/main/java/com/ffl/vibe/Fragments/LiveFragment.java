package com.ffl.vibe.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.ffl.vibe.Adapters.LiveeventAdapter;
import com.ffl.vibe.Models.EventEntity;
import com.ffl.vibe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by PJS on 9/22/2017.
 */

public class LiveFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    ListView lveventlive;
    ArrayList<EventEntity> listeventlive;
   LiveeventAdapter adapterlive;
    public static LiveFragment newInstance(int page) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage=getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live, container, false);
        setHasOptionsMenu(true);
        listeventlive=new ArrayList<>();
        lveventlive=(ListView)view.findViewById(R.id.lvliveEvents);
        adapterlive=new LiveeventAdapter(getContext(),listeventlive);
        lveventlive.setAdapter(adapterlive);

        IDataStore<Map> eventlivestore= Backendless.Data.of("event");
        eventlivestore.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                adapterlive.addAll(EventEntity.fromListMap(response));
                adapterlive.notifyDataSetChanged();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.getCode());
                Toast.makeText(getContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
