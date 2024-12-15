package com.example.restauranteapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import models.Pedido
import models.Platillo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pedido = Pedido()

        val pastel = Platillo("Pastel de Choclo", 12000)
        val cazuela = Platillo("Cazuela", 10000)

        pedido.agregarPlatillo(pastel)
        pedido.agregarPlatillo(cazuela)

        // Vinculando las vistas correctamente
        val etCantidadPastel = findViewById<EditText>(R.id.etCantidadPastel)
        val etCantidadCazuela = findViewById<EditText>(R.id.etCantidadCazuela)
        val swPropina = findViewById<Switch>(R.id.swPropina)
        val tvResultados = findViewById<TextView>(R.id.tvResultados)

        // Función para actualizar los resultados
        val actualizarResultados = {
            pastel.cantidad = etCantidadPastel.text.toString().toIntOrNull() ?: 0
            cazuela.cantidad = etCantidadCazuela.text.toString().toIntOrNull() ?: 0
            pedido.incluirPropina = swPropina.isChecked
            tvResultados.text = "Total: ${pedido.formatearMonto(pedido.calcularTotal())}"
        }

        // Escuchadores de texto para actualizar resultados
        etCantidadPastel.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = actualizarResultados()
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        etCantidadCazuela.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = actualizarResultados()
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Escuchador de cambio para el Switch
        swPropina.setOnCheckedChangeListener { _, _ -> actualizarResultados() }
    }
}
