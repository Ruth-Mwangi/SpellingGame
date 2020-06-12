package com.ruth.spellinggame.ui;

import android.os.Bundle;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ruth.spellinggame.R;
import com.ruth.spellinggame.adapters.ViewHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ViewHistoryFragment extends Fragment {
    @BindView(R.id.viewHistoryRecyclerView)
    RecyclerView viewHistoryRecyclerView;
    private DatabaseReference ref;
    private ViewHistoryAdapter mAdapter;


    public ViewHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_view_history, container, false);
        getHistory();
        return view;
    }

    private void getHistory() {
        final List<String> words= new ArrayList<>();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String uid= user.getUid();
        //add info to getReference()
        ref= FirebaseDatabase.getInstance().getReference();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //add words from db to LIst words
                    //words.add(snapshot.getValue(Business.class));
                }
                mAdapter = new ViewHistoryAdapter(getContext(),words);
                viewHistoryRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
                viewHistoryRecyclerView.setLayoutManager(layoutManager);
                viewHistoryRecyclerView.setHasFixedSize(true);
                showRestaurants();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void showRestaurants() {
        viewHistoryRecyclerView.setVisibility(View.VISIBLE);
    }
}
