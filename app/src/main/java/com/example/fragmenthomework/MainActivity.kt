package com.example.fragmenthomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val colors = resources.getStringArray(R.array.colors)
        val spinner = findViewById<Spinner>(R.id.spinner)
        var color = "красный"
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colors)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    color = colors[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    findViewById<TextView>(R.id.fragment_place).setBackgroundColor(R.color.red.toInt())

                }
            }
        }
        val btn = findViewById<Button>(R.id.btn_add)
        btn.setOnClickListener { onClick(color) }
    }

    val onClick: (String) -> Unit = { color ->

        if (supportFragmentManager.backStackEntryCount == 0) {
            findViewById<TextView>(R.id.btn_add).text = "Изменить"
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_place, ColorFragment.newInstance(color))
                .addToBackStack("name")
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_place, ColorFragment.newInstance(color))
                .addToBackStack("name")
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}