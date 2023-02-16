package Array;

import java.util.*;

public class Q380_InsertDeleteGetRandomO1 {

    List<Integer> list;
    Map<Integer, Integer> map;    // (value, order)
    Random random;

    public Q380_InsertDeleteGetRandomO1() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        // 如果Map中存在该值, 则返回false
        if(map.containsKey(val)){
            return false;
        }

        list.add(val);
        // 将值存入Map, 键是存入的val, 值是在list中的位置
        map.put(val, list.size() - 1);
        return true;
    }

    // 先将需要删除的元素和最后一个元素交换, 然后删除最后一个元素
    public boolean remove(int val) {
        // 如果Map中不存在该值, 则返回false
        if(!map.containsKey(val)){
            return false;
        }

        // 得到删除元素在list中的位置
        int idx = map.get(val);
        // 得到最后一个元素
        int last = list.get(list.size() - 1);
        // 1.将当前元素和最后一个元素交换
        list.set(idx, last);
        map.put(last, idx);    // 更新最后一个元素的位置
        // 2.删除最后一个元素
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        Q380_InsertDeleteGetRandomO1 insertDeleteGetRandom = new Q380_InsertDeleteGetRandomO1();

        insertDeleteGetRandom.insert(10);
        insertDeleteGetRandom.insert(20);
        insertDeleteGetRandom.insert(30);
        insertDeleteGetRandom.insert(40);
        insertDeleteGetRandom.remove(10);

        System.out.println(insertDeleteGetRandom.list);
    }

}
