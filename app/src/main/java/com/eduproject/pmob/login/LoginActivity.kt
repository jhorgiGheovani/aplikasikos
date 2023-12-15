package com.eduproject.pmob.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eduproject.pmob.MainActivity
import com.eduproject.pmob.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edEmail = binding.edLoginEmail
        val edPassword = binding.edLoginPassword

        binding.btnLogin.setOnClickListener {
            //check password kosong
            if (edPassword.text?.isEmpty() == true) {
                edPassword.error = "Password cannot be empty"
            }
            //cek email kosong
            if (edEmail.text?.isEmpty() == true) {
                edEmail.error = "Email cannot be empty"
            }


            if (edPassword.error == null && edEmail.error == null) {
                if (edEmail.text.toString() == EMAIL && edPassword.text.toString() == PASSWORD) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Snackbar.make(binding.root, "Password dan Email salah", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        const val EMAIL = "ayu@gmail.com"
        const val PASSWORD = "admin"
    }
}