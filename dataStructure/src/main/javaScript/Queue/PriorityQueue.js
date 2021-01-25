const PriorityQueue = (function (){
    const items = new WeakMap()
    class QueueElement {
        constructor(element, priority) {
            this.element = element;
            this.priority = priority;
        }
    }
    class PriorityQueue {
        constructor() {
            items.set(this,[])
        }
        _getItems() {
            return items.get(this);
        }
        // 向队列尾部添加一个（或多个）新的项
        enqueue(element, priority) {
            let queueElement = new  QueueElement(element, priority)
            let added = false;
            for (let i = 0; i < this.size(); i++) {
                if(queueElement.priority < this._getItems()[i].priority) {
                    this._getItems().splice(i,0,queueElement)

                }
            }
            this._getItems().push(element);
        }
        // 移除队列的第一（即排在队列最前面的）项，并返回被移除的元素。
        dequeue() {
            return this._getItems().shift();
        }
        // 返回队列中第一个元素——最先被添加，也将是最先被移除的元素。队列不做任何变动;
        front() {
            return this._getItems()[0];
        }
        // 如果队列中不包含任何元素，返回 true ，否则返回 false
        isEmpty() {
            return this._getItems().length === 0;
        }
        // 清空队列
        clear() {
            items.set(this,[])
        }
        //返回队列包含的元素个数
        size() {
            return this._getItems().length;
        }
        // 打印队列
        print() {
            console.log(this._getItems().toSting());
        }
    }
    return PriorityQueue
})()