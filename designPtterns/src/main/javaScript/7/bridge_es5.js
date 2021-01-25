// 组装洗衣机
function Washter(motorTpe, rollerType, transducerType) {
    this.motor = new Motor(motorTpe);
    this.roller = new Roller(rollerType);
    this.transducer = new Transducer(transducerType);
}
Washter.prototype.work = function() {
    this.motor.run();
    this.roller.run();
    this.transducer.run();
};

// 电机
function Motor(type) {
    this.motorTpe = type + '电机';
}
Motor.prototype.run = function() {
    console.log(this.motorTpe + '开始工作');
};

// 滚筒
function Roller(type) {
    this.rollerType = type + '滚筒';
}
Roller.prototype.run = function() {
    console.log(this.rollerType + '开始工作');
};

// 变频器
function Transducer(type) {
    this.transducerType = type + '变频器';
}
Transducer.prototype.run = function() {
    console.log(this.transducerType + '开始工作');
};

// 新建洗衣机
var washerA = new Washter('小功率', '直立', '小功率');
washerA.work();
