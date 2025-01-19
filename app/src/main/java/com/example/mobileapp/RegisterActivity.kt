package com.example.mobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.utils.CredentialsManager
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {


    private val fullNameInputLayout: TextInputLayout by lazy { findViewById(R.id.fullNameInputLayout) }
    private val emailInputLayout: TextInputLayout by lazy { findViewById(R.id.emailInputLayout) }
    private val phoneNumberInputLayout: TextInputLayout by lazy { findViewById(R.id.phoneNumberInputLayout) }
    private val passwordInputLayout: TextInputLayout by lazy { findViewById(R.id.passwordInputLayout) }
    private val fullNameEditText: TextInputEditText by lazy { findViewById(R.id.fulln) }
    private val emailEditText: TextInputEditText by lazy { findViewById(R.id.valid_passw) }
    private val phoneEditText: TextInputEditText by lazy { findViewById(R.id.phone_num) }
    private val passwordEditText: TextInputEditText by lazy { findViewById(R.id.strpasswd) }
    private val registerButton: Button by lazy { findViewById(R.id.registerButton) }
    private val loginNowButton: TextView by lazy { findViewById(R.id.logg) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_started)


        registerButton.setOnClickListener { handleRegistration() }


        loginNowButton.setOnClickListener {
            val intent = Intent(this, LogIn_Activity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun handleRegistration() {
        val fullName = fullNameEditText.text.toString()
        val email = emailEditText.text.toString()
        val phone = phoneEditText.text.toString()
        val password = passwordEditText.text.toString()

        var isValid = true


        if (fullName.isBlank()) {
            fullNameInputLayout.error = "Full Name is required"
            isValid = false
        } else {
            fullNameInputLayout.error = null
        }


        if (!CredentialsManager.isEmailValid(email)) {
            emailInputLayout.error = "Invalid email address"
            isValid = false
        } else {
            emailInputLayout.error = null
        }


        if (phone.isBlank() || phone.length < 10) {
            phoneNumberInputLayout.error = "Valid phone number is required"
            isValid = false
        } else {
            phoneNumberInputLayout.error = null
        }


        if (!CredentialsManager.isPasswordValid(password)) {
            passwordInputLayout.error = "Password must be at least 4 characters"
            isValid = false
        } else {
            passwordInputLayout.error = null
        }


        if (isValid) {
            val registrationResult = CredentialsManager.registerU(email, password)
            if (registrationResult) {
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                navigateToLogin()
            } else {
                emailInputLayout.error = "Email is already taken"
            }
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LogIn_Activity::class.java)
        startActivity(intent)
        finish()
    }
}
