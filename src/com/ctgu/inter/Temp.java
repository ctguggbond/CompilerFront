package com.ctgu.inter;

import com.ctgu.lexer.Word;
import com.ctgu.symbols.Type;

//临时变量类，在化简三地址表达式时，使用临时变量 

public class Temp extends Expr {
	static int count = 0;
	int number = 0;
	public Temp(Type p) {
		super(Word.temp,p);
		number = ++count;
	}
	public String toString() {
		return "t" + number;
	}
}
