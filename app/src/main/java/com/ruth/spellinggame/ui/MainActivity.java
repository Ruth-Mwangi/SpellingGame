package com.ruth.spellinggame.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.ruth.spellinggame.R;

public class MainActivity extends AppCompatActivity {
    private Button mStartGameButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartGameButton  = (Button)findViewById(R.id.button);
    }
}
