package com.example.bt23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCheck.setOnClickListener {
            val name = edtName.text.toString().trim()
            val ageText = edtAge.text.toString().trim()

            if (name.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val age = ageText.toIntOrNull()
            if (age == null || age < 0) {
                Toast.makeText(this, "Tuổi không hợp lệ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val category = when {
                age < 2 -> "Em bé"
                age in 2..6 -> "Trẻ em"
                age in 7..65 -> "Người lớn"
                else -> "Người già"
            }

            tvResult.text = "Xin chào $name\nBạn là: $category"
        }
    }
}
