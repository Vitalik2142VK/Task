import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;


public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String[] examplesStrings = {
                "SimpleString",
                "qQwerty",
                "qweqwe",
                "",
                null
        };

        for (var string : examplesStrings) {
            try {
                out.println(getFirstUniqueSymbol(string));
            } catch (Exception e) {
                LOG.log(Level.WARNING, e.toString());
            }
        }
    }

    public static char getFirstUniqueSymbol(String string) {
        if (string == null) {
            throw new NullPointerException();
        }

        if (string.isEmpty()) {
            throw new EmptyStringException();
        }

        char[] chars = string.toLowerCase().toCharArray();
        int defaultCount = 1;
        int countSymbols;

        Map<Character, Integer> uniqueSymbols = new HashMap<>();

        for (var symbol : chars) {
            if (uniqueSymbols.containsKey(symbol)) {
                countSymbols = uniqueSymbols.get(symbol);
                uniqueSymbols.put(symbol, ++countSymbols);
            } else {
                uniqueSymbols.put(symbol, defaultCount);
            }
        }

        for (var symbol : chars) {
            countSymbols = uniqueSymbols.get(symbol);

            if (defaultCount == countSymbols) {
                return symbol;
            }
        }

        throw new NotFoundUniqueChar("No unique chars found");
    }
}