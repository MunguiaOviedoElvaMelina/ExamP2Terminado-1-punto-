package com.example.agendaep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendaep.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var data=ArrayList<Agenda>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var indice:Int=0
        val nombre:String=binding.etxNombre.text.toString()
        val control:String=binding.etxControl.text.toString()

        binding.btnAgregar.setOnClickListener {

            if (nombre.length==0||control.length==0){
                Toast.makeText(this,"Escribe un Nombre y Control",Toast.LENGTH_LONG).show()
            }else{
                indice+=1
                binding.txtContactos.text="Contactos: ${indice}"
                data.add(indice,
                    Agenda("${nombre}","${control}")
                )


            }
        }
        binding.btnAgenda.setOnClickListener {
            val intento1=Intent(this,MainActivityDos::class.java)
            intento1.putExtra("nombre",nombre)
            intento1.putExtra("control",control)
            startActivity(intento1)

        }

    }
}