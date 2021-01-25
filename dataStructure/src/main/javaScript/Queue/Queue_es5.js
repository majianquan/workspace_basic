function Queue() {
    let items = [];
    // 向队列尾部添加一个（或多个）新的项
    this.enqueue = function(element) {
        items.push(element)
    };
    // 移除队列的第一（即排在队列最前面的）项，并返回被移除的元素。
    this.dequeue = function() {
        return items.shift()
    };
    // 返回队列中第一个元素——最先被添加，也将是最先被移除的元素。队列不做任何变动;
    this.front = function() {
        return items[0]
    };
    // 如果队列中不包含任何元素，返回 true ，否则返回 false
    this.isEmpty = function() {
        return items.length === 0
    };
    // 清空队列
    this.clear = function () {
        items = []
    }
    //返回队列包含的元素个数
    this.size = function() {
        return items.length
    };
    // 打印队列
    this.print = function() {
        console.log(items.toSting())
    }
}
