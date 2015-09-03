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
        
        int x, y, k;
        char Torre, Bispo;
        
        Torre = 'T';
        Bispo = 'B';
        k = 0;
        
        for (int i = 0; i < 2; i++){
            x = rn.nextInt(8);
            y = rn.nextInt(8);
            System.out.println(x + " " + y);
            chessboard[x][y] = Torre;
            if (i == 1) {
                k=1;
                minimatrixtorre[k][0] = x;
                minimatrixtorre[k][k] = y;
            }
            else{
                minimatrixtorre[0][k] = x;
                minimatrixtorre[0][k+1] = y;
            }
        }
        
        k = 0;
        for (int i = 0; i < 2; i++){
            x = rn.nextInt(8);
            y = rn.nextInt(8);
            System.out.println(x + " " + y);
            chessboard[x][y] = Bispo;
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
        
        
        
        System.out.println("");
        System.out.println("Matriz Final");
        int n=8;
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
        int hl=2;
        for (int i=0; i < hl; i++) {
            for(int j=0; j<hl; j++){
                System.out.print(minimatrixbispo[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
        