%% Exemplo 5: converter binários para decimais

s -->n.
n -->bs,['.'],bs.
n -->bs.
bs-->b,bs.
bs-->b.
b -->[0].
b -->[1].

/*
?-n([1,0,'.',1,0],L). 
  L=[] Yes. 
*/
