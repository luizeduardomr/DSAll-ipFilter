import java.util.LinkedList;

public class ArvoreBinaria {

    public No raiz;
    public static LinkedList<No> listona = new LinkedList<>();
    public static LinkedList<No> listaFinal = new LinkedList<>();

    public void emordem(No no) { //prefixado
        if (no == null) {
            return;
        }
        emordem(no.esquerda);
        emordem(no.direita);
        if (no.pai != null) {
            compare(no, no.pai);
        }
    }

    public void compare(No r1, No r2) {
        No nodo = new No();

        if (r1.minVal < r2.minVal && r1.maxVal > r2.minVal && r1.maxVal < r2.maxVal) {
            r2.minVal = r1.minVal;
            nodo.maxVal = r2.maxVal;
            nodo.minVal = r1.minVal;
            listona.add(nodo);
        }
        else if (r1.minVal > r2.minVal && r1.minVal < r2.maxVal && r1.maxVal < r2.maxVal && r1.maxVal > r2.minVal) {
            nodo.maxVal=r2.maxVal;
            nodo.minVal=r2.minVal;
        }
        else if (r1.minVal > r2.minVal && r1.minVal < r2.maxVal && r1.maxVal > r2.maxVal && r1.maxVal > r2.minVal) {
            r2.maxVal = r1.maxVal;
            nodo.maxVal = r1.maxVal;
            nodo.minVal = r2.minVal;
            listona.add(nodo);

        }
        else if (r1.minVal < r2.minVal && r1.maxVal > r2.maxVal)  {
            r2.minVal = r1.minVal;
            r2.maxVal = r1.maxVal;
            nodo.maxVal = r1.maxVal;
            nodo.minVal = r1.minVal;
            listona.add(nodo);
        }
        else if(r1.minVal > r2.minVal && r1.minVal > r2.maxVal && r1.maxVal > r2.maxVal){
            nodo.maxVal = r1.maxVal;
            nodo.minVal = r1.minVal;
            listona.add(nodo);
        }

    }

    public static LinkedList<No> verifica() {
        if (listaFinal.isEmpty()) {
            listaFinal.add(listona.get(0));
        }
        for (int x = 0; x <= listaFinal.size() - 1; x++) {
            for (int y = 1; y <= listona.size() - 1; y++) {
                boolean addItem = false;
                int fMin = listaFinal.get(x).minVal;
                int fMax = listaFinal.get(x).maxVal;
                int lMin = listona.get(y).minVal;
                int lMax = listona.get(y).maxVal;

                if(lMax >= fMax && fMin <= lMin && lMin > fMax ){
                    //lmax = lMax;
                    listaFinal.add(listona.get(y));
                    x++;
                }
                else if(fMin > lMin && lMax > fMax){
                    listaFinal.get(x).minVal = lMin;
                }
                else if(lMax != fMax && lMax > fMax){
                    fMax = lMax;
                    listaFinal.get(x).maxVal = fMax;
                }
                else if(fMin <= lMin && lMin >= fMax){
                    System.out.println("oi");    //caso enunciado 8
                }
                else if(fMin < lMin && fMax < lMax){
                    fMin = lMin;
                    fMax = lMax;
                    listaFinal.get(x).minVal = fMin;
                    listaFinal.get(x).maxVal = fMax;
                }
                else if(fMin < lMin && fMin < lMax && fMax < lMin && fMax < lMax){
                    listaFinal.add(listona.get(y));
                    x++;
                }


            }
        }
        return listaFinal;
    }

    public No insere(int chave, int chaveD) {

        if (raiz == null) {
            raiz = new No();
            raiz.minVal = chave;
            raiz.maxVal = chaveD;
            return raiz;
        }

        No atual = raiz;
        return inserir(chave, chaveD, atual);
    }

    private No inserir(int minVal, int maxVal, No atual) {
        if  (minVal <= atual.minVal || maxVal < atual.maxVal) {
            if (atual.esquerda == null) {
                No filho = new No();
                filho.minVal = minVal;
                filho.maxVal = maxVal;
                filho.pai = atual;
                atual.esquerda = filho;
                return filho;
            } else {
                return inserir(minVal, maxVal, atual.esquerda);
            }

        } else if (minVal >= atual.minVal || maxVal > atual.maxVal) {
            if (atual.direita == null) {
                No filho = new No();
                filho.minVal = minVal;
                filho.maxVal = maxVal;
                filho.pai = atual;
                atual.direita = filho;
                return filho;
            } else {
                return inserir(minVal, maxVal, atual.direita);
            }
        }

        return null;
    }
}


//if (listaFinal.get(x).maxVal > listona.get(y).minVal) {
//        //continue;
//        }
//        if (listaFinal.get(x).minVal > listona.get(y).minVal && listona.get(y).maxVal < listaFinal.get(x).minVal && listona.get(y).maxVal < listaFinal.get(x).maxVal) {
//        listaFinal.get(x).minVal = listona.get(y).minVal;
//        }
//        if (listaFinal.get(x).minVal < listona.get(y).minVal && listona.get(y).minVal > listaFinal.get(x).maxVal && listona.get(y).maxVal < listaFinal.get(x).maxVal && listaFinal.get(x).maxVal > listona.get(y).maxVal) {
//        //continue;
//        }
//        if (listaFinal.get(x).minVal > listona.get(y).minVal && listona.get(y).minVal < listaFinal.get(x).minVal && listona.get(y).maxVal < listaFinal.get(x).maxVal && listaFinal.get(x).maxVal > listona.get(y).minVal) {
//        listaFinal.get(x).maxVal = listona.get(y).maxVal;
//        }
//        if (listona.get(y).minVal < listaFinal.get(x).maxVal) {
//        listaFinal.add(listona.get(y));
//        }

