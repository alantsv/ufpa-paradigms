def list(x,xs = []): 
  return [x] + xs

def head(xxs): 
  x, *xs = xxs
  return x
  
def tail(xxs):
  x,*xs = xxs
  return xs
  
def empty(xs): 
  return xs == []
  
def wlist(xs):
  if empty(xs): 
    print('\n')
    return None
  else: 
    print(head(xs), end=" ")
    wlist(tail(xs))
    
def length(xs):
  if empty(xs): 
   return 0
  else: 
   return(1 + length(tail(xs)));
     
def sum(xs):
  if empty(tail(xs)): 
    return head(xs)
  else: 
    return head(xs) + sum(tail(xs));
     
def append(xs,ys):
  if empty(xs): 
    return ys
  if empty(ys):
    return xs
  else: 
    return list(head(xs), append(tail(xs), ys))

def max(xs):
  if empty(tail(xs)): 
    return head(xs)
  if max(tail(xs)) > head(xs):
    return max(tail(xs))
  return head(xs)
			  
def max_acc(xs, acc = None):
  if empty(xs): 
    return acc
  if head(xs) > acc: 
    return max_acc(tail(xs), head(xs))
  return max_acc(tail(xs), acc)
			  		  
def reverse(xs):
  if empty(xs): 
    return xs
  return append(reverse(tail(xs)),list(head(xs),[]))

def reverse_acc(xs, acc = []):
  if empty(xs): 
    return acc
  return reverse_acc(tail(xs), list(head(xs), acc))
  
def partition(xs):
  if empty(xs): 
    return [], []
  if empty(tail(xs)): 
    return list(head(xs),[]), []
  ys, ws = partition(tail(tail(xs)))
  return list(head(xs), ys), list(head(tail(xs)), ws)
  
def member(x, xs):
  if empty(xs):
    return False
  if x == head(xs):
    return True
  return member(x, tail(xs))
  
def select(x, xs):
  if empty(xs):
    return xs
  if x == head(xs):
    return tail(xs)
  return list(head(xs), select(x, tail(xs)))

def merge(xs, ys):
  if (empty(xs)):
    return ys
  if (empty(ys)):
    return xs
  if head(xs) <= head(ys):
    return list(head(xs), merge(tail(xs), ys))
  return list(head(ys), merge(xs, tail(ys)))

def msort(xs):
  if empty(tail(xs)):
    return xs
  ws, ys = partition(xs)
  return merge(msort(ws), msort(ys))

def last(xs):
  if empty(tail(xs)):
    return head(xs)
  return last(tail(xs))

def duplicated(xs):
  if empty(xs):
    return False
  if member(head(xs), tail(xs)):
    return True
  return duplicated(tail(xs))

def nth(i, xs):
  if i == 0:
    return head(xs)
  return nth(i - 1, tail(xs))
  
def drop_index(i, xs):
  if i == 0:
    return tail(xs)
  return list(head(xs), drop_index(i - 1, tail(xs)))
  
def contiguos(xs):
  if empty(tail(xs)):
    return False
  if (head(xs) == head(tail(xs))):
    return True
  return contiguos(tail(xs))
  
def init(xs):
  if empty(tail(xs)):
    return tail(xs)
  return list(head(xs), init(tail(xs)))
  
def equal(xs, ys):
  if empty(xs) and empty(ys):
    return True
  if head(xs) == head(ys):
    return equal(tail(xs), tail(ys))
  return False
  
def palindrome(xs):
  if empty(tail(xs)):
    return True
  if head(xs) == last(xs):
    return palindrome(init(tail(xs)))
  return False

def remove_dupl(xs):
  if empty(tail(xs)):
    return xs
  if member(head(xs), tail(xs)):
    return remove_dupl(tail(xs))
  return list(head(xs), remove_dupl(tail(xs)))
  
def isOrd(xs):
  if empty(tail(xs)):
    return True
  if head(xs) < head(tail(xs)):
    return isOrd(tail(xs))
  return False

def insert_in_order(x, xs):
  if empty(xs):
    return list(x)
  if x <= head(xs):
    return list(x, xs)
  return list(head(xs), insert_in_order(x, tail(xs)))
  
def index(x, xs, i = 0):
  if x == head(xs):
    return i
  return index(x, tail(xs), i + 1)

L1 = ['a','b','c','d']
L2 = [1, 2, 3, 4, 0, 8, 1, 2]   

print('L1 is:'); wlist(L1)
print('L2 is :'); wlist(L2)
print('L1 length is:', length(L1))
print('L1 length is: ', sum(L2))
print('Appending L1 and L2:', append(L1, L2))
print('The higher element of L2 is:', max(L2))
print('Is c member of L2?:', member('c', L2))
print('Is c member of L1?:', member('c', L1))
print('L2 with 2 selected:', select(2, L2))
print("L1 last element is ", last(L1));
print("Are there duplicated elements is L1? ", duplicated(L1))
print("The second element of L1 is ", nth(1, L1))
print("L1 without the 2nd element is: ", drop_index(1, L1))
print("Are there any contiguos elements is L1? ", contiguos(L1))
print("L1 without the last element is ", init(L1))
print("Are L1 and L2 equal? ", equal(L1, L2))
print("Are L1 and L1 equal? ", equal(L1, L1))

print();
L1 = [1, 2, 1]
L2 = [1, 5, 6, 7]
L2 = [1, 2, 3, 4, 0, 8, 1, 2]
L3 = [1, 2, 3, 4, 0, 8, 1, 2, 10]
L4 = [1, 2, 7, 11]
L5 = [1, 3, 5, 12]

print('L1 is:'); wlist(L1)
print('L2 is:'); wlist(L2)
print("Is L1 a palindrome? ", palindrome(L1));
print("Is L2 a palindrome? ", palindrome(L2));
print("L2 without duplicated elements is ", remove_dupl(L2));
print("Is L1 ordened? ", isOrd(L1));
print("Inserting 4 into the ordered list L5 is ", insert_in_order(4, L5));
print("What is the index of 3 in L1? ", index(3, L2));

print();
print('L2 is:'); wlist(L2)
print('L3 is:'); wlist(L3)
print('L4 is:'); wlist(L4)
print('L5 is:'); wlist(L5)
print('L3 reversed without accumulator:', reverse(L3))
print('L2 reversed with accumulator', reverse_acc(L2))
print('The higher element of L2 using accumulator:', max(L2))
print('L2 partitioned:', partition(L2))
print('L3 partitioned:', partition(L3))
print('L4 and L5 merged:', merge(L4, L5))
print('L3 sorted for Merge Sort', msort(L3))
print('L2 sorted for Merge Sort', msort(L2))
