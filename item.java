public class item {
    double preco;
    String nome;
    int Stock;

    public item(double preco, String nome, int Stock){
        this.preco = preco;
        this.nome = nome;
        this.Stock = Stock;
    }

    public int getStock()
    {
        return this.Stock;
    }
    public void setStock(int stock)
    {
        this.Stock = stock;
    }
    public String getNome()
    {
        return this.nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public double getPreco()
    {
        return this.preco;
    }
    public void setPreco(double preco)
    {
        this.preco = preco;
    }
}
