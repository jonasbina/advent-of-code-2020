package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(5)
    Day05(input).also {
        println(it.part1())
        println(it.part2())
    }


}

class Day05(
    inputLines: List<String>
) {

    private val passes = inputLines.map { createPass(it) }

    fun part1(): Any {
        var nejvetsiid = 0
        passes.forEach {
            if (it.id > nejvetsiid){nejvetsiid = it.id}
        }

        return nejvetsiid
    }

    fun part2(): Any {
        val sorted = passes.sortedBy { it.id }
        var vysledek = 0
        sorted.forEachIndexed { index, pass ->
            if (index > 0){
                if (pass.id - sorted[index-1].id != 1){
                    vysledek= pass.id - 1
                }
            }

        }



        return vysledek
    }

    fun createPass(pass: String): Pass {

        var maxRada = 127
        var minRada = 0
        var maxSloupec = 7
        var minSloupec = 0
        pass.forEachIndexed { index, c ->
            val rozdilRada = maxRada - minRada
            var rozdilSloupec = maxSloupec - minSloupec
            if (c == 'B') {
                minRada = rozdilRada / 2 + minRada + 1
            }
            if (c == 'F') {
                maxRada = rozdilRada / 2 + minRada
            }
            if (c == 'R') {
                minSloupec = rozdilSloupec / 2 + minSloupec + 1
            }
            if (c == 'L') {
                maxSloupec = rozdilSloupec / 2 + minSloupec
            }
        }

        return Pass(rada = maxRada,sloupec = maxSloupec)
    }

    data class Pass(
        val rada: Int,
        val sloupec: Int
    ){
        val id = rada * 8 + sloupec
    }
    data class idcka (
        val id : Int,
        val boolean: Boolean
            )
}
