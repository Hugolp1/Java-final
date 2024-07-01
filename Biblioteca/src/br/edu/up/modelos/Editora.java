package br.edu.up.modelos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Editora {
    private String nome;
    private String endereco;

    public Editora(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void salvarEmArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(this.nome + ";" + this.endereco);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Editora> lerEditoras(String nomeArquivo) {
        List<Editora> editoras = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Editora editora = new Editora(dados[0], dados[1]);
                editoras.add(editora);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return editoras;
    }
}
