package com.ctgu.inter;

import com.ctgu.lexer.Word;
import com.ctgu.symbols.Type;

//��ʱ�����࣬�ڻ�������ַ���ʽʱ��ʹ����ʱ���� 

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
