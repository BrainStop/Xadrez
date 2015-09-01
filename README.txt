Faça o programa P05Xadrez que, no contexto de um tabuleiro de xadrez, posicione de forma aleatória duas torres e dois bispos,
mas de forma a não haver ataques entre as peças. Assim para cada peça guarde as suas coordenadas x e y e compare se há ataque
com as peças já processadas. Em caso de ataque deve gerar novas coordenadas e voltar a testar, até não haver qualquer ataque.
No final deve-se mostrar o tabuleiro em que cada torre é visualizada com um ‘T’e cada bispo com um ‘B’, cada posição que não
sofra qualquer ataque deve conter um ‘o’, cada posição com um só ataque deve conter um ‘-‘ e cada posição com pelo menos dois
ataques deve conter um ‘+’. Para controlar os ataques deve utilizar um array bidimensional de 8 por 8 de char.
O programa deverá gerar e mostrar uma nova configuração válida quando, e sempre que, se premir a tecla de Enter.
