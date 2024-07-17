package com.erezes.flower

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erezes.flower.databinding.ActivitySigninBinding

class signin : AppCompatActivity() {
    private val binding by lazy{ActivitySigninBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nickname : EditText = binding.nickname
        nickname.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
            return@setOnKeyListener false
        }
        val id = binding.id
        val password = binding.password
        val back = binding.back
        val open = Intent(this, open::class.java)
        back.setOnClickListener{
            startActivity(open)
            finish()
        }
        val signin = binding.signin
        signin.setOnClickListener {
            if (id.text.length > 5 && id.text.length < 16 && password.text.length > 7 && password.text.length < 21 && nickname.text.length > 2 && nickname.text.length < 9) {
                if (id.text.contains(" ") == false && password.text.contains(" ") == false && nickname.text.contains(" ") == false){
                    startActivity(open)
                    finish()
                }
            }
        }
    }
}