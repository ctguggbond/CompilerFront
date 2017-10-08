package com.ctgu.symbols;

import com.ctgu.lexer.*;

public class Type extends Word {

   public int width = 0;          // 表示类型的存储容量

   public Type(String s, int tag, int w) { 
	   super(s, tag); 
	   width = w; 
	  }

   public static final Type
      Int   = new Type( "int",   Tag.BASIC, 4 ),
      Float = new Type( "float", Tag.BASIC, 8 ),
      Char  = new Type( "char",  Tag.BASIC, 1 ),
      Bool  = new Type( "bool",  Tag.BASIC, 1 );

   public static boolean numeric(Type p) {
      if (p == Type.Char || p == Type.Int || p == Type.Float) 
    	  return true;
      else 
    	  return false;
   }

   //max用于类型转换，当p1,p2都是int float 或者char 时可以像大的类型转换
   public static Type max(Type p1, Type p2 ) {
      if ( ! numeric(p1) || ! numeric(p2) ) 
    	  return null;
      else if ( p1 == Type.Float || p2 == Type.Float ) 
    	  return Type.Float;
      else if ( p1 == Type.Int   || p2 == Type.Int   ) 
    	  return Type.Int;
      else 
    	  return Type.Char;
   }
}
