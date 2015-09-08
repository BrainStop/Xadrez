import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Xadrez {
    public static void main (String args[]) {
        Random rn = new Random();
        Scanner in = new Scanner(System.in);
        
        char [][] chessboard = {
            {'o','o','o','o','o','o','o','o'},
            {'o','o','o','o','o','o','o','o'},
            {'o','o','o','o','o','o','o','o'},
            {'o','o','o','o','o','o','o','o'},
            {'o','o','o','o','o','o','o','o'},
            {'o','o','o','o','o','o','o','o'},
            {'o','o','o','o','o','o','o','o'},
            {'o','o','o','o','o','o','o','o'},
        };
        int [][] minimatrixtorre = new int[2][2];
        int [][] minimatrixbispo = new int[2][2];
        ArrayList<String> CoorTorre1 = new ArrayList<>();
        ArrayList<String> CoorTorre2 = new ArrayList<>();
        ArrayList<String> CoorBispo1 = new ArrayList<>();
        ArrayList<String> CoorBispo2 = new ArrayList<>();
        ArrayList<String> CoorIguais = new ArrayList<>();
        ArrayList<String> auxil = new ArrayList<>();
        
        int x, y, k, n, dstx, dsty;
        char Torre, Bispo, Reset, Ataque1, Ataque2;
        boolean assignment, clean;
        String End;
        
        Torre = 'T';
        Bispo = 'B';
        Reset = 'o';
        Ataque1 = '-';
        Ataque2 = '+';
        n = 8;
        assignment = true;
        clean = true;
        End = "";
        
        while (!End.equals("fim")) {
            
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++){
                    chessboard[i][j] = Reset;
                }
            }
            for (int i=0; i<2; i++){
                for (int j = 0; j < 2; j++){
                    minimatrixbispo[i][j] = 0;
                    minimatrixtorre[i][j] = 0;
                }
            }
            k = 0;
            for (int i = 0; i < 2; i++){
                x = rn.nextInt(8);
                y = rn.nextInt(8);
                System.out.println(x + " " + y);
                chessboard[y][x] = Torre;
                if (i == 1) {
                    k=1;
                    minimatrixtorre[k][0] = x;
                    minimatrixtorre[k][k] = y;
                }
                else{
                    minimatrixtorre[0][0] = x;
                    minimatrixtorre[0][k+1] = y;
                }
            }
            k = 0;
            for (int i = 0; i < 2; i++){
                x = rn.nextInt(8);
                y = rn.nextInt(8);
                System.out.println(x + " " + y);
                chessboard[y][x] = Bispo;
                if (i == 1) {
                    k=1;
                    minimatrixbispo[k][0] = x;
                    minimatrixbispo[k][k] = y;
                }
                else{
                    minimatrixbispo[0][k] = x;
                    minimatrixbispo[0][k+1] = y;
                }
                assignment = true;
                clean = true;
            }
            while (assignment) {
                //Esta zona serve para limpar a matriz e tornar a colocar os valores na matriz para não ficar com 3 B's ou 3 T's
                if (clean == false) {
                    clean = true;
                    for (int i = 0; i < n; i++) {
                        for(int j = 0; j < n; j++){
                            chessboard[i][j] = Reset;
                        }
                    }
                    for (int i = 0; i < 2; i++) {
                        if (i==1){
                            x = minimatrixtorre[i][0];
                            y = minimatrixtorre[i][i];
                            chessboard[y][x] = Torre;
                        }
                        else {
                            x = minimatrixtorre[0][0];
                            y = minimatrixtorre[0][i+1];
                            chessboard[y][x] = Torre;
                        }  
                    }
                    for (int i = 0; i < 2; i++) {
                        if (i==1){
                            x = minimatrixbispo[i][0];
                            y = minimatrixbispo[i][i];
                            chessboard[y][x] = Bispo;
                        }
                        else {
                            x = minimatrixbispo[0][0];
                            y = minimatrixbispo[0][i+1];
                            chessboard[y][x] = Bispo;
                        }  
                    }
                }
                //Aqui verifica se as peças estão com obstruções e se no caso de haver obstruções muda fazendo random
                if (minimatrixtorre[0][0]==minimatrixtorre[1][0] || minimatrixtorre[0][1] == minimatrixtorre[1][1]) {
                    x = minimatrixtorre[1][0];
                    y = minimatrixtorre[1][1];
                    chessboard[y][x] = Reset;
                    x = rn.nextInt(8);
                    y = rn.nextInt(8);
                    minimatrixtorre[1][0] = x;
                    minimatrixtorre[1][1] = y;
                    chessboard[y][x] = Torre;
                    clean = false;
                    assignment = true;
                }
                else if (minimatrixbispo[0][0]==minimatrixbispo[1][0] && minimatrixbispo[0][1] == minimatrixbispo[1][1]) {
                    x = minimatrixbispo[1][0];
                    y = minimatrixbispo[1][1];
                    chessboard[y][x] = Reset;
                    x = rn.nextInt(8);
                    y = rn.nextInt(8);
                    minimatrixbispo[1][0] = x;
                    minimatrixbispo[1][1] = y;
                    chessboard[y][x] = Bispo;
                    clean = false;
                    assignment = true;
                }
                else if (minimatrixbispo[0][0]==minimatrixtorre[0][0] || minimatrixbispo[0][1]==minimatrixtorre[0][1] || minimatrixbispo[0][0]==minimatrixtorre[1][0] || minimatrixbispo[0][1]==minimatrixtorre[1][1]) {
                    x = minimatrixbispo[0][0];
                    y = minimatrixbispo[0][1];
                    chessboard[y][x] = Reset;
                    x = rn.nextInt(8);
                    y = rn.nextInt(8);
                    minimatrixbispo[0][0] = x;
                    minimatrixbispo[0][1] = y;
                    chessboard[y][x] = Bispo;
                    clean = false;
                    assignment = true;
                } 
                else if (minimatrixbispo[1][0]==minimatrixtorre[0][0] || minimatrixbispo[1][1]==minimatrixtorre[0][1] || minimatrixbispo[1][0]==minimatrixtorre[1][0] || minimatrixbispo[1][1]==minimatrixtorre[1][1]) {
                    x = minimatrixbispo[1][0];
                    y = minimatrixbispo[1][1];
                    chessboard[y][x] = Reset;
                    x = rn.nextInt(8);
                    y = rn.nextInt(8);
                    minimatrixbispo[1][0] = x;
                    minimatrixbispo[1][1] = y;
                    chessboard[y][x] = Bispo;
                    clean = false;
                    assignment = true;
                }
                else {
                    x = minimatrixbispo[0][0];
                    y = minimatrixbispo[0][1];
                    dstx = minimatrixbispo[1][0];
                    dsty = minimatrixbispo[1][1];
                    if ( (Math.abs(x - dstx))==(Math.abs(y - dsty))) {
                        x = minimatrixbispo[0][0];
                        y = minimatrixbispo[0][1];
                        chessboard[y][x] = Reset;
                        x = rn.nextInt(8);
                        y = rn.nextInt(8);
                        minimatrixbispo[0][0] = x;
                        minimatrixbispo[0][1] = y;
                        chessboard[y][x] = Bispo;
                        clean = false;
                        assignment = true;
                    }
                    else {
                        x = minimatrixbispo[0][0];
                        y = minimatrixbispo[0][1];
                        dstx = minimatrixtorre[0][0];
                        dsty = minimatrixtorre[0][1];
                        if ( (Math.abs(x - dstx))==(Math.abs(y - dsty))) {
                            x = minimatrixbispo[0][0];
                            y = minimatrixbispo[0][1];
                            chessboard[y][x] = Reset;
                            x = rn.nextInt(8);
                            y = rn.nextInt(8);
                            minimatrixbispo[0][0] = x;
                            minimatrixbispo[0][1] = y;
                            chessboard[y][x] = Bispo;
                            clean = false;
                            assignment = true;
                        }
                        else {
                            x = minimatrixbispo[0][0];
                            y = minimatrixbispo[0][1];
                            dstx = minimatrixtorre[1][0];
                            dsty = minimatrixtorre[1][1];
                            if ( (Math.abs(x - dstx))==(Math.abs(y - dsty))) {
                                x = minimatrixbispo[0][0];
                                y = minimatrixbispo[0][1];
                                chessboard[y][x] = Reset;
                                x = rn.nextInt(8);
                                y = rn.nextInt(8);
                                minimatrixbispo[0][0] = x;
                                minimatrixbispo[0][1] = y;
                                chessboard[y][x] = Bispo;
                                clean = false;
                                assignment = true;
                            }
                            else {
                                x = minimatrixbispo[1][0];
                                y = minimatrixbispo[1][1];
                                dstx = minimatrixtorre[0][0];
                                dsty = minimatrixtorre[0][1];
                                if ( (Math.abs(x - dstx))==(Math.abs(y - dsty))) {
                                    x = minimatrixbispo[1][0];
                                    y = minimatrixbispo[1][1];
                                    chessboard[y][x] = Reset;
                                    x = rn.nextInt(8);
                                    y = rn.nextInt(8);
                                    minimatrixbispo[1][0] = x;
                                    minimatrixbispo[1][1] = y;
                                    chessboard[y][x] = Bispo;
                                    clean = false;
                                    assignment = true;
                                }
                                else {
                                    x = minimatrixbispo[1][0];
                                    y = minimatrixbispo[1][1];
                                    dstx = minimatrixtorre[1][0];
                                    dsty = minimatrixtorre[1][1];
                                    if ( (Math.abs(x - dstx))==(Math.abs(y - dsty))) {
                                        x = minimatrixbispo[1][0];
                                        y = minimatrixbispo[1][1];
                                        chessboard[y][x] = Reset;
                                        x = rn.nextInt(8);
                                        y = rn.nextInt(8);
                                        minimatrixbispo[1][0] = x;
                                        minimatrixbispo[1][1] = y;
                                        chessboard[y][x] = Bispo;
                                        clean = false;
                                        assignment = true;
                                    }
                                    else {
                                        assignment = false;
                                    }   
                                }    
                            }
                        }
                    }
                }   
            }
            
            //Aqui obtém todas as coordenadas possíveis para as Torres e os Bispos e adiciona-as em 4 ArrayList (CoorTorre1, CoorTorre2, CoorBispo1, CoorBispo2)
            for (int i=0; i<4; i++) {
                if (i == 0) {
                    x = minimatrixtorre[0][0];
                    y = minimatrixtorre[0][1];
                    for (int j=0; j<8; j++) {
                        for (int h=0; h<8; h++) {
                            if ( j == x || h == y) {
                                CoorTorre1.add(j + " " + h);
                                if (x == j && y == h){
                                    CoorTorre1.remove(x + " " + y);
                                }
                            }
                            else {
                            }
                        }
                    }
                }
                if (i == 1) {
                    x = minimatrixtorre[1][0];
                    y = minimatrixtorre[1][1];
                    for (int j=0; j<8; j++) {
                        for (int h=0; h<8; h++) {
                            if ( j == x || h == y) {
                                CoorTorre2.add(j + " " + h);
                                if (x == j && y == h){
                                    CoorTorre2.remove(x + " " + y);
                                }
                            }
                            else {
                            }
                        }
                    }
                }
                if (i==2) {
                    x = minimatrixbispo[0][0];
                    y = minimatrixbispo[0][1];
                    for (int j=0; j<8; j++) {
                        for (int h=0; h<8; h++) {
                            if (Math.abs(j - x) == Math.abs(h - y)) {
                                CoorBispo1.add(j + " " + h);
                                if (x == j && y == h){
                                    CoorBispo1.remove(x + " " + y);
                                }
                            }
                            else {
                            }
                        }
                    }
                }
                if (i==3) {
                    x = minimatrixbispo[1][0];
                    y = minimatrixbispo[1][1];
                    for (int j=0; j<8; j++) {
                        for (int h=0; h<8; h++) {
                            if (Math.abs(j - x)==Math.abs(h - y)) {
                                CoorBispo2.add(j + " " + h);
                                if (x == j && y == h){
                                    CoorBispo2.remove(x + " " + y);
                                }
                            }
                            else {
                            }
                        }
                    }
                }
            }
            //Aqui verifica as 4 ArrayList entre si e vê quais as coordenadas são iguais entre si, as coordenadas iguais vão para a ArrayList CoorIguais
            for (int i=0; i<6; i++) {
                if (i==0) {
                    for (int j=0; j<CoorTorre1.size(); j++) {
                        for (int h=0; h<CoorTorre2.size(); h++) {
                            if (CoorTorre1.get(j).equals(CoorTorre2.get(h))) {
                                CoorIguais.add(CoorTorre1.get(j));
                            }
                        }
                    }
                }
                if (i==1) {
                    for (int j=0; j<CoorTorre1.size(); j++) {
                        for (int h=0; h<CoorBispo1.size(); h++) {
                            if (CoorTorre1.get(j).equals(CoorBispo1.get(h))) {
                                CoorIguais.add(CoorTorre1.get(j));
                            }
                        }
                    }
                }
                if (i==2) {
                    for (int j=0; j<CoorTorre1.size(); j++) {
                        for (int h=0; h<CoorBispo2.size(); h++) {
                            if (CoorTorre1.get(j).equals(CoorBispo2.get(h))) {
                                CoorIguais.add(CoorTorre1.get(j));
                            }
                        }
                    }
                }
                if (i==3) {
                    for (int j=0; j<CoorTorre2.size(); j++) {
                        for (int h=0; h<CoorBispo1.size(); h++) {
                            if (CoorTorre2.get(j).equals(CoorBispo1.get(h))) {
                                CoorIguais.add(CoorTorre2.get(j));
                            }
                        }
                    }
                }
                if (i==4) {
                    for (int j=0; j<CoorTorre2.size(); j++) {
                        for (int h=0; h<CoorBispo2.size(); h++) {
                            if (CoorTorre2.get(j).equals(CoorBispo2.get(h))) {
                                CoorIguais.add(CoorTorre2.get(j));
                            }
                        }
                    }
                }
                if (i==5) {
                    for (int j=0; j<CoorBispo1.size(); j++) {
                        for (int h=0; h<CoorBispo2.size(); h++) {
                            if (CoorBispo1.get(j).equals(CoorBispo2.get(h))) {
                                CoorIguais.add(CoorBispo1.get(j));
                            }
                        }
                    }
                }
            }
            //Aqui coloca os + e os - na matriz principal
            
            //Work in progress
            for (int i=0; i<CoorIguais.size(); i++){
                String aux = CoorIguais.get(i);
                String[] split = aux.split(" ");
                x = Integer.parseInt(split[0]);
                y = Integer.parseInt(split[1]);
                chessboard[y][x] = Ataque1;
            }
            /*for (int i=0; i<CoorIguais.size(); i++){
                for(int j=0; j<CoorIguais.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    if(CoorBispo1.get(i).equals(CoorBispo2.get(j))) {
                        auxil.add(CoorBispo1.get(i));
                    }
                }
            }*/
            System.out.println(auxil);  
            /*for (int i=0; i<CoorIguais.size(); i++){
                for(int j=0; j<CoorIguais.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    if (!CoorIguais.get(i).equals(CoorIguais.get(j))) {
                        String aux = CoorIguais.get(i);
                        String[] split = aux.split(" ");
                        x = Integer.parseInt(split[0]);
                        y = Integer.parseInt(split[1]);
                        chessboard[y][x] = Ataque1;
                    }
                    if (CoorIguais.get(i).equals(CoorIguais.get(j))) {
                        String aux = CoorIguais.get(i);
                        String[] split = aux.split(" ");
                        x = Integer.parseInt(split[0]);
                        y = Integer.parseInt(split[1]);
                        chessboard[y][x] = Ataque2;
                    } 
                }
            }*/
            //Esta zona apresenta a matriz com as Torres e os Bispos colocados e com os + e os -
            System.out.println("");
            System.out.println(CoorTorre1);
            System.out.println("");
            System.out.println(CoorTorre2);
            System.out.println("");
            System.out.println(CoorIguais);
            System.out.println("");
            System.out.println("Matriz Final");
            for (int i=0; i < n; i++) {
                for(int j=0; j<n; j++){
                    System.out.print(chessboard[i][j] + " ");
                }
                System.out.print("\n");
            }
            System.out.println("");
            System.out.println("Mini-Matriz das Torres");
            int h=2;
            for (int i=0; i < h; i++) {
                for(int j=0; j<h; j++){
                    System.out.print(minimatrixtorre[i][j] + " ");
                }
                System.out.print("\n");
            }
            System.out.println("");
            System.out.println("Mini-Matriz dos Bispos");
            for (int i=0; i < h; i++) {
                for(int j=0; j<h; j++){
                    System.out.print(minimatrixbispo[i][j] + " ");
                }
                System.out.print("\n");
            }
            //Aqui faz uma preparação para a próxima execução limpando tudo para obter novos valores
            End = in.nextLine();
            End = End.toLowerCase();
            CoorBispo1.clear();
            CoorBispo2.clear();
            CoorTorre1.clear();
            CoorTorre2.clear();
            CoorIguais.clear();
        }
    }
}     