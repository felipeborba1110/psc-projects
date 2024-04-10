import java.util.Scanner;

class Global {
    static int nElem = 0;
    static int[] LL = new int[12];
}

public class ListaLinearSimples {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcao = 0;
        while (opcao != 9) {
            System.out.println("-----Menu-----");
            System.out.println("1. Inserir");
            System.out.println("2. Buscar");
            System.out.println("3. Exibir");
            System.out.println("4. Excluir");
            System.out.println("5. Reset");
            System.out.println("9. Sair");
            System.out.print("Opção: ");
            opcao = input.nextInt();
            switch (opcao){
                case 1:inserir();break;
                case 2:buscar();break;
                case 3:exibir();break;
                case 4:excluir();break;
                case 5:reset();break;
                case 9:break;
                default:
                    System.out.println("Opção Invalida!");
            }
        }
    }

    private static void reset() {
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja realmente resetar o progroma?\nIMPORTANTE: Isso apagará todos os dados salvos!\nDigite <s/n>:");
        String decisao = input.next();
        if ("s".equals(decisao)) {
            Global.nElem = 0;
            System.out.println("Programa resetado com sucesso!");
        }
        if ("n".equals(decisao)){
            System.out.println("Processo de reset foi abortado!");
        }
        if (!("s".equals(decisao))&&!("n".equals(decisao))){
            System.out.println("Opção invalida, digite s ou n, retornando ao menu!");
        }
    }

    private static void excluir() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor a ser excluido:");
        int valor = input.nextInt();
        for (int i = buscaexcluir(valor); i <= Global.nElem - 1; i++) {
            Global.LL[i] = Global.LL[i+1];
        }
    }

    private static int buscaexcluir(int valor) {
        int x = 0;
        while (x < Global.nElem){
            if (valor == Global.LL[x]){
                System.out.println("Valor excluido com suecsso");
                Global.nElem--;
                return x;
            } else {
                x++;
                if (x == Global.nElem){
                    System.out.printf("Valor %d não encontrado na lista\n", valor);
                    return Global.nElem;
                }
            }
        }
        return Global.nElem;
    }

    private static void exibir() {
        System.out.println("Lista: ");
        for (int i = 0; i < Global.nElem; i++){
            System.out.printf("[%d]",Global.LL[i]);
        }
        System.out.printf("\nHá %d elementos na lista!\n", Global.nElem);
    }

    private static void buscar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor a ser encontrado:");
        int valor = input.nextInt();
        int i = 0;
        while (i < Global.nElem) {
            if (valor == Global.LL[i]) {
                System.out.printf("Valor encontra-se na posição %d\n", i);
                break;
            } else {
                i++;
                if (i == Global.nElem){
                    System.out.printf("Valor %d não encontrado na lista\n", valor);
                }
            }
        }
    }

    private static void inserir() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor do elemento:");
        int inserido = input.nextInt();
        if (Global.LL.length == Global.nElem) {
            System.out.println("Elemento não pode ser inserido na lista");
        } else {
            Global.LL[Global.nElem] = inserido;
            Global.nElem++;
            System.out.println("Elemento inserido com sucesso");
        }
    }
}
