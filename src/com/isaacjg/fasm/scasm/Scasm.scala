package com.isaacjg.fasm.scasm

object Scasm {
	def main(args: Array[String]) {
		var array : Array[Int] = new Array[Int](1024);
		for (i <- 0 until array.length) {
			array(i) = 0
		}
		var cursor = new Cursor(array)
		if (args.length > 0) {
			val file = io.Source.fromFile(args(0))
			var instructions: List[Instruction] = parse(file.mkString)
			file.close
			for (i <- 0 until instructions.length) {
				val retr: String = instructions(i) exec cursor
				if (!retr.equals("")) print(retr)
			}
		} else {
			println("Not enough args")
		}
	}
	
	def parse(raw: String): List[Instruction] = {
		var instructions: List[Instruction] = List[Instruction]()
		var i: Int = 0
		while (i < raw.length) {
			val c: Char = raw.charAt(i)
			if ("><+-^.,/\\*~" contains c) {
				instructions :+= Instructions getInstruction c
				i += 1
			} else if (c == '[') {
				if (raw.substring(i+1, i+raw.substring(i).indexOf(']')).contains('[')) {
					var end: Int = i
					var loops: Int = 1
					while (loops > 0) {
						end += 1
						if (raw.charAt(end) == '[')
							loops += 1
						else if (raw.charAt(end) == ']')
							loops -=1
					}
					instructions :+= gatherLoop(raw.substring(i, end))
					i = end + 1
				} else {
					instructions :+= gatherLoop(raw.substring(i+1, i+raw.substring(i).indexOf(']')))
					i += raw.substring(i).indexOf(']')+1
				}
			} else {
				i += 1
			}
		}
		return instructions
	}
	
	def gatherLoop(section: String): Loop = {
		var loop: Loop = new Loop()
		var i: Int = 0
		while (i < section.length) {
			val c: Char = section.charAt(i)
			if ("><+-^.,/\\*~" contains c) {
				loop addInstruction(Instructions getInstruction c)
				i += 1
			} else if (c == '[') {
				if (section.indexOf(']') != -1) {
					loop addInstruction(gatherLoop(section.substring(i+1, section.indexOf(']'))))
					i = section.indexOf(']') + 1
				} else {
					var subLoop: Loop = gatherLoop(section.substring(i+1))
					i += subLoop.instructions.length
					loop addInstruction subLoop
				}
			} else {
				i += 1
			}
		}
		return loop
	}
}