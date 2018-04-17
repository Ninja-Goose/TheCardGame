package org.pltw.examples.thecardgame;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class LoginActivity extends AppCompatActivity {

    //Test user info:
    //Email = test@test.test
    //Pw = testtest
    //Name = test

    private final String TAG = this.getClass().getName();

    private Button signUpButton;
    private TextView signUpText;
    private Button logInButton;
    private EditText userNameEdit;
    private EditText passwordEdit;

    public void warnUser(String message, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logInButton = findViewById(R.id.login_button);
        passwordEdit = findViewById(R.id.enter_password);

        Backendless.initApp( this, getString(R.string.be_app_id), getString(R.string.be_android_api_key));

        signUpText = findViewById(R.id.sign_up_text);
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (signUpButton.getVisibility() == View.GONE) {
                    signUpButton.setVisibility(View.VISIBLE);
                    logInButton.setVisibility(View.GONE);
                    signUpText.setText(R.string.sign_up_cancel);
                } else {
                    signUpButton.setVisibility(View.GONE);
                    logInButton.setVisibility(View.VISIBLE);
                    signUpText.setText(R.string.sign_up_text);
                }
            }
        });

        signUpButton = findViewById(R.id.signup_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                userName = userName.trim();
                password = password.trim();

                if(password.length() < 8) {
                    warnUser(getString(R.string.invalid_password_error), getString(R.string.registration_error_title));
                }
                else if (!userName.isEmpty() &&!password.isEmpty() && !userName.isEmpty()) {
                    BackendlessUser user = new BackendlessUser();
                    user.setPassword(password);
                    user.setProperty("name", userName);

                    Backendless.UserService.register(user,
                            new AsyncCallback<BackendlessUser>() {
                                @Override
                                public void handleResponse( BackendlessUser backendlessUser ) {
                                    final ProgressDialog pDialog = ProgressDialog.show(LoginActivity.this,
                                            getString(R.string.wait_message),
                                            getString(R.string.create_account_wait_message),
                                            true);
                                    Log.i(TAG, "Registration successful for " +
                                            backendlessUser.getProperty("name"));
                                    pDialog.dismiss();
                                    Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                }
                                @Override
                                public void handleFault( BackendlessFault fault ) {
                                    Log.i(TAG, "Registration failed: " + fault.getMessage());
                                    warnUser((fault.getMessage() + "\nError Code (" + fault.getCode() + ")"), getString(R.string.registration_error_title));
                                }
                            } );
                } else {
                    warnUser(getString(R.string.empty_field_signup_error), getString(R.string.authentication_error_title));
                }
            }
        });

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = userNameEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                userEmail = userEmail.trim();
                password = password.trim();

                if (!userEmail.isEmpty() &&!password.isEmpty()) {
                    Backendless.UserService.login(userEmail, password, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {
                            final ProgressDialog pDialog = ProgressDialog.show(LoginActivity.this,
                                    getString(R.string.wait_message),
                                    getString(R.string.log_in_wait_message),
                                    true);
                            pDialog.dismiss();
                            //Intent intent = new Intent(LoginActivity.this, TripListActivity.class);
                            //startActivity(intent);
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            warnUser((fault.getMessage() + "\nError Code (" + fault.getCode() + ")"), getString(R.string.log_in_error_title));
                        }
                    });
                } else {
                    warnUser(getString(R.string.empty_filed_log_in_error), getString(R.string.log_in_error_title));
                }
            }
        });

    }
}
