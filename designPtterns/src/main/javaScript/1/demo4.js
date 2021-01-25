let getInstance;

{
    let _instance = null;
    const Singleton = function() {
        if (_instance) return _instance;
        _instance = this;
        this.init();
        return _instance;
    };

    Singleton.prototype.init = function() {
        this.foo = 'Singleton instance';
    };
    getInstance = function() {
        if (_instance) return _instance;
        _instance = new Singleton();
        return _instance;
    };

}

const instance1 = getInstance();
const instance2 = getInstance();

console.log(instance1 === instance2);
