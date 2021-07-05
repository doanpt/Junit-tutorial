package excercise

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.function.Executable
import java.math.BigDecimal


class RandomApartmentGeneratorTest {
    companion object {
        private const val MAX_MULTIPLIER = 4.0
    }

    @Nested
    internal inner class GeneratorDefaultParamsTests {
        private lateinit var generator: RandomApartmentGenerator

        @BeforeEach
        fun setup() {
            generator = RandomApartmentGenerator()
        }

        @RepeatedTest(10)
        fun should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice() {

            // given
            val minArea = 30.0
            val maxArea = minArea * MAX_MULTIPLIER
            val minPricePerSquareMeter = BigDecimal(3000.0)
            val maxPricePerSquareMeter = minPricePerSquareMeter.multiply(BigDecimal(MAX_MULTIPLIER))

            // when
            val apartment = generator.generate()

            // then
            val maxApartmentPrice: BigDecimal = BigDecimal(apartment.area).multiply(maxPricePerSquareMeter)
            val minApartmentPrice: BigDecimal = BigDecimal(apartment.area).multiply(minPricePerSquareMeter)
            Assertions.assertAll(
                Executable { Assertions.assertTrue(apartment.area >= minArea) },
                Executable { Assertions.assertTrue(apartment.area <= maxArea) },
                Executable { Assertions.assertTrue(apartment.price >= minApartmentPrice) },
                Executable { Assertions.assertTrue(apartment.price <= maxApartmentPrice) }
            )
        }
    }

    @Nested
    internal inner class GeneratorCustomParamsTests {
        private lateinit var generator: RandomApartmentGenerator
        private val minArea = 15.0
        private val minPricePerSquareMeter = BigDecimal(5000.0)

        @BeforeEach
        fun setup() {
            generator = RandomApartmentGenerator(minArea, minPricePerSquareMeter)
        }

        @RepeatedTest(10)
        fun should_GenerateCorrectApartment_When_CustomMinAreaMinPrice() {

            // given
            val minArea = minArea
            val maxArea = minArea * MAX_MULTIPLIER
            val minPricePerSquareMeter = minPricePerSquareMeter
            val maxPricePerSquareMeter = minPricePerSquareMeter.multiply(BigDecimal(MAX_MULTIPLIER))

            // when
            val apartment = generator.generate()

            // then
            val maxApartmentPrice: BigDecimal = BigDecimal(apartment.area).multiply(maxPricePerSquareMeter)
            val minApartmentPrice: BigDecimal = BigDecimal(apartment.area).multiply(minPricePerSquareMeter)
            Assertions.assertAll(
                Executable { Assertions.assertTrue(apartment.area >= minArea) },
                Executable { Assertions.assertTrue(apartment.area <= maxArea) },
                Executable { Assertions.assertTrue(apartment.price >= minApartmentPrice) },
                Executable { Assertions.assertTrue(apartment.price <= maxApartmentPrice) }
            )
        }
    }
}