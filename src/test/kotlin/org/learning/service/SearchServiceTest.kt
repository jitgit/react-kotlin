package org.learning.service

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.common.ConsoleNotifier
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.marcinziolo.kotlin.wiremock.get
import com.marcinziolo.kotlin.wiremock.like
import com.marcinziolo.kotlin.wiremock.returns
import org.junit.Rule
import org.learning.service.SearchService
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class SearchServiceTest {

    @Rule
    @JvmField
    var wireMockRule = WireMockRule(8080)

    val wiremock: WireMockServer
    val url
        get() = "https://samples.openweathermap.org"

    init {
        wiremock = WireMockServer(options().port(8080).notifier(ConsoleNotifier(true)))
    }

    @Test
    fun testResponse() {
        mockResponse()
        val service = SearchService()
        val result = service.search("ah")
        print(result)
        assertEquals(result.size, 3)
        result.forEach { c ->
            assertTrue(c.name.contains("ah"))
        }
    }

    private fun mockResponse() {
        wiremock.get {
            url like "/data/2.5/box/city"
        } returns {
            header = "Content-Type" to "application/json"
            statusCode = 200
            body = //More mock fields can be added if required
                """{"list": [ { "id": 2208791, "name": "Yafran" }, { "id": 2208425, "name": "Zuwarah" }, { "id": 2212771, "name": "Sabratah" }, { "id": 2217362, "name": "Gharyan"}]}"""
        }
    }

}