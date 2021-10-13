package com.example.bmi_calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity() { // 한 개의 인자값만 받고 있는 onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
//      Main에서 넘겨온 intent 값 불러오기
        val height = intent.getIntExtra("height", 0) // name 값 및 빈칸이었을 때 보일 default 값 설정
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : ${height}, weight : ${weight}")

        val bmi = weight / (height / 100.0).pow(2.0) // Math.pow > 제곱함수는 double 타입을 받기 때문에 소수점으로
                                                        // 위는 보통 자바, 함수를 통해서 pow로 사용하는 것이 보다 Kotlin 방식에 가까움
        val resultText = when {
        // when에서 나오는 결과값이 바로 resultText로 넘어감
            bmi >= 35.0 -> " 고도 비만 "
            bmi >= 30.0 -> " 중정도 비만 "
            bmi >= 25.0 -> " 경도 비만 "
            bmi >= 33.0 -> " 과체중 "
            bmi >= 10.5 -> " 정상체중 "
            else -> " 저체중 "
        }

        val resultValueTextView = findViewById<TextView>(R.id.bmiResultText)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString() // double형이라 String으로 치환
        resultStringTextView.text = resultText
    }
}