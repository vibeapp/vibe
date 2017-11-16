package com.ffl.vibe.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.ffl.vibe.Adapters.MyeventAdapter;
import com.ffl.vibe.Models.EventEntity;
import com.ffl.vibe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by PJS on 9/22/2017.
 */

public class MyeventFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private RecyclerView rvmyevent;
    private MyeventAdapter myeventAdapter;
    private ArrayList<EventEntity> listmyevent;
    public static MyeventFragment newInstance(int page) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        MyeventFragment fragment = new MyeventFragment();
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
        View view = inflater.inflate(R.layout.fragment_myevent, container, false);
        rvmyevent = (RecyclerView) view.findViewById(R.id.rvmyevent);
        listmyevent = new ArrayList<>();

        // initialize the adapter
        myeventAdapter = new MyeventAdapter(listmyevent,getContext());

        // attach the adapter to the RecyclerView
        rvmyevent.setAdapter(myeventAdapter);

        // Set layout manager to position the items
        rvmyevent.setLayoutManager(new LinearLayoutManager(getContext()));
        IDataStore<Map> eventlivestore= Backendless.Data.of("event");
        eventlivestore.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                final ArrayList<EventEntity> listevents=EventEntity.fromListMap(response);
                    listmyevent.addAll(EventEntity.fromListMap(response));
                myeventAdapter.notifyDataSetChanged();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.getCode());
                Toast.makeText(getContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
// In the activity or fragment
      /*  MyeventAdapter myeventAdapter=null;
        myeventAdapter.setOnItemClickListener(new MyeventAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                EventEntity event=listmyevent.get(position);
                String name = event.getEvent_name();
                Toast.makeText(getContext(), name + " was clicked!", Toast.LENGTH_SHORT).show();
            }
        });*/
        return view;
    }
}
