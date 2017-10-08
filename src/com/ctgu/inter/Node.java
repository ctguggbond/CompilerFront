package com.ctgu.inter;

import com.ctgu.lexer.Lexer;

/*
 * 中间代码生成基类，语句类Stmt,表达式Expr继承这个类
 */
public class Node {
	int lexline = 0;
	Node(){
		lexline = Lexer.line;
	}
	void error(String s) {
		throw new Error("near line "+ lexline + ":" +s);
	}
	static int labels = 0;
	public int newlabel() {
		return ++labels;
	}
	public void emitlabel(int i) {
		System.out.print("L" + i + ":");
	}
	public void emit(String s) {
		System.out.println("\t" + s);
	}
}
