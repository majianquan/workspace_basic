/* 男方 */
const ZhangXiaoShuai = {
    name: '张小帅',
    family: '张小帅家',
    info: { age: 25, height: 171, salary: 5000 },
    target: { age: [23, 27] }
};

/* 男方家长 */
const ZhangXiaoShuaiParent = {
    name: '张小帅家长',
    family: '张小帅家',
    info: null,
    target: { height: [160, 167] }
};

/* 女方 */
const LiXiaoMei = {
    name: '李小美',
    family: '李小美家',
    info: { age: 23, height: 160 },
    target: { age: [25, 27] }
};

/* 女方家长 */
const LiXiaoMeiParent = {
    name: '李小美家长',
    family: '李小美家',
    info: null,
    target: { salary: [10000, 20000] }
};
const MatchMaker = {
    matchBook: {},
    registerPersons(...personList) {
        personList.forEach(person => {
            if (this.matchBook[person.family]) {
                this.matchBook[person.family].push(person);
            } else {
                this.matchBook[person.family] = [person];
            }
        });
    }
};
