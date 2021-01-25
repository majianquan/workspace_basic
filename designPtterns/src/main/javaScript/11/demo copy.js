let examCarNum = 0; // 驾考车总数

class ExamCar {
    constructor(carType) {
        examCarNum++;
        this.carId = examCarNum;
        this.carType = carType ? '手动挡' : '自动挡';
        this.usingState = false; // 是否正在使用
    }
    examine(candidateId) {
        return new Promise(resolve => {
            this.usingState = true;
            console.log('考生- ' + candidateId + ' 在' + this.carType + '驾考车- ' + this.carId + ' 上考试');
            setTimeout(() => {
                console.log(`%c考生- ${candidateId} 在${this.carType}驾考车- ${this.carId} 上考试完毕`, 'color:#f40');
                resolve(); // 0~2秒后考试完毕
            }, Math.random() * 2000);
        });
    }
}
/* 手动档汽车对象池 */
ManualExamCarPool = {
    _pool: [], // 驾考车对象池
    _candidateQueue: [] // 考生队列
};
