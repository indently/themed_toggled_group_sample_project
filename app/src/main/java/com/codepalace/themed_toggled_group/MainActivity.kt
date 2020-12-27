package com.codepalace.themed_toggled_group

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.codepalace.themed_toggled_group.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.timeButtonGroup.setOnSelectListener {
            Log.d("Main", it.text)
        }

        binding.btnDone.setOnClickListener {

            val text = binding.timeButtonGroup.selectedButtons
            val fruitList = mutableListOf<String>()

            for (fruit in text) {
                fruitList.add(fruit.text)
            }

            Log.d("Main", text.toString())
            Toast.makeText(applicationContext, "You selected $fruitList", Toast.LENGTH_SHORT).show()
        }
    }
}