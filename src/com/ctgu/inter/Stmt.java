package com.ctgu.inter;

/*
 * 语句结点，所有语句中间代码生成的基类
 */

public class Stmt extends Node{
	public Stmt() {
		
	}
	public static Stmt Null = new Stmt(); //表示空语句序列
	
	public void gen(int b,int a) {   //b,a 分别代表语句开始时的标号和语句下一条指令的标号
				
	}
	int after = 0;		//用于保存语句下一条指令的标号
	public static Stmt Enclosing = Stmt.Null; //用于break语句
}
