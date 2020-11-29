package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(1)
    Day01(input).also {
        it.part1()
        it.part2()
    }
}

class Day01(inputLines: List<String>) {

    private val input = inputLines.map { it.toInt() }

    fun part1() {
        
    }

    fun part2() {
    }

}