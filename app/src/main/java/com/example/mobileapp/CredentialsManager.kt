package com.example.myapp.utils

import android.util.Patterns

object CredentialsManager {


    private val emailPat = ("[a-zA-Z0-9\\+\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+").toRegex()

   
    private val regUser = mutableMapOf<String, String>()

    
    fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

  
    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty() && password.length >= 4
    }
    fun isValidFullName(fullName: String): Boolean {
        return fullName.isNotEmpty()
    }
    
    fun registerU(email: String, password: String): Boolean {
        if (isEmailAlreadyUsed(email)) {
            return false
        }
        regUser[email.lowercase()] = password
        return true
    }

    fun isEmailAlreadyUsed(email: String): Boolean {
        return regUser.containsKey(email.lowercase())
    }
    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phonePattern = "^[0-9]{9,}$".toRegex()
        return phoneNumber.matches(phonePattern)
    }
 
    fun validateCredentials(email: String, password: String): Boolean {
        val storedPassword = regUser[email.lowercase()]
        return storedPassword != null && storedPassword == password
    }

    fun isHardcodedCredentials(email: String, password: String): Boolean {
        val hardcodedEmail = "test@te.st"
        val hardcodedPassword = "1234"
        return email == hardcodedEmail && password == hardcodedPassword
    }


}
