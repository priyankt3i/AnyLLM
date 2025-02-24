package com.example.wearosllmchat

interface LLM {
    fun sendMessage(message: String): String
}