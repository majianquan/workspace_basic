// 虚拟方法
const abstractFunc = function() {
    throw new Error('抽象方法不能调用');
};

// 饮料父类
class Beverage {
    constructor({ brewDrink = abstractFunc, addCondiment = abstractFunc }) {
        this.brewDrink = brewDrink;
        this.addCondiment = addCondiment;
    }
    // 烧开水 公用方法
    boilWater() {
        console.log('水已经煮沸!');
    }

    // 倒杯子里面 公用方法
    pourCup() {
        console.log('倒进杯子里 ');
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
    constructor() {
        super();
    }

}

var coffee = new Beverage({
    // 冲泡饮料 具体实现
    brewDrink:function() {
        console.log('冲泡咖啡饮料!');
    },
    // 加调味品 具体实现
    addCondiment:function() {
        console.log('咖啡加调味品!');
    }
});
coffee.init();
