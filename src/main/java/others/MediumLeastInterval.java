package others;

import java.util.*;

/**
 * Task Scheduler
 * <p>
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 */
public class MediumLeastInterval {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B','C','D'};
        System.out.println(leastInterval(tasks, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        /**ideaI
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : tasks) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        return minTime(entries, n);*/

        /**ideaII
        int[] chCount = new int[26];
        int max = 0;
        int maxCount = 0;
        for (Character ch : tasks) {
            chCount[ch - 'A']++;
            if (max==chCount[ch - 'A']) {
                maxCount++;
            } else if (max<chCount[ch - 'A']) {
                max = chCount[ch - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;*/

        /**ideaIII*/
        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);

    }

    private static int minTime(List<Map.Entry<Character, Integer>> entries, int n) {
        if (entries.isEmpty()) return 0;
        entries.sort((a, b) -> b.getValue() - a.getValue());
        int count = 0;
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (count > n) {
                break;
            }
            entry.setValue(entry.getValue() - 1);
            if (entry.getValue() == 0) {
                iterator.remove();
            }
            count++;
        }
        return entries.isEmpty() ? count : n + 1 + minTime(entries, n);
    }

}

