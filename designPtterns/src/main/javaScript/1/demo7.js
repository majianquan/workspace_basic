class FuncClass {
    constructor() {
        this.bar = 'bar';
    }
}

// 饿汉式
const HungrySingleton = (function() {
    let _instance = new FuncClass();
    // 饿汉式在 HungrySingleton 这个 IIFE 执行的时候就进入到 FuncClass 的实例化流程了，
    return function() {
        return _instance;
    };
})();
// 懒汉式
const LazySingleton = (function() {
    let _instance = null;
    // 懒汉式的 LazySingleton 中 FuncClass 的实例化过程是在第一次 new 的时候才进行的。
    return function() {
        return _instance || (_instance = new FuncClass());
    };
})();
