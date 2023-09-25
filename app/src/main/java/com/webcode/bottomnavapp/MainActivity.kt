package com.webcode.bottomnavapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.webcode.bottomnavapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnCurrentFragment(HomeFragment())


        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> setOnCurrentFragment(HomeFragment())
                R.id.setting -> setOnCurrentFragment(SettingFragment())
                R.id.person -> setOnCurrentFragment(PersonFragment())
            }
            true
        }


    }

    private fun setOnCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Framlayout, fragment)
            commit()
        }


    }


}


