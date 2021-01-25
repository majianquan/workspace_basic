class ManageGame {
    static _schedule = null;

    static getInstance() {
        if (ManageGame._schedule) {
            // 判断是否已经有单例了
            return ManageGame._schedule;
        }
        return (ManageGame._schedule = new ManageGame());
    }

    constructor() {
        if (ManageGame._schedule) {
            // 判断是否已经有单例了
            return ManageGame._schedule;
        }
        ManageGame._schedule = this;
    }
}

const schedule2 = ManageGame.getInstance();
const schedule1 = new ManageGame();
const schedule3 = new ManageGame();
const schedule4 = ManageGame.getInstance();

console.log(schedule1 === schedule2);
console.log(schedule1 === schedule3);
console.log(schedule2 === schedule4);
