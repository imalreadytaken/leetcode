package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 Design a data structure to support Insert/Remove/getRandom in O(1) time

 bool insert(int val)

 bool remove(int val)

 int getRandom()

 为了实现O(1)的删除复杂度，用一个哈希map和arraylist去维护，
 insert时向list尾部添加，remove时从头部删除
 哈希map负责维护元素对应的索引，实现O(1)的查找

 */
public class PinduoduoFirstInterview {



    public class MMap{

        private HashMap<Integer, Integer> map;
        private ArrayList<Integer> list;
        private Random r;

        public MMap(){
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
            this.r = new Random();
        }

        public boolean insert(int val){
            // 判断是否存在
            if(map.containsKey(val))
                return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val){
            // 判断是否存在
            if(!map.containsKey(val))
                return false;
            int cur = map.get(val);
            map.put(list.get(0), cur);
            list.set(cur, list.get(0));
            map.remove(val);
            list.remove(0);
            return true;
        }

        public int getRandom(){
            int a = r.nextInt(list.size());
            return list.get(a);
        }

    }

}
