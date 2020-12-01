package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main(args: Array<String>) {
    val input = Input.getDayInputLines(1)
    Day01(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day01(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        val listik = mutableListOf<Int>()
        inputInts.forEach {
            for (i in 0..inputInts.lastIndex) {
                if (inputInts[i] + it == 2020) {

                    listik.add(it)
                    listik.add(inputInts[i])
                }
            }
        }
        return listik[0] * listik[1]
    }

    fun part2(): Any {
        val listik = mutableListOf<Int>()
        inputInts.forEach {
            for (i in 0..inputInts.lastIndex) {
                for (p in 0..inputInts.lastIndex) {
                    if (inputInts[i] + it + inputInts[p] == 2020) {

                        listik.add(it)
                        listik.add(inputInts[i])
                        listik.add(inputInts[p])
                    }
                }

            }
        }
        return listik[0] * listik[1] * listik[2]
    }
}

