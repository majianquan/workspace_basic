const Stack = (
    function (){
        const items = new WeakMap();
        class Stack {
            constructor() {
                items.set(this, []);
            }
            // 添加一个（或几个）新元素到栈顶
            push(element) {
                let s = items.get(this);
                return s.push(element);
            }
            // 移除栈顶的元素，同时返回被移除的元素
            pop() {
                let s = items.get(this);
                return s.pop();
            }
            // 返回栈顶的元素，不对栈做任何修改（这个方法不会移除栈顶的元素，仅仅返回它）。
            peek() {
                let s = items.get(this);
                return s[items.length - 1];
            }
            // 如果栈里没有任何元素就返回 true ，否则返回 false
            isEmpty() {
                let s = items.get(this);
                return s.length === 0;
            }
            // 返回栈里的元素个数
            size() {
                let s = items.get(this);
                return s.length;
            }
            // 移除栈里的所有元素
            clear() {
                let s = items.get(this);
                s = [];
            }
            // 打印栈
            print() {
                let s = items.get(this);
                console.log(s.toString());
            }
        }
        return Stack
    }
)()