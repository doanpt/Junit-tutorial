package mockito

import mock.BookService
import mock.LendBookManager
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class LibraryManagementMockitoExtensionInjectMocksTest {
    @Mock
    lateinit var mockBookService:BookService
    @InjectMocks
    lateinit var manager: LendBookManager

    @Test
    fun whenBookIsNotAvailable_thenAnExceptionIsThrown() {
        Mockito.`when`(mockBookService.inStock(100)).thenReturn(false)
        assertThrows<IllegalStateException> {
            manager.checkout(100, 1)
        }
    }

    @Test
    fun whenBookIsAvailable_thenLendMethodIsCalled() {
        Mockito.`when`(mockBookService.inStock(100)).thenReturn(true)
        manager.checkout(100, 1)
        Mockito.verify(mockBookService).lend(100, 1)
    }
}