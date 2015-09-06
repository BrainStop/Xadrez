import java.util.Random;

public class Xadrez {
    public static void main (String args[]) {
        Random rn = new Random();
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
        
        int x, y, k, n, dstx, dsty;
        char Torre, Bispo, Reset;
        boolean assignment, clean;
        
        Torre = 'T';
        Bispo = 'B';
        Reset = 'o';
        k = 0;
        n = 8;
        assignment = true;
        clean = true;
        
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
        }
        while (assignment) {
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
    }
}
        