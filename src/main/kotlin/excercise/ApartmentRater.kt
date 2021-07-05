package excercise

import java.math.BigDecimal
import java.math.RoundingMode


object ApartmentRater {
    private val CHEAP_THRESHOLD = BigDecimal(6000.0)
    private val MODERATE_THRESHOLD = BigDecimal(8000.0)
    fun rateApartment(apartment: Apartment): Int {
        if (apartment.area == 0.0) {
            return -1
        }
        val ratio: BigDecimal = apartment.price.divide(BigDecimal(apartment.area), RoundingMode.HALF_UP)
        return if (ratio < CHEAP_THRESHOLD) {
            0
        } else if (ratio >= CHEAP_THRESHOLD && ratio < MODERATE_THRESHOLD) {
            1
        } else {
            2
        }
    }

    fun calculateAverageRating(apartments: List<Apartment>): Double {
        if (apartments.isEmpty()) {
            throw RuntimeException("Cannot calculate average rating for empty list")
        }
        var sumRatings = 0
        for (apartment in apartments) {
            sumRatings += rateApartment(apartment)
        }
        return sumRatings * 1.0 / apartments.size
    }
}