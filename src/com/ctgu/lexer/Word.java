package com.ctgu.lexer;

/*
 * �ַ����͵Ĵʷ���Ԫ�������ؼ��� ��ʶ�� ...�ȴ���
 * Ҳ���Ա�ʾһЩ����� �磺��Ŀ�����-1  �м��ʾΪ <minus , 2>
 */
public class Word extends Token{
	public String lexeme = ""; //�ʷ���Ԫ�Ĵ���

	public Word(String s, int tag) {
		super(tag);
		lexeme = s;
	}
	
	//������
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
