package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<View>(R.id.calculate)

        btn.setOnClickListener(){
            val carprice = CarPrice.text.toString()
            val dpamount = DPAmount.text.toString()
            val intrate = Interest.text.toString()
            val loanperiod = Years.text.toString()

            val dptotal = carprice.toDouble() - dpamount.toDouble()

            CLAMT.text = "RM %.2f".format(dptotal)

            val inttotal = (dptotal*intrate.toDouble() *0.01)* loanperiod.toDouble()

            INTAMT.text = "RM %.2f".format(inttotal)

            val monthlypay = (dptotal+inttotal) / loanperiod.toDouble() / 12

            MONTHAMT.text = "RM %.2f".format(monthlypay)


        }
    }

}
