package com.example.bellapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bellapps.databinding.ActivityFourthBinding
import com.example.bellapps.databinding.ActivityMainBinding
import com.example.bellapps.databinding.ActivityThirdBinding
import com.example.bellapps.pertemuan_3.ThirdResultActivity
import com.example.bellapps.pertemuan_4.FourthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //usahakan ada ini setiap menggunakan binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("nama", "Politeknik Caltex")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)
            startActivity(intent)
        }
    }
}