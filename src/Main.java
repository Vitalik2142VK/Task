import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFirstUniqueSymbol("SimpleString"));
        System.out.println(getFirstUniqueSymbol("qQwerty"));
        System.out.println(getFirstUniqueSymbol("qweqwe"));
    }

    public static char getFirstUniqueSymbol(String string) {
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