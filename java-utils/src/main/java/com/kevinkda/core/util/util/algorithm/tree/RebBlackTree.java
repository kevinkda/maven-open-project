/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.algorithm.tree;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;

/**
 * 红黑树
 *
 * @author Kevin KDA on 2020/10/13 16:35
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.algorithm.tree
 * @classname RebBlackTree
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public class RebBlackTree<T> implements Comparable<T> {
    /**
     * 数据根结点
     *
     * @since 1.0.0
     */
    private Node root;
    /**
     * 保存数据个数
     *
     * @since 1.0.0
     */
    private int intCount;


//        二叉树功能实现
    /**
     * 返回的数据
     *
     * @since 1.0.0
     */
    private Object[] returnData;
    /**
     * 脚标控制
     *
     * @since 1.0.0
     */
    private int foot = 0;


    /**
     * 添加数据要保存的数据
     *
     * @param data 传入需要存储的数据
     * @throws NullPointerException 保存数据为空时抛出的异常
     * @author Kevin KDA on 2020/10/14 12:49
     * @description RebBlackTree / add
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 12:49")
    public void add(Comparable<T> data) {
        if (data == null) {
            throw new NullPointerException("保存数据不允许为空");
        }
        /*
        所有的数据本身不具备有节点关系的匹配，那么一定要将其包装在 Node 类之中
        保存节点
         */
        Node newnode = new Node(data);
        //现在没有根节点，则第一个节点作为根节点
        if (this.root == null) {
            this.root = newnode;
        } else {//需要为其保存到一个合适的节点
            // 交由 Node 类负责处理
            this.root.addNode(newnode);
        }
        intCount++;
    }

    /**
     * 以对象数组的形式返回全部数据，如果没有数据返回 nu11
     *
     * @return java.lang.Object[] 返回全部数据
     * @author Kevin KDA on 2020/10/14 12:52
     * @description RebBlackTree / toArray
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 12:52")
    public Object[] toArray() {
        if (intCount == 0) {
            return null;
        }
//        保存长度为数组长度
        this.returnData = new Object[this.intCount];
//        脚标清零
        this.foot = 0;
//        直接通过 Node 类负责
        this.root.toArrayNode();
//        返回全部的数据
        return this.returnData;
    }

    /**
     * 执行数据的删除处理
     *
     * @param data 传入需要删除的数据
     * @author Kevin KDA on 2020/10/14 12:52
     * @description RebBlackTree / remove
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 12:52")
    public void remove(Comparable<T> data) {
//        根节点不存在
        if (root == null) {
//            结束调用
            return;
        } else {
            if (this.root.data.compareTo((T) data) == 0) {
//                要册除的是根节点
//                移动的节点
                Node moveNode = this.root.right;
//                现在还有左边的节点
                while (moveNode.left != null) {
//                    一直向左找
                    moveNode = moveNode.left;
                }
//                就可以确定删除节点的右节点的最小的左节点
                moveNode.left = this.root.left;
                moveNode.right = this.root.right;
                moveNode.parent.left = null;
//                改变根节点
                this.root = moveNode;
            } else {
//        找到要册除的节点
                Node removeNode = this.root.getRemoveNode(data);
//        找到要删除的对家信息
                if (removeNode != null) {
//            情况一：没有任何的子节点
                    if (removeNode.left == null && removeNode.right == null) {
//                直接断开父节点引用
                        removeNode.parent.left = null;
                        removeNode.parent.right = null;
                        removeNode.parent = null;
                    } else if (removeNode.left != null && removeNode.right == null) {
//                左边不为空
                        removeNode.parent.left = removeNode.left;
                        removeNode.left.parent = removeNode.parent;
                    } else if (removeNode.left == null && removeNode.right != null) {
//                右边不为空
                        removeNode.parent.left = removeNode.right;
                        removeNode.right.parent = removeNode.parent;
                    } else {
//                两边都有节点，则将右边节点中最左边的节点找到，改变其指向
//                移动的节点
                        Node moveNode = removeNode.right;
//                现在还有左边的节点
                        while (moveNode.left != null) {
//                    一直向左找
                            moveNode = moveNode.left;
                        }
//                就可以确定删除节点的右节点的最小的左节点
                        removeNode.parent.left = moveNode;
//                断开原本的连接
                        moveNode.parent.left = null;
                        moveNode.parent = removeNode.parent;
//                改变原始的右节点的指向
                        removeNode.right = removeNode.right;
                        removeNode.left = removeNode.left;
                    }
                }
            }
            this.intCount--;
        }
    }

    /**
     * 现在的检素主要依靠的是 Comparable实现的据比较
     *
     * @param data 要比较的数据
     * @return boolean 查找到数据返回 true，否则返回 False
     * @author Kevin KDA on 2020/10/14 12:53
     * @description RebBlackTree / contains
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 12:53")
    private boolean contains(Comparable<T> data) {
        if (this.intCount == 0) {
            return false;
        }
        return this.root.containsNode(data);
    }


    public RebBlackTree() {
    }


    /**
     * 实现排序接口
     *
     * @param o 传入对比数据
     * @return int 返回对比结果
     * @author Kevin KDA on 2020/5/4 12:57
     * @description RebBlackTree / compareTo
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 12:57")
    @Override
    public int compareTo(T o) {
        return 0;
    }


    /**
     * 红黑树结点信息
     *
     * @author Kevin KDA on 2020/5/4 12:59
     * @version 1.0.0
     * @package com.kevinkda.util.algorithm.tree
     * @classname RebBlackTree<T>.Color
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    private enum Color {
        /**
         * 红色标记
         */
        RED,
        /**
         * 黑色标记
         */
        BLACK;
    }


    /**
     * 二叉树结点
     *
     * @author Kevin KDA on 2020/5/4 12:59
     * @version 1.0.0
     * @package com.kevinkda.util.algorithm.tree
     * @classname RebBlackTree<T>.Node
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    private class Node {
        /**
         * 存储数据
         * 可以进行Comparable进行数据比较
         */
        private Comparable<T> data;
        /**
         * 保存父节点
         */
        private Node parent;
        /**
         * 保存左节点
         */
        private Node left;
        /**
         * 保存右节点
         */
        private Node right;
        /**
         * 保存红黑树颜色信息
         */
        private Color flag;

        /**
         * 构造方法直接进行数据存储
         *
         * @param data 传入需要存储的数据
         * @author Kevin KDA on 2020/5/4 13:03
         * @description Node / Node
         * @version 1.0.0
         * @apiNote
         * @implSpec
         * @implNote
         * @since 1.0.0
         */
        public Node(Comparable<T> data) {
            this.data = data;
        }

        /**
         * 实现节点数据的适当位置的存储
         *
         * @param newNode 创建的新节点
         * @return void
         * @throws
         * @author Kevin KDA on 2020/5/4 13:03
         * @description Node / addNode
         * @version 1.0.0
         * @apiNote
         * @implSpec
         * @implNote
         * @since 1.0.0
         */
        @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:03")
        private void addNode(Node newNode) {
            if (newNode.data.compareTo((T) this.data) <= 0) {//比当前节点数据小
                if (this.left == null) {//现在没有左子树
//                    保存左子树
                    this.left = newNode;
//                    保存父节点
                    newNode.parent = this;
                } else {//需要向左边继续判断
//                    继绩向下判断
                    this.left.addNode(newNode);
                }
            } else {//比根节点的数据要大
                if (this.right == null) {//现在没有右子树
//                    保存右子树
                    this.right = newNode;
//                    保存父节点
                    newNode.parent = this;
                } else {//需要向右边继续判断
//                    继绩向下判断
                    this.right.addNode(newNode);
                }
            }
        }

        /**
         * /**实现所有数据的获取处理，按照中序遍历的形式来完成
         *
         * @return void
         * @author Kevin KDA on 2020/5/4 13:03
         * @description Node / toArrayNode
         * @version 1.0.0
         * @apiNote
         * @implSpec
         * @implNote
         * @since 1.0.0
         */
        @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:03")
        public void toArrayNode() {
            //左子树存在
            if (this.left != null) {
//                递归调用
                this.left.toArrayNode();
            }
            RebBlackTree.this.returnData[RebBlackTree.this.foot++] = this.data;
            //右子树存在
            if (this.right != null) {
//                递归调用
                this.right.toArrayNode();
            }
        }

        /**
         * 进行数据的检索处理
         *
         * @param data 要检素的数据
         * @return boolean 找到返回 true，找不到返回 fa1se
         * @author Kevin KDA on 2020/5/4 13:03
         * @description Node / containsNode
         * @version 1.0.0
         * @apiNote
         * @implSpec
         * @implNote
         * @since 1.0.0
         */
        @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:03")
        public boolean containsNode(Comparable<T> data) {
            if (data.compareTo((T) this.data) == 0) {
//                找到了
                return true;
            } else if (data.compareTo((T) this.data) < 0) {
//                左边有数据
                if (this.left != null) {
                    return this.left.containsNode(data);
                } else {
                    return false;
                }
            } else {
                if (this.right != null) {
                    return this.right.containsNode(data);
                } else {
                    return false;
                }
            }
        }

        /**
         * 获取要刑除的节点对象
         *
         * @param data 比较的对象
         * @return com.kevinkda.util.algorithm.tree.RebBlackTree<T>.Node 要删除的节点对象，对象一定存在
         * @author Kevin KDA on 2020/5/4 13:03
         * @description Node / getRemoveNode
         * @version 1.0.0
         * @apiNote
         * @implSpec
         * @implNote
         * @since 1.0.0
         */
        @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:03")
        public Node getRemoveNode(Comparable<T> data) {
            if (data.compareTo((T) this.data) == 0) {
//                找到了
                return this;
            } else if (data.compareTo((T) this.data) < 0) {
//                左边有数据
                if (this.left != null) {
                    return this.left.getRemoveNode(data);
                } else {
                    return null;
                }
            } else {
                if (this.right != null) {
                    return this.right.getRemoveNode(data);
                } else {
                    return null;
                }
            }
        }
    }

}
