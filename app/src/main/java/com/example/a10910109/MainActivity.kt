package com.example.a10910109

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.a10910109.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button1.setOnClickListener {
            Toast.makeText(this,
                String.format("%s選擇的路是 %s %s",
                    binding.editTextTextPersonName1.text,
                    if(binding.checkBox1.isChecked) binding.checkBox1.text else "",
                    if(binding.checkBox2.isChecked) binding.checkBox2.text else ""),
                Toast.LENGTH_LONG).show()
        }

        binding.button2.setOnClickListener {
            val name = binding.editTextTextPersonName1.text
            val message = AlertDialog.Builder(this)
                .setPositiveButton("OK", null)
                .setNegativeButton("關閉", null)

            val height : Float = binding.editTextTextPersonName2.text.toString().toFloat()
            val weight : Float = binding.editTextTextPersonName3.text.toString().toFloat()
            val bmi : Float = weight / (height * height)

            when(true){
                binding.radioButton2.isChecked -> message.setTitle("$name 先生 您好").setMessage("BMI= $bmi").show()
                binding.radioButton1.isChecked -> message.setTitle("$name 小姐 您好").setMessage("BMI= $bmi").show()
                binding.radioButton3.isChecked -> message.setTitle("$name 貴賓 您好").setMessage("BMI=").show()
            }
        }
    }
}