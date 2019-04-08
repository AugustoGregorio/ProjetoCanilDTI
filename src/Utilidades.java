import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Utilidades {

    private static final String FS = File.separator;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final Properties PROPS = new Properties();

    public static String[] validarArgumentos(String input) throws IllegalArgumentException{
        String [] argumentos = input.split(" ");
        if(argumentos.length != 3){
            throw new IllegalArgumentException();
        }
        else{
            return argumentos;
        }
    }

    public static boolean verificaFimDeSemana (String data){
        LocalDate date = LocalDate.parse(data, FORMATTER);
        DayOfWeek diaSemana = date.getDayOfWeek();
        return (diaSemana.equals(DayOfWeek.SATURDAY) || diaSemana.equals(DayOfWeek.SUNDAY));

    }

    public static String obterMensagem (String mensagem) throws IOException {
        FileInputStream file = new FileInputStream(obterDiretorioContantes());
        PROPS.load(file);
        return PROPS.getProperty(mensagem);
    }

    private static String obterDiretorioAtual()
    {
        return System.getProperty("user.dir");
    }

    private static String obterDiretorioContantes(){
        return obterDiretorioAtual() + FS + "src" + FS + "Constantes";
    }

}
