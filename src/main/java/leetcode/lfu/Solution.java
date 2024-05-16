package leetcode.lfu;

import java.util.*;

/**
 * @author Alan
 * @Description
 * @date 2024.05.15 19:58
 */
public class Solution {

    private Map<Integer, Node> mp = new HashMap<>();

    private Map<Integer, LinkedList<Node>> freMp = new HashMap<>();

    private int capacity;

    private int freMin;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] operators = {{1,1,1},{1,2,2},{1,3,2},{1,2,4},{1,3,5},{2,2},{1,4,4},{2,1}};
        int[] lfu = solution.LFU(operators, 3);
        System.out.println(Arrays.toString(lfu));
    }

    public int[] LFU (int[][] operators, int k) {
        // write code here
        this.capacity = k;
        List<Integer> list = new ArrayList<>();
        for(int[] operator : operators){
            if (operator[0] == 1){
                set(operator[1], operator[2]);
            }else {
                list.add(get(operator[1]));
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public void set(int key, int value) {
        if (mp.containsKey(key)) {
            updateNode(mp.get(key), value);
        }else {
            // 队列已满情况，进行移除
            if (mp.size() == capacity){
                Node removeNode = freMp.get(freMin).getLast();
                // 频率mp
                freMp.get(freMin).removeLast();
                if (freMp.get(freMin).isEmpty()){
                    freMp.remove(freMin);
                }
                // mp
                mp.remove(removeNode.key);
            }
            // 频率mp进行插入
            freMin = 1;
            if (!freMp.containsKey(freMin)){
                freMp.put(freMin, new LinkedList<>());
            }
            Node newNode = new Node(freMin, key, value);
            freMp.get(freMin).addFirst(newNode);
            // mp进行插入
            mp.put(key, newNode);
        }
    }

    public int get(int key) {
        if (!mp.containsKey(key)){
            return -1;
        }
        Node node = mp.get(key);
        updateNode(node, node.val);
        return node.val;
    }

    public void updateNode(Node oldNode, int newValue) {
        int fre = oldNode.fre;
        // 频率Mp移除老节点
        freMp.get(fre).remove(oldNode);
        if (freMp.get(fre).isEmpty()) {
            // 当前频率不存在任何节点了
            freMp.remove(fre);
            if (fre == freMin) {
                freMin++;
            }
        }
        // 创建新节点
        int key = oldNode.key;
        Node newNode = new Node(fre + 1, key, newValue);
        // mp进行覆盖
        mp.put(key,newNode);
        // 频率+1,频率Mp新增节点
        if (!freMp.containsKey(fre+1)){
            freMp.put(fre+1, new LinkedList<>());
        }
        freMp.get(fre+1).addFirst(newNode);

    }
    static class Node {
        int key;
        int val;
        int fre;

        public Node(int fre, int key, int val) {
            this.fre = fre;
            this.key = key;
            this.val = val;
        }
    }

}