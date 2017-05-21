#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct List
{
	int head;
	struct List * tail;
} List;

void writeln(char str [], int value)
{
    printf("%s %d\n", str, value);
}

void write(char str [])
{
    printf("%s ", str);
}

void ln()
{
    printf("\n");
}

List * list(int x, List * xs)
{
 	List * head = malloc(sizeof(List));
 	head->head = x;
 	head->tail = xs;
	return head;
}

int head(List *xs)
{
    return xs->head;
}

List * tail(List *xs)
{
    return xs->tail;
}

int empty(List *xs)
{
    if (xs == NULL)
        return 1;
    return 0;
}

int length(List *xs)
{
    if(empty(xs))
        return 0;
    return (1 + length(tail(xs)));
}

int sum(List *xs)
{
    if(empty(xs))
        return 0;
    return (head(xs) + sum(tail(xs)));
}

void write_list(List *xs)
{
    if (empty(xs))
    {
        printf("\n");
        return;
    }
    printf("%d ", head(xs));
    write_list(tail(xs));
}

int last(List *xs)
{
    if (empty(tail(xs)))
        return head(xs);
    return last(tail(xs));
}

int member(int x, List *xs)
{
    if(empty(xs))
        return 0;
    else if(x == head(xs))
        return 1;
    return member(x, tail(xs));
}

int duplicated(List *xs)
{
    if (empty(xs))
        return 0;
    else if (member(head(xs), tail(xs)))
        return 1;
    return duplicated(tail(xs));
}

List * append(List *xs, List *ys)
{
    if(empty(xs))
        return ys;
    return list(head(xs), append(tail(xs), ys));
}

List * reverse(List *xs)
{
    if(empty(xs))
        return xs;
    return append(reverse(tail(xs)), list(head(xs), NULL));

}

List * reverse_acc_aux(List *xs, List *acc)
{
    if (empty(xs))
        return acc;
    return reverse_acc_aux(tail(xs), list(head(xs), acc));
}

List * reverse_acc(List *xs)
{
    return reverse_acc_aux(xs, NULL);
}

int max(List *xs)
{
    int max_value = head(xs);
    if (empty(tail(xs)))
        return max_value;
    else if (max_value > max(tail(xs)))
        return max_value;
    return max(tail(xs));
}

List * select_list(int x, List *xs)
{
    if (empty(xs))
        return xs;
    else if (x == head(xs))
        return tail(xs);
    return list(head(xs), select_list(x, tail(xs)));
}

int contiguos(List *xs)
{
    if (empty(tail(xs)))
        return 0;
    if (head(xs) == head(tail(xs)))
        return 1;
    return contiguos(tail(xs));
}

List * drop (int i, List * xs)
{
    if (i == 0)
        return xs;
    return drop(i - 1, tail(xs));
}

List * drop_index(int x, List *xs)
{
    if (empty(xs))
        return xs;
    else if (x == 0)
        return tail(xs);
    return list(head(xs), drop_index(x - 1, tail(xs)));
}

int equal(List *xs, List *ys)
{
    if (empty(xs) && empty(ys))
        return 1;
    if (head(xs) != head(ys))
        return 0;
    return equal(tail(xs), tail(ys));
}

int palindrome(List * xs)
{
    if (empty(xs) || empty(tail(xs)))
        return 1;
    if (head(xs) != last(xs))
        return 0;
    return palindrome(drop_index(length(xs) - 1, tail(xs)));

}

int palindrome_reverse(List *xs)
{
    return equal(xs, reverse(xs));
}

List * remove_duplicated(List * xs)
{
    if (empty(xs))
        return xs;
    if (member(head(xs), tail(xs)))
        return remove_duplicated(tail(xs));
    return list(head(xs), remove_duplicated(tail(xs)));
}

List * push_sort(int x, List *xs)
{
    if (empty(xs))
        return list(x, NULL);
    if (x < head(xs))
        return list(x, xs);
    return list(head(xs), push_sort(x, tail(xs)));
}

int nth (int x, List *xs)
{
    if(x == 0)
        return head(xs);
    return nth(x - 1, tail(xs));
}

List * merge(List *xs, List *ys)
{
    if (empty(xs))
        return ys;
    if (empty(ys))
        return xs;
    if (head(xs) <= head(ys))
        return list(head(xs), merge(tail(xs), ys));
    return list(head(ys), merge(xs, tail(ys)));
}

List * take(int len, List *xs)
{
    if (len == 0)
        return NULL;
    return list(head(xs), take(len - 1, tail(xs)));
}

List * merge_sort_aux(List *xs, int len)
{
    if (len == 1)
        return xs;

    int half = len / 2;
    // int half = floor(len / 2);
    return merge(merge_sort_aux(take(half, xs), half),
                    merge_sort_aux(drop(half, xs), len - half)
                );
}

List * merge_sort(List *xs)
{
    return merge_sort_aux(xs, length(xs));
}

int main()
{
    List * L1 = list(1, list(2, list(3, NULL)));
    List * L2 = list(5, list(6, list(7, NULL)));

    write("The first list is:");
    write_list(L1);
    writeln("The length of first list is:", length(L1));
    writeln("Duplicated in L1:", duplicated(L1));
    writeln("The last element in L1 list:", last(L1));
    write("The L1 list reversed:");
    write_list(reverse(L1));
    write("The second list is:");
    write_list(L2);
    write("The L1 list reversed with accumulator:");
    write_list(reverse_acc(L1));
    writeln("The max element of L1 list:", max(L1));
    writeln("Are the element 2 in L1 list?", member(2, L1));
    write("The L1 list without element 2:");
    write_list(select_list(2, L1));
    writeln("Are contiguos elements in L1 list?", contiguos(L1));
    write("The L1 list without the last element:");
    write_list(drop_index(length(L1) - 1, L1));

    L1 = list(1, list(2, list(1, NULL)));
    L2 = list(1, list(5, list(6, list(7, NULL))));

    writeln("Is L1 list palindrome?", palindrome_reverse(L1));
    writeln("Is L2 list palindrome?", palindrome_reverse(L2));
    writeln("Are L1 and L1 equal?", equal(L1, L1));
    writeln("Are L1 and L2 equal?", equal(L1, L2));

    List * L4 = list(4, list(6, list(3, list(4, list(2, list(6, list(4, NULL)))))));

    write("L4 list without duplicated:");
    write_list(remove_duplicated(L4));
    write("L2 list with element 4 inserted in ordened");
    write_list(push_sort(4, L2));
    writeln("The third element in L1 list is:", nth(2, L1));

    L1 = list(1, list(2, list(11, NULL)));

    write("Merge of L1 and L2 is:");
    write_list(merge(L1, L2));

    L4 = list(4, list(6, list(3, list(4, list(2, list(6, list(4, NULL)))))));

    write("L4 list sorted with Merge Sort:");
    write_list(merge_sort(L4));

    return 0;
}
