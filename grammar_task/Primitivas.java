public class Primitivas { 
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

