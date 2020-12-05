package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(3)
    Day03(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day03(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        var vyska = 0
        var sirka = 0
        val vstup = mutableListOf<String>()
        inputLines.forEach {
            val line = it
            var string = ""
            repeat(1000){
                string = string + line
            }
            vstup.add(string)
        }
        //val vystup = mutableListOf(inputLines)
        var num = 0
        while (true){
            vyska = vyska + 1
            sirka = sirka + 3
            if (vyska > vstup.lastIndex || sirka > vstup[0].lastIndex){
                break
            }
            if (vstup[vyska][sirka] == '#'){
                num++
            }
        }

        return num
    }

    fun funkce(sirkafun : Int,vyskafun:Int):Int{
        var vyska = 0
        var sirka = 0
        val vstup = mutableListOf<String>()
        inputLines.forEach {
            val line = it
            var string = ""
            repeat(1000){
                string = string + line
            }
            vstup.add(string)
        }
        //val vystup = mutableListOf(inputLines)
        var num = 0
        while (true){
            vyska = vyska + vyskafun
            sirka = sirka + sirkafun
            if (vyska > vstup.lastIndex || sirka > vstup[0].lastIndex){
                break
            }
            if (vstup[vyska][sirka] == '#'){
                num++
            }
        }
        return num
    }
    fun part2():  Long {
        val int1 = funkce(sirkafun = 1,vyskafun = 1)
        val int2 = funkce(sirkafun = 3,vyskafun = 1)
        val int3 = funkce(sirkafun = 5,vyskafun = 1)
        val int4 = funkce(sirkafun = 7,vyskafun = 1)
        val int5 = funkce(sirkafun = 1,vyskafun = 2)

    return int1 * int2 * int3 * int4 * int5.toLong()
}
}

