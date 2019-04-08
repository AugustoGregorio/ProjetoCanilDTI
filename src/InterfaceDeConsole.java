import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class InterfaceDeConsole {

    private static final List<PetShop> LISTA_DE_PET_SHOPS = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static void inicializarInterface() {
        LISTA_DE_PET_SHOPS.add(new PetShop("Meu Canino Feliz", 2, 20.00, 40.00, 4.00, 8.00));
        LISTA_DE_PET_SHOPS.add(new PetShop("Vai Rex", 1.7, 15.00, 50.00, 5.0, 5.0));
        LISTA_DE_PET_SHOPS.add(new PetShop("ChowChawgas", 0.8, 30.00, 45.00));
    }

    public static void mostrarInterface() throws IOException {
        inicializarInterface();

        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println(Utilidades.obterMensagem("MensagemBoasVindas"));
                String input = SCANNER.nextLine();
                String[] argumentos = Utilidades.validarArgumentos(input);
                continuar = false;
                String data = argumentos[0];
                int caesPequenos = Integer.parseInt(argumentos[1]);
                int caesGrandes = Integer.parseInt(argumentos[2]);

                for (PetShop petshop : LISTA_DE_PET_SHOPS) {
                    petshop.calcularCustoTotal(data, caesGrandes, caesPequenos);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(Utilidades.obterMensagem("MensagemErro"));
            }
        }

        LISTA_DE_PET_SHOPS.sort(new Comparator<PetShop>() {
            @Override
            public int compare(PetShop primeiro, PetShop segundo) {
                if (primeiro.getPrecoTotal() < segundo.getPrecoTotal()) {
                    return -1;
                } else if (primeiro.getPrecoTotal() > segundo.getPrecoTotal()) {
                    return 1;
                } else {
                    if (primeiro.getDistancia() < segundo.getDistancia()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        System.out.println(Utilidades.obterMensagem("MensagemMelhorPetshop")
                + LISTA_DE_PET_SHOPS.get(0));

    }
}

