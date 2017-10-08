package com.ctgu.inter;

import com.ctgu.lexer.Token;
import com.ctgu.symbols.Type;

//������Ļ���

public class Op extends Expr {
	public Op(Token tok,Type p) {
		super(tok,p);
	}
	public Expr reduce() {
		Expr x = gen();
		Temp t = new Temp(type);
		emit(t.toString() + " = " + x.toString());
		return t;
	}
}
