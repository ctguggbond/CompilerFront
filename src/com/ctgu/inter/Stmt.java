package com.ctgu.inter;

/*
 * ����㣬��������м�������ɵĻ���
 */

public class Stmt extends Node{
	public Stmt() {
		
	}
	public static Stmt Null = new Stmt(); //��ʾ���������
	
	public void gen(int b,int a) {   //b,a �ֱ������俪ʼʱ�ı�ź������һ��ָ��ı��
				
	}
	int after = 0;		//���ڱ��������һ��ָ��ı��
	public static Stmt Enclosing = Stmt.Null; //����break���
}
