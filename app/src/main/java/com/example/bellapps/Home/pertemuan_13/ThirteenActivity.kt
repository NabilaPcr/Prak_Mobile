package com.example.bellapps.Home.pertemuan_13

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bellapps.Home.pertemuan_10.TenthTabsAdapter
import com.example.bellapps.R
import com.example.bellapps.databinding.ActivityTenthBinding
import com.example.bellapps.databinding.ActivityThirteenBinding
import com.google.android.material.tabs.TabLayoutMediator

class ThirteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupTabs()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupTabs() {
        val adapter = ThirteenTabsAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Capture"
                1 -> "QR Code"
                2 -> "Scan"
                else -> null
            }
        }.attach()
    }
}