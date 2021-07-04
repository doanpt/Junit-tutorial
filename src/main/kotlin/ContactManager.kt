import java.util.concurrent.ConcurrentHashMap

class ContactManager {
    var contactList: MutableMap<String, Contact> = ConcurrentHashMap()
    fun addContact(firstName: String?, lastName: String?, phoneNumber: String?) {
        val contact = Contact(firstName!!, lastName!!, phoneNumber!!)
        validateContact(contact)
        checkIfContactAlreadyExist(contact)
        contactList[generateKey(contact)] = contact
    }

    val allContacts: Collection<Contact>
        get() = contactList.values

    private fun checkIfContactAlreadyExist(contact: Contact) {
        if (contactList.containsKey(generateKey(contact))) throw RuntimeException("Contact Already Exists")
    }

    private fun validateContact(contact: Contact) {
        contact.validateFirstName()
        contact.validateLastName()
        contact.validatePhoneNumber()
    }

    private fun generateKey(contact: Contact): String {
        return String.format("%s-%s", contact.firstName, contact.lastName)
    }
}