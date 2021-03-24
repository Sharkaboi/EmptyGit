# EmptyGit

Kotlin CLI tool to generate placeholder files in empty folders.  
Useful if you want to version control your directory structure even if they are empty.

## Installation

* Install [Kotlin](https://kotlinlang.org/) or Java to run JAR files.
* Get the `EmptyGit.zip` file from [releases](https://github.com/Sharkaboi/EmptyGit/releases) and extract to a permanent location, preffarably to `C:\`.
* Copy full absolute address of folder `.\bin`.
* Add the address to System environment path variable.
* Run `EmptyGit -h` to test (`refreshenv` if using PS).

## Commands
- **Command is performed on current folder, so CD to directory you wish to add placeholders.**  
- For adding `readme.md` to every empty folder run :   
    ```
    EmptyGit readme
    ```
- For adding `.gitignore` to every empty folder run :   
    ```
    EmptyGit git-ignore
    ```
- For adding `.gitkeep` to every empty folder run :   
    ```
    EmptyGit git-keep
    ```
- For verbose operation use `-v` or `--verbose` argument with the above commands. 
  For example  
    ```
    EmptyGit readme -v
    EmptyGit readme --verbose
    ```
- For help in any section use `-h` or `--help` as so  
    ```
    EmptyGit -h
    EmptyGit --help
    ```
  
## Build instructions
- Install [Gradle](https://gradle.org/) and [Kotlin](https://kotlinlang.org/).
- Clone project.
- Open in Intellij and run gradle task `distrubution > installDist`   
  or run `gradle installDist`
- Copy full absolute address to `.\build\install\EmptyGit\bin`.
- Add the address to System environment path variable.
- Run `EmptyGit -h` to test (`refreshenv` is using PS).

## Assumptions
- Skips over any folder/address that contains `.git`.
- Skips over already non empty folders.
- Skips over if file to be generated already exists.
- Fills deepest folder and then recurse without generating file in every layer.

## Tools used
- [Kotlin](https://kotlinlang.org/)
- [Gradle](https://gradle.org/)
- [Clikt](https://ajalt.github.io/clikt/)

## Contributing
PR's are welcome. Please try to follow the template.

## Licence
```
MIT License

Copyright (c) 2021 Sarath S

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

``` 
