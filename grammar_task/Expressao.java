public class Expressao extends Romanos {
  // Expressão
  public static boolean ES( int [] V, int [] i, int [] o ){ 
  return expr(V, i, o);
  }
  public static boolean expr(int [] V, int [] i, int [] o){
    int [] i1 = {0};
    int [] i2 = {0};
    int [] V2 = {0};
    return (termo(V, i, i1) && tok("+", i1, i2) && expr(V2, i2, o) && attr(V, V[0] + V2[0])
          || termo(V, i, i1) && tok ("-", i1, i2) && expr(V, i2, o) && attr(V, V[0] + V2[0])
          || termo(V, i, o)
      );
  }
  public static boolean termo(int [] V, int [] i, int [] o){
    int [] i1 = {0};
    int [] i2 = {0};
    int [] V2 = {0};
    return (fator(V, i, i1) && tok("*", i1, i2) && termo(V2, i2, o) && attr(V, V[0] * V2[0])
          || fator(V, i, i1) && tok ("/", i1, i2) && fator(V2, i2, o) && attr(V, V[0] / V2[0])
          || fator(V, i, o)
      );
  }
  public static boolean isNumeric(String s) {  
    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
  }  
  public static boolean fator(int [] V, int [] i, int [] o){
    int [] i1 = {0};
    int [] i2 = {0};
    String Char = Character.toString(s.charAt(i[0]));
    return (tok(Char, i, o) && isNumeric(Char) && attr(V, Integer.parseInt(Char))
          || tok("(", i, i1) && expr(V, i1, i2) && tok(")", i2, o)
      );
  }
  // Expressão Polonesa
  public static boolean PS( String [] V, int [] i, int [] o ){ 
    return expr(V, i, o);
  }
  public static boolean expr(String [] V, int [] i, int [] o){
    int [] i1 = {0};
    return (termo(V, i, i1) && rexpr(V, i1, o)
          || termo (V, i, o)
    );
  }
  public static boolean rexpr(String [] V, int [] i, int [] o){
    int [] i1 = {0};
    String [] V1 = {""};
    return (tok("+", i, i1) && expr(V1, i1, o) && attr(V, V[0] + V1[0] + "some\n")
          || tok("-", i, i1) && expr(V1, i1, o) && attr(V, V[0] + V1[0] + "subt\n")
          || tok("@", i, o) && attr(V, V[0] + "")
      );
  }
  public static boolean termo(String [] V, int [] i, int [] o){
    int [] i1 = {0};
    return ( fator(V, i, i1) && rtermo(V, i1, o)
          || fator(V, i, o)
      );
  }
  public static boolean rtermo(String [] V, int [] i, int [] o){
  int [] i1 = {0};
  String [] V1 = {""};
    return (tok("*", i, i1) && termo(V1, i1, o) && attr(V, V[0] + V1[0] + "mult\n")
          || tok("/", i, i1) && termo(V1, i1, o) && attr(V, V[0] + V1[0] + "div\n")
          //|| tok("@", i, o) && attr(V, V[0] + "")
      );
  }
  public static boolean fator(String [] V, int [] i, int [] o){
    int [] i1 = {0};
    int [] i2 = {0};
    String Char = Character.toString(s.charAt(i[0]));
    return (tok(Char, i, o) && isNumeric(Char) && attr(V, Char + " enter\n")
          || tok("(", i, i1) && expr(V, i1, i2) && tok(")", i2, o)
      );
  }
}
