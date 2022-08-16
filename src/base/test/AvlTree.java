package base.test;


/**
 * @author lixl
 * avl平衡树，首先是一个二叉树，但其添加节点过程中，会进行计算，旋转，是最后各分支的高度之差，不大于2
 * @description
 * @date 2022/1/28
 * 模拟网址：https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
 */
public class AvlTree {

    /**
     * 跟节点
     */
    private TreeNode rootNode;

    /**
     * 添加节点的方法
     * 由于二叉树在插入过程当中，需要旋转保持平衡
     * 因此，avl二叉树的根节点不会固定，每次插入成功后，返回本次的根节点
     * @param val
     */
    public void add(int val){
        rootNode = insert(val,rootNode);
    }
    /**
     * 递归调用插入节点方法
     */
    private TreeNode insert(int val,TreeNode node){
        if (node == null){
            return new TreeNode(val);
        }
        if (val>node.val){
            // 向节点的右侧插入
            node.right = insert(val,node.right);
        } else if(val < node.val){
            // 向节点左侧插入数据
            node.left = insert(val,node.left);
        } else {
            // 不做插入
        }
        // 判断树是否已经失衡
        return balanceTree(node);
    }

    /**
     * 调节树平衡统一入口
     * @param node
     * @return
     */
    private TreeNode balanceTree(TreeNode node){
        if (getNodeHeight(node.left) - getNodeHeight(node.right)>1) {
            // 说明左侧失衡
            System.out.println(1);
            if (getNodeHeight(node.left.left)-getNodeHeight(node.left.right)>0) {
                // LL失衡情况
                node = balanceLL(node);
            } else {
                // LR失衡情况
                node = balanceLR(node);
            }
        } else if (getNodeHeight(node.right) - getNodeHeight(node.left) > 1) {
            System.out.println(1);
            // 右侧失衡
            if (getNodeHeight(node.right.right)-getNodeHeight(node.right.left)>0) {
                // RR失衡情况
                node = balanceRR(node);
            } else {
                // RL失衡情况
                node = balanceRL(node);
            }
        }
        // 计算调节后 node 节点的高度，因为maxHeight方法返回的时当前node节点子节点中最大的高度，所以自身高度要+1
        node.height = maxHeight(getNodeHeight(node.left),getNodeHeight(node.right)) + 1;
        return node;
    }

    /**
     * 左侧节点一侧失衡情况，需要将节点向右旋转
     * 向右旋转策略：当前节点（失衡节点）的左侧节点作为子树的主节点，当前节点作为左侧节点的右节点
     * 当前节点的左节点，设置为原左节点的右节点
     * 返回原左侧节点
     * @param node 当前节点即失衡节点
     * @return
     */
    private TreeNode balanceLL(TreeNode node){
        // 申请临时变量，保存当前节点的左侧节点，即原左侧节点
        TreeNode l_node = node.left;
        // 重新设置失衡节点的左侧节点为原左侧节点的右节点
        node.left = l_node.right;
        // 向右旋转操作，将原左侧节点的右节点设置为失衡节点
        l_node.right = node;
        // 重新计算挪动了的失衡节点的高度
        node.height = maxHeight(getNodeHeight(node.left),getNodeHeight(node.right)) + 1;
        // 重新计算原左侧 节点的高度 两个高度计算顺序不能颠倒
        l_node.height = maxHeight(getNodeHeight(l_node.left),getNodeHeight(l_node.right)) + 1;
        return l_node;
    }

    /**
     * 失衡节点左侧失衡，并右侧有节点情况
     * 此种情况需要进行两次旋转
     * 1、将失衡的lr情况先转转成ll失衡
     *    即将当前失衡节点的左节点指向原左节点的右侧节点
     *    原左侧节点作为其（代指原左侧节点本身）右侧节点的左侧节点
     * 2、进行ll旋转
     * @param node 失衡节点
     * @return
     */
    private TreeNode balanceLR(TreeNode node){
        // 申请链式变量保存失衡节点的左侧节点，即原左侧节点
        TreeNode l_node = node.left;
        // 获取原左侧节点的右侧节点，即原右侧节点
        TreeNode lr_node = l_node.right;
        // 进行旋转调节，失衡节点的左侧节点指向原右侧节点
        node.left = lr_node;
        // 原左侧节点的右侧节点指向原右侧节点的左侧节点（根据二叉树的数据排列进行此项调整）
        l_node.right = lr_node.left;
        // 原右侧节点的左侧节点调整为原左侧节点，完成第一步旋转操作
        lr_node.left = l_node;
        // 调用ll操作完成平衡旋转
        return balanceLL(node);
    }

