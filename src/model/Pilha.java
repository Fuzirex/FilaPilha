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
    private String elementos[];

    public Pilha(int tamanho) {
        this.tamanho = tamanho;
        inicio = fim = -1;
        qtdeElementos = 0;
        elementos = new String[tamanho];
    }

    // RUN <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public void run() {
        while (true) {
            Integer menuItem = Integer.valueOf(JOptionPane.showInputDialog(getMenuItens()));

            switch (menuItem) {
                case 1:
                    String tarefa = JOptionPane.showInputDialog("Qual a nova tarefa?");
                    empilhar(tarefa);
                    break;

                case 2:
                    desempilhar();
                    break;

                case 3:
                    verProximaTarefa();
                    break;

                case 4:
                    verValores();
                    break;

                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    private String getMenuItens() {
        StringBuilder sb = new StringBuilder();

        sb.append("1 - Adicionar tarefa\n");
        sb.append("2 - Remover próxima tarefa\n");
        sb.append("3 - Ver próxima tarefa\n");
        sb.append("4 - Ver todas tarefas\n");
        sb.append("0 - Sair");


        return sb.toString();
    }

    // MÉTODOS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public void empilhar(String valor) {
        if (!estaCheia()) {
            if (inicio == -1)
                inicio++;
            fim++;
            elementos[fim] = valor;
            qtdeElementos++;
        } else
            JOptionPane.showMessageDialog(null, "A pilha ja está cheia.");
    }

    public void desempilhar() {
        if (!estaVazia()) {
            String tarefaRemovida = elementos[fim];

            fim--;
            qtdeElementos--;

            JOptionPane.showMessageDialog(null, "Tarefa Removida: " + tarefaRemovida);
        } else
            JOptionPane.showMessageDialog(null, "A pilha ja está vazia.");
    }

    public void verValores() {
        if (estaVazia()) {
            JOptionPane.showMessageDialog(null, "Sem tarefas.");
        } else {
            String valores = "";
            for (int i = fim; i >= 0; i--)
                valores += elementos[i] + " - ";

            JOptionPane.showMessageDialog(null, valores);
        }
    }

    public String verUltimaTarefaRemovida() {
        return elementos[fim + 1];
    }

    public void verProximaTarefa() {
        if (estaVazia()) {
            JOptionPane.showMessageDialog(null, "Sem tarefas.");
        } else
            JOptionPane.showMessageDialog(null, "Próxima tarefa: " + elementos[fim]);
    }

    public boolean estaVazia() {
        return qtdeElementos == 0;
    }

    public boolean estaCheia() {
        return qtdeElementos == tamanho;
    }
}
