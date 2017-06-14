%% Exemplo 3: sensível ao contexto

s --> a(N),b(M),c(N),d(M).
    %(M1 is M, write('M':M1),nl,		%% Ação semântica
     %N1 is N, write('N':N1)).
a(N+1)-->[a],a(N).
a(    1)-->[a].
b(N+1)-->[b],b(N).
b(    1)-->[b].
c(N+1)-->[c],c(N).
c(    1)-->[c].
d(N+1)-->[d],d(N).
d(    1)-->[d].

/*
?- listing([s, a, b]).
s(A, G) :-
	a(C, A, B),
	b(E, B, D),
	c(C, D, F),
	d(E, F, G).

a(A+1, [a|B], C) :- a(A, B, C).
a(1, [a|A], A).

b(A+1, [b|B], C) :- b(A, B, C).
b(1, [b|A], A).

?- s([a,b,c,d],X). 
    X=[], Yes

?- s([a,b,b,c,d,d],[]). 
    Yes

?- s([a,b,a],[]). 
    NO
?- a(X, [a,a,a,a,a,a],[]).
X = 1+1+1+1+1+1

?- a(X, [a,a,a,a,a,a],[]), Xr is X.
X = 1+1+1+1+1+1,
Xr = 6

?- s([a,b,b,c,d,d], []).

*/

s1 --> {X=[1,1+1,1+1+1],member(N,X),member(M,X)}, 
       a(N),b(M),c(N),d(M).

/*
?- s(X,[]).
X = [a, b, c, d] ;
X = [a, b, b, c, d, d] ;
X = [a, b, b, b, c, d, d, d] ;
X = [a, a, b, c, c, d] ;
X = [a, a, b, b, c, c, d, d] ;
X = [a, a, b, b, b, c, c, d, d|...] ;
...
*/

/*
1.  Modifique a gramática para calcular os valores de M e N. X=[1,2,...]. 
      com N is N1+1

2.  Se adicionarmos um parâmetros em R (regular), 
     teremos 
    r --> a(N), b(N)             que igual a L:  

    l-->[a],l,[b]|[]   que é livre de contexto. 
   
   O que aconteceu ?
*/
