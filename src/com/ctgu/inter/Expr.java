package com.ctgu.inter;

import com.ctgu.lexer.Token;
import com.ctgu.symbols.Type;

public class Expr extends Node {
	public Token op;  //�ʷ���Ԫ
	public Type type;  //����
 
	Expr(Token tok,Type p){
		op = tok;
		type = p;
	}
 //�Ż�һ������ַָ����Ҳ�
 //�ս���Ĵ˽ڵ�������һ����ַ��ֱ�ӷ���this�� �����������ش˷���
	public Expr gen() {
		return this;
	}
	
	//������ʽ�����س�������ʶ�� ������ʱ����
	public Expr reduce() {
		return this;
	}
	
	
	//t Ϊ���ʽtrue�ĳ��ڱ��  fΪfalse�ĳ��ڱ��
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
