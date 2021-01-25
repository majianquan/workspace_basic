var candidate = 10;
var examCarNum = 0;

function ExamCar(carType) {
    examCarNum++;
    this.carId = examCarNum;
    this.carType = carType ? '手动挡' : '自动挡';
}
ExamCar.prototype.examine = function(candidateId) {
    console.log('考生- ' + candidateId + ' 在' + this.carType + '驾考车- ' + this.carId + ' 上考试');
};

var manualExamCar = new ExamCar(true);
var autoExamCar = new ExamCar(false);

for (let candidateId = 1; candidateId <= candidate; candidateId++) {
    var examCar = candidateId % 2 ? manualExamCar : autoExamCar
    examCar.examine(candidateId);
}
console.log('驾考车总数 - ' + examCarNum);
