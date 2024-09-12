package com.example.layoutshow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutButton = findViewById<Button>(R.id.linear_layout_button)
        linearLayoutButton.setOnClickListener {
            val intent = Intent(this, LinearActivity::class.java)
            startActivity(intent)
        }

        val constraintLayoutButton = findViewById<Button>(R.id.constraint_layout_button)
        constraintLayoutButton.setOnClickListener {
            val intent = Intent(this, ConstraintActivity::class.java)
            startActivity(intent)
        }

        val tableLayoutButton = findViewById<Button>(R.id.table_layout_button)
        tableLayoutButton.setOnClickListener {
            val intent = Intent(this, TableActivity::class.java)
            startActivity(intent)
        }

        val frameLayoutButton = findViewById<Button>(R.id.frame_layout_button)
        frameLayoutButton.setOnClickListener {
            val intent = Intent(this, FrameActivity::class.java)
            startActivity(intent)
        }

        val gridLayoutButton = findViewById<Button>(R.id.grid_layout_button)
        gridLayoutButton.setOnClickListener {
            val intent = Intent(this, GridActivity::class.java)
            startActivity(intent)
        }

        val relativeLayoutButton = findViewById<Button>(R.id.relative_layout_button)
        relativeLayoutButton.setOnClickListener {
            val intent = Intent(this, RelativeActivity::class.java)
            startActivity(intent)
        }
    }
}