import java.util.*;

class SomarDoisNumeros {
    public static void main(String[] args) throws Exception {
        //scanner
        Scanner sc = new Scanner(System.in);

        //dados
        int numero1, numero2, soma;

        //ler entradas
        System.out.print("Digite um número: ");
        numero1 = sc.nextInt();
        System.out.print("Digite outro número: ");
        numero2 = sc.nextInt();

        //somar
        soma = numero1 + numero2;

        //mostrar na tela
        System.out.println("Soma: " + soma);

        //fecjar scanner
        sc.close();
    }
}
