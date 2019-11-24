package org.gad.util

import java.nio.file.Files
import java.nio.file.Path

fun read(env: Boolean, day: String) : List<String> {
    var fName = "data.txt";
    if (!env) {
        fName = "test.txt";
    }
    return Files.readAllLines(Path.of("data/day$day/$fName"));
}