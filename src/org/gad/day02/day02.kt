package org.gad.day02

import org.gad.util.read

fun main(args: Array<String>) {
    val lines = read(true, "02")
    part1(lines)
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