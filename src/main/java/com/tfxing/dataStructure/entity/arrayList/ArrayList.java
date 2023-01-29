package com.tfxing.dataStructure.entity.arrayList;

import lombok.Data;

import java.util.StringJoiner;

import static java.util.Objects.isNull;

/**
 * @author :tanfuxing
 * @date :2023/1/29
 * @description :
 */
@Data
public class ArrayList<T> {

    /**
     * 列表长度
     */
    private Integer size = 0;

    /**
     * 容量
     */
    private Integer capacity = 10;
    
    Object[] array = new Object[capacity];

    /**
     * 添加
     * @param t
     */
    public void add(T t) {
        if(isFull()) {
            enlarge();
        }
        if(isEmpty(array))size++;
        array[size] = t;
    }

    /**
     * 是否为空
     * @param array
     * @return
     */
    private boolean isEmpty(Object[] array) {
        return null == array[0];
    }

    /**
     * 扩容
     */
    private void enlarge() {
        capacity = Math.toIntExact(Math.round(capacity * 1.5));
        Object[] tempArray = new Object[capacity];
        copy(array,tempArray);
        array = tempArray;
    }

    /**
     * 复制
     * @param array
     * @param tempArray
     */
    private void copy(Object[] array, Object[] tempArray) {
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
    }

    /**
     * 容量是否已满
     * @return
     */
    private boolean isFull() {
        return size < capacity;
    }

    /**
     * 删除
     * @param index
     */
    public void remove(int index) {
        //校验是否下标越界
        checkOutFlow(index);
        //压缩整理
        compress(index);
        size--;
    }

    /**
     * 检测是否下标越界
     * @param index
     */
    private void checkOutFlow(int index) {
        if(index >= size || index < 0) {
            String message = "ArrayIndexOutOfBoundsException,size:%s,index:%s";
            message = String.format(message,size,index);
            throw new RuntimeException(message);
        }
    }

    /**
     * 压缩整理
     * @param index
     */
    private void compress(int index) {
        if(index == size) {
            array[index+1] = null;
        }
        for (Integer i = index+1; i < size; i++) {
            array[i] = array[i+1];
            array[i+1] = null;
        }
    }
    
    public String toString() {
        StringJoiner str = new StringJoiner(",");
        for (Object o : array) {
            if(isNull(o)) {
                continue;
            }
            str.add(o.toString());
        }
        return "["+str+"]";
    }
}
