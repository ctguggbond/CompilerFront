package com.ctgu.inter;

import com.ctgu.lexer.Word;
import com.ctgu.symbols.Type;

/*
 * 标识符类
 * 表达式代表终结符
 */

public class Id extends Expr {
	public int offset; //相对地址
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
