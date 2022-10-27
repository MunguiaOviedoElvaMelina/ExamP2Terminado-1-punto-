package com.example.agendaep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agendaep.databinding.ActivityMainBinding
import com.example.agendaep.databinding.ActivityMainDosBinding

class MainActivityDos : AppCompatActivity() {
    private lateinit var binding: ActivityMainDosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainDosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val parExtras=intent.extras
        val nom=parExtras?.getString("nombre")
        //val nocon=parExtras?.getString("control")
        binding.txtContactoResultado.text=nom.toString()

        binding.btnSalir.setOnClickListener {
            val intento2= Intent(this,MainActivity::class.java)
            startActivity(intento2)
        }

    }
}