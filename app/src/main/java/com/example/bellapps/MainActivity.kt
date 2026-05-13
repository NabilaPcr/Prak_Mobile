package com.example.bellapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import com.example.bellapps.databinding.ActivityMainBinding
import com.example.bellapps.Home.pertemuan_3.ThirdActivity
import com.example.bellapps.Home.pertemuan_4.FourthActivity
import com.example.bellapps.Home.pertemuan_5.FifthActivity
import com.example.bellapps.Home.pertemuan_7.SevenActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToSec.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
        binding.btnToThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
            finish()
        }
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(this, SevenActivity::class.java)
            startActivity(intent)
        }
        binding.btnlogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()

                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()

                }
                .show()
        }
    }
}





