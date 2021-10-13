package com.example.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 메인 view를 가짐
//      findViewById 함수는 절대 널이 없음을 반환한다.
        val heightEditText : EditText = findViewById(R.id.heightEditText) // 메인 뷰 안의 해당 EditTeext를 값으로 가짐
        val weightEditText = findViewById<EditText>(R.id.weightEditText) // <> 안에 추론하여 타입을 넣을 수 있음

        val resultButton = findViewById<Button>(R.id.resultButton)
//      인터페이스를 구현하는데 코틀린에서는 람다식으로 치환하여 지정할 수 있음
        resultButton.setOnClickListener {
            Log.d("MainActivity", "ResultButton이 클릭되었습니다.") // 디버깅 체크하여 동작 확인하기
//      값이 없을 때 알람
            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈칸이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // 해당 함수를 빠져나옴
            }
            // 아래는 빈값이 아닌 상태로 실행
            val height : Int = heightEditText.text.toString().toInt() // String값으로 받은 다음 Int로 다시 치환
            val weight : Int = weightEditText.text.toString().toInt()
            Log.d("MainActivity", "height :$height, weight : $weight") // 디버깅 체크하여 동작 확인하기
//          MainActivity에서 ResultActivity를 실행시키는 방법
//          Intent를 통해서 두 개의 인자값을 전달해야 함
            val intent = Intent(this, ResultActivity::class.java)
//          intent에 값 전달하는 방법
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent) // 현재는 MainActivity지만  ResultButton을 눌렀을 때 intent를 실행시키겠다는 의미
        }

    }
}