package com.ctgu.lexer;

import java.io.IOException;
import java.util.Hashtable;
/*
 * 词法分析类
 */

import org.omg.Messaging.SyncScopeHelper;

import com.ctgu.symbols.Type;



/*	词法分析 将字符流转换成词法单元
 * 
 * 
 * 注意分号的位置也是巧妙
 * 
 * 文法定义:
 *           program ->  block
 *           block   -> {decls stmts}
 *           decls	-> decls decl | null
 *           decl	-> type id;
 *           type	-> type[num]  | basic
 *           stmts	-> stmts stmt | null
 * 
 *	单条语句：
 *		     stmt -> loc = bool；  赋值语句
 *            		|   if (bool)  stmt
 *            		|   if (bool) stmt else stmt   
 * 					|   while(bool) stmt
 *					|   do stmt while(bool);
 *					|	break ;
 *					|	block		
 *			  loc -> loc[bool] | id
 *
 *表达式：
 *			  bool	-> bool || join | join
 *			  join 	-> join && equality | equality
 *			  equality-> equality == rel | equality != rel | rel
 *			  rel	-> expr < expr | expr <= expr | expr >= expr | expr > expr | expr
 *			  expr	-> expr + term | expr - term | term
 *			  term	-> term * unary| term / unary | unary
 *			  unary	-> !unary | -unary | factor
 *			  factor	-> (bool) | loc | num | real | true | false
 */



public class Lexer {
	public static int line = 1;
	char peek = ' ';
	Hashtable words = new Hashtable(); //符号表
	
	void reserve(Word w) {
		words.put(w.lexeme, w);
	}
	
	//构造函数先将关键字放入
	public Lexer() {
		reserve(new Word("if", Tag.IF));
		reserve(new Word("else", Tag.ELSE));
		reserve(new Word("while", Tag.WHILE));
		reserve(new Word("do", Tag.DO));
		reserve(new Word("break", Tag.BREAK));
		reserve(Word.True);
		reserve(Word.False);
		reserve(Type.Int);
		reserve(Type.Char);
		reserve(Type.Bool);
		reserve(Type.Float);
	}
	
	public void readch() throws IOException{
		peek = (char) System.in.read();
	}
	public boolean readch(char c) throws IOException{
		readch();
		if(peek != c)
			return false;
		peek = ' ';
		return true;
	}
	public Token scan() throws IOException{
		for(;;readch()) {
			if(peek == ' ' || peek == '\t') 
				continue;
			else if(peek == '\r') {   //windows 换行符是\r\n   linux是\n
				line = line + 1;
				System.in.read();
			}
			else
				break;
		}

		switch (peek) {
		case '&':
			if(readch('&')) return Word.and;
			else return new Token('&');
		case '|':
			if(readch('|'))	return Word.or;
			else return new Token('|');
		case '=':
			if(readch('='))	return Word.eq;
			else return new Token('=');
		case '!':
			if(readch('='))	return Word.ne;
			else return new Token('!');
		case '<':
			if(readch('='))	return Word.le;
			else return new Token('<');
		case '>':
			if(readch('='))	return Word.ge;
			else return new Token('>');
		}
		if(Character.isDigit(peek)) {
			int v = 0;
			do {
				v = 10*v + Character.digit(peek, 10);
				readch();
			}while(Character.isDigit(peek));
			if(peek != '.')
				return new Num(v);
			float x = v ;
			float d = 10;
			for(;;) {
				readch();
				if(! Character.isDigit(peek))
					break;
				x = x + Character.digit(peek, 10) / d; 
				d = d * 10;
			}
			return new Real(x);
		}
		
		if(Character.isLetter(peek)) {
			StringBuffer b = new StringBuffer();
			do {
				b.append(peek);
				readch();
			}while(Character.isLetterOrDigit(peek));
			String s = b.toString();
			Word w = (Word) words.get(s);
			if(w != null)
				return w;
			w = new Word(s,Tag.ID);
			words.put(s, w);
			return w;
		}
		
		Token tok = new Token(peek);
		peek = ' ';
		return tok;                
	}
}
	