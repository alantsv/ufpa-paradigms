%% decimal p extenso e vice versa
%% ?- dx(EXT,[1,2,3],[]).

dx(X)-->dddd(X);ddd(X);dd(X);d(X).
d([zero])-->[0].
d([um])-->[1].
d([dois])-->[2].
d([tres])-->[3].
d([quatro])-->[4].
d([cinco])-->[5].
d([seis])-->[6].
d([sete])-->[7].
d([oito])-->[8].
d([nove])-->[9].

dd([dez])-->[1,0].
dd([onze])-->[1,1].
dd([doze])-->[1,2].
dd([treze])-->[1,3].
dd([quartoze])-->[1,4].
dd([quinze])-->[1,5].
dd([dezesseis])-->[1,6].
dd([dezessete])-->[1,7].
dd([dezeito])-->[1,8].
dd([dezenove])-->[1,9].

dd([vinte])-->[2,0].
dd([vinte,e|D])-->[2],d(D).
dd([trinta])-->[3,0].
dd([trinta,e|D] )-->[3],d(D).
dd([quarenta])-->[4,0].
dd([quarenta,e|D] )-->[4],d(D).
dd([cinquenta])-->[5,0].
dd([cinquenta,e|D] )-->[5],d(D).
dd([sessenta])-->[6,0].
dd([sessenta,e|D] )-->[6],d(D).
dd([setenta])-->[7,0].
dd([setenta,e|D] )-->[7],d(D).
dd([oitenta])-->[8,0].
dd([oitenta,e|D] )-->[8],d(D).
dd([noventa])-->[9,0].
dd([noventa,e|D] )-->[9],d(D).

ddd([cem])-->[1,0,0].
ddd([cento,e|D])-->[1,0],d(D).
ddd([cento,e|DD])-->[1],dd(DD).

ddd([duzentos])-->[2,0,0].
ddd([duzentos,e|D])-->[2,0],d(D).
ddd([duzentos,e|DD])-->[2],dd(DD).

ddd([trezentos])-->[3,0,0].
ddd([trezentos,e|D])-->[3,0],d(D).
ddd([trezentos,e|DD])-->[3],dd(DD).

ddd([quatrocentos])-->[4,0,0].
ddd([quatrocentos,e|D])-->[4,0],d(D).
ddd([quatrocentos,e|DD])-->[4],dd(DD).

ddd([quinhetos])-->[5,0,0].
ddd([quinhetos,e|D])-->[5,0],d(D).
ddd([quinhetos,e|DD])-->[5],dd(DD).

ddd([seiscentos])-->[6,0,0].
ddd([seiscentos,e|D])-->[6,0],d(D).
ddd([seiscentos,e|DD])-->[6],dd(DD).

ddd([setecentos])-->[7,0,0].
ddd([setecentos,e|D])-->[7,0],d(D).
ddd([setecentos,e|DD])-->[7],dd(DD).

ddd([oitocentos])-->[8,0,0].
ddd([oitocentos,e|D])-->[8,0],d(D).
ddd([oitocentos,e|DD])-->[8],dd(DD).

ddd([novecentos])-->[9,0,0].
ddd([novecentos,e|D])-->[9,0],d(D).
ddd([novecentos,e|DD])-->[9],dd(DD).

dddd([mil])-->[1,0,0,0].
dddd([mil, e|D])-->[1,0,0],d(D).
dddd([mil, e|DD])-->[1,0],dd(DD).
dddd([mil|DDD])-->[1],ddd(DDD).

dddd([D,mil])-->d([D]),[0,0,0].
dddd([X, mil, e|D])-->d([X]),[0,0],d(D).
dddd([X, mil, e|DD])-->d([X]),[0],dd(DD).
dddd([X, mil|DDD])-->d([X]),ddd(DDD).

%
