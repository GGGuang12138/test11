package leetcode.meeting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alan
 * @Description
 * @date 2024.04.02 20:01
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll("\\[", "").replaceAll("\\]", "");
        String[] inputArray = input.split(",");
        int[][] meetings = new int[inputArray.length / 2][2];

        for (int i = 0; i < inputArray.length; i += 2) {
            int start = Integer.parseInt(inputArray[i]);
            int end = Integer.parseInt(inputArray[i + 1]);
            meetings[i / 2] = new int[]{start, end};
        }

        int[][] mergedMeetings = merge(meetings);

        System.out.print("[");
        for (int i = 0; i < mergedMeetings.length; i++) {
            int[] time = mergedMeetings[i];
            System.out.print("[" + time[0] + "," + time[1] + "]");
            if (i < mergedMeetings.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");


    }



    private static int[][] merge(int[][] roomTimes) {
        List<int[]> timeList = new ArrayList<>();
        for (int[] roomTime : roomTimes) {
            timeList.add(roomTime);
            timeList.sort(Comparator.comparingInt(o -> o[0]));
        }
        List<int[]> result = new ArrayList<>();
        for (int[] curr : timeList) {
            // 第一个时间
            if (result.isEmpty()) {
                result.add(curr);
                continue;
            }
            // 第二个起
            int[] last = result.get(result.size() - 1);
            if (last[1] < curr[0]) {
                result.add(curr);
            } else {
                last[1] = Math.max(last[1], curr[1]);
            }
        }
        return result.toArray(new int[0][]);

    }



}

