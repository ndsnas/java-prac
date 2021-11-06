public class GenerateAllBinaryStringsFromPattern {

    public static void main(String[] args) {
        // Integer i = null;
        replaceWildcard("1??0?101", null, '?');
    }

    private static void replaceWildcard(String str, Integer val, char wildcard) {
        if (str.indexOf(wildcard) == -1) {
            System.out.println(str);
            return;
        }
        if (val != null) {
            int indexOfWildcard = str.indexOf(wildcard);
            str = str.substring(0, indexOfWildcard) + val + str.substring(indexOfWildcard + 1);
        }
        replaceWildcard(str, 0, wildcard);
        if (str.indexOf(wildcard) != -1) {
            replaceWildcard(str, 1, wildcard);
        }
        return;
    }

}
