package com.ctgu.lexer;

/*
 * 字符类型的词法单元，包括关键字 标识符 ...等词素
 * 也可以表示一些运算符 如：单目运算符-1  中间表示为 <minus , 2>
 */
public class Word extends Token{
	public String lexeme = ""; //词法单元的词素

	public Word(String s, int tag) {
		super(tag);
		lexeme = s;
	}
	
	//保留字
	public static final Word
	and = new Word("&&", Tag.AND), 	or = new Word("||", Tag.OR),
	eq = new Word("==", Tag.EQ),	ne = new Word("!=", Tag.NE),
	le = new Word("<=", Tag.LE),	ge = new Word(">=", Tag.GE),
	
	minus = new Word("minus", Tag.MINUS),
	True = new Word("true", Tag.TRUE),
	False = new Word("false", Tag.FALSE),
	temp = new Word("t", Tag.TEMP);	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return lexeme;
	}

}
