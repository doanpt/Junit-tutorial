import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import kotlin.test.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilTest {
    private lateinit var contactManager: ContactManager
    companion object {
        @BeforeAll
        @JvmStatic
        fun setupAll() {
            println("Should Print Before All Tests")
        }

        @AfterAll
        @JvmStatic
        fun tearDownAll() {
            println("Should be executed at the end of the Test")
        }
    }
    // TODO NOTE: JUnit will create a instance of a test for each test
    @BeforeEach
    fun setup() {
        println("Instantiating Contact Manager")
        contactManager = ContactManager()
    }

    @AfterEach
    fun tearDown() {
        println("Should Execute After Each Test")
    }

    @Test
    @DisplayName("Should Create Contact")
    fun shouldCreateContact() {
        contactManager.addContact("John", "Doe", "0123456789")
        assertFalse(contactManager.allContacts.isEmpty())
        assertEquals(1, contactManager.allContacts.size)
    }

    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    fun shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        Assertions.assertThrows(RuntimeException::class.java) { contactManager.addContact(null, "Doe", "0123456789") }
    }

    @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    fun shouldThrowRuntimeExceptionWhenLastNameIsNull() {
        Assertions.assertThrows(RuntimeException::class.java) { contactManager.addContact("John", null, "0123456789") }
    }

    @Test
    @DisplayName("Should Not Create Contact When Phone Number is Null")
    fun shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        Assertions.assertThrows(RuntimeException::class.java) { contactManager.addContact("John", "Doe", null) }
    }


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
//        assertTimeout(Duration.ofSeconds(5), { println("hello") })
//        assertTimeout(Duration.ofSeconds(5)) { println("hello") }
//        assertNull(student, "This test failed due to student is not null")
    }
}