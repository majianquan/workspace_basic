// 组装洗衣机
class Washter {
    constructor(motorTpe, rollerType, transducerType) {
        this.motor = new Motor(motorTpe);
        this.roller = new Roller(rollerType);
        this.transducer = new Transducer(transducerType);
    }
    work() {
        this.motor.run();
        this.roller.run();
        this.transducer.run();
    }
}

// 电机
class Motor {
    constructor(type) {
        this.motorTpe = type + '电机';
    }
    run() {
        console.log(this.motorTpe + '开始工作');
    }
}
// 滚筒
class Roller {
    constructor(type) {
        this.rollerType = type + '滚筒';
    }
    run() {
        console.log(this.rollerType + '开始工作');
    }
}

class Transducer {
    constructor(type) {
        this.transducerType = type + '变频器';
    }
    run() {
        console.log(this.transducerType + '开始工作');
    }
}

// 新建洗衣机
var washerA = new Washter('小功率', '直立', '小功率');
washerA.work();
