package com.example.shared

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var txt01 = findViewById<TextView>(R.id.txt01)
        var txt02 = findViewById<TextView>(R.id.txt02)
        var txt03 = findViewById<TextView>(R.id.txt03)

        var btnAdd = findViewById<Button>(R.id.btnADD)
        var btnLoad = findViewById<Button>(R.id.btnLoad)
        var txtNome = findViewById<EditText>(R.id.edtNome)
        var txtCPF = findViewById<EditText>(R.id.edtCPF)
        var txtEmail = findViewById<EditText>(R.id.edtEmail)

        var shared = getSharedPreferences("FileKey", Context.MODE_PRIVATE)

        btnAdd.setOnClickListener {
            val editar = shared.edit()
            editar.apply{
                putString("NOME", txtNome.text.toString())
                putString("CPF",txtCPF.text.toString())
                putString("EMAIL",txtEmail.text.toString())
                apply()
            }
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alerta")
            builder.setMessage("Adicionado!")
            builder.setNeutralButton("OK"){dialog, which ->
                Toast.makeText(this,"Dados inseridos", Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()

        }

        btnLoad.setOnClickListener {
            var nome = shared.getString("NOME",null)
            var cpf = shared.getString("CPF",null)
            var email = shared.getString("EMAIL", null)
            txt01.setText(nome)
            txt02.setText(cpf)
            txt03.setText(email)
        }


    }

}