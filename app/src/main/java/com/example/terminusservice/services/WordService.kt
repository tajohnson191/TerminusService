package com.example.terminusservice.services

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class WordService {
    //TODO figure out how to send the "word" to the service.

    fun isWord(word: String) : Response {

        val client = OkHttpClient()
        try {
            val request = Request.Builder()
                .url("https://wordsapiv1.p.rapidapi.com/words/hatchback/typeOf")
                .get()
                .addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "c6ebeb1638mshc9f7a33d6b06bb6p1d1a94jsn981bfa7990c5")
                .build()
            val response = client.newCall(request).execute()
            return response
        } catch(e: Exception) {
            println("Failed to connect to dictionary api")
            throw e
        }
    }
}