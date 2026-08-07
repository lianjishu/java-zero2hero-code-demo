package io.github.lianjishu.unittest.taste.junit;

/**
 * Unit常用注解（Unit 4.xxxx版本）
 * <p>
 * {@code @Test} 测试方法
 * {@code @Before} 修饰实例方法，在每个测试方法执行之前执行一次
 * {@code @After} 修饰实例方法，在每个测试方法执行之后执行一次
 * {@code @BeforeClass} 修饰静态方法，在所有测试方法之前只执行一次
 * {@code @AfterClass} 修饰静态方法，在所有测试方法之后只执行一次
 */
public class TryoutJunit {
    public int add(int x, int y) {
        return x + y;
    }
}
