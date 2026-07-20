package collections.comprehensivexercise.exerciseA.randomrollcallsystem.v4.decayingpick;
/**
 * 自动点名器 V4 —— 衰减权重随机点名系统。
 *
 * <p>本程序从一个 TXT 文件中读取学生名单，每次点名时，已被点到的学生下次被点到的
 * 概率会降为原来的一半（衰减机制）。同时支持"作弊模式"，可在指定次数强制点
 * 到指定学生。</p>
 *
 * <h2>核心特性</h2>
 * <ul>
 *   <li><b>IO 读取</b>：从 TXT 文件加载学生名单，每个学生姓名独占一行。</li>
 *   <li><b>权重衰减</b>：被点过的学生权重 × 0.5，未被点过的学生权重保持 1.0。</li>
 *   <li><b>加权随机</b>：使用轮盘赌算法（Roulette Wheel Selection）按权重抽取。</li>
 *   <li><b>作弊机制</b>：可强制某一次点名指定到某个学生。</li>
 * </ul>
 *
 * <h2>概率变化示例</h2>
 * <p>假设 80 个学生，连续 5 次都点到小 A，概率变化如下：</p>
 * <pre>
 *   第 1 次：每人概率 1.25%
 *   第 2 次：小 A 概率 0.625%；其他学生 1.2579%
 *   第 3 次：小 A 概率 0.3125%；其他学生 1.261867%
 *   第 4 次：小 A 概率 0.15625%；其他学生 1.2638449%
 *   第 5 次：小 A 概率 0.078125%；其他学生 1.26483386%
 * </pre>
 *
 * <h2>作弊要求</h2>
 * <p>第三次点名强制为"张三"，无论权重如何。</p>
 *
 * <h2>相关知识点</h2>
 * <ul>
 *   <li>集合框架（{@link java.util.Map}、{@link java.util.List}）</li>
 *   <li>IO 流（{@link java.nio.file.Files} 或 {@code BufferedReader}）</li>
 *   <li>权重随机算法（累积权重 + 随机数）</li>
 * </ul>
 *
 * <h2>难度提示</h2>
 * <p>有 IO 基础的同学可以尝试；零基础同学建议先学习 IO 后再做。</p>
 *
 * @author lianjishu
 * @version 1.0
 * @since 2026-07-20
 */
public class DecayingRandomPick {
    // ...
}
