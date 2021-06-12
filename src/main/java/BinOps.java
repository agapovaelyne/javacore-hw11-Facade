public class BinOps {
    public String sum(String a, String b) {
        int var1 = -1;
        int var2 = -2;
        try {
            var1 = Integer.parseInt(a.trim(), 2);
            var2 = Integer.parseInt(b.trim(), 2);
            return Integer.toBinaryString(var1 + var2);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(
                    String.format("Ошибка: Неккорректный формат двоичного числа - \'%s\'", var1 == -1 ? a : b)
            );
            return null;
        }

    }

    public String mult(String a, String b) {
        int var1 = -1;
        int var2 = -2;
        try {
            var1 = Integer.parseInt(a.trim(), 2);
            var2 = Integer.parseInt(b.trim(), 2);
            return Integer.toBinaryString(var1 * var2);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(
                    String.format("Ошибка: Неккорректный формат двоичного числа - \'%s\'", var1 == -1 ? a : b)
            );
            return null;
        }
    }
}