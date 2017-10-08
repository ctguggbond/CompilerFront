package com.ctgu.inter;

import com.ctgu.lexer.Token;
import com.ctgu.symbols.Type;

public class Expr extends Node {
	public Token op;  //词法单元
	public Type type;  //类型
 
	Expr(Token tok,Type p){
		op = tok;
		type = p;
	}
 //放回一个三地址指令的右部
 //终结符的此节点对象就是一个地址，直接返回this， 否则自行重载此方法
	public Expr gen() {
		return this;
	}
	
	//计算表达式，返回常量，标识符 或者临时名字
	public Expr reduce() {
		return this;
	}
	
	
	//t 为表达式true的出口标号  f为false的出口标号
	public void jumping(int t,int f) {
		emitjumps(toString(),t,f);
	}
	public void emitjumps(String test,int t,int f) {
		if(t != 0 && f != 0) {
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		}
		else if(t != 0) {
			emit("if " + test + " goto L" + t);
		}else if(f != 0){
			emit("iffalse " + test + " got L"+ f);
		}else {
			
		}
	}
	public String toString() {
		return op.toString();
	}
}
