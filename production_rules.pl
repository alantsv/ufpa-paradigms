%% Exemplo 1: regras DCG em Prolog

r --> a,b. 
a --> [a],a.
a --> [].
b --> [b],b.
b --> [].


/*
?- listing([r,a,b]).
r(A, C) :-	a(A, B), b(B, C).
a([a|A], B) :-	a(A, B).
a(A, A).
b([b|A], B) :-	b(A, B).
b(A, A).

válidas: {a,b,aa,bb,ab,aab,abb,...}
não válidas {ba,aba,...}

?- r([a,b,b],X). 
     X=[], Yes

?- r([a,b,a],[]). 
     NO

?- r([a,b,a],X).
      X=[a]   Yes    
*/

%% Exemplo 2: livre de contexto

l --> [a],l,[b].
l --> [].

/*
?- listing(l).
l([a|A], C) :- l(A, B),	B=[b|C].
l(A, A).

?- l([a,b],X). 
    X=[], Yes
?- l([a,a,a,a,b,b,b],[]). 
    No
?- l([a,b,a],[]). 
    No

Compare L com R ? 
*/

%% Podemos colocar várias grámaticas no mesmo arquivo, a não seu que eles tenham os mesmos não-terminais.
