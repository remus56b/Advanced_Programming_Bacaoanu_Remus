/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.labone;

/**
 *
 * @author remus
 */
public class LabOne {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String lang[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        //System.out.println(lang[3]);

        int n = (int) (Math.random() * 1000000);

        n = n * 3;

        String binary = "10101";
        int to10 = Integer.parseInt(binary, 2);
        n = n + to10;

        n = n + 0xFF;

        n = n * 6;

        while (n > 9) {
            int a = n;
            int s = 0;
            while (a > 0) {
                s = s + a % 10;
                a = a / 10;
            }
            n = s;
        }

        int result = n;
        System.out.println(result);
        System.out.println("Willy-nilly, this semester I will learn " + lang[result]);

    }
}
