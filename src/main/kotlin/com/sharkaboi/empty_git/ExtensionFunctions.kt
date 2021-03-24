package com.sharkaboi.empty_git

import java.io.File

fun File.isEmpty(): Boolean {
    val listOfItems = this.list()
    // not a directory
    return listOfItems?.isEmpty() ?: false
}
