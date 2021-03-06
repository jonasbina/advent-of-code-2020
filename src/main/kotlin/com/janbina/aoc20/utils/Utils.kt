package com.janbina.aoc20.utils

fun <T> List<T>.uniquePairs(): Sequence<Pair<T, T>> = sequence {
    for (i in 0..lastIndex) {
        for (j in i+1..lastIndex) {
            yield(get(i) to get(j))
        }
    }
}

fun <T> List<T>.uniqueTriples(): Sequence<Triple<T, T, T>> = sequence {
    for (i in 0..lastIndex) {
        for (j in i+1..lastIndex) {
            for (k in j+1..lastIndex) {
                yield(Triple(get(i), get(j), get(k)))
            }
        }
    }
}

fun String.sorted(): String {
    return this.toList().sorted().joinToString(separator = "")
}

fun <T> List<T>.repeatIndefinitely() = generateSequence(0) {
    (it + 1) % this.size
}.map { this[it] }

fun <T> List<T>.permutations(): List<List<T>> {
    return if (this.size <= 1) {
        listOf(this)
    } else {
        val elementToInsert = first()
        drop(1).permutations().flatMap { permutation ->
            (0..permutation.size).map { i ->
                permutation.toMutableList().apply { add(i, elementToInsert) }
            }
        }
    }
}

fun <T, R> MutableMap<T, R>.copyOf(): MutableMap<T, R> {
    return mutableMapOf<T, R>().also { it.putAll(this) }
}

fun <T> MutableList<T>.copyOf(): MutableList<T> {
    return mutableListOf<T>().also { it.addAll(this) }
}
