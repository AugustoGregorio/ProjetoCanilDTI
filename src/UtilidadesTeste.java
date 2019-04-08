import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class UtilidadesTeste {

    @Test
    public void validarArgumentos(){
        String [] args = Utilidades.validarArgumentos("07/04/2019 1 1");
        String dataEsperada = "07/04/2019";
        int caesPequenosEsperados = 1;
        int caesGrandesEsperados = 1;
        Assert.assertEquals(args[0], dataEsperada);
        Assert.assertEquals(Integer.parseInt(args[1]), caesPequenosEsperados);
        Assert.assertEquals(Integer.parseInt(args[2]), caesGrandesEsperados);
    }

    @Test
    public void verificaFimDeSemana(){
        Assert.assertTrue(Utilidades.verificaFimDeSemana("07/04/2019"));
    }

    @Test
    public void obterMensagem() throws IOException {
        String mensagemBoasVindas = "Por favor, informe a data, quantidade de caes pequenos e quantidade de caes grandes no formato, (dd/mm/aaaa x y):";
        String mensagemErro = "Voce nao digitou os dados corretamente. Por favor, insira novamente!";
        String mensagemMelhorPetshop = "O petshop com o melhor custo e o:";
        Assert.assertEquals(Utilidades.obterMensagem("MensagemBoasVindas"), mensagemBoasVindas);
        Assert.assertEquals(Utilidades.obterMensagem("MensagemErro"), mensagemErro);
        Assert.assertEquals(Utilidades.obterMensagem("MensagemMelhorPetshop"), mensagemMelhorPetshop);
    }
}









