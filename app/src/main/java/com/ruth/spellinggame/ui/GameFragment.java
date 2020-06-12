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
import android.widget.TextView;

import com.ruth.spellinggame.R;
import com.ruth.spellinggame.models.WebsterSearchResponse;
import com.ruth.spellinggame.networks.WebsterApi;
import com.ruth.spellinggame.networks.WebsterClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ruth.spellinggame.Constants.WEBSTER_API_KEY;

public class GameFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = GameFragment.class.getSimpleName();
    private static final String WEBSITER_API_KEY = WEBSTER_API_KEY;
    private Button mFindWordButton;
    private EditText mSearchWord;
    private String mResults;
    private TextView mWordDefinition;
    private TextView mCorrectResult;
    private TextView mWrongResult;

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
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFindWordButton = view.findViewById(R.id.findWordButton);
        mSearchWord = view.findViewById(R.id.searchWordEditText);
        mWordDefinition = view.findViewById(R.id.wordDefinition);
        mCorrectResult = view.findViewById(R.id.correctResult);
        mWrongResult = view.findViewById(R.id.wrongResult);
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
        WebsterApi client = WebsterClient.getClient();
        Call<List<WebsterSearchResponse>> call = client.getDefinition(word, WEBSITER_API_KEY);
        call.enqueue(new Callback<List<WebsterSearchResponse>>() {
            @Override
            public void onResponse( Call<List<WebsterSearchResponse>> call, Response<List<WebsterSearchResponse>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Response is successful " + response);
                    mResults = response.body().get(0).getShortdef().get(0);
                    mWordDefinition.setText("Definition is: " + mResults);
                    Log.d("Here it is", mResults);
                    showDefinition();
                }
                else {
                    showUnsuccessful();
                }
            }

            @Override
            public void onFailure(Call<List<WebsterSearchResponse>> call, Throwable t) {
                Log.e(TAG, "This is failure: ", t);
            }
        });
    }

    private void showUnsuccessful() {
        mWrongResult.setVisibility(View.VISIBLE);
    }

    private void showDefinition() {
        mCorrectResult.setVisibility(View.VISIBLE);
        mWordDefinition.setVisibility(View.VISIBLE);
    }
}
