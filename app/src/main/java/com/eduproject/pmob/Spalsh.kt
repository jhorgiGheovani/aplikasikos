package com.eduproject.pmob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eduproject.pmob.login.LoginActivity

class Spalsh : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this@Spalsh, LoginActivity::class.java))
        finish()
    }
}