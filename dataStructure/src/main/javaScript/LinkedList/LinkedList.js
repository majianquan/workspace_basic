function LinkedList() {
    //  Node 类表示要加入列表的项
    // 它包含一个 element 属性，即要添加到列表的值
    // 指向列表中下一个节点项的指针
    let Node = function(element) {
        this.element;
        this.next = null;
    };

    // 存储列表项的数量的 length 属性
    let length = 0;

    // 存储第一个节点的引用
    let head = null;

    // 向列表尾部添加一个新的项。
    this.append = function(element) {
        // 把 element 作为值传入，创建 Node 项
        let node = new Node(element),
            current;

        // 向为空的列表添加一个元素。
        if (head === null) {
            head = node;
        } else {
            // 向一个不为空的列表尾部添加元素。
            current = head;

            // 循环列表，直到找到最后一项
            while (current.next) {
                current = current.next;
            }
            // 找到最后一项，将其next赋为node，建立链接
            current.next = node;
        }
        // 更新列表的长度
        length++;
    };

    // 向列表的特定位置插入一个新的项
    this.insert = function(position, element) {
        if (position > -1 && position <= length) {
            let node = new Node(element);
            (current = head), previous, (index = 0);
            // 如果添加的位置是0
            if (position === 0) {
                node.next = current;
                // 更新head
                head = node;
            } else {
                while (index++ < position) {
                    previous = current;
                    current = current.next;
                }
                previous.next = node;
                node.next = current;
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
            } else {
                while (index++ < position) {
                    previous = current;
                    current = current.next;
                }
                // 讲前一个的next指向,当前的next,这样就跳过current,从而移除他
                previous.next = current.next;
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

module.export = LinkedList;
