package com.example.barat.plspls;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import android.widget.Toast;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.*;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,View.OnClickListener
         {
             SignInButton signInButton;
             FirebaseAuth mAuth;
             Button signOutButton;
             TextView statusTextView;
             GoogleApiClient mGoogleApiClient;
             FirebaseAuth.AuthStateListener mAuthListener;
             FirebaseAuth firebaseAuth;
             private static final String TAG="SignInActivity";
             private static final int RC_SIGN_IN = 9001;


             @Override
             protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_main);
                 GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                         .requestEmail()
                         .build();
                 mGoogleApiClient = new GoogleApiClient.Builder(this)
                         .enableAutoManage(this,this)
                         .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                         .build();

                 signInButton = (SignInButton)findViewById(R.id.sign_in_button);
                 //mAuth = FirebaseAuth.getInstance();
                 // firebaseAuth = FirebaseAuth.getInstance();
                 signInButton.setOnClickListener(this);
                 signOutButton = (Button)findViewById(R.id.signOutButton);
                 signOutButton.setOnClickListener(this);




             }



    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gbutton:
                Intent toy = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(toy);
                break;


            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.signOutButton:
                signOut();
                break;

        }
    }




    private  void signIn()
{
    Intent signInIntent=Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
    startActivityForResult(signInIntent,RC_SIGN_IN);

}

public  void onActivityResult(int requestCode,int resultCode,Intent data)
{
    super.onActivityResult(requestCode,resultCode,data);
    if(requestCode==RC_SIGN_IN)
    {
        GoogleSignInResult result  = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        handleSignInResult(result);
    }
}
private  void handleSignInResult(GoogleSignInResult result)
{
    Log.d(TAG,"handleSignInResult:" + result.isSuccess());
    if(result.isSuccess())
    {
        GoogleSignInAccount acct = result.getSignInAccount();
        statusTextView.setText("Hello"+ acct.getDisplayName());


    }
    else
    {}

}

   /* protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        //GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        mAuth.addAuthStateListener(mAuthListener);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            }

                        //*/
                    //}
                //});

public  void onConnectionFailed(ConnectionResult connectionResult)
{
    Log.d(TAG,"onConnectionFailed:"+ connectionResult);
}
     private void signOut(){
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                statusTextView.setText("Signed out");
            }
        });
     }}

