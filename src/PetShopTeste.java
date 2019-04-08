import org.junit.Assert;
import org.junit.Test;

public class PetShopTeste {

    @Test
    public void calcularCustoTotal(){
        PetShop chowChawgas = new PetShop("ChowChawgas", 0.8, 30.00, 45.00);
        chowChawgas.calcularCustoTotal("07/04/2019", 0, 0);
        double precoEsperado = 0;
        Assert.assertTrue(chowChawgas.getPrecoTotal() == precoEsperado);
    }
}
