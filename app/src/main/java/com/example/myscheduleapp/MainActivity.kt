package com.example.myscheduleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import com.example.myscheduleapp.ui.GenericRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val headers = listOf("Waseem", "Rehman", "Ali")
    private val times = listOf("9: AM", "10: AM", "11: AM", "12: PM", "1: PM", "2: PM", "3: PM", "4: PM", "5: PM", "6: PM", "7: PM")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = GenericRecyclerViewAdapter(headers, R.layout.item_table_header)
        rvHeaders.adapter = adapter

        val adapter2 = GenericRecyclerViewAdapter(times, R.layout.item_table_first_col)
        rv_times.adapter = adapter2

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            main_scroll.setOnScrollChangeListener { view, i, i2, i3, i4 ->

            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            delay(500)
            val width = rvHeaders.width
            Log.d("width34", width.toString())
            inner_table.layoutParams.width = width
            inner_table.requestLayout()
            Log.d("width34", inner_table.width.toString())
        }

    }
}