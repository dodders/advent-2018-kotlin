package org.gad.day02

import org.gad.util.read
import kotlin.system.exitProcess

//const val env = false
const val env = true

fun main(args: Array<String>) {
    val lines = read(env, "02")
    part1(lines)
    part2(lines)
}

fun part2(lines: List<String>) {
    lines.forEach { l1 ->
        lines.forEach { l2 ->
            if (l1.zip(l2).filter { p -> p.first != p.second }.size == 1) {
                println("part2: $l1 and $l2")
                val commonLetters = l1.zip(l2).filter { p -> p.first == p.second}.map {it.first}
                println("common letters: $commonLetters as a string ${commonLetters.joinToString("")}")
                exitProcess(0)
            }
        }
    }
}

private fun part1(lines: List<String>) {
    var twos = 0
    var threes = 0
    lines.forEach { it ->
        val cts = it.toList().groupingBy { it }.eachCount()
        if (cts.values.any { it == 2 }) {
            twos += 1
        }
        if (cts.values.any { it == 3 }) {
            threes += 1
        }
    }
    println("part1: twos $twos threes $threes sum ${twos * threes}")
}