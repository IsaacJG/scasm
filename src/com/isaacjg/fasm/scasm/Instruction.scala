package com.isaacjg.fasm.scasm

trait Instruction {
	def exec(cursor: Cursor): String
}