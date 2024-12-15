package com.example.restauranteapp.models

data class Platillo(
    val nombre: String,
    val precio: Int,
    var cantidad: Int = 0
) {
    fun calcularSubtotal(): Int {
        return precio * cantidad
    }
}

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
        val formato = java.text.NumberFormat.getCurrencyInstance(java.util.Locale("es", "CL"))
        return formato.format(monto)
    }
}
