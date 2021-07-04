package mockito

import mock.BookService
import mock.LendBookManager
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito
import org.mockito.Mockito.mock

class LibraryManagementTest {
    @Test
    fun whenBookIsNotAvailable_thenAnExceptionIsThrown() {
        val mockBookService = mock(BookService::class.java)
        Mockito.`when`(mockBookService.inStock(100)).thenReturn(false)
        val manager = LendBookManager(mockBookService)
        assertThrows<IllegalStateException> {
            manager.checkout(100, 1)
        }
    }

    @Test
    fun whenBookIsAvailable_thenLendMethodIsCalled() {
        val mockBookService = mock(BookService::class.java)
        Mockito.`when`(mockBookService.inStock(100)).thenReturn(true)
        val manager = LendBookManager(mockBookService)
        manager.checkout(100, 1)
        Mockito.verify(mockBookService).lend(100, 1)
    }
}