function DoublyLinkedList() {
    //  Node 类表示要加入列表的项
    // 它包含一个 element 属性，即要添加到列表的值
    // 指向列表中下一个节点项的指针
    let Node = function(element) {
        this.element;
        // 下一个节点
        this.next = null;
        // 前一个节点
        this.prev = null;
    };

    // 存储列表项的数量的 length 属性
    let length = 0;

    // 存储第一个节点的引用
    let head = null;

    // 对列表最后一项的引用的 tail 属性
    let tail = null;

    // 向列表尾部添加一个新的项。
    this.append = function(element) {

    };

    // 向列表的特定位置插入一个新的项
    this.insert = function(position, element) {
        if (position > -1 && position <= length) {
            let node = new Node(element);
            (current = head), previous, (index = 0);
            // 如果添加的位置是0
            if (position === 0) {
                if(!head) {
                    head = node;
                    tail = node;
                } else {
                    node.next = current
                    current.prev = node;
                    head = node; 
                }
            // 新增到最后一个    
            } else if(position === length){
                current = tail
                current.next = node
                node.prev = current
                tail = node
            } else {

            }

            // 更新列表长度
            length++;

            return true;
        } else {
            return false;
        }
    };

    // 从列表中移除一项
    this.remove = function(element) {
        let index = this.indexOf(element);
        return this.removeAt(index);
    };

    // 从列表的特定位置移除一项
    this.removeAt = function(position) {
        // 检查索引越界值
        if (position > -1 && position < length) {
            let current = head,
                previous,
                index = 0;

            // 如果位置是0,移除第一项
            if (position === 0) {
                head = current.next;
                if(length === 1) {
                    tail = null
                } else {
                    head.prev = null
                }
            } else if(position === length - 1) {
                current = tail
                tail = current.prev
                tail.next = null;

            } else {
                while (index++ < position) {
                    previous = current;
                    current = current.next;
                }
                // 讲前一个的next指向,当前的next,这样就跳过current,从而移除他
                previous.next = current.next;
                current.next.prev = previous
            }
            // 更新length
            length--;
            return current.element;
        } else {
            return null;
        }
    };

    // 返回元素在列表中的索引。如果列表中没有该元素则返回 -1
    this.indexOf = function(element) {
        let current = head,
            index = -1;
        while (current) {
            index++;
            if (element === current.element) {
                return index;
            }
            current = current.next;
        }

        return index;
    };

    // 如果链表中不包含任何元素，返回 true ，如果链表长度大于0则返回 false
    this.isEmpty = function() {
        return length === 0;
    };

    // 返回链表包含的元素个数。与数组的 length 属性类似
    this.size = function() {
        return length;
    };

    // 返回头部的数据
    this.getHead = function() {
        return head;
    };

    // 由于列表项使用了 Node 类，就需要重写继承自JavaScript对象默认的toString 方法，让其只输出元素的值
    this.toString = function() {
        let current = head,
            str = '';

        while (current) {
            str += current.element + (current.next ? 'n' : '');
            current = current.next;
        }

        return str;
    };
}
