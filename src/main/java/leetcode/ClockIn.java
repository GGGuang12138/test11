package leetcode;

import java.util.*;

/**
 * 打卡
 *
 * @author: Alan
 * @since: 2023/3/22 22:36
 */
public class ClockIn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 工号个数
        int numCount = scanner.nextInt();
        HashMap<String, Integer[]> map = new HashMap<>(numCount);
        String line = "";
        if (scanner.hasNext()) {
            scanner.nextLine();
            line = scanner.nextLine();
        }
        // 每天打卡人数
        String[] everyDayCount = line.split(" ");
        // 天数
        int days = everyDayCount.length;
        // 遍历统计每天打卡的信息
        while (days > 0) {
            String currStr = scanner.nextLine();
            String[] nums = currStr.split(" ");
            for (String num : nums) {
                if (map.containsKey(num)) {
                    // 已经存在进行累计
                    Integer[] orderAndCount = map.get(num);
                    orderAndCount[1]++;
                } else {
                    // 不存在，保存第一天打卡时间、记录一次
                    map.put(num, new Integer[]{days, 1});
                }
            }
            days--;
        }

        // 排序
        List<Map.Entry<String, Integer[]>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer[]>>() {
            @Override
            public int compare(Map.Entry<String, Integer[]> t1, Map.Entry<String, Integer[]> t2) {
                if (t1.getValue()[1].equals(t2.getValue()[1])) {
                    // 天数从大到小排
                    return t2.getValue()[0].compareTo(t1.getValue()[0]);
                }
                // 个数从大到小排
                return t2.getValue()[1].compareTo(t1.getValue()[1]);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            if (i == 5) {
                break;
            }
            Map.Entry<String, Integer[]> entry = list.get(i);
            System.out.println(entry.getKey());

        }
    }

}
