// 抽象状态类
const AbstractState = function() {};
// 抽象方法
AbstractState.prototype.employ = function() {
    throw new Error('抽象方法不能调用!');
};

// 交通灯状态
const State = function(name, desc) {
    this.color = { name, desc };
};

State.prototype = new AbstractState();
State.prototype.construct = State;

State.prototype.employ = function(trafficLight) {
    console.log('交通灯颜色变为 ' + this.color.name + '，' + this.color.desc);
    trafficLight.setState(this);
};

/* 交通灯类 */
var TrafficLight = function() {
    this.state = null;
};

/* 获取交通灯状态 */
TrafficLight.prototype.getState = function() {
    return this.state;
};

/* 设置交通灯状态 */
TrafficLight.prototype.setState = function(state) {
    this.state = state;
};

// 实例化一个红绿灯
var trafficLight = new TrafficLight();

// 实例化红绿灯可能有的三种状态
var redState = new State('红色', '行人等待 & 车辆等待');
var greenState = new State('绿色', '行人等待 & 车辆通行');
var yellowState = new State('黄色', '行人等待 & 车辆等待');

redState.employ(trafficLight); // 输出： 交通灯颜色变为 红色，行人通行 & 车辆等待
yellowState.employ(trafficLight); // 输出： 交通灯颜色变为 黄色，行人等待 & 车辆等待
greenState.employ(trafficLight); // 输出： 交通灯颜色变为 绿色，行人等待 & 车辆通行
