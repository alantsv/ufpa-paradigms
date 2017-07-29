public class Main extends Expressao {
  public static void main( String args[] ) { 
    int[] i = {0}; int[] i1 = {0}; int[] o1 = {0}; String [] V1 = {""}; 
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
    i[0] = 0; i1[0] = 0; o1[0] = 0; int [] V3 = {0};
    le_fita("(5+2)*2/2@"); pe[0] = 0; 
    if ( ES( V3, i, i1 ) && tok( "@", i1, o1 ) ) { 
      System.out.println("Expression: "+s.substring(0, s.length()-1) +" Result: "+V3[0]); 
    } 
    else { 
      System.out.println("Erro na posicao: "+(pe[0]+1)); 
    }
    i[0] = 0; i1[0] = 0; o1[0] = 0; String [] V4 = {""};
    le_fita("(1+2)/2@"); pe[0] = 0; 
    if ( PS(V4, i, i1 )) { 
      System.out.println("Expression: "+s.substring(0, s.length()-1) +"\nResult:\n"+V4[0]); 
    } 
    else { 
      System.out.println("Erro na posicao: "+(pe[0]+1)); 
    } 
  } 
} 

