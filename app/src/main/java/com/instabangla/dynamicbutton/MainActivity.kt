package com.instabangla.dynamicbutton

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ll = findViewById<View>(R.id.button_layout) as LinearLayout
        val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val buttonMap = mutableMapOf<Int, Button>()
        var index = 1

        /*
        for (i in 0 until 5) {
            val btn = Button(this)
            btn.id = i + 1
            btn.text = "Button" + (i + 1)
            btn.layoutParams = lp
            btn.setOnClickListener { Log.i("TAG", "The index is$i") }
            ll.addView(btn)
        }

         */


        findViewById<Button>(R.id.add_btn).setOnClickListener {
            Log.d(TAG, "onCreate: Add button clicked")

            val btn = Button(this)
            buttonMap[index] = btn
            btn.text = "button-$index"
            btn.layoutParams = lp
            ll.addView(btn)
            index++

            setClickListener(buttonMap)

            //button.add(btn)

            /*
            btn.id = index + 1
            btn.text = "Button" + (index + 1)
            btn.layoutParams = lp
            btn.setOnClickListener { Log.i("TAG", "The index is$index") }
            ll.addView(btn)
            index++

             */

            /*
            val myButton = Button(this)
            myButton.text = "Add Me"
            boxes.add(myButton)
            ll.addView(myButton, lp)

             */

        }

        findViewById<Button>(R.id.show_btn).setOnClickListener {
            Log.d(TAG, "onCreate: Show Button: $buttonMap")
        }


    }

    private fun setClickListener(buttonMap: MutableMap<Int, Button>) {
        for (key in buttonMap.keys){
            Log.d(TAG, "setClickListener: key: $key Value: ${buttonMap[key]}")
            buttonMap[key]!!.setOnClickListener {
                Log.d(TAG, "setClickListener: Clicked Button: $key")
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}

