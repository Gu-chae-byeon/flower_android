package com.erezes.flower

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erezes.flower.databinding.ActivityHomeBinding

class home : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val points = binding.points
        var score = 0
        points.text = score.toString()
        val flag = binding.flag
        val user = binding.user
        val map = Intent(this, map::class.java)
        val profile = Intent(this, profile::class.java)
        map.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
        profile.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
        flag.setOnClickListener{
            startActivity(map)
            finish()
        }
        user.setOnClickListener{
            startActivity(profile)
            finish()
        }
    }
}