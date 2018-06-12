package DBO;


public class DBOIngresso {

    private int codSetor;
    private String categoria;
    private float preco;
    
    public DBOIngresso(int codSetor, String categoria, float preco) {
        this.codSetor = codSetor;
        this.categoria = categoria;
        this.preco = preco;
    }

    public int getCodSetor() {
        return codSetor;
    }

    public void setCodSetor(int codSetor) {
        this.codSetor = codSetor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
