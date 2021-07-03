import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MathUtilTest {
    @Test
    fun test_add() {
        println("This is demo of test")
    }

    @Test
    fun test_demo1() {
        val mathUtil = MathUtils()
        val result = mathUtil.add(5, 5)
        assertEquals(10, result)
    }
}