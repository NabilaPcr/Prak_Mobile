package com.example.bellapps.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bellapps.R
import com.example.bellapps.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding  //usahakan ada ini setiap menggunakan binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root) //digunakan untuk menetapkan binding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //val inputNomor: EditText = findViewById(R.id.inputNoTujuan)
        //val btnKirim: Button = findViewById(R.id.btnKirim)
        //karena sudah ada binding, jadi 2 variabel diatas sudah tidak diperlukan, cukup menambahkan binding.
        // pada btnKirim dan value dari nomor

        binding.btnKirim.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat
            val nomor = binding.inputNoTujuan.text
            Log.e("Klik btnKirim", "Tombol berhasil di tekan. Isi dari inputNoTujuan = $nomor")

            Toast.makeText(this, "Anda telah melakukan klik pada tombol Submit", Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent) //wajib ada start seperti disamping
//            gunanya intent adalah untuk memindahkan activity ini ke activity lain

        }

    }
}