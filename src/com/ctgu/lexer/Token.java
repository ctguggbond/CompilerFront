package com.ctgu.lexer;

/*
 * �ʷ���Ԫ�Ļ��࣬tag����Ϊ����ʷ���Ԫ������ 
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
