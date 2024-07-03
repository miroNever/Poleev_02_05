package com.example.exampoleev

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var SharedPreferences : SharedPreferences
    private lateinit var loginEdit: EditText
    private lateinit var passEdit: EditText
    private lateinit var Button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginEdit = findViewById(R.id.edLogin)
        passEdit = findViewById(R.id.edPassword)
        Button = findViewById(R.id.btnLogIn)
        SharedPreferences = getSharedPreferences("project", MODE_PRIVATE)
        Button.setOnClickListener{
           val login = loginEdit.text.toString()
           val pass = passEdit.text.toString()
            val savel = SharedPreferences.getString("login", "ects")
            val savep = SharedPreferences.getString("pass", "ects2024")
            if(login == savel && pass == savep)
            {
                intent =Intent(this, MainScrean::class.java)
                startActivity(intent)
            }
            else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Ошибка")
                    .setMessage("Введите логин и пароль")
                    .setPositiveButton("ОК") { dialog, _ ->
                        dialog.cancel()
                    }
                val alert = builder.create()
                alert.show()
            }
        }
    }
}