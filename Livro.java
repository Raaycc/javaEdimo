package biblioteca;

public class Livro {
    private String titulo;
    private int qtdPaginas;
    
    public Livro(String titulo, int qtdPaginas){
        this.titulo = titulo;
        this.qtdPaginas = qtdPaginas;
    }
    
    public void EditarLivro(String titulo, int qtdPaginas){
        if(titulo != null && qtdPaginas > 0){
            
            if(this.titulo != titulo || qtdPaginas != this.qtdPaginas){
                this.titulo = titulo;
                this.qtdPaginas = qtdPaginas;
            }
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }
    
}
