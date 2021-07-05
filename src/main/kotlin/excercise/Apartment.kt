package excercise

import java.math.BigDecimal


class Apartment(var area: Double, var price: BigDecimal) {

    fun setArea(area: Float) {
        this.area = area.toDouble()
    }

    override fun toString(): String {
        return "Apartment [area=$area, price=$price]"
    }
}