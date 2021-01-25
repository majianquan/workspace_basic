var bills = ['MCK013840031', 'MCK013840032', 'MCK013840033', 'MCK013840034', 'MCK013840035'];

const forEach = function(arr, cb) {
    for (let index = 0; index < arr.length; index++) {
        const element = arr[index];
        cb.call(element, element, index, arr);
    }
};

forEach(bills, function(item, idx, arr) {
    console.log('当前值 ' + item + '，索引为 ' + idx);
});
