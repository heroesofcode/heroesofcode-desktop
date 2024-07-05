package repository

import dto.InfoDTO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import io.mockk.coEvery
import network.ApiClient
import org.junit.After
import org.junit.Before
import testModule
import kotlin.test.*

@OptIn(ExperimentalCoroutinesApi::class)
class InfoRepositoryTest : KoinTest {

    private val repository: InfoRepository by inject()
    private val apiClient: ApiClient by inject()

    @Before
    fun setUp() {
        startKoin { modules(testModule) }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun testFetchInfoSuccess() = runTest {
        val infoDTO = InfoDTO(
            description = "Description",
            name = "Name",
            followers = 123,
            following = 456,
            avatarUrl = "http://example.com/avatar.png"
        )

        coEvery { apiClient.getInfo() } returns infoDTO

        val result = repository.getInfo()

        assertTrue(result.isSuccess)
        val info = result.getOrNull()
        assertNotNull(info)
        assertEquals("Description", info.description)
        assertEquals("Name", info.name)
        assertEquals(123, info.followers)
        assertEquals(456, info.following)
        assertEquals("http://example.com/avatar.png", info.avatarUrl)
    }

    @Test
    fun testFetchInfoFailure() = runTest {
        coEvery { apiClient.getInfo() } throws Exception("Network error")

        val result = repository.getInfo()

        assertTrue(result.isFailure)
        val exception = result.exceptionOrNull()
        assertNotNull(exception)
        assertEquals("Network error", exception?.message)
    }
}