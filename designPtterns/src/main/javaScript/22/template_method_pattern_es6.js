// ES6
// 饮料父类
class Beverage {
    constructor() {
        if (new.target === Beverage) {
            throw new Error('抽象类不能实例化!!!');
        }
    }
    // 烧开水 公用方法
    boilWater() {
        console.log('水已经煮沸!');
    }

    // 冲泡饮料 抽象方法
    brewDrink() {
        throw new Error('抽象方法不能调用');
    }

    // 倒杯子里面 公用方法
    pourCup() {
        console.log('倒进杯子里 ');
    }

    // 加调味品 抽象方法addCondiment
    addCondiment() {
        throw new Error('抽象方法不能调用');
    }
    // 制作流程,模板方法
    init() {
        this.boilWater();
        this.brewDrink();
        this.pourCup();
        this.addCondiment();
    }
}

class Coffee extends Beverage {
    constructor(){
        super()
    }
    // 冲泡饮料 具体实现
    brewDrink() {
        console.log('冲泡咖啡饮料!');
    };
    // 加调味品 具体实现
    addCondiment() {
        console.log('咖啡加调味品!');
    };
}





var coffee = new Coffee();
coffee.init();
