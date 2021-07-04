class Contact(val firstName: String = "", val lastName: String = "", private val phoneNumber: String = "") {
    fun validateFirstName() {
        if (firstName.isBlank()) throw RuntimeException("First Name Cannot be null or empty")
    }

    fun validateLastName() {
        if (lastName.isBlank()) throw RuntimeException("Last Name Cannot be null or empty")
    }

    fun validatePhoneNumber() {
        if (phoneNumber.isBlank()) {
            throw RuntimeException("Phone Name Cannot be null or empty")
        }
        if (phoneNumber.length != 10) {
            throw RuntimeException("Phone Number Should be 10 Digits Long")
        }
        if (!phoneNumber.matches("\\d+".toRegex())) {
            throw RuntimeException("Phone Number Contain only digits")
        }
        if (!phoneNumber.startsWith("0")) {
            throw RuntimeException("Phone Number Should Start with 0")
        }
    }
}

