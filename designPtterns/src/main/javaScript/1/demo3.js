const Singleton = (function() {
    let _instance = null;
    const Singleton = function() {
        if (_instance) return _instance;
        _instance = this;
    };

    Singleton.getInstance = function() {
        if (_instance) return _instance;
        return new Singleton()
    };

    return Singleton;
})();

const instance1 = Singleton.getInstance();
const instance2 = new Singleton();
console.log(instance1 === instance2);
