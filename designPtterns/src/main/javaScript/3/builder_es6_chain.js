// 建造者，汽车部件厂家，提供具体零部件的生产
class CarBuilder {
    constructor(engine, weight, height, color, tyre, name, type) {
        this.engine = engine;
        this.weight = weight;
        this.height = height;
        this.color = color;
        this.tyre = tyre;
        this.name = name;
        this.type = type;
    }
    setPropertyNames() {
        Object.getOwnPropertyNames(this).forEach(key => {
            const funcName = 'set' + key.replace(/^\w/g, str => str.toUpperCase());
            this[funcName] = value => {
                this[key] = value;
                return this;
            };
        });
        return this;
    }
}
/* 奔驰厂家，负责最终汽车产品的装配 */
class benChiDirector {
    constructor() {
        const _car = new CarBuilder();

        return _car;
    }
}

// 获得产品实例
var benchi1 = new benChiDirector()
    .setPropertyNames()
    .setEngine('大马力发动机')
    .setWeight('2ton')
    .setHeight('2000mm')
    .setColor('white')
    .setTyre('大号轮胎')
    .setName('奔驰')
    .setType('AMG');

console.log(benchi1);
