const adadisPub = {
    adadisBook: [], // adadis售货员的小本本
    subShoe(customer) {
        // 买家在小本本是登记号码
        if (!this.adadisBook.includes(customer))
            // 判重
            this.adadisBook.push(customer);
    },
    unSubShoe(customer) {
        // 取消订阅
        if (!this.adadisBook.includes(customer)) return;
        const idx = this.adadisBook.indexOf(customer);
        this.adadisBook.splice(idx, 1);
    },
    notify() {
        // 售货员打电话通知小本本上的买家
        for (const customer of this.adadisBook) {
            customer.update();
        }
    }
};

const customer1 = {
    phoneNumber: '152xxx',
    update() {
        console.log(this.phoneNumber + ': 去商场看看');
    }
};

const customer2 = {
    phoneNumber: '138yyy',
    update() {
        console.log(this.phoneNumber + ': 给表弟买双');
    }
};

adadisPub.subShoe(customer1); // 在小本本上留下号码
adadisPub.subShoe(customer1);
adadisPub.subShoe(customer2);
adadisPub.unSubShoe(customer1);

adadisPub.notify(); // 打电话通知买家到货了
