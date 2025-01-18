package com.example.mobileapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapp.R
import com.example.mobileapp.RegisterActivity
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


    private val validEmail = "test@te.st"
    private val validPassword = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.log_in)


        loginButton.setOnClickListener { handleLogin() }
        registerNowTextView.setOnClickListener {

            navigateToRegistration()
        }
        forgotPasswordTextView.setOnClickListener {

            showForgotPasswordDialog()
        }
    }

    private fun handleLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        var isValid = true


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInputLayout.error = "Invalid email address"
            isValid = false
        } else {
            emailInputLayout.error = null
        }


        if (password.isEmpty() || password.length < 4) {
            passwordInputLayout.error = "Password must be at least 4 characters"
            isValid = false
        } else {
            passwordInputLayout.error = null
        }


        if (isValid) {
            if (email == validEmail && password == validPassword) {

                startActivity(Intent(this, RegisterActivity::class.java))
            } else {
                passwordInputLayout.error = "Invalid email or password"
            }
        }
    }

    private fun navigateToRegistration() {

    }

    private fun showForgotPasswordDialog() {

    }
}



}
