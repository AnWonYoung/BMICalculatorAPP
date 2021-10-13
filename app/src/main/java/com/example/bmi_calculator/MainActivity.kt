package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 메인 view를 가짐
//      findViewById 함수는 절대 널이 없음을 반환한다.
        val heightEditText : EditText = findViewById(R.id.heightEditText) // 메인 뷰 안의 해당 EditTeext를 값으로 가짐
        val weightEditText = findViewById<EditText>(R.id.weightEditText) // <> 안에 추론하여 타입을 넣을 수 있음

        val resultButton = findViewById<Button>(R.id.resultButton)

    }
}