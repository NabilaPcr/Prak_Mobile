package com.example.bellapps

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bellapps.databinding.ActivityAuthBinding
import com.example.bellapps.databinding.ActivityFourthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Kode ini harus selalu dipanggil saat butuh akses "user_pref"
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        //Kondisi jika isLogin bernilai true
        val isLogin = sharedPref.getBoolean("isLogin", false)
        if (isLogin) {

            //Panggil Intent untuk ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val username = binding.nama.text.toString()
            val password = binding.pass.text.toString()


            if (username == password && username.isNotEmpty()) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username",username)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                showErrorDialog()
            }
        }
    }
    private fun showErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle("Gagal")
            .setMessage("Silahkan coba lagi")
            .setPositiveButton("OK", null)
            .show()
    }
}
