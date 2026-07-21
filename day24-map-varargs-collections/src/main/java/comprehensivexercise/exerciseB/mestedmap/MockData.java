package comprehensivexercise.exerciseB.mestedmap;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MockData {
    /**
     * 构建省份与市的映射数据。
     *
     * <p>覆盖中华人民共和国全部 34 个省级行政单位:4 个直辖市、23 个省、5 个自治区、
     * 2 个特别行政区,另将台湾省作为"省"一并纳入。其中:</p>
     * <ul>
     *   <li>直辖市和特别行政区无"下辖市"概念,使用占位数据。</li>
     *   <li>省与自治区下属地级市采取穷举(以截至 2026 年的行政区划为准)。</li>
     * </ul>
     *
     * <p>使用 {@link java.util.LinkedHashMap} 保证输出顺序与插入顺序一致。</p>
     *
     * @return 填充好数据的省份-市映射表
     */
    public static Map<String, List<String>> buildProvinceMap() {
        Map<String, List<String>> provinceMap = new LinkedHashMap<>();

        // ===== 直辖市(占位) =====
        List<String> beijing = new java.util.ArrayList<>();
        beijing.add("本市");
        provinceMap.put("北京市", beijing);

        List<String> tianjin = new java.util.ArrayList<>();
        tianjin.add("本市");
        provinceMap.put("天津市", tianjin);

        List<String> shanghai = new java.util.ArrayList<>();
        shanghai.add("本市");
        provinceMap.put("上海市", shanghai);

        List<String> chongqing = new java.util.ArrayList<>();
        chongqing.add("本市");
        provinceMap.put("重庆市", chongqing);

        // ===== 省 =====
        // 河北省
        List<String> hebei = new java.util.ArrayList<>();
        hebei.add("石家庄市");
        hebei.add("唐山市");
        hebei.add("秦皇岛市");
        hebei.add("邯郸市");
        hebei.add("邢台市");
        hebei.add("保定市");
        hebei.add("张家口市");
        hebei.add("承德市");
        hebei.add("沧州市");
        hebei.add("廊坊市");
        hebei.add("衡水市");
        provinceMap.put("河北省", hebei);

        // 山西省
        List<String> shanxi = new java.util.ArrayList<>();
        shanxi.add("太原市");
        shanxi.add("大同市");
        shanxi.add("阳泉市");
        shanxi.add("长治市");
        shanxi.add("晋城市");
        shanxi.add("朔州市");
        shanxi.add("晋中市");
        shanxi.add("运城市");
        shanxi.add("忻州市");
        shanxi.add("临汾市");
        shanxi.add("吕梁市");
        provinceMap.put("山西省", shanxi);

        // 辽宁省
        List<String> liaoning = new java.util.ArrayList<>();
        liaoning.add("沈阳市");
        liaoning.add("大连市");
        liaoning.add("鞍山市");
        liaoning.add("抚顺市");
        liaoning.add("本溪市");
        liaoning.add("丹东市");
        liaoning.add("锦州市");
        liaoning.add("营口市");
        liaoning.add("阜新市");
        liaoning.add("辽阳市");
        liaoning.add("盘锦市");
        liaoning.add("铁岭市");
        liaoning.add("朝阳市");
        liaoning.add("葫芦岛市");
        provinceMap.put("辽宁省", liaoning);

        // 吉林省
        List<String> jilin = new java.util.ArrayList<>();
        jilin.add("长春市");
        jilin.add("吉林市");
        jilin.add("四平市");
        jilin.add("辽源市");
        jilin.add("通化市");
        jilin.add("白山市");
        jilin.add("松原市");
        jilin.add("白城市");
        jilin.add("延边朝鲜族自治州");
        provinceMap.put("吉林省", jilin);

        // 黑龙江省
        List<String> heilongjiang = new java.util.ArrayList<>();
        heilongjiang.add("哈尔滨市");
        heilongjiang.add("齐齐哈尔市");
        heilongjiang.add("鸡西市");
        heilongjiang.add("鹤岗市");
        heilongjiang.add("双鸭山市");
        heilongjiang.add("大庆市");
        heilongjiang.add("伊春市");
        heilongjiang.add("佳木斯市");
        heilongjiang.add("七台河市");
        heilongjiang.add("牡丹江市");
        heilongjiang.add("黑河市");
        heilongjiang.add("绥化市");
        provinceMap.put("黑龙江省", heilongjiang);

        // 江苏省
        List<String> jiangsu = new java.util.ArrayList<>();
        jiangsu.add("南京市");
        jiangsu.add("无锡市");
        jiangsu.add("徐州市");
        jiangsu.add("常州市");
        jiangsu.add("苏州市");
        jiangsu.add("南通市");
        jiangsu.add("连云港市");
        jiangsu.add("淮安市");
        jiangsu.add("盐城市");
        jiangsu.add("扬州市");
        jiangsu.add("镇江市");
        jiangsu.add("泰州市");
        jiangsu.add("宿迁市");
        provinceMap.put("江苏省", jiangsu);

        // 浙江省
        List<String> zhejiang = new java.util.ArrayList<>();
        zhejiang.add("杭州市");
        zhejiang.add("宁波市");
        zhejiang.add("温州市");
        zhejiang.add("嘉兴市");
        zhejiang.add("湖州市");
        zhejiang.add("绍兴市");
        zhejiang.add("金华市");
        zhejiang.add("衢州市");
        zhejiang.add("舟山市");
        zhejiang.add("台州市");
        zhejiang.add("丽水市");
        provinceMap.put("浙江省", zhejiang);

        // 安徽省
        List<String> anhui = new java.util.ArrayList<>();
        anhui.add("合肥市");
        anhui.add("芜湖市");
        anhui.add("蚌埠市");
        anhui.add("淮南市");
        anhui.add("马鞍山市");
        anhui.add("淮北市");
        anhui.add("铜陵市");
        anhui.add("安庆市");
        anhui.add("黄山市");
        anhui.add("滁州市");
        anhui.add("阜阳市");
        anhui.add("宿州市");
        anhui.add("六安市");
        anhui.add("亳州市");
        anhui.add("池州市");
        anhui.add("宣城市");
        provinceMap.put("安徽省", anhui);

        // 福建省
        List<String> fujian = new java.util.ArrayList<>();
        fujian.add("福州市");
        fujian.add("厦门市");
        fujian.add("莆田市");
        fujian.add("三明市");
        fujian.add("泉州市");
        fujian.add("漳州市");
        fujian.add("南平市");
        fujian.add("龙岩市");
        fujian.add("宁德市");
        provinceMap.put("福建省", fujian);

        // 江西省
        List<String> jiangxi = new java.util.ArrayList<>();
        jiangxi.add("南昌市");
        jiangxi.add("景德镇市");
        jiangxi.add("萍乡市");
        jiangxi.add("九江市");
        jiangxi.add("新余市");
        jiangxi.add("鹰潭市");
        jiangxi.add("赣州市");
        jiangxi.add("吉安市");
        jiangxi.add("宜春市");
        jiangxi.add("抚州市");
        jiangxi.add("上饶市");
        provinceMap.put("江西省", jiangxi);

        // 山东省
        List<String> shandong = new java.util.ArrayList<>();
        shandong.add("济南市");
        shandong.add("青岛市");
        shandong.add("淄博市");
        shandong.add("枣庄市");
        shandong.add("东营市");
        shandong.add("烟台市");
        shandong.add("潍坊市");
        shandong.add("济宁市");
        shandong.add("泰安市");
        shandong.add("威海市");
        shandong.add("日照市");
        shandong.add("临沂市");
        shandong.add("德州市");
        shandong.add("聊城市");
        shandong.add("滨州市");
        shandong.add("菏泽市");
        provinceMap.put("山东省", shandong);

        // 河南省
        List<String> henan = new java.util.ArrayList<>();
        henan.add("郑州市");
        henan.add("开封市");
        henan.add("洛阳市");
        henan.add("平顶山市");
        henan.add("安阳市");
        henan.add("鹤壁市");
        henan.add("新乡市");
        henan.add("焦作市");
        henan.add("濮阳市");
        henan.add("许昌市");
        henan.add("漯河市");
        henan.add("三门峡市");
        henan.add("南阳市");
        henan.add("商丘市");
        henan.add("信阳市");
        henan.add("周口市");
        henan.add("驻马店市");
        henan.add("济源市");
        provinceMap.put("河南省", henan);

        // 湖北省
        List<String> hubei = new java.util.ArrayList<>();
        hubei.add("武汉市");
        hubei.add("黄石市");
        hubei.add("十堰市");
        hubei.add("宜昌市");
        hubei.add("襄阳市");
        hubei.add("鄂州市");
        hubei.add("荆门市");
        hubei.add("孝感市");
        hubei.add("荆州市");
        hubei.add("黄冈市");
        hubei.add("咸宁市");
        hubei.add("随州市");
        hubei.add("恩施土家族苗族自治州");
        provinceMap.put("湖北省", hubei);

        // 湖南省
        List<String> hunan = new java.util.ArrayList<>();
        hunan.add("长沙市");
        hunan.add("株洲市");
        hunan.add("湘潭市");
        hunan.add("衡阳市");
        hunan.add("邵阳市");
        hunan.add("岳阳市");
        hunan.add("常德市");
        hunan.add("张家界市");
        hunan.add("益阳市");
        hunan.add("郴州市");
        hunan.add("永州市");
        hunan.add("怀化市");
        hunan.add("娄底市");
        hunan.add("湘西土家族苗族自治州");
        provinceMap.put("湖南省", hunan);

        // 广东省
        List<String> guangdong = new java.util.ArrayList<>();
        guangdong.add("广州市");
        guangdong.add("韶关市");
        guangdong.add("深圳市");
        guangdong.add("珠海市");
        guangdong.add("汕头市");
        guangdong.add("佛山市");
        guangdong.add("江门市");
        guangdong.add("湛江市");
        guangdong.add("茂名市");
        guangdong.add("肇庆市");
        guangdong.add("惠州市");
        guangdong.add("梅州市");
        guangdong.add("汕尾市");
        guangdong.add("河源市");
        guangdong.add("阳江市");
        guangdong.add("清远市");
        guangdong.add("东莞市");
        guangdong.add("中山市");
        guangdong.add("潮州市");
        guangdong.add("揭阳市");
        guangdong.add("云浮市");
        provinceMap.put("广东省", guangdong);

        // 海南省
        List<String> hainan = new java.util.ArrayList<>();
        hainan.add("海口市");
        hainan.add("三亚市");
        hainan.add("三沙市");
        hainan.add("儋州市");
        provinceMap.put("海南省", hainan);

        // 四川省
        List<String> sichuan = new java.util.ArrayList<>();
        sichuan.add("成都市");
        sichuan.add("自贡市");
        sichuan.add("攀枝花市");
        sichuan.add("泸州市");
        sichuan.add("德阳市");
        sichuan.add("绵阳市");
        sichuan.add("广元市");
        sichuan.add("遂宁市");
        sichuan.add("内江市");
        sichuan.add("乐山市");
        sichuan.add("南充市");
        sichuan.add("眉山市");
        sichuan.add("宜宾市");
        sichuan.add("广安市");
        sichuan.add("达州市");
        sichuan.add("雅安市");
        sichuan.add("巴中市");
        sichuan.add("资阳市");
        sichuan.add("阿坝藏族羌族自治州");
        sichuan.add("甘孜藏族自治州");
        sichuan.add("凉山彝族自治州");
        provinceMap.put("四川省", sichuan);

        // 贵州省
        List<String> guizhou = new java.util.ArrayList<>();
        guizhou.add("贵阳市");
        guizhou.add("六盘水市");
        guizhou.add("遵义市");
        guizhou.add("安顺市");
        guizhou.add("毕节市");
        guizhou.add("铜仁市");
        guizhou.add("黔西南布依族苗族自治州");
        guizhou.add("黔东南苗族侗族自治州");
        guizhou.add("黔南布依族苗族自治州");
        provinceMap.put("贵州省", guizhou);

        // 云南省
        List<String> yunnan = new java.util.ArrayList<>();
        yunnan.add("昆明市");
        yunnan.add("曲靖市");
        yunnan.add("玉溪市");
        yunnan.add("保山市");
        yunnan.add("昭通市");
        yunnan.add("丽江市");
        yunnan.add("普洱市");
        yunnan.add("临沧市");
        yunnan.add("楚雄彝族自治州");
        yunnan.add("红河哈尼族彝族自治州");
        yunnan.add("文山壮族苗族自治州");
        yunnan.add("西双版纳傣族自治州");
        yunnan.add("大理白族自治州");
        yunnan.add("德宏傣族景颇族自治州");
        yunnan.add("怒江傈僳族自治州");
        yunnan.add("迪庆藏族自治州");
        provinceMap.put("云南省", yunnan);

        // 陕西省
        List<String> shaanxi = new java.util.ArrayList<>();
        shaanxi.add("西安市");
        shaanxi.add("铜川市");
        shaanxi.add("宝鸡市");
        shaanxi.add("咸阳市");
        shaanxi.add("渭南市");
        shaanxi.add("延安市");
        shaanxi.add("汉中市");
        shaanxi.add("榆林市");
        shaanxi.add("安康市");
        shaanxi.add("商洛市");
        provinceMap.put("陕西省", shaanxi);

        // 甘肃省
        List<String> gansu = new java.util.ArrayList<>();
        gansu.add("兰州市");
        gansu.add("嘉峪关市");
        gansu.add("金昌市");
        gansu.add("白银市");
        gansu.add("天水市");
        gansu.add("武威市");
        gansu.add("张掖市");
        gansu.add("平凉市");
        gansu.add("酒泉市");
        gansu.add("庆阳市");
        gansu.add("定西市");
        gansu.add("陇南市");
        gansu.add("临夏回族自治州");
        gansu.add("甘南藏族自治州");
        provinceMap.put("甘肃省", gansu);

        // 青海省
        List<String> qinghai = new java.util.ArrayList<>();
        qinghai.add("西宁市");
        qinghai.add("海东市");
        qinghai.add("海北藏族自治州");
        qinghai.add("黄南藏族自治州");
        qinghai.add("海南藏族自治州");
        qinghai.add("果洛藏族自治州");
        qinghai.add("玉树藏族自治州");
        qinghai.add("海西蒙古族藏族自治州");
        provinceMap.put("青海省", qinghai);

        // 台湾省
        List<String> taiwan = new java.util.ArrayList<>();
        taiwan.add("台北市");
        taiwan.add("新北市");
        taiwan.add("桃园市");
        taiwan.add("台中市");
        taiwan.add("台南市");
        taiwan.add("高雄市");
        taiwan.add("基隆市");
        taiwan.add("新竹市");
        taiwan.add("嘉义市");
        provinceMap.put("台湾省", taiwan);

        // ===== 自治区 =====
        // 内蒙古自治区
        List<String> neimenggu = new java.util.ArrayList<>();
        neimenggu.add("呼和浩特市");
        neimenggu.add("包头市");
        neimenggu.add("乌海市");
        neimenggu.add("赤峰市");
        neimenggu.add("通辽市");
        neimenggu.add("鄂尔多斯市");
        neimenggu.add("呼伦贝尔市");
        neimenggu.add("巴彦淖尔市");
        neimenggu.add("乌兰察布市");
        neimenggu.add("兴安盟");
        neimenggu.add("锡林郭勒盟");
        neimenggu.add("阿拉善盟");
        provinceMap.put("内蒙古自治区", neimenggu);

        // 广西壮族自治区
        List<String> guangxi = new java.util.ArrayList<>();
        guangxi.add("南宁市");
        guangxi.add("柳州市");
        guangxi.add("桂林市");
        guangxi.add("梧州市");
        guangxi.add("北海市");
        guangxi.add("防城港市");
        guangxi.add("钦州市");
        guangxi.add("贵港市");
        guangxi.add("玉林市");
        guangxi.add("百色市");
        guangxi.add("贺州市");
        guangxi.add("河池市");
        guangxi.add("来宾市");
        guangxi.add("崇左市");
        provinceMap.put("广西壮族自治区", guangxi);

        // 西藏自治区
        List<String> xizang = new java.util.ArrayList<>();
        xizang.add("拉萨市");
        xizang.add("日喀则市");
        xizang.add("昌都市");
        xizang.add("林芝市");
        xizang.add("山南市");
        xizang.add("那曲市");
        xizang.add("阿里地区");
        provinceMap.put("西藏自治区", xizang);

        // 宁夏回族自治区
        List<String> ningxia = new java.util.ArrayList<>();
        ningxia.add("银川市");
        ningxia.add("石嘴山市");
        ningxia.add("吴忠市");
        ningxia.add("固原市");
        ningxia.add("中卫市");
        provinceMap.put("宁夏回族自治区", ningxia);

        // 新疆维吾尔自治区
        List<String> xinjiang = new java.util.ArrayList<>();
        xinjiang.add("乌鲁木齐市");
        xinjiang.add("克拉玛依市");
        xinjiang.add("吐鲁番市");
        xinjiang.add("哈密市");
        xinjiang.add("昌吉回族自治州");
        xinjiang.add("博尔塔拉蒙古自治州");
        xinjiang.add("巴音郭楞蒙古自治州");
        xinjiang.add("阿克苏地区");
        xinjiang.add("克孜勒苏柯尔克孜自治州");
        xinjiang.add("喀什地区");
        xinjiang.add("和田地区");
        xinjiang.add("伊犁哈萨克自治州");
        xinjiang.add("塔城地区");
        xinjiang.add("阿勒泰地区");
        provinceMap.put("新疆维吾尔自治区", xinjiang);

        // ===== 特别行政区(占位) =====
        List<String> xianggang = new java.util.ArrayList<>();
        xianggang.add("全境");
        provinceMap.put("香港特别行政区", xianggang);

        List<String> aomen = new java.util.ArrayList<>();
        aomen.add("全境");
        provinceMap.put("澳门特别行政区", aomen);

        return provinceMap;
    }
}