    /**
     * 此后的rr和rl进行相反的操作，即可完成
     */

    /**
     * 右侧节点一侧失衡情况，需要将节点向左旋转
     * 向左旋转策略：当前节点（失衡节点）的右侧节点作为子树的主节点，当前节点作为右侧节点的左节点
     * 当前节点的右节点，设置为原右节点的左节点
     * 返回原右侧节点
     * @param node 当前节点即失衡节点
     * @return
     */
    private TreeNode balanceRR(TreeNode node){
        // 申请临时变量，保存当前节点的右侧节点，即原右侧节点
        TreeNode r_node = node.right;
        // 重新设置失衡节点的右侧节点为原右侧节点的左节点
        node.right = r_node.left;
        // 向左旋转操作，将原右侧节点的左节点设置为失衡节点
        r_node.left = node;
        // 重新计算挪动了的失衡节点的高度
        node.height = maxHeight(getNodeHeight(node.left),getNodeHeight(node.right)) + 1;
        // 重新计算原右侧 节点的高度 两个高度计算顺序不能颠倒
        r_node.height = maxHeight(getNodeHeight(r_node.left),getNodeHeight(r_node.right)) + 1;
        return r_node;
    }

    /**
     * 失衡节点右侧失衡，并左侧有节点情况
     * 此种情况需要进行两次旋转
     * 1、将失衡的rl情况先转转成rr失衡
     *    即将当前失衡节点的右节点指向原右节点的左侧节点
     *    原右侧节点作为其（代指原右侧节点本身）左侧节点的右侧节点
     * 2、进行rr旋转
     * @param node 失衡节点
     * @return
     */
    private TreeNode balanceRL(TreeNode node){
        // 申请链式变量保存失衡节点的左侧节点，即原左侧节点
        TreeNode l_node = node.left;
        // 获取原左侧节点的右侧节点，即原右侧节点
        TreeNode lr_node = l_node.right;
        // 进行旋转调节，失衡节点的左侧节点指向原右侧节点
        node.left = lr_node;
        // 原左侧节点的右侧节点指向原右侧节点的左侧节点（根据二叉树的数据排列进行此项调整）
        l_node.right = lr_node.left;
        // 原右侧节点的左侧节点调整为原左侧节点，完成第一步旋转操作
        lr_node.left = l_node;
        // 调用ll操作完成平衡旋转
        return balanceRR(node);
    }

    /**
     * 获取节点的高度
     * 因为默认节点的高度为0，因此在没有节点的情况下为-1
     * @param node
     * @return
     */
    private int getNodeHeight(TreeNode node){
        return node == null ? -1 : node.height;
    }

    /**
     * 获取两个节点中，最大高度
     * @param leftHeight
     * @param rightHeight
     * @return
     */
    private int maxHeight(int leftHeight,int rightHeight){
        return leftHeight > rightHeight?leftHeight:rightHeight;
    }

    /**
     * 平衡树节点类
     */
    private static class TreeNode {
        // 节点的值，可以根据需要使用任意可以对比的对象，或者实现了Comparable接口的对象
        // 注意调整不同的对比规则
        private int val;
        // 节点左子树
        private TreeNode left;
        // 节点右子树
        private TreeNode right;
        // 当前节点的高度，用于判断是否失衡
        private int height;

        /**
         * 构造函数
         * @param val
         * @param left
         * @param right
         */
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        /**
         * 构造函数
         * @param val
         */
        public TreeNode(int val){
            this(val,null,null);
        }

    }
}
