package com.helpline.config

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        prefs.edit().putString("login_token", token).apply()
    }

    fun getToken(): String? {
        return prefs.getString("login_token", null)
    }

    fun clearToken() {
        prefs.edit().remove("login_token").apply()
    }
}
