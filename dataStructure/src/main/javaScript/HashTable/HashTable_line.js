// 线性探查解决散列冲突
function HashTable() {
    let table = []
    // 向散列表增加一个新的项（也能更新散列表）。
    this.put = function(key,value) {
        var position = loseloseHashCode(key)
        if(table[position] == undefined) {
            table[position] = new ValuePair(key,value)
        } else {
            // 如果position有值就一值加上1
            var index = ++position;
            while(table[index] != undefined) {
                index++
            }
            table[index] = new ValuePair(key,value)
        }
    }
    // 根据键值从散列表中移除值
    this.remove(key) = function(key) {
        var position = loseloseHashCode(key)
        if(table[position] !== undefined) {
            if(table[position].key === key) {
                table[position] = undefined
                return true
            } else {
                var index = position++
                while(table[index] === undefined || table[index].key !== key) {
                    index++
                }
                if(table[index].key === key) {
                    table[index] = undefined
                    return true
                }
            }
        }
        return false;
    }
    // 返回根据键值检索到的特定的值
    this.get = function(key) {
        var position = loseloseHashCode(key)
        if(table[position] !== undefined) {
            if(table[position].key === key) {
                return table[position].value
            } else {
                var index = position++
                while(table[index] === undefined || table[index].key !== key) {
                    index++
                }
                if(table[index].key === key) {
                    return table[index].value
                }
            }
        }
        return undefined;
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
