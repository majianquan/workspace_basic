function HashTable() {
    let table = []
    // 向散列表增加一个新的项（也能更新散列表）。
    this.put = function(key,value) {
        var position = djb2HashCode(key)
        table[position] = value
    }
    // 根据键值从散列表中移除值
    this.remove(key) = function(key) {
        table[djb2HashCode(key)] = undefined;
    }
    // 返回根据键值检索到的特定的值
    this.get = function(key) {
        return table[djb2HashCode(key)];
    }
    // 更好的散列函数
    let djb2HashCode = function(key) {
        var hash = 5381;
        for (let index = 0; index < key.length; index++) {
            hash = hash * 33 + key.charCodeAt(i)
        }
        return hash % 1013
    }
}
