package com.codepath.sampleinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codepath.sampleinstagram.fragments.ComposeFragment;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG="SignupActivity";
    private Button signUp;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button etSignup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        etSignup=findViewById(R.id.etSignup);


        etSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                addUser(username,password);

            }
        });
    }

    private void addUser(String username, String password) {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with login");
                    e.printStackTrace();
                    return;
                }
                goMainActivity();
                Log.d(TAG,"Login Successful.");

            }
        });
    }

    public void goMainActivity(){
        Log.d(TAG,"Navigating to MainActivity");
        Intent i= new Intent(this, ComposeFragment.class);
        startActivity(i);
        finish();
    }
}
