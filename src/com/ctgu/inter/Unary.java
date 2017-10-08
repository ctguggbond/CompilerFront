package com.ctgu.inter;

import com.ctgu.lexer.Token;
import com.ctgu.symbols.Type;

//处理单目运算符

public class Unary extends Op {
	public Expr expr;
	
	public Unary(Token tok, Expr x) {
		super(tok,null);
		expr = x;
		type = Type.max(Type.Int,expr.type);
		if(type == null)
			error("type error");
	}
	public Expr gen() {
		return new Unary(op,expr.reduce());
	}
	public String toString() {
		return op.toString() + " " + expr.toString();
	}
}
