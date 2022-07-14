package com.example.timepickerkotlin

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
//import android.icu.util.Calendar
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

// listener: parámetro de entrada, es decir,
// le pasaremos la posibilidad de ejecutar
// una función de la clase MainActivity,
// pasándole un parámetro, en concreto una
// String que será la hora seleccionada.
class TimePickerFragment (val listener: (String) -> Unit): DialogFragment(),
// DialogFragment:  La clase deberiá extender de DialogFragment().

//  TimePickerDialog.OnTimeSetListener: Nos va avisar cuando el usuario,seleccionaLaHora
TimePickerDialog.OnTimeSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

//  creamos un objeto de tipo Calendar,
        val calendar: Calendar = Calendar.getInstance()

//  Con la función get() le pediremos
//  la hora actual y los minutos.
        val hour:Int = calendar.get(Calendar.HOUR_OF_DAY)
        val minute: Int = calendar.get(Calendar.MINUTE)

//  Creamos un objeto de tipo TimePickerDialog que
//  recibe por parámetro el contexto,
//  el listener que hemos implementado en nuestra clase
        val dialog = TimePickerDialog(activity as Context, R.style.TimePicker, this, hour, minute, true)
//  Si ponemos el valor true al final,
//  estamos activando la variable is24HourView,
//  que mostrará las 24 horas en el reloj,
//  si lo ponemos a false, solo aparecerán las 12 horas pero con una selección de AM o PM.

        return dialog
    }

//  Se trata de un método que estamos implementando,
//  que se llamará cuando el usuario seleccione una hora
//  y nos devolverá la hora y los minutos por separado.
//  En en ese momento en el que llamaremos a nuestro listener
//  y le pasaremos una String formateando los dos Int
//  que recibimos, añadiendo dos puntos entre ellos
//  como solemos visualizar la hora.
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        listener("$hourOfDay: $minute")
    }
}