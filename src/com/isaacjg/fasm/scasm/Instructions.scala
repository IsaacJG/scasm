package com.isaacjg.fasm.scasm

object Instructions {
	def getInstruction(instruction: Char): Instruction = instruction match {
		case '>' => GreaterThan
		case '<' => LessThan
		case '+' => Plus
		case '-' => Minus
		case '^' => Carrot
		case '.' => Period
		case ',' => Comma
		case '/' => ForwardSlash
		case '\\' => BackSlash
		case '*' => Asterisk
		case '~' => Tidle
	}

	object GreaterThan extends Instruction {
		def exec(cursor: Cursor): String = {
			cursor.up()
			return ""
		}
	}
	
	object LessThan extends Instruction {
		def exec(cursor: Cursor): String = {
			cursor.down()
			return ""
		}
	}
	
	object Plus extends Instruction {
		def exec(cursor: Cursor): String = {
			cursor.inc()
			return ""
		}
	}
	
	object Minus extends Instruction {
		def exec(cursor: Cursor): String = {
			cursor.dec()
			return ""
		}
	}
	
	object Carrot extends Instruction {
		def exec(cursor: Cursor): String = Integer.toString(cursor.pop())
	}
	
	object Period extends Instruction {
		def exec(cursor: Cursor): String = {
			if (cursor.cout)
				return Character.toString(cursor.getC())
			else
				return Integer.toString(cursor.getI())
		}
	}
	
	object Comma extends Instruction {
		def exec(cursor: Cursor): String = {
			cursor.put()
			return ""
		}
	}
	
	object ForwardSlash extends Instruction {
		def exec(cursor: Cursor): String = {
			cursor.copyUp()
			return ""
		}
	}
	
	object BackSlash extends Instruction {
		def exec(cursor: Cursor): String = {
			cursor.copyDown()
			return ""
		}
	}
	
	object Asterisk extends Instruction {
		def exec(cursor: Cursor): String = cursor.dump()
	}
	
	object Tidle extends Instruction {
		def exec(cursor: Cursor): String = {
			cursor.toggleout()
			return ""
		}
	}
}