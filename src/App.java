import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static   int inteiroX = 0;
    private static   int inteiroY = 0;

    private static ArvoreBinaria arvore = new ArvoreBinaria();

    public static void main(String[] args) throws IOException {
        leitura();
        arvore.emordem(arvore.raiz);
        ArvoreBinaria.verifica();
        for(int i = 0; i < ArvoreBinaria.listaFinal.size(); i++){
            System.out.println(ArvoreBinaria.listaFinal.get(i).minVal + " " + ArvoreBinaria.listaFinal.get(i).maxVal);
        }
    }
    public static void leitura() throws IOException {

        FileInputStream stream = new FileInputStream("D:\\cohen\\casoenunciado.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();

        while(linha != null) {
            String[] splitted= linha.split("-");
            String x = splitted[0];
            String y = splitted[1];

            int resultX = Integer.parseInt(x);
            int resultY = Integer.parseInt(y);

            arvore.insere(resultX,resultY);

            linha = br.readLine();
        }
    }

}



