const queue = (
    function (){
        const items = new WeakMap();
        class Queue {
            constructor() {
                items.set(this,[])
            }

            // 向队列尾部添加一个（或多个）新的项
            enqueue(element) {
                let s = items.get(this);
                s.push(element);
            }
            // 移除队列的第一（即排在队列最前面的）项，并返回被移除的元素。
            dequeue() {
                let s = items.get(this);
                return s.shift();
            }
            // 返回队列中第一个元素——最先被添加，也将是最先被移除的元素。队列不做任何变动;
            front() {
                let s = items.get(this);
                return s[0];
            }
            // 如果队列中不包含任何元素，返回 true ，否则返回 false
            isEmpty() {
                let s = items.get(this);
                return s.length === 0;
            }
            // 清空队列
            clear() {
                let s = items.get(this);
                s = [];
            }
            //返回队列包含的元素个数
            size() {
                let s = items.get(this);
                return s.length;
            }
            // 打印队列
            print() {
                let s = items.get(this);
                console.log(s.toSting());
            }
        }
    }
)()