import java.lang.IllegalArgumentException

data class Student(
    var name: String,
    var age: Int = 18
) {
    fun testThrow() {
        throw IllegalArgumentException()
    }
}

