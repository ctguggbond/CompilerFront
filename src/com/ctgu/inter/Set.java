package com.ctgu.inter;

import com.ctgu.symbols.Type;

/*
 * 左部为标识符，右边为表达式的复制语句  id = expr;
 */

public class Set extends Stmt{
	public Id id;
	public Expr expr;
	public Set(Id i,Expr x) {
		id = i;
		expr = x;
		if(check(id.type,expr.type) == null)
			error("type error");
	}
	public Type check(Type p1, Type p2) {
		if(Type.numeric(p1) && Type.numeric(p2))
			return p2;
		else if(p1 == Type.Bool && p2 == Type.Bool)
			return p2;
		else
			return null;
	}
	public void gen(int b, int a) {
		emit(id.toString() + " = " + expr.gen().toString());
	}
}
