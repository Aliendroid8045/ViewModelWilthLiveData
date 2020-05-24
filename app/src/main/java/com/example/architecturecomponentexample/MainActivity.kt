package com.example.architecturecomponentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe

class MainActivity() : AppCompatActivity() {

    private val TAG: String? = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btn_tap)
        val countNo: TextView = findViewById(R.id.tv_times_clicked)


        /**
         * get the viewModal for @this Owner.
         */
        val viewModal = ViewModelProviders.of(this).get(MainActivityViewModal::class.java)


        /**
         * Button click listener for Button which increase button tap count.
         */
        button.setOnClickListener { viewModal.updateButtonClickNumbers() }


        /**
         * Observe the live data.
         */
        viewModal.taps.observe(this){
            countNo.text=it
        }
    }
}
