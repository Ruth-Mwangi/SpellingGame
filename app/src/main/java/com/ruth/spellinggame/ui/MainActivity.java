package com.ruth.spellinggame.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ruth.spellinggame.R;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button ) Button mStartGameButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartGameButton  = (Button)findViewById(R.id.button);
        mStartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameFragment.class);
                startActivity(intent);
            }
        });
    }
}
