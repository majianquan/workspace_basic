// 工厂类
class Restaurant {
    constructor() {
        this.menuData = {};
    }
    getMenu(menu) {
        if (!this.menuData[menu]) {
            throw new Error('没有这个');
            const { type, message } = this.menuData[menu];
            return new Menu(type, message);
        }
    }
    addMenu(menu, type, message) {
        if (this.menuData[menu]) {
            console.log('已经存在');
            return;
        }
        this.menuData[menu] = { type, message };
    }
    removeMenu(menu) {
        if (!this.menuData[menu]) return;
        delete this.menuData[menu];
    }
}
/* 菜品类 */
class Menu {
    constructor(type, message) {
        this.type = type;
        this.message = message;
    }

    eat() {
        console.log(this.type + this.message);
    }
}
