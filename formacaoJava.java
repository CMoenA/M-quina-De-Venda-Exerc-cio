import java.util.LinkedList;
import java.util.Scanner;

public class formacaoJava
{
    static double trocado;
    static double balanco;
    static  LinkedList<item> produtos;

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args)
    {
        balanco = 0.0;
        produtos = new LinkedList<item>();
        /****~INIT***/
        item p1 = new item(0.7,"Coca-Cola",10);
        item p2 = new item(0.65,"Pepsi",15);
        item p3 = new item(0.6,"Ice Tea",25);
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        /*******/
        int opcao;
        do {
            System.out.println("\n\n   ### Bem Vindos a máquina de bebidas, o que deseja fazer? ###");
            System.out.println("\n                =========================|");
            System.out.println("                  |     1 - Compra         |");
            System.out.println("                  |     2 - Reset          |");
            System.out.println("                  |     0 - Sair           |");
            System.out.println("                  =========================|\n");

            opcao = SCANNER.nextInt();
            System.out.print("\n");
            switch (opcao) {
                case 1:
                    aceitarMoedas();
                    break;
                case 2:
                    reset();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }
    public static  void aceitarMoedas() {
        int opcao;
        //double valor;
        do {
            System.out.println("\n\n   ###             Insira as moedas             ###");
            System.out.println("\n                ============================|");
            System.out.println("                  |     5 Cêntimos            |");
            System.out.println("                  |     10 Cêntimos           |");
            System.out.println("                  |     20 Cêntimos           |");
            System.out.println("                  |     50 Cêntimos           |");
            System.out.println("                  |     1 - Escolher Bebida   |");
            System.out.println("                  |     0 - Cancelar          |");
            System.out.println("                  ============================|\n");

            opcao = SCANNER.nextInt();
            switch (opcao) {
                case 0:
                    cancelarPagamento();
                break;
                case 1:
                    selecionarBebida();
                break;
                case 5:
                    balanco = +0.05;
                break;
                case 10:
                    balanco = +0.10;
                case 20:
                    balanco = +0.20;
                case 50:
                    balanco = +0.50;
            }
        }while (true);
    }
    public static  void selecionarBebida()
    {
        int opcao;
        boolean continuar = true;
        do {
            System.out.println("\n\n   ###         Selecione a sua Bebida ###");
            System.out.println("\n                =========================|");
            System.out.println("                  |     1 - Coca-Cola      |");
            System.out.println("                  |     2 - Pepsi          |");
            System.out.println("                  |     3 - Ice-Tea        |");
            System.out.println("                  |     0 - Sair           |");
            System.out.println("                  =========================|\n");
            opcao = SCANNER.nextInt();

            String nomeProduto = "";
            item produtoSelecionado = null;

            switch (opcao){
                case 1:
                    nomeProduto  ="Coca-Cola";
                case 2:
                    nomeProduto  ="Pepsi";
                case 3:
                    nomeProduto  ="Ice-Tea";
                default: {
                    System.out.println("Vou sair");
                    continuar = false;
                }
            }

            for (int idx = 0;idx < produtos.size(); ++idx){
                item bebida = produtos.get(idx);
                if (bebida.getNome().equals(nomeProduto)){
                    produtoSelecionado=bebida;
                    break;
                }
            }
            if (produtoSelecionado != null) {
                trocado = balanco - produtoSelecionado.getPreco();
            System.out.println("O seu troco é de" + trocado);
            produtoSelecionado.setStock(produtoSelecionado.getStock() - 1);
            }


            continuar= false;

        }while(continuar);
    }
    public static  void cancelarPagamento()
    {
        System.out.println("O seu troco de " + balanco + "foi devolvido");
        balanco = 0;
    }

    public static  void reset()
    {
        trocado = 0;
        balanco = 0;
        produtos = new LinkedList<item>();
        item p1 = new item(0.7,"Coca-Cola",10);
        item p2 = new item(0.65,"Pepsi",15);
        item p3 = new item(0.6,"Ice Tea",25);
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
    }
}