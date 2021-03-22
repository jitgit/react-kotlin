package org.learning.service

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class SearchService {
    private val httpClient = OkHttpClient()
    val mapper = ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .registerKotlinModule()

    fun search(s: String): List<City> {
        val request = Request.Builder()
            .url("https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22")
            .addHeader("Accept", "*/*")
            .build()

        httpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            val content = response.body()!!.string()
            val result = mapper.readValue<OpenWeatherResponse>(content)
            return result.list.filter { c -> c.name.contains(s, ignoreCase = true) }.toList()
        }
    }

}

class OpenWeatherResponse {
    val list = listOf<City>()
}

data class City(val id: Long, val name: String)