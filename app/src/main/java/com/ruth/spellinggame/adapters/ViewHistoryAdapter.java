package com.ruth.spellinggame.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewHistoryAdapter extends RecyclerView.Adapter<ViewHistoryAdapter.ViewHistoryViewHolder> {
    //change this List<String> to expected class
    List<String> mWords;
    @NonNull
    @Override
    public ViewHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHistoryViewHolder holder, int position) {
        holder.bindWord(mWords.get(position));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHistoryViewHolder extends RecyclerView.ViewHolder{
        public ViewHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        // change String s to appropriate thing
        public void bindWord(String s) {
        }
    }
}
