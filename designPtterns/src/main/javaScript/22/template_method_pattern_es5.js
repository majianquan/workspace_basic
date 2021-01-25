// 饮料父类
var Beverage = function() {

};

// 烧开水 公用方法
Beverage.prototype.boilWater = function() {
    console.log('水已经煮沸!');
};

// 冲泡饮料 抽象方法
Beverage.prototype.brewDrink = function() {
    throw new Error('抽象方法不能调用');
};

// 倒杯子里面 公用方法
Beverage.prototype.pourCup = function() {
    console.log('倒进杯子里 ');
};

// 加调味品 抽象方法addCondiment
Beverage.prototype.addCondiment = function() {
    throw new Error('抽象方法不能调用');
};

Beverage.prototype.init = function() {
    this.boilWater();
    this.brewDrink();
    this.pourCup();
    this.addCondiment();
};

var Coffee = function() {
    Beverage.call(this);
};

Coffee.prototype = new Beverage();
Coffee.prototype.constructor = Coffee;

// 冲泡饮料 具体实现
Coffee.prototype.brewDrink = function() {
    console.log('冲泡咖啡饮料!');
};
// 加调味品 具体实现
Coffee.prototype.addCondiment = function() {
    console.log('咖啡加调味品!');
};

var coffee = new Coffee();
coffee.init();
