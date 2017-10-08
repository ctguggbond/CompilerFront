package com.ctgu.main;

import java.io.IOException;

import com.ctgu.lexer.Lexer;
import com.ctgu.parser.Parser;

public class Main {
	public static void main(String[] args) throws IOException {
		Lexer lex = new Lexer();
		Parser parse  = new Parser(lex);
		parse.program();
		System.out.println('\n');
	}
}
