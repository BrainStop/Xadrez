Fa�a o programa P05Xadrez que, no contexto de um tabuleiro de xadrez, posicione de forma aleat�ria duas torres e dois bispos,
mas de forma a n�o haver ataques entre as pe�as. Assim para cada pe�a guarde as suas coordenadas x e y e compare se h� ataque
com as pe�as j� processadas. Em caso de ataque deve gerar novas coordenadas e voltar a testar, at� n�o haver qualquer ataque.
No final deve-se mostrar o tabuleiro em que cada torre � visualizada com um �T�e cada bispo com um �B�, cada posi��o que n�o
sofra qualquer ataque deve conter um �o�, cada posi��o com um s� ataque deve conter um �-� e cada posi��o com pelo menos dois
ataques deve conter um �+�. Para controlar os ataques deve utilizar um array bidimensional de 8 por 8 de char.
O programa dever� gerar e mostrar uma nova configura��o v�lida quando, e sempre que, se premir a tecla de Enter.
