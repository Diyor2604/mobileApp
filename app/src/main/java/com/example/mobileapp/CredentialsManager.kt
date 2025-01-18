package com.example.myapp.utils

import android.util.Patterns

object CredentialsManager {


    private const val VALID_EMAIL = "test@te.st"
    private const val VALID_PASSWORD = "1234"


    fun validateCredentials(email: String, password: String): Boolean {
        return email == VALID_EMAIL && password == VALID_PASSWORD
    }


    fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty() && password.length >= 4
    }

    fun isHardcodedCredentials(email: String, password: String): Boolean {
        val hardcodedEmail = "test@te.st"
        val hardcodedPassword = "1234"
        return email == hardcodedEmail && password == hardcodedPassword
    }
}
