package com.ffl.vibe.Fragments;

import android.content.Intent;
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
import com.ffl.vibe.Activities.DetailseventActivity;
import com.ffl.vibe.Adapters.AlleventAdapter;
import com.ffl.vibe.Models.EventEntity;
import com.ffl.vibe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by PJS on 9/22/2017.
 */

public class AllEventFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    ListView lvAllevent;
    ArrayList<EventEntity> listEvent;
    AlleventAdapter adapterevent;
    public static AllEventFragment newInstance(int page) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AllEventFragment fragment = new AllEventFragment();
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
        View view = inflater.inflate(R.layout.fragment_allevent, container, false);
        setHasOptionsMenu(true);
        lvAllevent=(ListView)view.findViewById(R.id.lvallevent);
        listEvent=new ArrayList<>();
        adapterevent=new AlleventAdapter(getContext(),listEvent);
        lvAllevent.setAdapter(adapterevent);

        IDataStore<Map> eventstore= Backendless.Data.of("event");

        eventstore.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                adapterevent.addAll(EventEntity.fromListMap(response));
                adapterevent.notifyDataSetChanged();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.getCode());
                Toast.makeText(getContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        lvAllevent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               EventEntity event=listEvent.get(position);
                Intent intent = new Intent(getActivity(), DetailseventActivity.class);
                intent.putExtra("event", event);
                startActivity(intent);
            }
        });
        return view;

    }
}
