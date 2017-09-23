package org.king.algorithms.jversion.find;

public interface ST<Key extends Comparable<?>, Value> {
    // ST() 创建一张有序符号表
    void put(Key key, Value val);// 将键值对存入表中（若值为空则将键 key 从表中删除）

    Value get(Key key);// 获取键 key 对应的值（若键 key 不存在则返回空）

    void delete(Key key);// 从表中删去键 key（及其对应的值）

    boolean contains(Key key);// 键 key 是否存在于表中

    boolean isEmpty();// 表是否为空

    int size();// 表中的键值对数量

    Key min();// 最小的键

    Key max();// 最大的键

    Key floor(Key key);// 小于等于 key 的最大键

    Key ceiling(Key key);// 大于等于 key 的最小键

    int rank(Key key);// 小于 key 的键的数量

    Key select(int k);// 排名为 k 的键

    void deleteMin();// 删除最小的键

    void deleteMax();// 删除最大的键

    int size(Key lo, Key hi);// [lo..hi] 之间键的数量

    Iterable<Key> keys(Key lo, Key hi);// [lo..hi] 之间的所有键，已排序

    Iterable<Key> keys();//

}
