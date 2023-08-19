package ti2cc.model;

public class Livro {
    //data
    private String nome;
    private String autor;
    private String genero;
    private int codigo;

    //empty livro constructor
    public Livro() {
        this.nome = "";
        this.autor = "";
        this.genero = "";
        this.codigo = -1;
    }

    //fill livro construtor
    public Livro(int codigo, String nome, String autor, String genero) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.codigo = codigo;
    }

    //getter && setters
    //nome
    public void setNome(String nome) {
        this.nome = nome;
    } 

    public String getNome() {
        return nome;
    }

    //autor
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    //genero
    public void setGenero(String genero) {
        this.genero = genero;
    } 

    public String getGenero() {
        return genero;
    }

    //codigo
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Livro [codigo=" + codigo + ", nome=" + nome + ", autor=" + autor + ", genero=" + genero + "]";
    }
}
