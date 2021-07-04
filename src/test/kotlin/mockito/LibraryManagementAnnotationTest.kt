package mockito

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class LibraryManagementAnnotationTest {
    @Mock
    lateinit var mockBookService:BookService
    lateinit var closeable: AutoCloseable
    lateinit var manager: LendBookManager

    @BeforeEach
    fun initService() {
        closeable = MockitoAnnotations.openMocks(this)
        manager = LendBookManager(mockBookService)
    }

    @AfterEach
    @Throws(Exception::class)
    fun closeService() {
        closeable.close()
    }


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