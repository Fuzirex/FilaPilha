package model;

import javax.swing.*;

public class Fila {
    private int inicio;
    private int fim;
    private int tamanho;
    private int qtdeElementos;
    private Contato contatos[];

    public Fila(int tamanho) {
        this.tamanho = tamanho;
        inicio = fim = -1;
        contatos = new Contato[tamanho];
        qtdeElementos = 0;
    }

    // RUN <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public void run() {
        while (true) {
            Integer menuItem = Integer.valueOf(JOptionPane.showInputDialog(getMenuItens()));

            switch (menuItem) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Nome do contato:");
                    String telefone = JOptionPane.showInputDialog("Telefone do contato:");
                    adicionar(new Contato(nome, telefone));
                    break;

                case 2:
                    remover();
                    break;

                case 3:
                    mostrar();
                    break;

                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    private String getMenuItens() {
        StringBuilder sb = new StringBuilder();

        sb.append("1 - Inserir contato\n");
        sb.append("2 - Próximo contato\n");
        sb.append("3 - Ver todos os contatos\n");
        sb.append("0 - Sair");


        return sb.toString();
    }

    // MÉTODOS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public boolean estaVazia() {
        return qtdeElementos == 0;
    }

    public boolean estaCheia() {
        return qtdeElementos == tamanho;
    }

    public void adicionar(Contato contato) {
        if (!estaCheia()) {
            if (inicio == -1)
                inicio = 0;

            if ((fim + 1) == tamanho)
                fim = 0;
            else
                fim++;

            contatos[fim] = contato;
            qtdeElementos++;
        } else
            JOptionPane.showMessageDialog(null, "Fila está cheia.");
    }

    public void remover() {
        if (!estaVazia()) {
            Contato contatoRemovido = contatos[inicio];

            if ((inicio + 1) == tamanho)
                inicio = 0;
            else
                inicio++;

            qtdeElementos--;

            JOptionPane.showMessageDialog(null, String.format("Nome: %s - Telefone: %s", contatoRemovido.getNome(), contatoRemovido.getTelefone()));
        } else
            JOptionPane.showMessageDialog(null, "Fila está vazia.");
    }

    public void mostrar() {
        if(estaVazia()) {
            JOptionPane.showMessageDialog(null, "Fila está vazia.");
        } else {
            String values = "";
            boolean flag = true;
            int i = inicio;
            int qtde = 0;


            while(flag) {
                values += String.format("Nome: %s - Telefone: %s \n", contatos[i].getNome(), contatos[i].getTelefone());
                qtde++;

                if(qtde == qtdeElementos)
                    flag = false;

                if(i == tamanho - 1)
                    i = 0;
                else
                    i++;
            }

            JOptionPane.showMessageDialog(null, values);
        }
    }
}
