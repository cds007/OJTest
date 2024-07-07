package AcWingQuestion._01基础算法;

public class 原码反码补码 {
    public static void main(String[] args) {
        int n = 10; //int和long等基本数据类型都是有符号的，int是32位的，long是64位的
        for (int i = 31; i >= 0; i--) {
            System.out.print(n >> i & 1); //00000000000000000000000000001010
        }
        System.out.println();
        n = -n;
        for (int i = 31; i >= 0; i--) {
            System.out.print(n >> i & 1); //11111111111111111111111111110110 这个确实是补码
        }

        //无符号数
        /**
         *
         是的，int 在 Java 中确实是有符号的，它可以表示从 -2,147,483,648 到 2,147,483,647 的范围。
         我的意思是在没有内置无符号整数类型的 Java 中，我们可以使用有符号的 int 来“模拟”无符号整数的行为。
         这是通过确保我们的操作不会错误地将这些数值解释为负数来实现的。
         */
        int unsignedInt = 42; // 表示一个无符号整数
        long unsignedLong = Integer.toUnsignedLong(unsignedInt); // 将 int 视为无符号数并转换为 long

        // 使用无符号右移
        unsignedInt >>>= 1; // 无符号右移一位

        // 将无符号整数转换为字符串
        String unsignedString = Long.toUnsignedString(unsignedLong);

        // 从字符串解析无符号整数
        unsignedLong = Long.parseUnsignedLong("1234567890123456789");

        // 比较两个无符号整数
        int compareResult = Long.compareUnsigned(unsignedLong, Integer.toUnsignedLong(unsignedInt));
    }
}
