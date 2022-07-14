package com.example.timepickerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.timepickerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//  Cada vez que se pulse el editText(etTime), llamará a la función showTimePickerDialog()
        binding.etTime.setOnClickListener { showTimePickerDialog() }
//        setContentView(R.layout.activity_main)
    }

    private fun showTimePickerDialog() {

//  WapKreyeYonInstanciaDeYonLotKlas,TimePickerFragment
        val timePicker = TimePickerFragment{

//  Pasaremos por parámetro una nueva función onTimeSelected(),
//  la cual recibirá una String, la que devolverá
//  la clase TimePickerFragment al seleccionar una hora.
            onTimeSelected(it)
//  it, que será la String.
        }

//  Método show() que mostrará el diálogo...
        timePicker.show(supportFragmentManager, "time")

    }

//  Encargará de asignar el valor de la String
//  en el editText que creamos al principio, etTime.
    private fun onTimeSelected(time:String) {
        binding.etTime.setText("Has seleccionado las $time")

    }

    
}