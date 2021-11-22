package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Pilha {
    private int inicio;
    private int fim;
    private int tamanho;
    private int qtdeElementos;
    private int elementos[];

    public Pilha(int tamanho) {
        this.tamanho = tamanho;
        inicio = 0;
        fim = 0;
        qtdeElementos = 0;
        elementos = new int[tamanho];
    }

    public void empilhar(int valor) {

    }

    public void desempilhar(int valor) {

    }

    public void verTopo() {
        JOptionPane.showMessageDialog(null, elementos[fim]);
    }

    public void verValores() {
        String valores = "";
        for (int i = fim; i >= 0; i--)
            valores += elementos[i] + " - ";

        JOptionPane.showMessageDialog(null, valores);
    }

    public boolean estaVazia() {
        return qtdeElementos == 0;
    }

    public boolean estaCheia() {
        return qtdeElementos == tamanho - 1;
    }
}
