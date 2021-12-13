package com.cookandroid.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lotteryNumbers = arrayListOf(num1,num2,num3,num4,num5,num6)

        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onTick(p0: Long) {
                val lotteryList = arrayListOf(num1, num2, num3, num4, num5, num6)
                val numberArray = IntArray(6)
                lotteryList.forEachIndexed {index, textView ->
                    while (true) {
                        val randomNumber = (Math.random() * 45 + 1).toInt()
                        if (!numberArray.contains(randomNumber)) {
                            numberArray[index] = randomNumber
                            break;
                        }
                    }
                    textView.text = "${numberArray[index]}"
                }
            }
            override fun onFinish() {
            }
        }
        lotteryButton.setOnClickListener{
            if(lotteryButton.isAnimating){
                lotteryButton.cancelAnimation()
                countDownTimer.cancel()
            }else {
                lotteryButton.playAnimation()
                countDownTimer.start()
            }
        }
    }
}