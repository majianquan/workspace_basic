/* 功能类 */
class FuncClass {
    constructor(bar) {
        this.bar = bar;
        this.init();
    }
    init() {
        this.foo = 'Singleton instance';
    }
}

// 单例模式赋能列
const Singleton = (function() {
    let _instance = null;

    const ProxySingleton = function(bar) {
        if (_instance) return _instance;
        _instance = new FuncClass(bar);
        return _instance;
    };
    ProxySingleton.getInstance = function() {
        if (_instance) return _instance;
        _instance = new Singleton(bar);
        return _instance;
    };
    return ProxySingleton;
})();

const visitor1 = new Singleton('单例1');
const visitor2 = new Singleton('单例2');
const visitor3 = Singleton.getInstance();

console.log(visitor1 === visitor2); // true
console.log(visitor1 === visitor3);
