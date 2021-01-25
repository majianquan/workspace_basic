package linkedList;

public class CircleSingleLinedListDemo {
}

// 循环单向链表  解决约瑟夫问题
class CircleSingleLinedList {
    private Boy first = null;

    public void addBoy(int nums) {
        // 判断数值
        if (nums < 1) {
            System.out.println("传输进入的值不正确");
            return;
        }
        Boy cur = null;
        for (int i = 0; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    public void showBoy() {
        // 判空
        if(first == null) {
            System.out.println("链表为空...");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.printf("小孩的编号为%d\n",cur.getNo());
            if(cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        // 数据校验
        if(first == null || startNo < 1 || startNo > nums) {
            System.out.println("数据不正确");
            return;
        }
        // 寻找最后节点的
        Boy last = first;
        while (true) {
            if (last.getNext() == first) {
                break;
            }
            last = last.getNext();
        }
        // 从第几个小孩开始
        for (int i = 0; i < startNo -1; i++) {
            first = first.getNext();
            last = last.getNext();
        }
        // 开始报数
        while (true) {
            if (last == first) {
                break;
            }
            for (int i = 0; i < countNum -1; i++) {
                first = first.getNext();
                last = last.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first = first.getNext();
            last.setNext(first);
        }
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}