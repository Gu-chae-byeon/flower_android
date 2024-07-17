package com.erezes.flower

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erezes.flower.databinding.ActivityHomeBinding
import com.erezes.flower.databinding.ActivityMapBinding
import com.erezes.flower.databinding.ActivityProfileBinding

class map : AppCompatActivity() {
    private val binding by lazy { ActivityMapBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val homeBtn = binding.house
        val user = binding.user
        val homeScreen = Intent(this, home::class.java)
        val profile = Intent(this, profile::class.java)
        homeScreen.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
        profile.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
        homeBtn.setOnClickListener{
            startActivity(homeScreen)
            finish()
        }
        user.setOnClickListener{
            startActivity(profile)
            finish()
        }
    }
}