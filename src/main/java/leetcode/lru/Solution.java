package leetcode.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 描述
 * 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 capacity ，操作次数是 n ，并有如下功能:
 * 1. Solution(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * 2. get(key)：如果关键字 key 存在于缓存中，则返回key对应的value值，否则返回 -1 。
 * 3. set(key, value)：将记录(key, value)插入该结构，如果关键字 key 已经存在，则变更其数据值 value，如果不存在，则向缓存中插入该组 key-value ，如果key-value的数量超过capacity，弹出最久未使用的key-value
 *
 * 提示:
 * 1.某个key的set或get操作一旦发生，则认为这个key的记录成了最常使用的，然后都会刷新缓存。
 * 2.当缓存的大小超过capacity时，移除最不经常使用的记录。
 * 3.返回的value都以字符串形式表达，如果是set，则会输出"null"来表示(不需要用户返回，系统会自动输出)，方便观察
 * 4.函数set和get必须以O(1)的方式运行
 * 5.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
 *
 * @author Alan
 * @Description
 * @date 2024.05.08 11:40
 */
public class Solution {

    private final Map<Integer,Node> map;
    private final int capacity;
    private final Node head;
    private final Node tail;

    public Solution(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        moveToHead(node);
        return node.val;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node == null){
            node = new Node(key, value);
            map.put(key, node);
            if (map.size() > capacity){
                removeLast();
            }
            addFirst(node);
        }else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node){
        if (node.pre == head){
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addFirst(node);

    }

    private void addFirst(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeLast(){
        map.remove(tail.pre.key);
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }

    static class Node{
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
