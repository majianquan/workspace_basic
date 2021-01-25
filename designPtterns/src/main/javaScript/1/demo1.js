function ManageGame() {
    if (ManageGame._instance) {
        return ManageGame._instance;
    }
    ManageGame._instance = this;
}
ManageGame.getInstance = function() {
    if (ManageGame._instance) {
        return ManageGame._instance;
    } else {
        return new ManageGame();
    }
};

const schedule2 = ManageGame.getInstance();
const schedule1 = new ManageGame();
const schedule3 = new ManageGame();
const schedule4 = ManageGame.getInstance();

console.log(schedule1 === schedule2);
console.log(schedule1 === schedule3);
console.log(schedule2 === schedule4);
