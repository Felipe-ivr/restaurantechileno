package models

import java.text.NumberFormat
import java.util.Locale

class Pedido {
    private val platillos = mutableListOf<Platillo>()
    var incluirPropina: Boolean = false

    fun agregarPlatillo(platillo: Platillo) {
        platillos.add(platillo)
    }

    fun calcularTotal(): Int {
        val subtotal = platillos.sumOf { it.calcularSubtotal() }
        val propina = if (incluirPropina) subtotal * 0.1 else 0.0
        return (subtotal + propina).toInt()
    }

    fun formatearMonto(monto: Int): String {
        val formato = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
        return formato.format(monto)
    }
}
