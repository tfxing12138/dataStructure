package com.tfxing.dataStructure.entity.rbTree;

import com.tfxing.dataStructure.enums.rbTree.RBTreeColorEnum;
import lombok.Data;

/**
 * @author :tanfuxing
 * @date :2023/1/10
 * @description :
 */
@Data
public class TreeNode<T> {
    
    private Boolean color;
    
    private T value;
    
    //父节点
    private TreeNode<T> parent;
    
    //左子树
    private TreeNode<T> left;
    
    //右子树
    private TreeNode<T> right;

    public TreeNode(T t,boolean color) {
        this.value = t;
        this.color = color;
    }
    
    public int getHashCode() {
        return value.hashCode();
    }

    /**
     * 比较器
     * this>treeNode，返回1
     * this<treeNode，返回-1
     * this=treeNode，返回0
     * @param treeNode
     * @return
     */
    public int compare(TreeNode<T> treeNode) {
        if(this.getHashCode()> treeNode.getHashCode()) {
            return 1;
        } else if(this.getHashCode()< treeNode.getHashCode()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public String toString() {
        String result = "{\"value\":\"%s\", \n \"color\":\"%s\", \n \"left\":%s, \n \"right\":%s}";
        result = String.format(result,this.value, RBTreeColorEnum.getDescByKey(this.color),getToString(this.left),getToString(this.right));
        return result;
    }

    /**
     * 返回toString字符串
     * @param treeNode
     * @return
     */
    private String getToString(TreeNode<T> treeNode) {
        return null == treeNode ? null : treeNode.toString();
    }
}
