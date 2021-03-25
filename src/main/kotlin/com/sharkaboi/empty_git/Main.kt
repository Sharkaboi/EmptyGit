package com.sharkaboi.empty_git

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.NoOpCliktCommand
import com.github.ajalt.clikt.core.context
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.output.Localization
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.versionOption
import java.io.File

class EmptyGit : NoOpCliktCommand(
    help = "Generate files in all empty folders inside the current directory.",
    name = "EmptyGit"
) {
    init {
        this.context {
            helpOptionNames = setOf("-h", "--help")
            localization = object : Localization {
                override fun helpOptionMessage(): String {
                    return "View additional info on any command."
                }
            }
        }
        this.versionOption(
            version = "1.0.1",
            help = "Show the current version of EmptyGit."
        )
    }
}

class Readme : CliktCommand(help = "Create $FILE_NAME for every empty folder.") {
    private val verboseFlag by option(
        "--verbose",
        "-v",
        help = "For showing verbose log of operations."
    ).flag(default = false)
    private val lowerCaseFlag by option(
        "--lower-case", "-l",
        help = "For creating lowercase readme.md files."
    ).flag(default = false)

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
    private val verboseFlag by option(
        "--verbose", "-v",
        help = "For showing verbose log of operations."
    ).flag(default = false)

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
    private val verboseFlag by option(
        "--verbose", "-v",
        help = "For showing verbose log of operations."
    ).flag(default = false)

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