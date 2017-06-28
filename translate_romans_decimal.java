class Primitivas { 
  public static String s; 
  public static void le_fita(String fita){ s = fita; } 
  public static int[] pe = { 0 } ; 
  public static boolean tok( String c, int[] i, int[] o ) { // c:in, i:in,o:out 
	  o[0] = i[0] + 1; 
	  if ( pe[0] < i[0]) { pe = o; } 
	  return( s.substring( i[0], i[0] + 1 ).equals( c ) ); 
	} 
  public static boolean attr(String[] v, String exp) { 
	  v[0] = exp; 
	  return (true); 
	} 

  public static boolean attr(int[] v,int exp) { 
	v[0] = exp; return(true); 
	}
} 

//*****************************************
class Romanos extends Primitivas { 
  public static boolean RS( String[] V, int[] i, int[] o ) { 
  return (ddd(V, i, o) 
    || dd(V, i, o) 
    || d(V, i, o)); 
  }
  public static boolean d(String[] V, int[] i, int[] o) { 
    return (tok("0", i, o) && attr(V, "") 
        || tok("1", i, o) && attr(V, "I") 
	      || tok("2", i, o) && attr(V, "II") 
	      || tok("3", i, o) && attr(V, "III")
	      || tok("4", i, o) && attr(V, "IV")
	      || tok("5", i, o) && attr(V, "V")
	      || tok("6", i, o) && attr(V, "VI")
	      || tok("7", i, o) && attr(V, "VII")
	      || tok("8", i, o) && attr(V, "VIII")
	      || tok("9", i, o) && attr(V, "IX")); 
  }
  public static boolean dd(String[] V, int[] i, int[] o) { 
    int[] i1 = {0}; 
    String[] D = {""}; 
    return (tok("0", i, i1) && d(D,i1, o) && attr(V, "" + D[0])
	      || tok("1", i, i1) && d(D, i1, o) && attr(V, "X" + D[0]) 
	      || tok("2", i, i1) && d(D, i1, o) && attr(V, "XX" + D[0]) 
	      || tok("3", i, i1) && d(D, i1, o) && attr(V, "XXX" + D[0]) 
	      || tok("4", i, i1) && d(D, i1, o) && attr(V, "XL" + D[0])
	      || tok("5", i, i1) && d(D, i1, o) && attr(V, "L" + D[0])
	      || tok("6", i, i1) && d(D, i1, o) && attr(V, "LX" + D[0])
	      || tok("7", i, i1) && d(D, i1, o) && attr(V, "LXX" + D[0])
        || tok("8", i, i1) && d(D, i1, o) && attr(V, "LXXX" + D[0]) 
        || tok("9", i, i1) && d(D, i1, o) && attr(V, "XC" + D[0]));
  }
  public static boolean ddd(String[] V, int[] i, int[] o) { 
    int[] i1 = {0}; 
    String[] D = {""}; 
    return (tok("0", i, i1) && dd(D,i1, o) && attr(V, "" + D[0])
	      || tok("1", i, i1) && dd(D, i1, o) && attr(V, "C" + D[0]) 
	      || tok("2", i, i1) && dd(D, i1, o) && attr(V, "CC" + D[0]) 
	      || tok("3", i, i1) && dd(D, i1, o) && attr(V, "CCC" + D[0]) 
	      || tok("4", i, i1) && dd(D, i1, o) && attr(V, "CD" + D[0])
	      || tok("5", i, i1) && dd(D, i1, o) && attr(V, "D" + D[0])
	      || tok("6", i, i1) && dd(D, i1, o) && attr(V, "DC" + D[0])
	      || tok("7", i, i1) && dd(D, i1, o) && attr(V, "DCC" + D[0])
        || tok("8", i, i1) && dd(D, i1, o) && attr(V, "DCCC" + D[0]) 
        || tok("9", i, i1) && dd(D, i1, o) && attr(V, "CM" + D[0]));
  }
  public static boolean DS( int [] V, int [] i, int [] o ){ 
    int [] N = {0}; int [] i1 = {0}; int [] N1 = {0};
  return (d(N, i, i1) && DS(N1, i1, o) && attr(V, N[0] + N1[0])
        || attr (o, i[0]) && attr(V, 0));
  }
  public static boolean d(int [] V, int [] i, int [] o){
    int [] i1 = {0};
    return (tok("C", i, o) && attr(V, 100)
          || tok("X", i, i1) && tok ("C", i1, o) && attr(V, 90)
          || tok("L", i, o) && attr(V, 50)
          || tok("X", i, i1) && tok ("L", i1, o) && attr(V, 40)
          || tok("X", i, o) && attr(V, 10)
          || tok("I", i, i1) && tok ("X", i1, o) && attr(V, 9)
          || tok("I", i, i1) && tok ("V", i1, o) && attr(V, 4)
          || tok("V", i, o) && attr(V, 5)
          || tok("I", i, o) && attr(V, 1)
      );
  }
  // public static void write(){
  //     if (RS( V1, i, i1 ) && tok( "@", i1, o1 )) { 
  //     System.out.println("Decimal: "+s.substring(0, s.length()-1) +" Romano: "+V1[0]); 
  //   } 
  //   else { 
  //     System.out.println("Erro na posicao: "+(pe[0]+1)); 
  //   } 
  // }
}

public class Main extends Romanos {
  public static void main( String args[] ) { 
    int[] i = {0}; int[] i1 = {0}; int[] o1 = {0}; String[] V1 = {""}; 
    le_fita("397@"); pe[0] = 0; 
    if (RS( V1, i, i1 ) && tok( "@", i1, o1 )) { 
      System.out.println("Decimal: "+s.substring(0, s.length()-1) +" Romano: "+V1[0]); 
    } 
    else { 
      System.out.println("Erro na posicao: "+(pe[0]+1)); 
    } 
    i[0] = 0; i1[0] = 0; o1[0] = 0; int [] V2 = {0}; 
    le_fita("IV@"); pe[0] = 0; 
    if ( DS( V2, i, i1 ) && tok( "@", i1, o1 ) ) { 
      System.out.println("Romano: "+s.substring(0, s.length()-1) +" Decimal: "+V2[0]); 
    } 
    else { 
      System.out.println("Erro na posicao: "+(pe[0]+1)); 
    } 
  } 
} 
