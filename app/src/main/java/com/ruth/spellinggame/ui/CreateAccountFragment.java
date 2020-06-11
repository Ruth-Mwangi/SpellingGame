package com.ruth.spellinggame.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.ruth.spellinggame.R;

import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CreateAccountFragment extends Fragment implements View.OnClickListener{
    public static final String TAG = CreateAccountFragment.class.getSimpleName();
    @BindView(R.id.txtName)EditText mName;
    @BindView(R.id.txtEmail)EditText mEmail;
    @BindView(R.id.txtPass)EditText mPass;
    @BindView(R.id.txtConfirmPass)EditText mConfirmPass;
    @BindView(R.id.btnRegister)Button mBtnRegister;
    @BindView(R.id.txtLogin)TextView mTxtLogin;

    private Context mContext;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mAuthProgressDialog;
    private String mUserName;

    public CreateAccountFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBtnRegister.setOnClickListener(this);
        mTxtLogin.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_create_account, container, false);

        ButterKnife.bind(this,view);
        mBtnRegister.setOnClickListener(this);
        mTxtLogin.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        createAuthStateListener();

        createAuthProgressDialog();
        return view;
    }

    private void createAuthProgressDialog() {
        mAuthProgressDialog = new ProgressDialog(getActivity());
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Authenticating Credentials...");
        mAuthProgressDialog.setCancelable(false);
    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Intent intent=new Intent(getActivity(),GameFragment.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        if (v==mBtnRegister){
            createNewUser();
        }
        if (v==mTxtLogin){
            Toast.makeText(getActivity(),"this",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getActivity(),LoginFragment.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void createNewUser() {
        mUserName = mName.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        String pass = mPass.getText().toString().trim();
        String confirmPass = mConfirmPass.getText().toString().trim();

        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(mUserName);
        boolean validPassword = isValidPassword(pass, confirmPass);
        if (!validEmail || !validName || !validPassword) return;

        mAuthProgressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mAuthProgressDialog.dismiss();
                if (task.isSuccessful()){
                    Log.d(TAG, "Authentication successful");
                    createFirebaseUserProfile(task.getResult().getUser());
                }else {
                    Toast.makeText(getActivity(),"Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createFirebaseUserProfile(final FirebaseUser user) {

        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder()
                .setDisplayName(mUserName)
                .build();

        user.updateProfile(addProfileName)
                .addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, user.getDisplayName());
                        }
                    }

                });
    }


    private boolean isValidPassword(String pass, String confirmPass) {
        if (pass.length() < 6) {
            mPass.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!pass.equals(confirmPass)) {
            mConfirmPass.setError("Passwords do not match");
            return false;
        }
        return true;
    }

    private boolean isValidName(String mUserName) {
        if (mUserName.equals("")) {
            mName.setError("Please enter your name");
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        boolean isGoodEmail =
                (email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            mEmail.setError("Please enter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
