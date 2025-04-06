package com.example.jetnews.utils

import org.junit.Assert
import org.junit.Test

class JsonConverterTests {

    private val inputValues : List<Person> = listOf (
        Person("John", 21),
        Person("Anne", 20),
        Person("Hulk", 18),
    )

    @Test
    fun testJsonConverter() {
        for (person in inputValues) {
            val text = person.toJsonString()
            Assert.assertNotNull(text)
            assert(text.contains(person.name))
            assert(text.contains(person.age.toString()))

            val reverted = text.fromJsonString<Person>()
            Assert.assertEquals(person, reverted)
        }
    }

    private data class Person(val name: String, val age: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Person) return false

            if (name != other.name) return false
            if (age != other.age) return false

            return true
        }

        override fun hashCode(): Int {
            var result = name.hashCode()
            result = 31 * result + age
            return result
        }

    }
}