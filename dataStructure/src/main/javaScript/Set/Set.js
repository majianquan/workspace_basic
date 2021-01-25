function Set() {
    let items = {};
    // 向集合添加一个新的项
    this.add = function() {
        if (!this.has(value)) {
            items[value] = value;
            return true;
        }
        return false;
    };
    // 从集合移除一个值
    this.delete = function(value) {
        if (!this.has(value)) {
            delete items[value];
            return true;
        }
        return false;
    };
    // 如果值在集合中，返回 true ，否则返回 false
    this.has = function(value) {
        // return value in items
        return items.hasOwnProperty(value);
    };
    // 移除集合中的所有项
    this.clear = function() {
        items = {};
    };
    // 返回集合所包含元素的数量
    this.size = function() {
        return Object.keys(items).length;
    };
    // 返回一个包含集合中所有值的数组
    this.values = function() {
        return Object.keys(items).map(item => items[item]);
    };
    // 并集
    this.union = function(otherSet) {
        let unionSet = new Set();
        let values = this.values();
        for (let index = 0; index < values.length; index++) {
            unionSet.add(values[index]);
        }
        let other_values = otherSet.values();
        for (let index = 0; index < other_values.length; index++) {
            unionSet.add(other_values[index]);
        }
        return unionSet;
    };
    // 交集
    this.intersection = function(otherSet) {
        let intersectionSet = new Set();
        let values = this.values();
        for (let index = 0; index < values.length; index++) {
            if (otherSet.has(values[index])) {
                intersectionSet.add(values[i]);
            }
        }
        return intersectionSet;
    };
    // 差集
    this.difference = function(otherSet) {
        let differenceSet = new Set();
        let values = this.values();
        for (let index = 0; index < values.length; index++) {
            if (!otherSet.has(values[index])) {
                differenceSet.add(values[index]);
            }
        }
    };
    // 是否是某个集合的子集
    this.subSet = function(otherSet) {
        if(this.size > otherSet.size) {
            return false
        } else {
            let values = this.values()
            for (let index = 0; index < values.length; index++) {
                if(!otherSet.has(values[index])) {
                    return false
                }
            }
            return true
        }
    }
}
