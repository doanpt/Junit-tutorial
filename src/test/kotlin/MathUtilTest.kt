import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.*


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilTest {
    private lateinit var contactManager: ContactManager

    @BeforeAll
    fun setupAll() {
        println("Should Print Before All Tests")
    }

    @AfterAll
    fun tearDownAll() {
        println("Should be executed at the end of the Test")
    }

    // TODO NOTE: JUnit will create a instance of a test for each test
    // To let Junit create only once instance for whole test class, we can use TestInstance(TestInstance.Lifecycle.PER_CLASS), then we don't need the static function of BeforeAll, AfterAll
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

    @Test
    @DisplayName("Should Create Contact On Mac OS")
    @EnabledOnOs(value = [OS.MAC])
    fun shouldCreateContactOnMAC() {
        contactManager.addContact(
            "John", "Doe", "0123456789"
        )
        assertFalse(contactManager.allContacts.isEmpty())
        assertEquals(1, contactManager.allContacts.size)
    }

    @Test
    @DisplayName("Should Create Contact except MacOS")
    @DisabledOnOs(value = [OS.MAC])
    fun shouldCreateContactExceptMacOS() {
        contactManager.addContact(
            "John", "Doe", "0123456789"
        )
        assertFalse(contactManager.allContacts.isEmpty())
        assertEquals(1, contactManager.allContacts.size)
    }

    @Test
    @DisplayName("Test Contact Creation not on Developer Machine")
    fun shouldTestContactCreationOnDEV() {
        Assumptions.assumeFalse("DEV" == System.getProperty("ENV"))
        contactManager.addContact(
            "John", "Doe", "0123456789")
        assertFalse(contactManager.allContacts.isEmpty())
        assertEquals(1, contactManager.allContacts.size)
    }

    @Test
    @DisplayName("Repeat Contact Creation Test 5 Times")
    @RepeatedTest(value = 5, name = "Repeating Contact Creation Test {currentRepetition} of {totalRepetitions}")
    fun shouldTestContactCreationRepeatedly() {
        contactManager.addContact("John", "Doe", "0123456789")
        assertFalse(contactManager.allContacts.isEmpty())
        assertEquals(1, contactManager.allContacts.size)
    }

    @DisplayName("Phone Number should match the required Format")
    @ParameterizedTest
    @ValueSource(strings = ["0123456789", "0123456798", "0123456897"])
    fun shouldTestPhoneNumberFormatUsingValueSource(phoneNumber: String) {
        contactManager.addContact("John", "Doe", phoneNumber)
        assertFalse(contactManager.allContacts.isEmpty())
        assertEquals(1, contactManager.allContacts.size)
    }

    @DisplayName("Method Source Case - Phone Number should match the required Format")
    @ParameterizedTest
    @MethodSource("phoneNumberList")
    fun shouldTestPhoneNumberFormatUsingMethodSource(phoneNumber: String?) {
        contactManager.addContact("John", "Doe", phoneNumber)
        assertFalse(contactManager.allContacts.isEmpty())
        assertEquals(1, contactManager.allContacts.size)
    }

    private fun phoneNumberList(): List<String> {
        return listOf("0123456789", "0123456798", "0977521942")
    }

    @DisplayName("CSV Source Case - Phone Number should match the required Format")
    @ParameterizedTest
    @CsvSource("0123456789", "0123456798", "0123456897")
    fun shouldTestPhoneNumberFormatUsingCSVSource(phoneNumber: String?) {
        contactManager.addContact("John", "Doe", phoneNumber)
        assertFalse(contactManager.allContacts.isEmpty())
        assertEquals(1, contactManager.allContacts.size)
    }

    @DisplayName("CSV File Source Case - Phone Number should match the required Format")
    @ParameterizedTest
    @CsvFileSource(resources = ["/data.csv"])
    fun shouldTestPhoneNumberFormatUsingCSVFileSource(phoneNumber: String?) {
        contactManager.addContact("John", "Doe", phoneNumber)
        assertFalse(contactManager.allContacts.isEmpty())
        assertEquals(1, contactManager.allContacts.size)
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