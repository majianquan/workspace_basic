package linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
}

class SingleLinkedList {
    // 初始化头节点
    private SingleNode head = new SingleNode(0,"");
    // 添加节点
    public void add(SingleNode node) {
        SingleNode curNode = head;
        while (true) {
            if(curNode.next == null) {
                break;
            }
            curNode = curNode.next;
        }
        curNode.next = node;
    }
    // 按照指定的顺序添加节点
    public void addByOrder(SingleNode node) {
        SingleNode curNode = head;
        boolean flag = false;
        while (true) {
            if(curNode.next == null) {
                break;
            }
            if(curNode.next.no > node.no) {
                break;
            } else if(curNode.next.no == node.no) {
                flag = true;
                break;
            }
            curNode = curNode.next;
        }
        if(flag) {
            System.out.println("该节点已经存在");
        } else {
            node.next = curNode.next;
            curNode.next = node;
        }
    }
    // 删除节点
    public void delete(int no) {
        SingleNode curNode = head;
        boolean flag = false;
        while (true)  {
            if(curNode.next == null) {
                break;
            }
            if(curNode.next.no == no) {
                flag = true;
                break;
            }
            curNode = curNode.next;
        }
        if(flag) {
            curNode.next = curNode.next.next;
        } else {
            System.out.printf("要删除的%d节点不存在",no);
        }
    }
    // 更新节点
    public void update(SingleNode node) {
        SingleNode curNode = head.next;
        boolean flag = false;
        while (true) {
            if(curNode == null) {
                break;
            }
            if(curNode.no == node.no) {
                flag = true;
                break;
            }
            curNode = curNode.next;
        }
        if(flag) {
            curNode.name = node.name;
        } else {
            System.out.printf("找不到no为%d的节点",node.no);
        }
    }
    // 遍历节点
    public void list() {
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        SingleNode curNode = head.next;
        while (true) {
            if(curNode == null) {
                break;
            }
            System.out.println(curNode);
            curNode = curNode.next;
        }
    }
    // 获取单链表的节点个数
    public static int getLength(SingleNode head) {
        int length = 0;
        if(head.next == null) {
            return  length;
        }
        SingleNode curNode = head.next;
        while (curNode.next != null) {
            length++;
            curNode = curNode.next;
        }
        return  length;
    }
    // 查找单链表中倒数第k个节点
    public SingleNode findLastIndexNode(SingleNode head,int k) {
        // 判空
        if(head.next == null) {
            System.out.println("链表为空");
            return null;
        }
        int size = getLength(head);
        // 判断k的有效范围
        if(k<=0 && k> size) {
            return null;
        }
        SingleNode curNode = head.next;
        for (int i = 0; i < size - k; i++) {
            curNode = curNode.next;
        }
        return  curNode;
    }
    /**
     * 逆转链表
     * 1.先建立一个空的头节点
     * 2.遍历节点,插入新的节点的第1个
     */
    public static void reverseList(SingleNode head) {
        // 判空
        if(head.next == null) {
            return;
        }
        SingleNode reverseHead = new SingleNode(0,"");
        SingleNode curNode = head.next;
        SingleNode next = null;
        while (curNode != null) {
            next = curNode.next;
            curNode.next = reverseHead.next;
            reverseHead.next = curNode;
            curNode = next;
        }
        head.next = reverseHead.next;
    }
    // 单向链表的逆序打印
    // 遍历每一个链表的节点,然后推入栈中,然后在打印栈
    public static void reversePrint(SingleNode head) {
        if(head.next == null) {
            return; // 空链表
        }
        Stack<SingleNode> singleNodes = new Stack<>();
        SingleNode curNode = head.next;
        while (curNode != null) {
            singleNodes.push(curNode);
            curNode = curNode.next;
        }
        while (singleNodes.size() > 0) {
            System.out.println(singleNodes.pop());
        }
    }

}

class SingleNode {
    public int no;
    public String name;
    public SingleNode next; // 指向下一个节点

    public SingleNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}