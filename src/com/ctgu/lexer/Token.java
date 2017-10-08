package com.ctgu.lexer;

/*
 * 词法单元的基类，tag变量为这个词法单元的名字 
 */

public class Token {
	public final int tag;
	
	public Token(int t) {
		tag = t;
	}
	public String toString() {
		return ""+(char)tag;
	}
}
