/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espoch.reactiva;

import java.util.Scanner;



/**
 *
 * @author PERSONAL
 */
public class Reactiva {

    public static void main(String[] args) {
       
       Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double num1 = sc.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = sc.nextDouble();

        System.out.print("Ingrese el tercer número: ");
        double num3 = sc.nextDouble();

        
        Flux<Double> numeros = Flux.just(num1, num2, num3);

        numeros
            .collectList() 
            .map(lista -> {
                double suma = lista.stream().mapToDouble(Double::doubleValue).sum();
                return suma / lista.size(); // Calcula el promedio
            })
            .subscribe(promedio -> System.out.println("El promedio es: " + promedio));

    }
}
