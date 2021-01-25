

const each = function(obj, callback) {
    var i = 0;

    // 数组
    if (typeOf(obj) === 'array') {
        for (; i < obj.length; index++) {
            if (callback.call(obj[i], i, obj[i]) === false) break;
        }
    }
    // 对象
    if (typeOf(obj) === 'object') {
        for (i in obj) {
            if (callback.call(obj[i], i, obj[i]) === false) break;
        }
    }
    return obj
};

function typeOf(obj) {
    const toString = Object.prototype.toString;
    const map = {
        '[object Boolean]': 'boolean',
        '[object Number]': 'number',
        '[object String]': 'string',
        '[object Function]': 'function',
        '[object Array]': 'array',
        '[object Date]': 'date',
        '[object RegExp]': 'regExp',
        '[object Undefined]': 'undefined',
        '[object Null]': 'null',
        '[object Object]': 'object'
    };
    return map[toString.call(obj)];
}
