package excercise

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToInt
import kotlin.math.roundToLong


class RandomApartmentGenerator {
    private var minArea: Double
    private var minPricePerSquareMeter: BigDecimal

    constructor() : super() {
        minArea = 30.0
        minPricePerSquareMeter = BigDecimal(3000.0)
    }

    constructor(minArea: Double, minPricePerSquareMeter: BigDecimal) : super() {
        this.minArea = minArea
        this.minPricePerSquareMeter = minPricePerSquareMeter
    }

    fun generate(): Apartment {
        val maxArea = minArea * MAX_MULTIPLIER
        val maxPricePerSquareMeter =
            minPricePerSquareMeter.multiply(BigDecimal(MAX_MULTIPLIER))
        val area = (((minArea + Math.random() * (maxArea - minArea)) * 10).roundToLong() / 10).toDouble()
        val pricePerSquareMeter = minPricePerSquareMeter
            .add(BigDecimal(Math.random()).multiply(maxPricePerSquareMeter.subtract(minPricePerSquareMeter)))
        val price = pricePerSquareMeter.multiply(BigDecimal(area)).setScale(1, RoundingMode.FLOOR)
        return Apartment(area, price)
    }

    companion object {
        private const val MAX_MULTIPLIER = 4.0
    }
}