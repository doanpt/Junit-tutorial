import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MathUtilTest {

    //We have 7 popular method naming ways, I prefer solution 3 or 4.
    // For more detail, refer 7-popular-method-naming-in-junit.md file in resource folder
    // below is testes named follow solution 3.
    @Test
    @DisplayName("test add if number is valid")
    fun testAddIfNumberValid() {
        val mathUtil = MathUtils()
        val result = mathUtil.add(5, 5)
        assertEquals(10, result)
    }

    @Test
    fun `test add if number is valid`() {
        val mathUtil = MathUtils()
        val result = mathUtil.add(5, 5)
        assertEquals(10, result)
    }
}