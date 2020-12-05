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
            val parts = it.split(" ", "-", ": ")
            val cislo1 = parts[0].toInt()
            val cislo2 = parts[1].toInt()
            val pismeno = parts[2].first()
            val heslo = parts[3]
            var cislo = 0
            heslo.forEach {
                if (it == pismeno){
                    cislo++
                }
            }
            if (cislo >= cislo1 && cislo <= cislo2){
                vysledkovyint++
            }
        }
            return vysledkovyint


    }

    fun part2(): Any {
        var vysledkovyint = 0
        inputLines.forEach {
            val parts = it.split(" ", "-", ": ")
            val cislo1 = parts[0].toInt()
            val cislo2 = parts[1].toInt()
            val pismeno = parts[2].first()
            val heslo = parts[3]
            var cislo = 0
            var boolean1 = heslo[cislo1 - 1] == pismeno
            var boolean2 = heslo[cislo2 - 1] == pismeno
           if (boolean1){
               if (boolean2 == false){
                   vysledkovyint++
               }
           }
            if (boolean2){
                if (boolean1 == false){
                    vysledkovyint++
                }
            }

        }
        return vysledkovyint
    }


}