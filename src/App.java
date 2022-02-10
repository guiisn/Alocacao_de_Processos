import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ProcessQueue queue = new ProcessQueue(32);

        System.out.println("Digite a quantidade de processos que você quer executar [MÍNIMO: 1 | MÁXIMO: 32] -> ");

        Scanner scanner = new Scanner(System.in);

        int tam = scanner.nextInt();

        for (int i = 0; i < tam; i++) {
            String word = Utils.randomWord(); // gera uma palavra ateatória
            System.out.println(word);
            new Node(word, queue);
        }
    }
}
