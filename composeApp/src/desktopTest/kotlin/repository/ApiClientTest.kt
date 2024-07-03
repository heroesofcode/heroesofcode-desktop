package repository

import dto.InfoDTO
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import network.ApiClient
import org.junit.Before
import kotlin.test.Test

class ApiClientTest {

    private lateinit var mockApiClient: ApiClient

    @Before
    fun setUp() {
        mockApiClient = mockk(relaxed = true)
    }

    @Test
    fun testGetInfo() = runBlocking {
        coEvery { mockApiClient.getInfo() } returns InfoDTO(
            description = "Description",
            name = "Name",
            followers = 123,
            following = 456,
            avatarUrl = "http://example.com/avatar.png"
        )

        val info = mockApiClient.getInfo()

        assertNotNull(info)
        assertEquals("Description", info.description)
        assertEquals("Name", info.name)
        assertEquals(123, info.followers)
        assertEquals(456, info.following)
        assertEquals("http://example.com/avatar.png", info.avatarUrl)
    }
}