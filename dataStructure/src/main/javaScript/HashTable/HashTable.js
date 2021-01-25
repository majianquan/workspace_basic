function HashTable() {
    let table = []
    // 向散列表增加一个新的项（也能更新散列表）。
    this.put = function(key,value) {
        var position = loseloseHashCode(key)
        table[position] = value
    }
    // 根据键值从散列表中移除值
    this.remove(key) = function(key) {
        table[loseloseHashCode(key)] = undefined;
    }
    // 返回根据键值检索到的特定的值
    this.get = function(key) {
        return table[loseloseHashCode(key)];
    }
    let loseloseHashCode = function(key) {
        var hash = 0;
        for (let index = 0; index < key.length; index++) {
            hash += key.charCodeAt(i)
        }
        return hash % 37
    }
}
// 会有数据丢失问题(当hash值相同时)
//处理冲突有几种方法：分离链接、线性探查和双散列法