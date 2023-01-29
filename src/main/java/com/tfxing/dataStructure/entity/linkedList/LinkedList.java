package com.tfxing.dataStructure.entity.linkedList;

import lombok.Data;

/**
 * @author :tanfuxing
 * @date :2023/1/12
 * @description : 链表
 */
@Data
public class LinkedList<T> {
    
    private LinkedListNode root;
    
    private int size;

    /**
     * 返回列表长度
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 添加
     * @param t
     */
    public void add(T t) {
        LinkedListNode<T> linkedListNode = createLinkedListNode(t);
        if(isNull(this.root)) {
            this.root = linkedListNode;
        } else {
            LinkedListNode<T> finalNode = getFinalNode(root);
            finalNode.setRight(linkedListNode);
            linkedListNode.setLeft(finalNode);
        }
        size++;
    }

    /**
     * 按元素删除
     * @param t
     */
    public boolean remove(T t) {
        LinkedListNode<T> node = getOrderNode(t);
        if(isNull(node)) {
            return false;
        }
        if(isSameNode(this.root,t)) {
            this.root = this.root.getRight();
            this.root.setLeft(null);
            return true;
        }
        LinkedListNode<T> left = node.getLeft();
        LinkedListNode<T> right = node.getRight();
        if(!isNull(left)) {
            left.setRight(right);
        }
        if(!isNull(right)) {
            right.setLeft(left);
        }
        size--;
        return true;
    }

    /**
     * 修改
     * @param t
     * @param index
     * @return
     */
    public boolean update(int index, T t) {
        LinkedListNode<T> orderNode = getOrderNode(index);
        if(isNull(orderNode)) {
            return false;
        }
        orderNode.setValue(t);
        return true;
    }
    
    /**
     * 查询
     * @param index
     * @return
     */
    public LinkedListNode<T> get(int index) {
        return getOrderNode(index);
    }
    

    /**
     * 获取目标节点
     * @param t
     * @return
     */
    private LinkedListNode<T> getOrderNode(T t) {
        return getOrderNode(t,this.root);
    }

    /**
     * 获取目标节点
     * @param t
     * @return
     */
    private LinkedListNode<T> getOrderNode(T t, LinkedListNode<T> node) {
        if(isSameNode(node,t)) {
            return node;
        } else {
            return getOrderNode(t, node.getRight());
        }
    }

    /**
     * t是否为node节点
     * @param t
     * @return
     */
    private boolean isSameNode(LinkedListNode<T> node, T t) {
        return node.getValue() == t;
    }

    /**
     * 按下标删除
     * @param index
     */
    public boolean remove(int index) {
        LinkedListNode<T> node = getOrderNode(index);
        if(isNull(node)) {
            return false;
        }
        
        if(this.root == node) {
            this.root = this.root.getRight();
            this.root.setLeft(null);
            return true;
        }
        
        LinkedListNode<T> left = node.getLeft();
        LinkedListNode<T> right = node.getRight();
        if(!isNull(left)) {
            left.setRight(right);
        }
        if(!isNull(right)) {
            right.setLeft(left);
        }
        size--;
        return true;
    }

    /**
     * 按下标获取节点
     * @param index
     * @return
     */
    private LinkedListNode<T> getOrderNode(int index) {
        LinkedListNode<T> node = null;
        if(index < 0) {
            return node;
        }
        LinkedListNode nextNode = this.root;
        for (int i = 0; i < index; i++) {
            if(isNull(nextNode)) {
               return node; 
            } else {
                node = getNextNode(nextNode);
            }
        }
        return node;
    }

    /**
     * 获取下一个节点
     * @param node
     * @return
     */
    private LinkedListNode getNextNode(LinkedListNode node) {
        if(isNull(node)) {
            return null;
        }
        return node.getRight();
    }

    /**
     * 创建节点
     * @param t
     * @return
     */
    private LinkedListNode<T> createLinkedListNode(T t) {
        return new LinkedListNode<T>(t);
    }

    /**
     * 获取最后一个节点
     * @return
     */
    private LinkedListNode<T> getFinalNode(LinkedListNode<T> node) {
        LinkedListNode right = node.getRight();
        if(isNull(right)) {
            return node;
        } else {
            return getFinalNode(right);
        }
    }

    private <T> boolean isNull(T t) {
        return null == t;
    }
    
    public String toString() {
        return this.root.toString();
    }
    
}
