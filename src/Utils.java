import java.util.Random;

public class Utils {
    // função que gera uma string com letras aleatórias
    public static String randomWord() {
        String name = "";
        Integer len = (int) (Math.random() * 26);

        for (int i = 0; i < len; i++) {
            int v = 1 + (int) (Math.random() * 26);
            char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
            name += c;
        }
        return name;
    }
}
