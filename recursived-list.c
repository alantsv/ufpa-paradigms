#include <stdio.h>
#include <stdlib.h>

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
    write("The L1 list reversed with accumulator:");
    write_list(reverse_acc(L1));
    writeln("The max element of L1 list:", max(L1));
    writeln("Are the element 2 in L1 list?", member(2, L1));


    return 0;
}
