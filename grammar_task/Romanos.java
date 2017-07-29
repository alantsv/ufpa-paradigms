//*****************************************
public class Romanos extends Primitivas { 
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
}
