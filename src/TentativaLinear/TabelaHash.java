
package TentativaLinear;

import java.util.Scanner;

public class TabelaHash {
    
    private int tamanho;
    private Hash tabela[];
    private Scanner entrada;

    public TabelaHash(int tamanhoTabela) {
        this.tamanho = tamanhoTabela;
        tabela = new Hash[tamanho];
        entrada = new Scanner(System.in);
    }
    
    
    
}
