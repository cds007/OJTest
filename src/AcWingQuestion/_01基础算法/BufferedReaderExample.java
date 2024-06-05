package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderExample {
    // BufferedReader要比Scanner更快，快个10倍20倍左右
    public static void main(String[] args) {
        // 创建一个BufferedReader对象
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入一些文本：");

        try {
            // 读取一行文本
            String input = reader.readLine();
            // 打印读取到的文本
            System.out.println("你输入的是： " + input);
        } catch (IOException e) {
            // 处理可能发生的IO异常
            e.printStackTrace();
        } finally {
            // 关闭BufferedReader
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
