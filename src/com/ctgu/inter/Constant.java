package com.ctgu.inter;

import com.ctgu.lexer.Num;
import com.ctgu.lexer.Token;
import com.ctgu.lexer.Word;
import com.ctgu.symbols.Type;

/*
 * 表达式叶子结点 True False 标号跳转
 */
public class Constant extends Expr {
	public Constant(Token tok, Type p) {
		super(tok,p);
	}
	
	/*
	 * 用于创建常量结点
	 */
	public Constant(int i) {
		super(new Num(i),Type.Int);
	}
	public static final Constant
		True = new Constant(Word.True,Type.Bool),
		False = new Constant(Word.False,Type.Bool);
	public void jumping(int t,int f) {
		if(this == True && t != 0) {
			emit("goto L" + t);
		}else if(this == False && f != 0) {
			emit("goto L" + f);
		}
	}
}
