package com.example.colorselector

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ColorPickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.color_picker_layout)


        val buttonIds = arrayOf(
            R.id.red_button, R.id.orange_button, R.id.yellow_button,R.id.green_button,
            R.id.blue_button, R.id.indigo_button, R.id.violet_button
        )
        for (buttonId in buttonIds) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener {
                when(buttonId){
                    R.id.red_button -> setSelectedColor(getString(R.string.red), R.color.red)
                    R.id.orange_button -> setSelectedColor(getString(R.string.orange), R.color.orange)
                    R.id.yellow_button -> setSelectedColor(getString(R.string.yellow), R.color.yellow)
                    R.id.green_button -> setSelectedColor(getString(R.string.green), R.color.green)
                    R.id.blue_button -> setSelectedColor(getString(R.string.blue), R.color.blue)
                    R.id.indigo_button -> setSelectedColor(getString(R.string.indigo), R.color.indigo)
                    R.id.violet_button -> setSelectedColor(getString(R.string.violet), R.color.violet)
                }
            }
        }
    }

    /**
     * colorName: 颜色字符串名称
     * color: 颜色的整数值
     */
    private fun setSelectedColor(colorName:String, color: Int){
        // 新建一个Intent对象，然后基于该Intent对象，执行{...}中代码
        Intent().let{ pickedColorIntent ->
            // 在Intent对象中保存颜色字符串名称的键值对
            pickedColorIntent.putExtra(RAINBOW_COLOR_NAME, colorName)
            // 在Intent对象中保存颜色的整数值的键值对
            pickedColorIntent.putExtra(RAINBOW_COLOR, color)
            // 将Intent对象返回给本Activity的启动者
            setResult(Activity.RESULT_OK, pickedColorIntent)
            // 结束本Activity
            finish()
        }
    }
}