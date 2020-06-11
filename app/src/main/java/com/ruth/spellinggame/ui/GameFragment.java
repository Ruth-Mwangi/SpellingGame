package com.ruth.spellinggame.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ruth.spellinggame.models.OxfordWordSearchResponse;
import com.ruth.spellinggame.R;
import com.ruth.spellinggame.models.Result;
import com.ruth.spellinggame.models.Sense;
import com.ruth.spellinggame.networks.OxfordApi;
import com.ruth.spellinggame.networks.OxfordClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameFragment extends Fragment implements View.OnClickListener {
    private Button mFindWordButton;
    private EditText mSearchWord;
    private List<Result> mResults = new ArrayList<>();

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFindWordButton = (Button) view.findViewById(R.id.findWordButton);
        mSearchWord = (EditText) view.findViewById(R.id.searchWordEditText);
        mFindWordButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindWordButton) {
            String searchWord = mSearchWord.getText().toString();
            findword(searchWord);
        }
    }

    private void findword(String word) {
        OxfordApi client = OxfordClient.getClient();
        Call<OxfordWordSearchResponse> call = client.getWords(word);
        call.enqueue(new Callback<OxfordWordSearchResponse>() {
            @Override
            public void onResponse(Call<OxfordWordSearchResponse> call, Response<OxfordWordSearchResponse> response) {
                if (response.isSuccessful()) {
                    mResults = response.body().getResults();
                    Log.e("results: ", String.valueOf(mResults));
                }
            }

            @Override
            public void onFailure(Call<OxfordWordSearchResponse> call, Throwable t) {

            }
        });
    }
}
