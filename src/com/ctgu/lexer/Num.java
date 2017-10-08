package com.ctgu.lexer;

/*
 * 类型为整型数字的词法单元
 */

public class Num extends Token{
	public final int value;
	public Num(int v) {
		super(Tag.NUM);
		value = v;
	}
	public String toString() {
		return ""+value;
	}
}
