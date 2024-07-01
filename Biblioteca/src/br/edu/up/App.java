package br.edu.up;

import br.edu.up.modelos.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String livrosArquivo = "livros.txt";
        String autoresArquivo = "autores.txt";
        String usuariosArquivo = "usuarios.txt";
        String emprestimosArquivo = "emprestimos.txt";
        String editorasArquivo = "editoras.txt";
        String categoriasArquivo = "categorias.txt";

        List<Livro> livros = Livro.lerLivros(livrosArquivo);
        List<Autor> autores = Autor.lerAutores(autoresArquivo);
        List<Usuario> usuarios = Usuario.lerUsuarios(usuariosArquivo);
        List<Emprestimo> emprestimos = Emprestimo.lerEmprestimos(emprestimosArquivo);
        List<Editora> editoras = Editora.lerEditoras(editorasArquivo);
        List<Categoria> categorias = Categoria.lerCategorias(categoriasArquivo);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Autor");
            System.out.println("3. Adicionar Usuario");
            System.out.println("4. Adicionar Emprestimo");
            System.out.println("5. Adicionar Editora");
            System.out.println("6. Adicionar Categoria");
            System.out.println("7. Listar Livros");
            System.out.println("8. Listar Autores");
            System.out.println("9. Listar Usuarios");
            System.out.println("10. Listar Emprestimos");
            System.out.println("11. Listar Editoras");
            System.out.println("12. Listar Categorias");
            System.out.println("13. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Titulo do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN do livro: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Editora do livro: ");
                    String editora = scanner.nextLine();
                    System.out.print("Categoria do livro: ");
                    String categoria = scanner.nextLine();
                    Livro livro = new Livro(titulo, autor, isbn, editora, categoria);
                    livros.add(livro);
                    livro.salvarEmArquivo(livrosArquivo);
                    break;

                case 2:
                    System.out.print("Nome do autor: ");
                    String nomeAutor = scanner.nextLine();
                    System.out.print("Nacionalidade do autor: ");
                    String nacionalidade = scanner.nextLine();
                    Autor novoAutor = new Autor(nomeAutor, nacionalidade);
                    autores.add(novoAutor);
                    novoAutor.salvarEmArquivo(autoresArquivo);
                    break;

                case 3:
                    System.out.print("Nome do usuario: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Email do usuario: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha do usuario: ");
                    String senha = scanner.nextLine();
                    Usuario usuario = new Usuario(nomeUsuario, email, senha);
                    usuarios.add(usuario);
                    usuario.salvarEmArquivo(usuariosArquivo);
                    break;

                case 4:
                    System.out.print("Nome do usuario: ");
                    String nomeEmprestimoUsuario = scanner.nextLine();
                    System.out.print("Titulo do livro: ");
                    String tituloEmprestimoLivro = scanner.nextLine();
                    LocalDate dataEmprestimo = LocalDate.now();
                    LocalDate dataDevolucao = dataEmprestimo.plusDays(14);
                    Emprestimo emprestimo = new Emprestimo(nomeEmprestimoUsuario, tituloEmprestimoLivro, dataEmprestimo, dataDevolucao);
                    emprestimos.add(emprestimo);
                    emprestimo.salvarEmArquivo(emprestimosArquivo);
                    break;

                case 5:
                    System.out.print("Nome da editora: ");
                    String nomeEditora = scanner.nextLine();
                    System.out.print("Endereco da editora: ");
                    String endereco = scanner.nextLine();
                    Editora novaEditora = new Editora(nomeEditora, endereco);
                    editoras.add(novaEditora);
                    novaEditora.salvarEmArquivo(editorasArquivo);
                    break;

                case 6:
                    System.out.print("Nome da categoria: ");
                    String nomeCategoria = scanner.nextLine();
                    System.out.print("Descricao da categoria: ");
                    String descricao = scanner.nextLine();
                    Categoria novaCategoria = new Categoria(nomeCategoria, descricao);
                    categorias.add(novaCategoria);
                    novaCategoria.salvarEmArquivo(categoriasArquivo);
                    break;

                case 7:
                    System.out.println("Livros cadastrados:");
                    for (Livro l : livros) {
                        System.out.println("Titulo: " + l.getTitulo() + ", Autor: " + l.getAutor() + ", ISBN: " + l.getIsbn() + ", Editora: " + l.getEditora() + ", Categoria: " + l.getCategoria());
                    }
                    break;

                case 8:
                    System.out.println("Autores cadastrados:");
                    for (Autor a : autores) {
                        System.out.println("Nome: " + a.getNome() + ", Nacionalidade: " + a.getNacionalidade());
                    }
                    break;

                case 9:
                    System.out.println("Usuarios cadastrados:");
                    for (Usuario u : usuarios) {
                        System.out.println("Nome: " + u.getNome() + ", Email: " + u.getEmail());
                    }
                    break;

                case 10:
                    System.out.println("Emprestimos cadastrados:");
                    for (Emprestimo e : emprestimos) {
                        System.out.println("Usuario: " + e.getUsuario() + ", Livro: " + e.getLivro() + ", Data de Emprestimo: " + e.getDataEmprestimo() + ", Data de Devolucao: " + e.getDataDevolucao());
                    }
                    break;

                case 11:
                    System.out.println("Editoras cadastradas:");
                    for (Editora e : editoras) {
                        System.out.println("Nome: " + e.getNome() + ", Endereco: " + e.getEndereco());
                    }
                    break;

                case 12:
                    System.out.println("Categorias cadastradas:");
                    for (Categoria c : categorias) {
                        System.out.println("Nome: " + c.getNome() + ", Descricao: " + c.getDescricao());
                    }
                    break;

                case 13:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
