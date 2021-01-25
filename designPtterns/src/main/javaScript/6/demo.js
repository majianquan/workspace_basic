var chinaPlug = {
    type: '中国插头',
    voltage: 220,
    chinaInPlug() {
        console.log(`开始供电,电压${this.voltage}V`);
    }
};

var japanPlug = {
    type: '日本插头',
    voltage: 110,
    japanInPlug() {
        console.log(`开始供电,电压${this.voltage}V`);
    }
};

function japanPlugAdapter(plug) {
    // 适配器让电压变成220
    plug.voltage = 220;
    return {
        chinaInPlug() {
            return plug.japanInPlug();
        }
    };
}

japanPlugAdapter(japanPlug).chinaInPlug();
