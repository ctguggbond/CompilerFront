package com.ctgu.inter;

import com.ctgu.lexer.Word;
import com.ctgu.symbols.Type;

/*
 * ��ʶ����
 * ���ʽ�����ս��
 */

public class Id extends Expr {
	public int offset; //��Ե�ַ
	public Id(Word id,Type p,int b) {
		super(id,p);
		offset = b;
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return ((Word)op).lexeme;
//	}
}
