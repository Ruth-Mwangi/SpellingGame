package com.ruth.spellinggame.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.ruth.spellinggame.R;

import butterknife.BindView;

public class ViewHistoryFragment extends Fragment {
    @BindView(R.id.viewHistoryRecyclerView)
    RecyclerView viewHistoryRecyclerView;
    private DatabaseReference ref;


    public ViewHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_view_history, container, false);
        return view;
    }
}
