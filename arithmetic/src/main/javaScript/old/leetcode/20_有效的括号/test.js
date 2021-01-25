var str = '([{()}])';
function isValid(s) {
    let valid = true
    const stack = []
    const mapper = {
        "{": "}",
        "[": "]",
        "(": ")"
    }
    for (let i in s) {
        const v = s[i];
        if(Object.keys(mapper).indexOf(v) > -1) {
            stack.push(v)
        } else {
            const peak = stack.pop()
            if(v !== mapper[peak]) {
                return false
            }
        }
    }
    if (stack.length) return false;
    return valid
}
console.log(isValid(str));