package com.ctgu.inter;

import com.ctgu.lexer.Token;

// !运算的出口标号跳转

public class Not extends Logical{
	public Not(Token tok,Expr x2) {
		super(tok,x2,x2);
	}
	public void jumping(int t, int f) {
		expr2.jumping(f, t);
	}
	public String toString() {
		return op.toString() + " " + expr2.toString();
	}
}
