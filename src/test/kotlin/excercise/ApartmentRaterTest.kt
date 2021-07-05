package excercise

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class ApartmentRaterTest {

    @ParameterizedTest
    @CsvSource(value = ["72.0, 250000.0, 0", "48.0, 350000.0, 1", "30.0, 600000.0, 2"])
    fun should_ReturnCorrectRating_When_CorrectApartment(area: Double?, price: Double?, rating: Int) {

        // given
        val apartment = Apartment(area!!, BigDecimal(price!!))

        // when
        val actual = ApartmentRater.rateApartment(apartment)

        // then
        Assertions.assertEquals(rating, actual)
    }

    @Test
    fun should_ReturnErrorValue_When_IncorrectApartment() {

        // given
        val apartment = Apartment(0.0, BigDecimal(350000.0))
        val expected = -1

        // when
        val actual = ApartmentRater.rateApartment(apartment)

        // then
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun should_CalculateAverageRating_When_CorrectApartmentList() {

        // given
        val apartments: MutableList<Apartment> = ArrayList()
        apartments.add(Apartment(72.0, BigDecimal(250000.0)))
        apartments.add(Apartment(48.0, BigDecimal(350000.0)))
        apartments.add(Apartment(30.0, BigDecimal(600000.0)))
        val expected = 1.0

        // when
        val actual = ApartmentRater.calculateAverageRating(apartments)

        // then
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList() {

        // given
        val apartments: List<Apartment> = ArrayList()

        // when
        // ----------------------------
        val executable = Executable {
            ApartmentRater.calculateAverageRating(
                apartments
            )
        }
        // then
        Assertions.assertThrows(RuntimeException::class.java, executable)

//        Assertions.assertThrows(RuntimeException::class.java) {
//            ApartmentRater.calculateAverageRating(
//                apartments
//            )
//        }
        // ----------------------------
    }
}