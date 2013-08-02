package com.isaacjg.fasm.scasm

class Loop() extends Instruction {
	var instructions: List[Instruction] = List[Instruction]()

	def addInstruction(instruction: Instruction) = instructions :+= instruction

	def exec(cursor: Cursor): String = {
		var retr: String = ""
		val origin: Int = cursor.loc
		while (cursor.array(origin) > 0) {
			for (i <- 0 until instructions.length) {
				retr += instructions(i) exec cursor
			}
		}
		return retr
	}
}