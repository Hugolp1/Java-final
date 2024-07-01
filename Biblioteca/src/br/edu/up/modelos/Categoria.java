package br.edu.up.modelos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private String descricao;

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void salvarEmArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(this.nome + ";" + this.descricao);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Categoria> lerCategorias(String nomeArquivo) {
        List<Categoria> categorias = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Categoria categoria = new Categoria(dados[0], dados[1]);
                categorias.add(categoria);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categorias;
    }
}
