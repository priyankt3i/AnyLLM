package com.example.wearosllmchat

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class OpenAIChatGPT(val apiKey: String) : LLM {
    override fun sendMessage(message: String): String {
        val url = "https://api.openai.com/v1/chat/completions"
        val requestBody = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [ {\"role\": \"user\", \"content\": \"$message\"} ]}"
        val mediaType = "application/json".toMediaType()
        val request = Request.Builder()
            .url(url)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer $apiKey")
            .post(requestBody.toRequestBody(mediaType))
            .build()
        val client = OkHttpClient()
        val response = client.newCall(request).execute()
        if (response.isSuccessful) {
            val responseBody = response.body?.string() ?: throw IOException("Empty response")
            val json = JSONObject(responseBody)
            val choices = json.getJSONArray("choices")
            val firstChoice = choices.getJSONObject(0)
            val message = firstChoice.getJSONObject("message")
            return message.getString("content")
        } else {
            throw IOException("Request failed with code ${response.code}")
        }
    }
}