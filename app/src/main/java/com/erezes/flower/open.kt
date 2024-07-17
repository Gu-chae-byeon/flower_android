package com.erezes.flower
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erezes.flower.databinding.ActivityOpenBinding

class open : AppCompatActivity() {
    private val binding by lazy{ActivityOpenBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val loginPage = Intent(this, login::class.java)
        val signinPage = Intent(this, signin::class.java)
        val login : android.widget.Button = binding.login
        val signin : android.widget.Button = binding.signin
        login.setOnClickListener {
            startActivity(loginPage)
        }
        signin.setOnClickListener{
            startActivity(signinPage)
        }
    }
}