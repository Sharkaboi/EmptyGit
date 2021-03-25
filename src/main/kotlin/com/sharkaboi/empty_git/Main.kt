package com.sharkaboi.empty_git

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import java.io.File

class EmptyGit : CliktCommand(help = "Generate files in all empty folders inside the current directory.") {
    override fun run() = Unit
}

class Readme : CliktCommand(help = "Create $FILE_NAME for every empty folder.") {
    private val verboseFlag by option("--verbose", "-v").flag(default = false)
    private val lowerCaseFlag by option("--lower-case", "-l").flag(default = false)

    override fun run() {
        val currentDirectory = System.getProperty("user.dir")
        val dirAsFile = File(currentDirectory)
        if (verboseFlag) {
            echo("Starting from " + dirAsFile.absolutePath)
        }
        dirAsFile.walk().forEach {
            if (it.isDirectory && it.isEmpty() && !it.absolutePath.contains(".git")) {
                val fileLocation = it.absolutePath + File.separator + if (lowerCaseFlag) FILE_NAME_SMALL else FILE_NAME
                val isFileCreated: Boolean = File(fileLocation).createNewFile()
                if (isFileCreated && verboseFlag) {
                    echo("Adding ${if (lowerCaseFlag) FILE_NAME_SMALL else FILE_NAME} to ${it.absolutePath}")
                } else if (!isFileCreated && verboseFlag) {
                    echo("A ${if (lowerCaseFlag) FILE_NAME_SMALL else FILE_NAME} already exists in ${it.absolutePath}")
                }
            } else {
                if (verboseFlag) {
                    echo("Skipping " + it.absolutePath)
                }
            }
        }
        echo("Done")
    }

    companion object {
        const val FILE_NAME = "README.md"
        const val FILE_NAME_SMALL = "readme.md"
    }
}

class GitKeep : CliktCommand(help = "Create $FILE_NAME for every empty folder.") {
    private val verboseFlag by option("--verbose", "-v").flag(default = false)
    override fun run() {
        val currentDirectory = System.getProperty("user.dir")
        val dirAsFile = File(currentDirectory)
        if (verboseFlag) {
            echo("Starting from " + dirAsFile.absolutePath)
        }
        dirAsFile.walk().forEach {
            if (it.isDirectory && it.isEmpty() && !it.absolutePath.contains(".git")) {
                val isFileCreated: Boolean = File(it.absolutePath + File.separator + Readme.FILE_NAME).createNewFile()
                if (isFileCreated && verboseFlag) {
                    echo("Adding $FILE_NAME to ${it.absolutePath}")
                } else if (!isFileCreated && verboseFlag) {
                    echo("A $FILE_NAME already exists in ${it.absolutePath}")
                }
            } else {
                if (verboseFlag) {
                    echo("Skipping " + it.absolutePath)
                }
            }
        }
        echo("Done")
    }

    companion object {
        const val FILE_NAME = ".gitkeep"
    }
}

class GitIgnore : CliktCommand(help = "Create $FILE_NAME for every empty folder.") {
    private val verboseFlag by option("--verbose", "-v").flag(default = false)
    override fun run() {
        val currentDirectory = System.getProperty("user.dir")
        val dirAsFile = File(currentDirectory)
        if (verboseFlag) {
            echo("Starting from " + dirAsFile.absolutePath)
        }
        dirAsFile.walk().forEach {
            if (it.isDirectory && it.isEmpty() && !it.absolutePath.contains(".git")) {
                val isFileCreated: Boolean = File(it.absolutePath + File.separator + Readme.FILE_NAME).createNewFile()
                if (isFileCreated && verboseFlag) {
                    echo("Adding $FILE_NAME to ${it.absolutePath}")
                } else if (!isFileCreated && verboseFlag) {
                    echo("A $FILE_NAME already exists in ${it.absolutePath}")
                }
            } else {
                if (verboseFlag) {
                    echo("Skipping " + it.absolutePath)
                }
            }
        }
        echo("Done")
    }

    companion object {
        const val FILE_NAME = ".gitignore"
    }
}

fun main(args: Array<String>) = EmptyGit()
    .subcommands(GitIgnore(), GitKeep(), Readme())
    .main(args)