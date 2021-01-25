var isValid = function (s) {
    const map = {
        '(': 1,
        '{': 2,
        '[': 3,
        ')': -1,
        '}': -2,
        ']': -3
    }
    const stack = []
    for (let i = 0; i < s.length; i++) {
        const item = s[i]
        if(map[item] > 0) {
            stack.push(item)
        } else {
            let last = stack.pop()
            if(map[last] + map[item] !== 0) {
                return false
            }
        }
    }
    if(stack.length > 0)  return false
    return true
}