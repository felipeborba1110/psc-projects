import java.util.Scanner;

class Global2 {
    static int nElem = 0;
    static int[] LL = new int[5];
}

public class PilhaSimples {
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
            Global2.nElem = 0;
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
        System.out.println("Deseja realmente excluir o último valor adicionado?\nIMPORTANTE: Dados apagados não podem ser restaurados!\nDigite <s/n>:");
        String decisao = input.next();
        if ("s".equals(decisao)) {
            Global2.nElem--;
            System.out.println("Exclusão feita com sucesso!");
        }
        if ("n".equals(decisao)){
            System.out.println("Exclusão foi abortada!");
        }
        if (!("s".equals(decisao))&&!("n".equals(decisao))){
            System.out.println("Opção invalida, digite s ou n, retornando ao menu!");
        }
    }

    private static void exibir() {
        System.out.println("Lista: ");
        for (int i = 0; i < Global2.nElem; i++){
            System.out.printf("[%d]",Global2.LL[i]);
        }
        System.out.printf("\nHá %d elementos na lista!\n", Global2.nElem);
    }

    private static void buscar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor a ser encontrado:");
        int valor = input.nextInt();
        int i = 0;
        while (i < Global2.nElem) {
            if (valor == Global2.LL[i]) {
                System.out.printf("Valor encontra-se na posição %d\n", i);
                break;
            } else {
                i++;
                if (i == Global2.nElem){
                    System.out.printf("Valor %d não encontrado na lista\n", valor);
                }
            }
        }
    }

    private static void inserir() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor do elemento:");
        int inserido = input.nextInt();
        if (Global3.LL.length == Global3.nElem) {
            System.out.println("Elemento não pode ser inserido na lista");
        } else {
            Global3.LL[Global3.nElem] = inserido;
            Global3.nElem++;
            System.out.println("Elemento inserido com sucesso");
        }
    }
}
