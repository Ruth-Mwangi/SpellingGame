package com.ruth.spellinggame.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruth.spellinggame.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewHistoryAdapter extends RecyclerView.Adapter<ViewHistoryAdapter.ViewHistoryViewHolder> {
    private ContentView mContext;
    //change this List<String> to expected class
    private List<String> mWords;

    public ViewHistoryAdapter(ContentView mContext, List<String> mWords) {
        this.mContext = mContext;
        this.mWords = mWords;
    }

    @NonNull
    @Override
    public ViewHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_history_item,parent,false);
        ViewHistoryViewHolder viewHolder=new ViewHistoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHistoryViewHolder holder, int position) {
        holder.bindWord(mWords.get(position));

    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public class ViewHistoryViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.viewHistoryWord)
        TextView viewHistoryWord;
        @BindView(R.id.viewHistoryDefinition)
        TextView viewHistoryDefinition;
        public ViewHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        // change String s to appropriate thing
        public void bindWord(String s) {
            //change this to get name and definition
            viewHistoryWord.setText(s);
            viewHistoryDefinition.setText(s);
        }
    }
}
