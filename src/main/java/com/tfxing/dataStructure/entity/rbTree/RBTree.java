package com.tfxing.dataStructure.entity.rbTree;

import com.tfxing.dataStructure.enums.rbTree.RBTreeColorEnum;
import lombok.Data;

/**
 * @author :tanfuxing
 * @date :2023/1/10
 * @description :
 */
@Data
public class RBTree<T> {
    
    //根节点
    private TreeNode<T> root;
    
    public RBTree() {}

    /**
     * 插入元素
     * @param t
     */
    public void add(T t) {
        TreeNode<T> currentNode = createTreeNode(t);
        insertTree(currentNode,this.root);
        
    }

    /**
     * 插入树节点
     * @param currentNode
     */
    private void insertTree(TreeNode<T> currentNode, TreeNode treeNode) {
        
        if(isNull(treeNode)) {
            if(isNull(this.root)) {
                this.root = currentNode;
            } else {
                TreeNode<T> parentNode = currentNode.getParent();
                if(parentNode.compare(currentNode) > 0) {
                    parentNode.setLeft(currentNode);
                } else {
                    parentNode.setRight(currentNode);
                }
            }
            //树修复
            treeFixHandle(currentNode);
            return;
        }
        
        currentNode.setParent(treeNode);
        if(currentNode.compare(treeNode) < 0) {
            insertTree(currentNode,treeNode.getLeft());
        } else if(currentNode.compare(treeNode) > 0){
            insertTree(currentNode,treeNode.getRight());
        } else {
            return;
        }
        
    }

    /**
     * 对象是否为空
     * @param t
     * @return
     */
    private <T> boolean isNull(T t) {
        return null == t;
    }

    /**
     * 树修复
     * @param currentNode
     */
    private void treeFixHandle(TreeNode<T> currentNode) {
        if(isRoot(currentNode)) {
            colorChangeHandle(currentNode, RBTreeColorEnum.BLACK.getKey());
        } else if(isRed(currentNode.getParent())) {
            TreeNode<T> parentNode = currentNode.getParent();
            TreeNode<T> grandPaNode = parentNode.getParent();
            TreeNode<T> uncleNode = getUncleNode(currentNode);
            //父节点和叔叔节点都为红色
            if(isRed(parentNode) && isRed(uncleNode)) {
                colorChangeHandle(parentNode,RBTreeColorEnum.BLACK.getKey());
                colorChangeHandle(uncleNode,RBTreeColorEnum.BLACK.getKey());
                colorChangeHandle(grandPaNode,RBTreeColorEnum.RED.getKey());
                treeFixHandle(grandPaNode);
            } else { //父节点为红色，叔叔节点为黑色
                if(isLeftNode(currentNode)) {
                    if(isLeftNode(parentNode)) { //LL双红
                        colorChangeHandle(parentNode,RBTreeColorEnum.BLACK.getKey());
                        colorChangeHandle(grandPaNode,RBTreeColorEnum.RED.getKey());
                        rightRotation(grandPaNode);
                    } else { //RL双红
                        rightRotation(parentNode);
                        treeFixHandle(parentNode);
                    }
                } else { 
                    if(isRightNode(parentNode)) { //RR双红
                        colorChangeHandle(parentNode,RBTreeColorEnum.BLACK.getKey());
                        colorChangeHandle(grandPaNode,RBTreeColorEnum.RED.getKey());
                        leftRotation(grandPaNode);
                    } else { //LR双红
                        leftRotation(parentNode);
                        treeFixHandle(parentNode);
                    }
                }
            }
        }
    }

    /**
     * 当前节点是否为右子节点
     * @param currentNode
     * @return
     */
    private boolean isRightNode(TreeNode<T> currentNode) {
        TreeNode<T> parentNode = currentNode.getParent();
        return parentNode.getRight() == currentNode;
    }

    /**
     * 当前节点是否为红色
     * @param currentNode
     * @return
     */
    private boolean isRed(TreeNode<T> currentNode) {
        //如果为空，则为黑色
        if(isNull(currentNode)) return false;
        return !currentNode.getColor();
    }

    /**
     * 变色：指定颜色
     * @param currentNode
     * @param color
     */
    private void colorChangeHandle(TreeNode<T> currentNode, boolean color) {
        currentNode.setColor(color);
    }

    /**
     * 获取当前节点的叔叔节点
     * @param currentNode
     * @return
     */
    private TreeNode<T> getUncleNode(TreeNode<T> currentNode) {
        TreeNode<T> parentNode = currentNode.getParent();
        TreeNode<T> grandPaNode = parentNode.getParent();
        TreeNode<T> uncleNode = isLeftNode(parentNode) ? grandPaNode.getRight() : grandPaNode.getLeft();
        return uncleNode;
    }

    /**
     * 右旋
     * @param currentNode
     */
    private void rightRotation(TreeNode<T> currentNode) {
        TreeNode<T> parentNode = currentNode.getParent();
        TreeNode<T> leftNode = currentNode.getLeft();
        TreeNode<T> leftRightNode = leftNode.getRight();
        if (!isNull(parentNode)) {
            if(isLeftNode(currentNode)) {
                parentNode.setLeft(leftNode);
            } else {
                parentNode.setRight(leftNode);
            }
        }
        leftNode.setParent(parentNode);
        leftNode.setRight(currentNode);
        currentNode.setParent(leftNode);
        currentNode.setLeft(leftRightNode);
        
        if(isRoot(currentNode)) {
            this.root = leftNode;
        }
    }

    /**
     * 左旋
     * @param currentNode
     */
    private void leftRotation(TreeNode<T> currentNode) {
        TreeNode<T> parentNode = currentNode.getParent();
        TreeNode<T> rightNode = currentNode.getRight();
        TreeNode<T> rightLeftNode = rightNode.getLeft();
        if(!isNull(parentNode)) {
            if(isLeftNode(currentNode)) {
                parentNode.setLeft(rightNode);
            } else {
                parentNode.setRight(rightNode);
            }
        }
        rightNode.setParent(parentNode);
        rightNode.setLeft(currentNode);
        currentNode.setParent(rightNode);
        currentNode.setRight(rightLeftNode);
        
        if(isRoot(currentNode)) {
            this.root = rightNode;
        }
    }

    /**
     * 当前节点是否为左子节点
     * @param currentNode
     * @return
     */
    private boolean isLeftNode(TreeNode<T> currentNode) {
        TreeNode<T> parentNode = currentNode.getParent();
        return parentNode.getLeft() == currentNode;
    }
    

    /**
     * 是否是根节点
     * @param currentNode
     * @return
     */
    private boolean isRoot(TreeNode<T> currentNode) {
        return this.root == currentNode;
    }

    /**
     * 创建树节点
     * @param t
     * @return
     */
    private TreeNode<T> createTreeNode(T t) {
        return new TreeNode<>(t, RBTreeColorEnum.RED.getKey());
    }
    
    public String toString() {
        return this.root.toString();
    }
}
