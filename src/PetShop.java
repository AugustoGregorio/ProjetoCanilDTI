
public class PetShop {

    private String nome;
    private double precoCaoPequeno;
    private double precoCaoGrande;
    private double tarifaCaoPequeno;
    private double tarifaCaoGrande;
    private double precoTotal;
    private double distancia;

    public PetShop(String nome, double distancia, double precoCaoPequeno, double precoCaoGrande) {
        this.nome = nome;
        this.distancia = distancia;
        this.precoCaoPequeno = precoCaoPequeno;
        this.precoCaoGrande = precoCaoGrande;
    }

    public PetShop(String nome, double distancia, double precoCaoPequeno, double precoCaoGrande, double tarifaCaoPequeno, double tarifaCaoGrande)
    {
        this(nome, distancia, precoCaoPequeno, precoCaoGrande);
        this.tarifaCaoPequeno = tarifaCaoPequeno;
        this.tarifaCaoGrande = tarifaCaoGrande;
    }

    public void calcularCustoTotal(String data, int caesGrandes, int caesPequenos) {
        if (Utilidades.verificaFimDeSemana(data)) {
            this.precoTotal = ((caesPequenos * (this.tarifaCaoPequeno + this.precoCaoPequeno))
                    + (caesGrandes * (this.tarifaCaoGrande + this.precoCaoGrande)));
        } else {
            this.precoTotal = ((caesPequenos * this.precoCaoPequeno)
                    + (caesGrandes * this.precoCaoGrande));
        }
    }

    public double getDistancia() {
        return distancia;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    @Override
    public String toString() {
        return " " + this.nome + " " + this.precoTotal;
    }

}
