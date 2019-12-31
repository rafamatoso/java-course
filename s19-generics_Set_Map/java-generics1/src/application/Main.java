package application;

import services.PrintService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // O Generics garante a execução da aplicação independente do tipo de dado usado, bastando especificar na instanciação da classe (Integer, String...)

        PrintService<Integer> ps = new PrintService<>();

        System.out.print("How many values?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();

        System.out.println("First: "+ps.first());

        sc.close();
    }
}
