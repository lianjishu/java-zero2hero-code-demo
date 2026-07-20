package collections.comprehensivexercise.exerciseB.mestedmap;

import java.util.List;
import java.util.Map;

/**
 * Map 集合案例 —— 省和市的映射关系演示。
 *
 * <p>本案例演示如何使用 {@link Map} 集合存储"省份 - 多个市"的对应关系。
 * 键（Key）为省份名称，值（Value）为该省份下辖的多个市的集合。</p>
 *
 * <h2>数据结构</h2>
 * <ul>
 *   <li><b>键（Key）</b>：省份名称（String），例如 "江苏省"、"湖北省"、"河北省"。</li>
 *   <li><b>值（Value）</b>：该省份下辖的多个市的列表（{@link List}&lt;{@link String}&gt;）。</li>
 *   <li><b>集合类型</b>：{@link java.util.HashMap} 或 {@link java.util.LinkedHashMap}
 *       （后者可保持插入顺序）。</li>
 * </ul>
 *
 * <h2>输出格式</h2>
 * <p>遍历后按以下格式输出：</p>
 * <pre>
 *   江苏省 = 南京市，扬州市，苏州市，无锡市，常州市
 *   湖北省 = 武汉市，孝感市，十堰市，宜昌市，鄂州市
 *   河北省 = 石家庄市，唐山市，邢台市，保定市，张家口市
 * </pre>
 *
 * <h2>核心知识点</h2>
 * <ul>
 *   <li>{@link Map} 集合的基本使用（put、get、entrySet）。</li>
 *   <li>嵌套集合：{@code Map<String, List<String>>}。</li>
 *   <li>{@link Map.Entry} 的遍历方式。</li>
 *   <li>{@link String#join(CharSequence, Iterable)} 字符串拼接。</li>
 * </ul>
 *
 * @author YourName
 * @version 1.0
 * @since 2026-07-20
 */
public class ProvinceCityMap {

    /**
     * 程序入口，演示省份与市的映射关系。
     *
     * <p>主要步骤：</p>
     * <ol>
     *   <li>创建一个存储省份-市映射的 {@link Map}。</li>
     *   <li>向 Map 中添加江苏省、湖北省、河北省的数据。</li>
     *   <li>遍历 Map 并按指定格式输出结果。</li>
     * </ol>
     *
     * @param args 命令行参数（本案例未使用）
     */
    public static void main(String[] args) {
        Map<String, List<String>> provinceMap = buildProvinceMap();
        printProvinceMap(provinceMap);
    }

    /**
     * 构建省份与市的映射数据。
     *
     * <p>使用 {@link java.util.LinkedHashMap} 保证输出顺序与插入顺序一致。</p>
     *
     * @return 填充好数据的省份-市映射表
     */
    private static Map<String, List<String>> buildProvinceMap() {
        Map<String, List<String>> provinceMap = new java.util.LinkedHashMap<>();

        // 江苏省
        List<String> jiangsu = new java.util.ArrayList<>();
        jiangsu.add("南京市");
        jiangsu.add("扬州市");
        jiangsu.add("苏州市");
        jiangsu.add("无锡市");
        jiangsu.add("常州市");
        provinceMap.put("江苏省", jiangsu);

        // 湖北省
        List<String> hubei = new java.util.ArrayList<>();
        hubei.add("武汉市");
        hubei.add("孝感市");
        hubei.add("十堰市");
        hubei.add("宜昌市");
        hubei.add("鄂州市");
        provinceMap.put("湖北省", hubei);

        // 河北省
        List<String> hebei = new java.util.ArrayList<>();
        hebei.add("石家庄市");
        hebei.add("唐山市");
        hebei.add("邢台市");
        hebei.add("保定市");
        hebei.add("张家口市");
        provinceMap.put("河北省", hebei);

        return provinceMap;
    }

    /**
     * 按指定格式遍历输出省份与市的映射关系。
     *
     * <p>输出格式：{@code 省份 = 市1，市2，市3...}</p>
     *
     * @param provinceMap 待输出的省份-市映射表
     */
    private static void printProvinceMap(Map<String, List<String>> provinceMap) {

    }
}
