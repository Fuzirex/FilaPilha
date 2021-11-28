package main;

import model.Fila;
import model.Pilha;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String opcao = JOptionPane.showInputDialog("1 - Pilha\n" +
                                                   "2 - Fila");

        if(opcao.equals("1")) {
            Integer tamanho = Integer.valueOf(JOptionPane.showInputDialog("Qual o tamanho da pilha?"));
            Pilha pilha = new Pilha(tamanho);
            pilha.run();
        } else {
            Integer tamanho = Integer.valueOf(JOptionPane.showInputDialog("Qual o tamanho da fila?"));
            Fila fila = new Fila(tamanho);
            fila.run();
        }
    }
}
