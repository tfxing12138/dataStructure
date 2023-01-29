package com.tfxing.dataStructure.entity.linkedList;

import lombok.Data;

/**
 * @author :tanfuxing
 * @date :2023/1/10
 * @description :
 */
@Data
public class LinkedListNode<T> {
    
    private T value;
    
    //左节点
    private LinkedListNode<T> left;
    
    //右节点
    private LinkedListNode<T> right;

    public LinkedListNode(T t) {
        this.value = t;
    }
 

    public String toString() {
        String result = "{\"value\":\"%s\", \n \"right\":%s}";
        result = String.format(result,this.value, getToString(this.right));
        return result;
    }

    /**
     * 返回toString字符串
     * @param treeNode
     * @return
     */
    private String getToString(LinkedListNode<T> treeNode) {
        return null == treeNode ? null : treeNode.toString();
    }
}
