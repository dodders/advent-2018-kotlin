package org.gad.day01

import org.gad.util.read
import kotlin.system.exitProcess

const val env = true

fun main(args: Array<String>) {
    var lines = read(env, "01")
    part1(lines)
    part2(lines)
}

fun part2(lines: List<String>) {
    var freq = 0
    var freqs = setOf(0)
    var run = true
    while (run) {
        lines.forEach {
            var oldfreq = freq
            freq = doOp(freq, it)
            if (freqs.contains(freq)) {
                println("old freq: $oldfreq op: $it newfreq: $freq frequencies: $freqs")
                println("part 2: $freq")
                exitProcess(0)
            } else {
                freqs = freqs.plus(freq)
//                println("old freq: $oldfreq op: $it newfreq: $freq frequencies: $freqs")
            }
        }
    }
}

fun part1(lines: List<String>) {
    var freq = 0
    lines.forEach {
        freq = doOp(freq, it)
    }
    println("part 1 answer: $freq")
}

fun doOp(acc: Int, inp: String) : Int {
    val line = split(inp)
    return if (line.first == '+') {
        acc + Integer.valueOf(line.second)
    } else {
        acc - Integer.valueOf(line.second)
    }
}

fun split(str: String) : Pair <Char, String> {
    return Pair(str[0], str.substring(1, str.length).trim())
}
