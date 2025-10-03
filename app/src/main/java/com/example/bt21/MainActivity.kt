package com.example.bt21

import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var edtNumber: EditText
    private lateinit var btnCreate: Button
    private lateinit var layoutList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber = findViewById(R.id.edtNumber)
        btnCreate = findViewById(R.id.btnCreate)
        layoutList = findViewById(R.id.layoutList)

        btnCreate.setOnClickListener {
            val inputText = edtNumber.text.toString().trim()

            // Xóa danh sách cũ
            layoutList.removeAllViews()

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Dữ liệu bạn nhập không hợp lệ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val n = inputText.toInt()

                if (n <= 0) {
                    Toast.makeText(this, "Dữ liệu bạn nhập không hợp lệ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Tạo danh sách khung số
                for (i in 1..n) {
                    // Tạo CardView
                    val cardView = CardView(this)
                    val params = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(0, 12, 0, 0) // khoảng cách giữa các ô
                    cardView.layoutParams = params
                    cardView.radius = 25f
                    cardView.setCardBackgroundColor(resources.getColor(android.R.color.holo_red_light))
                    cardView.cardElevation = 8f
                    cardView.setContentPadding(20, 20, 20, 20)

                    // Tạo TextView bên trong
                    val textView = TextView(this)
                    textView.text = i.toString()
                    textView.textSize = 18f
                    textView.setTextColor(resources.getColor(android.R.color.white))
                    textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER

                    cardView.addView(textView)
                    layoutList.addView(cardView)
                }

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Dữ liệu bạn nhập không hợp lệ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
