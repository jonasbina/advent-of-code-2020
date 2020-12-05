package com.janbina.aoc20.solutions

import com.janbina.aoc20.utils.Input

fun main() {
    val input = Input.getDayInputLines(4)
    Day04(input).also {
        println(it.part1())
        println(it.part2())
    }
}

class Day04(
    private val inputLines: List<String>
) {

    private val inputInts by lazy { inputLines.map { it.toInt() } }
    private val inputLinesSplitted by lazy {
        inputLines.map {
            it.split(",")
        }
    }

    fun part1(): Any {
        val pasy = mutableListOf<String>()
        val booleanlist = mutableListOf<Boolean>()
        var pass = ""
        inputLines.forEach {
            if (it == ""){
                pasy.add(pass)
                pass = ""
            }else{
                pass = pass + " $it"
            }
        }
        pasy.forEach{
            val ejhwlawesfjkWS = it.split(" ")
            val pss = ejhwlawesfjkWS.map { it.split(":") }
            val b = validujPas(pss)
            booleanlist.add(b)
        }

        var vysledek = 0
        booleanlist.forEach{
            if(it == true){
                vysledek++
            }
        }
        return vysledek
    }

    private fun validujPas(pss: List<List<String>>): Boolean {
        var byr = false
        var iyr = false
        var eyr = false
        var hgt = false
        var hcl = false
        var ecl = false
        var pid = false
        pss.forEach {
            val key = it.first()
            var value = ""
            if (it.getOrNull(1) != null){
                value = it[1]
            }

            if (key == "byr") {
                if (value.toInt() >= 1920 && value.toInt() <=2002)
                byr = true

            }
            if (key == "iyr"){
                if (value.toInt() >= 2010 && value.toInt() <=2020){
                iyr = true
                }
            }
            if (key == "eyr"){
                if (value.toInt() >= 2020 && value.toInt() <=2030){
                eyr = true
                }
            }
            if (key == "hgt"){
                val jednotka = value.takeLast(2)
                val cislo = value.dropLast(2).toIntOrNull() ?: 0

                if (jednotka == "cm"){
                    if (cislo >= 150 && cislo <= 193){
                        hgt = true
                    }
                }

                if (jednotka == "in"){
                    if (cislo >= 59 && cislo <= 76){
                        hgt = true
                    }
                }


               }

            if (key == "hcl"){

                if (value.first() == '#' && value.drop(1).all { it in "0123456789abcdef" }){
                    hcl = true
                }
            }
            if (key == "ecl"){
                if (value in listOf("amb" ,"blu" ,"brn" ,"gry" ,"grn" ,"hzl" ,"oth")){
                    ecl = true
                }

            }
            if (key == "pid"){
                if (value.length == 9){
                   if (value.toLongOrNull() != null){
                       pid = true
                   }
                }
            }

        }

        return byr && iyr && eyr && hgt && hcl && ecl && pid
    }

    fun part2(): Any {

        return 0
    }
}


