package com.example.bellapps.Home.pertemuan_13

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bellapps.Home.pertemuan_10.TabAFragment
import com.example.bellapps.Home.pertemuan_10.TabBFragment
import com.example.bellapps.Home.pertemuan_10.TabCFragment

class ThirteenTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Jumlah total tab yang ada
    override fun getItemCount(): Int = 3 //TAMBAH ANGKA JIKA MAU MENAMBAH TAB

    // Menentukan Fragment mana yang akan ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            // FRAGMENT
            0 -> TabCaptureFragment()
            1 -> TabQrcodeFragment()
            2 -> TabScanFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}