package andre;

import java.io.IOException;
import java.util.Scanner;

public class JogoDaVida {
    static Scanner s = new Scanner(System.in);
    static int N;
    public static void main(String[] args) throws Exception {
        
        System.out.println("Digite um número referente a quantidade de ciclos no jogo");
        System.out.print("->");
        int ciclos = Math.abs(s.nextInt());
        System.out.println("Digite apenas uma vez um número, ela será utilizada para linhas E colunas");
        System.out.print("->");
        N = Math.abs(s.nextInt());
        int cont = 0;
        int[][] matriz = new int[N+2][N+2];
        int[][] nova = new int[N+2][N+2];

        int contVivos = 0;
        input(N, matriz);

        for (int i = 0; i <N+2; i++) {
            for(int j = 0; j<N+2; j++){
                if(i==0||j==0||i==N+1||j==N+1){
                    matriz[i][j] = 0;
                    nova[i][j] = 0;
                    continue;    
                }
                nova[i][j] = 0;
            }
        }

        while(ciclos!=cont){
            for (int i = 1; i < N+1; i++) {
                for(int j = 1; j < N+1; j++){
                    //linha anterior
                    if(matriz[i-1][j-1]==1)
                        contVivos++;
                    if(matriz[i-1][j]==1)
                        contVivos++;
                    if(matriz[i-1][j+1]==1)
                        contVivos++;
                        
                    //linha atual
                    if(matriz[i][j-1]==1)
                        contVivos++;
                    if(matriz[i][j+1]==1)
                        contVivos++;

                    //linha posterior
                    if(matriz[i+1][j-1]==1)
                        contVivos++;
                    if(matriz[i+1][j]==1)
                        contVivos++;
                    if(matriz[i+1][j+1]==1)
                        contVivos++;
                    

                    //aplicando regras do jogo
                    if(contVivos==3)
                        nova[i][j] = 1;
                    else if(contVivos>3)
                        nova[i][j] = 0;
                    else if(contVivos<2)
                        nova[i][j] = 0;
                    else if(contVivos==2)
                        nova[i][j] = matriz[i][j];
                    
                    contVivos = 0;
                }            
            }

            for(int i=0;i<N+2;i++){
                for(int j=0; j<N+2;j++){
                    matriz[i][j] = nova[i][j];
                }
            }
            System.out.println();
            System.out.println("Gen " +(cont+1));
            for (int i = 1; i < N+1; i++) {
                for(int j = 1; j < N+1; j++){
                    System.out.print(matriz[i][j] +" ");
                }
                System.out.println();
            }
            Thread.sleep(1000);
            cont++;
        }

    }

    private static void input(int q, int[][] matriz){
        String[] in = new String[q];
        for(int i=0;i<in.length;i++){
            try{limparConsole();}catch(Exception e){}
            mostraMatriz(in);
            in[i] = inputPadronizado();
        }
        try{limparConsole();}catch(Exception e){}
        mostraMatriz(in);
        
        
            for(int i=0;i<q;i++){
                for(int j=0; j<q;j++)
                    matriz[i+1][j+1] = Integer.parseInt(in[i].charAt(j) +"");
            }
        
    }

    private static String inputPadronizado() {
        System.out.print("->");
        String string = s.next();
        int j = 0;
        while(true){
            if(j==string.length()&&string.length()!=0){
                break;
            }
            if(string.length()==N && (string.charAt(j)=='0'||string.charAt(j)=='1')){
                j++;
                continue;
            }else{
                System.out.println("Entrada diferente do padrão. Insira outra entrada");
                System.out.print("->");
                string = s.next();
                j=0;
                continue;
            }
        }
        return string;
    }

    private static void mostraMatriz(String[] s){
        System.out.println("Matriz atual:");
        for(int i=0;i<s.length;i++)
            System.out.println(s[i]);
    }

    private static void limparConsole() throws InterruptedException, IOException{
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }
}
