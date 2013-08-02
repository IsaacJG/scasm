Scasm: Fasm implemented in Scala
===============================
For information on the Fasm language, see the [official language specification](https://github.com/IsaacJG/fasm-spec#fasm-specification)

## Compiling
The following commands should be run in the root folder of the project:

1. `mkdir bin` Make the bin directory to place compiled scala files
2. `scalac -sourcepath src -d bin src\com\isaacjg\fasm\scasm\Scasm.scala` Compile the source files
3. `jar cfm Scasm.jar Manifest.mf -C bin/ .` Make a usable jar

## Usage
`scala Scala.jar file.fasm`

## Implementation issues

* Nested loops **do not work** :(

## Contributions
Feel free to submit issues and make pull requests if you can help improve this implementation!

## License
[GPLv3](LICENSE)
