package com.example.vijay.kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vijay.kotlin.databinding.ActivityMain2Binding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.PhoneAuthCredential


class FireBaseGoogleLogin : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    var TAG: String = "GoogleActivity"
    var RC_SIGN_IN = 9001

    lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        binding.GgleSingIn.setOnClickListener(View.OnClickListener {
            signInToGoogle()
        })
        binding.signOut.setOnClickListener {
            signOut()
        }
        binding.signOutDisconnect.setOnClickListener {
            revokeAccess()
        }
        // Configuration google signIn
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        //Initialize firebase Auth
        mAuth = FirebaseAuth.getInstance()
//        startActivity(Intent(this,PhoneNumActivity::class.java))
    }

    override fun onStart() {
        super.onStart()
        // Checking if the user is signed in (non-null) and update UI accordingly.
        var currentUser = mAuth.currentUser
        if (currentUser != null) {
            Log.d(TAG, "Currently Signed in: " + currentUser.getEmail());
            Toast.makeText(
                this, "Currently Logged in: " + currentUser.getEmail(),
                Toast.LENGTH_LONG
            ).show();
        }
    }

    //Calling onActivityResult to use the information about the sign-in user contains in the object.

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode === RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                Toast.makeText(this, "Google Sign in Succeeded", Toast.LENGTH_LONG).show()
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign in failed", e)
                Toast.makeText(this, "Google Sign in Failed $e", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.id)
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val user = mAuth.currentUser
                Log.d(TAG, "signInWithCredential:success: currentUser: " + user!!.email)
                Toast.makeText(this, "Firebase Authentication Succeeded ", Toast.LENGTH_LONG).show()
            } else {
                Log.w(TAG, "signInWithCredential:failure", task.exception)
                Toast.makeText(
                    this,
                    "Firebase Authentication failed:" + task.exception,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun signInToGoogle() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun signOut() {
        FirebaseAuth.getInstance().signOut()
        mGoogleSignInClient.signOut().addOnCompleteListener(this) {
            Toast.makeText(applicationContext, "Signed out of google", Toast.LENGTH_SHORT).show()
        }
    }

    private fun revokeAccess() {
        FirebaseAuth.getInstance().signOut()
        // Google revoke access
        mGoogleSignInClient.revokeAccess().addOnCompleteListener(this) {
            Toast.makeText(this, "Revoked Access", Toast.LENGTH_LONG).show()
            Log.w(TAG, "Revoked Access")
        }
    }

}