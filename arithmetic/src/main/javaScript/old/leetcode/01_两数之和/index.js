function Solution(nums, target) {
    const record = new Map()
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i]
        if (record.has(complement)) {
            return [record.get(complement),i]
        }
        record.set(nums[i], i)
    }
    return record
}

var nums = [2, 7, 11, 15],
    target = 9


console.log(Solution(nums, target));