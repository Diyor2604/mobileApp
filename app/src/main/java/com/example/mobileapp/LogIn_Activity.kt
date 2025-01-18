package com.example.mobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.utils.CredentialsManager
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LogIn_Activity : AppCompatActivity() {




    private val emailInputLayout: TextInputLayout by lazy { findViewById(R.id.emailInputLayout) }
    private val passwordInputLayout: TextInputLayout by lazy { findViewById(R.id.passwordInputLayout) }
    private val emailEditText: TextInputEditText by lazy { findViewById(R.id.loginEmail) }
    private val passwordEditText: TextInputEditText by lazy { findViewById(R.id.passwordEditText1) }
    private val rememberMeCheckBox: CheckBox by lazy { findViewById(R.id.Remember_me) }
    private val forgotPasswordTextView: TextView by lazy { findViewById(R.id.ForgotPassword) }
    private val loginButton: Button by lazy { findViewById(R.id.button) }
    private val registerNowTextView: TextView by lazy { findViewById(R.id.passwdid) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.log_in)


        loginButton.setOnClickListener { handleLogin() }
        val registerNowTextView = findViewById<TextView>(R.id.passwdid)

        registerNowTextView.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun handleLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()


        var isValid = true

        val credentialsManager=CredentialsManager
        if (credentialsManager.isHardcodedCredentials(email, password)) {
            navigateToMainActivity()
            return
        }

            if (!CredentialsManager.isEmailValid(email)) {
                emailInputLayout.error = "Invalid email address"
                isValid = false
            } else {
                emailInputLayout.error = null
            }

                if (!CredentialsManager.isPasswordValid(password)) {
                    passwordInputLayout.error = "Password must be at least 4 characters"
                    isValid = false
                }

            else {
                passwordInputLayout.error = null
            }


            if (isValid) {
                if (CredentialsManager.validateCredentials(email, password)) {
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    passwordInputLayout.error = "Invalid email or password"
                }
            }
        }

    private fun navigateToMainActivity() {
        TODO("Not yet implemented")
    }


    private fun navigateToRegistration() {

        }


        private fun showForgotPasswordDialog() {

        }
    }

