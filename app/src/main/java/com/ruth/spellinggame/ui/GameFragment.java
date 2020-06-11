package com.ruth.spellinggame.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ruth.spellinggame.models.WebsterSearchResponse;
import com.ruth.spellinggame.adapters.DefinitionAdapter;
import com.ruth.spellinggame.R;
import com.ruth.spellinggame.networks.WebsterApi;
import com.ruth.spellinggame.networks.WebsterClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ruth.spellinggame.Constants.WEBSTER_API_KEY;

public class GameFragment extends Fragment implements View.OnClickListener {
    private static final String WEBSITER_API_KEY = WEBSTER_API_KEY;
    private Button mFindWordButton;
    private EditText mSearchWord;
    private List<String> mResults = new ArrayList<>();
    private DefinitionAdapter mDefinitionAdapter;

    public static final String TAG = GameFragment.class.getSimpleName();
    private TextView mWordDefinition;

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
        mFindWordButton = view.findViewById(R.id.findWordButton);
        mSearchWord = view.findViewById(R.id.searchWordEditText);
        mWordDefinition = view.findViewById(R.id.wordDefinition);
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
        Call<WebsterSearchResponse> call = client.getDefinition(word, WEBSITER_API_KEY);
        call.enqueue(new Callback<WebsterSearchResponse>() {
            @Override
            public void onResponse( Call<WebsterSearchResponse> call, Response<WebsterSearchResponse> response) {
                if (response.isSuccessful()) {
                    mResults = response.body().getShortdef();
                    Log.d("Here it is", String.valueOf(mResults));
//                    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout., mResults);
                    mWordDefinition.setText(mResults.get(0));
                }
            }

            @Override
            public void onFailure(Call<WebsterSearchResponse> call, Throwable t) {
                Log.e(TAG, "This is the Failure: ", t);
            }
        });
    }
}
