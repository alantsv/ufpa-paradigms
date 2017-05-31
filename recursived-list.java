class List {
  public int head;
  public List tail;
  
  public List(int h, List t) {
    head = h;
    tail = t;
  } 
}

public class Main {
  public static void main(String[] args) {
    
    List L1 = list(1, list(2, list(3, null)));
    List L2 = list(5, list(6, list(7, null)));
    
    write("L1 is ");write_list(L1);
    writeln("L1 length is " + length(L1));
    writeln("L1 sum is " + sum(L1));
    writeln("L1 last element is " + last(L1));
    writeln("Are there duplicated elements is L1? " + duplicated(L1));
    write("L1 reversed WITHOUT accumulator is ");write_list(reverse(L1));
    write("L2 is ");write_list(L2);
    write("Appending L2 to L1 is ");write_list(append(L1,L2));
    write("L1 reversed WITH accumulator is ");write_list(reverse_acc(L1));
    writeln("The higher element of L1 is " + max(L1));
    writeln("The second element of L1 is " + nth(1, L1));
    write("L1 without the 2nd element is ");write_list(drop_index(1, L1));
    writeln("Are there any contiguos elements is L1? " + contiguos(L1));
    writeln("L1 without the last element is ");write_list(init(L1));
    writeln("Are L1 and L2 equal? " + equal(L1, L2));
    
    L1 = list(1, list(2, list(1, null)));
    L2 = list(1, list(5, list(6, list(7, null))));
    
    writeln("Is L1 a palindrome? " + palindrome(L1));
    writeln("Is L2 a palindrome? " + palindrome(L2));
    writeln("Are L1 and L1 equal? " + equal(L1, L1));
    
    List L4 = list(4,list(6,list(3,list(4,list(2,list(6,list(4,null)))))));
    
    write("L4 without duplicated elements is ");write_list(remove_dupl(L4));
    writeln("Is L1 ordened? " + isOrd(L1));
    write("Inserting 4 into the ordered list L2 is ");write_list(insert_in_order(4, L2));
    writeln("What is the index of 3 in L1? " + index(3, L1));
    writeln("The third element of L1 is " + nth(2, L1));
    
    L1 = list(1, list(2, list(11, null)));
    	
    write("Merging the two ordered lists L1 and l2 is ");write_list(merge(L1, L2));
     
    L4 = list(4,list(6,list(3,list(4,list(2,list(6,list(4,null))))))); 
    
    write("Merge sorting of L4 is ");write_list(msort(L4));
  }
  
  static List list(int head, List tail) {
    return new List(head, tail);
  }
  
  static int head(List xs) {
    return xs.head;
  }
  
  static List tail(List xs) {
    return xs.tail;
  }
  
  static boolean empty(List xs) {
    return xs == null;
  }
  
  static int length(List xs) {
    if (empty(xs)) return 0;
    return 1 + length(tail(xs));
  }
  
  static int sum(List xs) {
    if (empty(xs))
      return 0;
    return head(xs) + sum(tail(xs));
  }

  static int last(List xs) {
    if (empty(tail(xs)))
      return head(xs);
    return last(tail(xs));
  }

  static boolean member(int x, List xs) {
    if (empty(xs))
      return false;
    if (x == head(xs))
      return true;
    return member(x , tail(xs));
  }

  static boolean duplicated(List xs) {
    if (empty(xs))
      return false;
    if (member(head(xs), tail(xs)))
      return true;
    return duplicated(tail(xs));
  }
  
  static List append(List xs, List ys) {
    if (empty(xs))
      return ys;
    if (empty(ys))
      return xs;
    return list(head(xs), append(tail(xs), ys));
  }
  
  static List reverse(List xs) {
    if (empty(xs))
      return xs;
    return append(reverse(tail(xs)), list(head(xs), null));
  }
  
  static List reverse_acc(List xs, List acc) {
    if (empty(xs))
      return acc;
    return reverse_acc(tail(xs), list(head(xs), acc));
  }
  
  static List reverse_acc(List xs) {
    return reverse_acc(xs, null);
  }
  
  static int max(List xs) {
    if (empty(tail(xs)))
      return head(xs);
    if (head(xs) > max(tail(xs)))
      return head(xs);
    return max(tail(xs));
  }
  
  static int nth(int i, List xs) {
    if (i == 0)
      return head(xs);
    return nth(i - 1, tail(xs));
  }
  
  static List drop_index(int i, List xs) {
    if (i == 0)
      return tail(xs);
    return list(head(xs), drop_index(i - 1, tail(xs)));
  }
  
  static boolean contiguos(List xs) {
    if (empty(tail(xs)))
      return false;
    if (head(xs) == head(tail(xs)))
      return true;
    return contiguos(tail(xs));
  }
  
  static List init(List xs) {
    if (empty(tail(xs)))
      return null;
    return list(head(xs), init(tail(xs)));
  }
  
  static boolean palindrome(List xs) {
    if (empty(tail(xs)))
      return true;
    if (head(xs) == last(xs))
      return palindrome(init(tail(xs)));
    return false;
  }
  
  static boolean equal(List xs, List ys) {
    if (empty(xs) && empty(ys))
      return true;
    if (head(xs) == head(ys))
      return equal(tail(xs), tail(ys));
    return false;
  }
  
  static List remove_dupl(List xs) {
    if (empty(tail(xs)))
      return xs;
    if (member(head(xs), tail(xs)))
      return remove_dupl(tail(xs));
    return list(head(xs), remove_dupl(tail(xs)));
  }
  
  static boolean isOrd(List xs) {
    if (empty(tail(xs)))
      return true;
    if (head(xs) <= head(tail(xs)))
      return isOrd(tail(xs));
    return false;
  }
  
  static List insert_in_order(int x, List xs) {
    if (empty(xs))
      return list(x, null);
    if (x < head(xs))
      return list(x, xs);
    return list(head(xs), insert_in_order(x, tail(xs)));
  }
  
  static int index (int x, List xs, int i) {
    if (empty(xs))
      return -1;
    if (x == head(xs))
      return i;
    return index(x, tail(xs), i + 1);
  }
  
  static int index(int x, List xs) {
    return index(x, xs, 0);
  }
  
  static List merge(List xs, List ys) {
    if (empty(xs))
      return ys;
    if (head(xs) < head(ys))
      return list (head(xs), merge(tail(xs), ys));
    if (head(ys) <= head(xs))
      return list (head(ys), merge(tail(ys), xs));
    return xs;
  }
  
  static List drop(int end, List xs) {
    if (empty(xs))
      return xs;
    if (end == 0)
      return xs;
    return drop(end - 1, tail(xs));
  }
  
  static List take(int i, List xs) {
    if (i == 0)
      return null;
    return list(head(xs), take(i - 1, tail(xs)));
  }
  
  static List msort(List xs, int len){
    if (len == 1)
      return xs;
    int half = len / 2;
    return merge(msort(take(half, xs)), msort(drop(half,xs)));
  }
  
  static List msort(List xs){
    return msort(xs, length(xs));
  }
  
  static void write_list(List xs) {
    if (empty(xs))
      write("\n");
    else {
      write(" " +head(xs) + " ");
      write_list(tail(xs));
    }
  }

  static void write(String str) {
    System.out.print(str);
  }
  
  static void writeln(String str) {
    write(str);
    write("\n");
  }
}
