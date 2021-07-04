import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.time.Duration
import kotlin.test.*

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

    @Test
    fun `test try all assertion method`() {
        val student = Student("Doan", 17)
        assertFalse(student.age == 18, "this test pass due to age of student is 17")
        assertTrue(student.name === "Doan", "This pass due to name of student is Doan")
        assertEquals("DOAN", student.name.toUpperCase(), "this test pass Doan upper case is DOAN")
        assertNotEquals("Doan", student.name.toUpperCase(), "this test pass Doan upper case is DOAN not Doan")
        assertSame(student, student, "This pass due to 2 object is refer to one")
        assertNotSame(student, Student("Doan", 17), "This pass due to 2 students does not refer to same object")
        assertNotNull(student, "This test pass due to student are initialized")
        assertThrows<IllegalArgumentException> {
            student.testThrow()
        }
        assertAll(
            { assertEquals("Doan", student.name) },
            { assertNotEquals("Ha", student.name) }
        )
        assertTimeout(Duration.ofSeconds(5), { println("hello") })
        assertTimeout(Duration.ofSeconds(5)) { println("hello") }
        assertNull(student, "This test failed due to student is not null")
    }
}