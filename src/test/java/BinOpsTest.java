import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinOpsTest {
    private BinOps testBinOpsCalc = new BinOps();
    private int a = 5;
    private int b = 2;
    private int c = -2;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void sum_test1() {
        String testVar1 = Integer.toBinaryString(a);
        String testVar2 = Integer.toBinaryString(b);
        int result = Integer.parseInt(testBinOpsCalc.sum(testVar1, testVar2), 2);
        assertEquals(7, result);
    }

    @Test
    void sum_test2() {
        String testVar1 = Integer.toBinaryString(a);
        String result = testBinOpsCalc.sum(testVar1, "someString");
        assertNull(result);
    }

    @Test
    void sum_test3() {
        String testVar1 = Integer.toBinaryString(a);
        String testVar2 = Integer.toBinaryString(c);
        testBinOpsCalc.sum(testVar1, testVar2);
        Assert.assertEquals(
                String.format("Ошибка: Неккорректный формат двоичного числа - \'%s\'", testVar2),
                outputStreamCaptor.toString().trim()
        );
    }

    @Test
    void sum_test4() {
        String testVar1 = "someString";
        String testVar2 = Integer.toBinaryString(c);
        testBinOpsCalc.sum(testVar1, testVar2);
        Assert.assertEquals(
                String.format("Ошибка: Неккорректный формат двоичного числа - \'%s\'", testVar1),
                outputStreamCaptor.toString().trim()
        );
    }

    @Test
    void sum_test5() {
        String testVar1 = " 0101    ";
        String testVar2 = Integer.toBinaryString(b);
        testBinOpsCalc.sum(testVar1, testVar2);
        int result = Integer.parseInt(testBinOpsCalc.sum(testVar1, testVar2), 2);
        assertEquals(7, result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void sum_test6(String testVar1) {
        String testVar2 = Integer.toBinaryString(b);
        testBinOpsCalc.sum(testVar1, testVar2);
        Assert.assertEquals(
                String.format("Ошибка: Неккорректный формат двоичного числа - \'%s\'", testVar1),
                outputStreamCaptor.toString().trim()
        );
    }

    ///
    @Test
    void mult_test1() {
        String testVar1 = Integer.toBinaryString(a);
        String testVar2 = Integer.toBinaryString(b);
        int result = Integer.parseInt(testBinOpsCalc.mult(testVar1, testVar2), 2);
        assertEquals(10, result);
    }

    @Test
    void mult_test2() {
        String testVar1 = Integer.toBinaryString(a);
        String result = testBinOpsCalc.mult(testVar1, "someString");
        assertNull(result);
    }

    @Test
    void mult_test3() {
        String testVar1 = Integer.toBinaryString(a);
        String testVar2 = Integer.toBinaryString(c);
        testBinOpsCalc.mult(testVar1, testVar2);
        Assert.assertEquals(
                String.format("Ошибка: Неккорректный формат двоичного числа - \'%s\'", testVar2),
                outputStreamCaptor.toString().trim()
        );
    }

    @Test
    void mult_test4() {
        String testVar1 = "someString";
        String testVar2 = Integer.toBinaryString(c);
        testBinOpsCalc.mult(testVar1, testVar2);
        Assert.assertEquals(
                String.format("Ошибка: Неккорректный формат двоичного числа - \'%s\'", testVar1),
                outputStreamCaptor.toString().trim()
        );
    }

    @Test
    void mult_test5() {
        String testVar1 = " 0101    ";
        String testVar2 = Integer.toBinaryString(b);
        testBinOpsCalc.mult(testVar1, testVar2);
        int result = Integer.parseInt(testBinOpsCalc.mult(testVar1, testVar2), 2);
        assertEquals(10, result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void mult_test6(String testVar1) {
        String testVar2 = Integer.toBinaryString(b);
        testBinOpsCalc.sum(testVar1, testVar2);
        Assert.assertEquals(
                String.format("Ошибка: Неккорректный формат двоичного числа - \'%s\'", testVar1),
                outputStreamCaptor.toString().trim()
        );
    }
}
