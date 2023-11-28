package com.example.vijay.kotlin

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vijay.kotlin.databinding.ActivityPhoneNumBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import java.util.concurrent.TimeUnit


class PhoneNumActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var binding: ActivityPhoneNumBinding
    private val TAG = "PhoneAuthActivity"
    private val KEY_VERIFY_IN_PROGRESS = "key_verify_in_progress"
    private var mAuth: FirebaseAuth? = null
    private var mVerificationInProgress = false
    private var mVerificationId: String? = null
    private var mResendToken: ForceResendingToken? = null
    private var mCallbacks: OnVerificationStateChangedCallbacks? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            com.example.vijay.kotlin.R.layout.activity_phone_num
        )

        // Restoring the instance state
        savedInstanceState?.let { onRestoreInstanceState(it) }

        // Assigning all the views

        // Setting all the click listeners
        binding.buttonStartVerification.setOnClickListener(this)
        binding.buttonVerifyPhone.setOnClickListener(this)
        binding.buttonResend.setOnClickListener(this)
        binding.signOutButton.setOnClickListener(this)


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()

        // Initializing phone auth callbacks  (For verification, Not entering code yet, To get text send to device)
        mCallbacks = object : OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // It will be invoked in two situations, i.e., instant verification and auto-retrieval:
                // 1 - In few of the cases, the phone number can be instantly verified without needing to  enter or send a verification code.
                // 2 - On some devices, Google Play services can automatically detect the incoming verification SMS and perform verification without
                //     user action.
                Log.d(TAG, "onVerificationCompleted:$credential")
                mVerificationInProgress = false

                //Calling signInWithPhoneAuthCredential.
                signInWithPhoneAuthCredential(credential)
            }

            //Creating onVerificationFailed() method.
            override fun onVerificationFailed(e: FirebaseException) {
                // It is invoked when an invalid request is made for verification.                 //For instance, if the phone number format is not valid.
                Log.w(TAG, "onVerificationFailed", e)
                mVerificationInProgress = false
                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    // Setting error to text field
                    binding.fieldPhoneNumber.setError("Invalid phone number.")
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota has been exceeded for the project                     Toast.makeText(getApplicationContext(), "Quota exceeded", Toast.LENGTH_SHORT).show();
                }
            }

            // Creating onCodeSent() method called after the verification code has been sent by SMS to the provided phone number.
            override fun onCodeSent(
                verificationId: String,
                token: ForceResendingToken
            ) {
                // The SMS verification code will be sent to the provided phone number
                // Now need to ask the user for entering the code and then construct a credential
                // through integrating the code with a verification ID.
                Log.d(TAG, "onCodeSent:$verificationId")

                // Save the verification ID and resend token to use them later
                mVerificationId = verificationId
                mResendToken = token
            }
        }
    }

    // Creating onStart method.
    override fun onStart() {
        super.onStart()

        // Checking if the user is signed in or not. If signed in, then update UI accordingly.
        val currentUser = mAuth?.currentUser
        if (currentUser != null) {
            Log.d(TAG, "Currently Signed in: " + currentUser.email)
            Toast.makeText(
                this,
                "Currently Logged in: " + currentUser.email,
                Toast.LENGTH_LONG
            ).show()
            binding.phoneAuthFields.visibility = View.GONE
            binding.signedInButtons.visibility = View.VISIBLE
        } else {
            binding.phoneAuthFields.visibility = View.VISIBLE
            binding.signedInButtons.visibility = View.GONE
        }

        //check if a verification is in progress. If it is then we have to re verify.
        if (mVerificationInProgress && validatePhoneNumber()) {
            startPhoneNumberVerification(binding.fieldPhoneNumber.text.toString())
        }
    }

    //Implementing SaveInstanceState to save the flag.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_VERIFY_IN_PROGRESS, mVerificationInProgress)
    }

    //Implementing RestoreInstanceState to restore the flag.
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mVerificationInProgress = savedInstanceState.getBoolean(KEY_VERIFY_IN_PROGRESS)
    }

    // Creating startPhoneNumberVerification() method
    //Getting text code sent. So we can use it to sign-in.
    private fun startPhoneNumberVerification(phoneNumber: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber,  // Phone number to verify
            60,  // Timeout duration
            TimeUnit.SECONDS,  // Unit of timeout
            this,  // Activity (for callback binding)
            mCallbacks!!
        ) // OnVerificationStateChangedCallbacks

        //Setting flag to say that the verification is in process.
        mVerificationInProgress = true
    }

    //Creating a helper method for verification of phone number with code.
    // Entering code and manually signing in with that code
    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        signInWithPhoneAuthCredential(credential)
    }

    // Creating helper method signInWithPhoneAuthCredential().
    //Use text to sign-in.
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {

        //Adding onCompleteListener to signInWithCredential.
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    //Sign-In is successful, update the UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = task.result.user
                    binding.phoneAuthFields.visibility = View.GONE
                    binding.signedInButtons.visibility = View.VISIBLE
                } else {
                    // If the Sign-In fails, it will display a message and also update the UI
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        binding.fieldVerificationCode.error = "Invalid code."
                    }
                }
            }
    }

    // Creating helper method for validating phone number.
    private fun validatePhoneNumber(): Boolean {
        val phoneNumber = binding.fieldPhoneNumber.text.toString()
        if (TextUtils.isEmpty(phoneNumber)) {
            binding.fieldPhoneNumber.error = "Invalid phone number."
            return false
        }
        return true
    }

    //Creating helper method for resending verification code.
    private fun resendVerificationCode(
        phoneNumber: String,
        token: ForceResendingToken?
    ) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber,  // Phone number to verify
            60,  // Timeout duration
            TimeUnit.SECONDS,  // Unit of timeout
            this,  // Activity (for callback binding)
            mCallbacks!!,  // OnVerificationStateChangedCallbacks
            token
        ) // ForceResendingToken from callbacks
    }

    //Adding onClick method which handles the button clicks.
    override fun onClick(view: View) {
        when (view.id) {
            binding.buttonStartVerification.id -> {
                if (!validatePhoneNumber()) {
                    return
                }
                //Calling startPhoneNumberVerification helper method for verifying phone number.
                startPhoneNumberVerification(binding.fieldPhoneNumber.text.toString())
            }

            binding.buttonVerifyPhone.id -> {
                val code = binding.fieldVerificationCode.text.toString()
                if (TextUtils.isEmpty(code)) {
                    binding.fieldVerificationCode.error = "Cannot be empty."
                    return
                }
                //Call the verifyPhoneNumberWithCode () method.
                verifyPhoneNumberWithCode(mVerificationId, code)
            }

            binding.buttonResend.id ->                 //Call the resendVerificationCode () method.
                resendVerificationCode(binding.fieldPhoneNumber.text.toString(), mResendToken)

            binding.signOutButton.id ->                 //Call the signOut() method.
                signOut()
        }
    }

    //Create the signOut() method.
    private fun signOut() {
        mAuth!!.signOut()
        binding.phoneAuthFields.visibility = View.VISIBLE
        binding.signedInButtons.visibility = View.GONE
    }
}