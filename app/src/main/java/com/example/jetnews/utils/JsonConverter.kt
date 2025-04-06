package com.example.jetnews.utils

import com.google.gson.Gson

fun Any.toJsonString(): String {
    return Gson().toJson(this)
}

inline fun <reified T> String.fromJsonString(): T {
    return Gson().fromJson(this, T::class.java)
}