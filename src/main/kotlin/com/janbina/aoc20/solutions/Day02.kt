package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main(args: Array<String>) {
    val input = Input.getDayInputLines(2)
    Day02(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day02(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        var vysledkovyint = 0
        inputLines.forEach {
            val ah = mutableListOf<Char>()
            for (i in 0..it.length - 1) {
                if (it[i].toString() == "") {
                } else if (it.toString() == ":") else {
                    if (it[i].toString() == "-") {
                        ah.add('-')
                    } else {
                        ah.add(it[i])
                    }
                }
            }


            var x = ""
            var y = ""
            var pocet = 0

            while (true) {
                if (ah[pocet].isDigit()) {
                    x = x + ah[pocet]
                } else {
                    break
                    pocet++
                }
                pocet++
            }
            while (true) {
                if (ah[pocet].isDigit()) {
                    y = y + ah[pocet]
                } else {
                    break
                    pocet++
                }
                pocet++
            }
            val pismenko = ah[pocet]
            pocet++
            var stringik = ""
            while (true) {
                if (pocet > ah.lastIndex) {
                    break
                }
                stringik = stringik + ah[pocet]
                pocet++
            }
            var pocetpismenvhesle = 0
            for (j in 0..stringik.lastIndex) {
                if (pismenko == stringik[j]) {
                    pocetpismenvhesle++
                }
            }
            if (pocetpismenvhesle >= x.toInt() && pocetpismenvhesle <= y.toInt()) {
                vysledkovyint++
            }
        }

        return vysledkovyint
    }


    fun part2(): Any {

        return 0
    }


}