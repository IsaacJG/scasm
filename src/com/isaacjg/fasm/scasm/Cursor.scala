package com.isaacjg.fasm.scasm

class Cursor(arrayc: Array[Int]) {
	var array: Array[Int] = arrayc
	var loc: Int = 0
	var length: Int = array.length
	var cout: Boolean = true
	
	def up() {
		loc += 1
		if (loc >= length)
			loc = 0
	}
	
	def down() {
		loc -= 1
		if (loc < 0)
			loc = length - 1
	}
	
	def inc() {
		array(loc) += 1
	}
	
	def dec() {
		array(loc) -=1
	}
	
	def pop(): Int = {
		val hold: Int = array(loc)
		array(loc) = 0
		return hold
	}
	
	def getC(): Char = {
		return array(loc).asInstanceOf[Char]
	}
	
	def getI(): Int = {
		return array(loc)
	}
	
	def put() {
		val input = readChar()
		if (input.isDigit)
			array(loc) = input.asInstanceOf[Int]
		else
			array(loc) = input.asInstanceOf[Char]
	}
	
	def copyUp() {
		val hold : Int = array(loc)
		up()
		array(loc) = hold
		down()
	}
	
	def copyDown() {
		val hold : Int = array(loc)
		down()
		array(loc) = hold
		up()
	}
	
	def dump(): String = {
		var retr : String = "["
		for (i <- 0 until array.length) {
			if (i < array.length-1)
				retr += array(i) + ", "
			else
				retr += array(i) + "]"
		}
		return retr + "\n"
	}
	
	def toggleout() {
		cout = !cout
	}
}