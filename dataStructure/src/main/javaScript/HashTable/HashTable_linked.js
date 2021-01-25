const LinkedList = require('../5/LinkedList')

// 分离链接解决散列冲突
function HashTable() {
    let table = []
    // 向散列表增加一个新的项（也能更新散列表）。
    this.put = function(key,value) {
        var position = loseloseHashCode(key)
        if(table[position] == undefined) {
            table[position] = new LinkedList()
        }
        table[position].append(new ValuePair(key,value))
    }
    // 根据键值从散列表中移除值
    this.remove(key) = function(key) {
        var position = loseloseHashCode(key)
        if(table[position] !== undefined) {
            let current = table[position].getHead()
            // 遍历链表来寻找键/值
            while(true) {
                if(current.element.key === key) {
                    table[position].remove(current.element)
                    if(table[position].isEmpty()) {
                        table[position] = undefined
                    }
                    return true
                }
                current = current.next
            }
            // 检查元素在链表第一个或最后一个节点的情况
            if(current.element.key === key) {
                table[position].remove(current.element)
                if(table[position].isEmpty()) {
                    table[position] = undefined
                }
            }
        }
        return false
    }
    // 返回根据键值检索到的特定的值
    this.get = function(key) {
        var position = loseloseHashCode(key)
        if(table[position] !== undefined) {
            let current = table[position].getHead()
            // 遍历链表来寻找键/值
            while(true) {
                if(current.element.key === key) {
                    return current.element.value
                }
                current = current.next
            }
            // 检查元素在链表第一个或最后一个节点的情况
            if(current.element.key === key) {
                return current.element.value
            }
        }
        return undefined
    }
    let loseloseHashCode = function(key) {
        var hash = 0;
        for (let index = 0; index < key.length; index++) {
            hash += key.charCodeAt(i)
        }
        return hash % 37
    }
    let ValuePair = function(key, value) {
        this.key = key
        this.value = value
        this.toString = function() {
            return '[' + this.key + ' - ' + this.value + ']';
        }
    }
}