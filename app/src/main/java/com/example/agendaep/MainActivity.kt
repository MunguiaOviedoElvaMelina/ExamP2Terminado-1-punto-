package com.example.agendaep

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agendaep.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //array para datos
    private var data=ArrayList<Agenda>()
    //indice para conteo
    var indice:Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intento1 = Intent(this, MainActivityDos::class.java)

        //recoger lo de las cajas de texto
        val nombre = binding.etxNombre.text
        val control = binding.etxControl.text
        //val contarray = binding.array.text

        //boton para guardar los datos y amuentar los contactos, valida si tiene escrito algo
        binding.btnAgregar.setOnClickListener {
            if (nombre.length == 0 || control.length == 0) {
                Toast.makeText(this, "Escribe un Nombre y Control", Toast.LENGTH_LONG).show()
            } else {
                var insertIndex: Int = data.count()
                //array para guardar
                data.add(insertIndex, Agenda("${nombre}", "${control}"))
            }
                indice += 1
                binding.txtContactos.text = "Contactos: ${indice}"


                binding.array.text="Mi array: ${data[0]}"
            }

            binding.btnAgenda.setOnClickListener {
               // val intento1 = Intent(this, MainActivityDos::class.java)
                intento1.putExtra("nombre", "${data[0]}")
                startActivity(intento1)
            }
        }
    }
