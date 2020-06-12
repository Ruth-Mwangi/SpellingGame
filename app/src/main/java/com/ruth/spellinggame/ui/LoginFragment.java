package com.ruth.spellinggame.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ruth.spellinggame.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.passwordEditText)
    EditText password;
    @BindView(R.id.emailEditText) EditText email;
    @BindView(R.id.loginButton)
    Button login;
    @BindView(R.id.registerTextView)
    TextView register;
    private Class fragmentClass;
    private Fragment fragment;



    public LoginFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,view);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==login){
            loginFirebase();
        }
        if(v==register){
            fragmentClass= CreateAccountFragment.class;
            try {
                fragment=(Fragment) fragmentClass.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager=getParentFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        }

    }

    private void loginFirebase() {
    }
}
