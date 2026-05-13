package com.example.bellapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.bellapps.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

             //Kondisi jika isLogin bernilai true
             val isLogin = sharedPref.getBoolean("isLogin", false)
             if (isLogin) {
            //Panggil Intent untuk ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        lifecycleScope.launch {
            delay(2000) //simulasi pengambilan data selama 2 detik
//tampilannya jadi punya waktu, delay disini adalah waktu dalam milisecond
            var intent = Intent(this@SplashScreenActivity, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}