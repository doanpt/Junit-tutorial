package mockito

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class LibraryManagementMockitoExtensionMethodParameterTest {

    @Test
    fun whenBookIsNotAvailable_thenAnExceptionIsThrown(@Mock bookService: BookService) {
        val manager = LendBookManager(bookService)
        Mockito.`when`(bookService.inStock(100)).thenReturn(false)
        assertThrows<IllegalStateException> {
            manager.checkout(100, 1)
        }
    }

}