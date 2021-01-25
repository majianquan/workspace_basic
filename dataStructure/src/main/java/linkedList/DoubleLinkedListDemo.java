package linkedList;

public class DoubleLinkedListDemo {
}

class DoubleLinkedList {
    private Node head = new Node(0,"");

    // 遍历链表
    public void list() {
        if(head.next == null) {
            System.out.println("链表为空...");
        }
        Node cur = head.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
    // 添加节点
    public void addNode(Node node){
        Node cur = head;
        while (true) {
            if(cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = node;
        node.pre = cur;
    }
    // 更新节点
    public void updateNode(Node node) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node cur = node.next;
        boolean flag = false;
        while (true) {
            if(cur.next == null) {
                break;
            }
            if(cur.id == node.id) {
                flag = true;
                break;
            }

            cur = cur.next;
        }
        if(flag) {
            cur.name = node.name;
        } else {
            System.out.println("找不到该节点");
        }
    }
    // 删除节点
    public void deleteNode(int id) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node cur = head.next;
        boolean flag = true;
        while (cur != null) {
            if(cur.next == null) {
                break;
            }
            if (cur.id == id) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if(flag) {
            cur.pre.next = cur.next;
            if(cur.next != null) {
                cur.next= cur.pre;
            }
        } else {
            System.out.println("没有找到删除的节点");
        }

    }
}

class Node {
    int id;
    String name;
    Node pre;
    Node next;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}
