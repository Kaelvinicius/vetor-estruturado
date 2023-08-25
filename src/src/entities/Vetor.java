package entities;

public class Vetor {
    private String elementos[];
    int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        tamanho = 0;
    }

    /*
    public void adiciona(String elemento){
        for(int i = 0; i < this.elementos.length; i++){
            if(elementos[i] == null){
                elementos[i] = elemento;
                break;
            }
        }
    }
    */

    public void adiciona(String elemento) throws Exception {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Vetor está totalmente cheio, não é possivel adicionar mais elementos");
        }
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]");
        return s.toString();
    }

    public String busca(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        return elementos[posicao];
    }

    public int busca_posicao(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void adiciona_elemento(int posicao, String elemento){
        if (!(posicao >= 0 && posicao <= tamanho)) {
            throw new IllegalArgumentException("Posição invalida");
        }

        this.aumentaCapacidade();

        for(int i = this.tamanho - 1; i>= posicao; i--){
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
    }

    public void aumentaCapacidade(){
        if(this.tamanho == this.elementos.length){
            String [] novosElementos = new String[this.elementos.length * 2];
            for(int i = 0; i<elementos.length; i++){
                novosElementos[i] = elementos[i];
            }
            this.elementos = novosElementos;
        }
    }

    // posicao 2 = elemento 3
    // elemntos[2] = elementos[3] = elemento 3


    public void remove(int posicao) throws Exception{
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int  i = posicao; i < tamanho - 1; i++){
            this.elementos[i] = elementos[i+1];
        }
        this.tamanho--;
    }
}
