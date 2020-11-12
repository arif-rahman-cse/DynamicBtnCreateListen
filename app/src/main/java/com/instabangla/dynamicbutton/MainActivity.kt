package com.instabangla.dynamicbutton

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.hawk.Hawk


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initHawk()

        val ll = findViewById<View>(R.id.button_layout) as LinearLayout
        val lp = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val buttonMap = mutableMapOf<Int, Button>()
        var index = 1

        val chatTab = Hawk.get<Int>(Constants.CHAT_TAB)
        if (chatTab != null) {
            getChatTabLog(chatTab, lp, ll)
        } else {
            Log.d(TAG, "onCreate: Nothing to do...No chat tab was created!!")
        }


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
            Hawk.put(Constants.CHAT_TAB, index)

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

    private fun getChatTabLog(
        chatTab: Int,
        lp: ViewGroup.LayoutParams,
        ll: LinearLayout
    ) {

        for (key in 1 until chatTab) {
            val btn = Button(this)
            btn.text = "Button $key"
            btn.layoutParams = lp
            btn.setOnClickListener { Log.d("TAG", "The index is$key") }
            ll.addView(btn)
        }

    }

    private fun setClickListener(buttonMap: MutableMap<Int, Button>) {

        for (key in buttonMap.keys) {
            Log.d(TAG, "setClickListener: key: $key Value: ${buttonMap[key]}")
            buttonMap[key]!!.setOnClickListener {
                Log.d(TAG, "setClickListener: Clicked Button: $key")
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    private fun initHawk() {
        Hawk.init(this).build()
    }
}

