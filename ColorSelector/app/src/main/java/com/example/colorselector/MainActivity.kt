package com.example.colorselector

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

const val RAINBOW_COLOR = "RAINBOW_COLOR"
const val RAINBOW_COLOR_NAME = "RAINBOW_COLOR_NAME"

class MainActivity : AppCompatActivity() {

    private val colorSelect: Button
        get() = findViewById(R.id.color_select_button)

    private val colorShower: TextView
        get() = findViewById(R.id.color_shower)

    private val myResult : ActivityResultLauncher<Intent> =
        // 注册一个请求，启动一个Activity以获得结果，该结果由Contract进行约定
        registerForActivityResult(
            // 合约
            ActivityResultContracts.StartActivityForResult(),
            // 回调方法，用于处理返回的结果
            ActivityResultCallback {
                if (it.resultCode == Activity.RESULT_OK){
                    with(it.data!!) {
                        val backgroundColor = getIntExtra(RAINBOW_COLOR, Color.parseColor("#FFFFFF"))
                        val backgroundColorName = getStringExtra(RAINBOW_COLOR_NAME)
                        with(colorShower) {
                            setBackgroundColor(ContextCompat.getColor(applicationContext, backgroundColor))
                            text = backgroundColorName
                            setTextColor(Color.WHITE)
                            isVisible = true
                        }
                    }
                }
            }
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        colorSelect.setOnClickListener {
            val intent = Intent(this, ColorPickerActivity::class.java)
            myResult.launch(intent)
        }
    }

}