/**
 * @param {*} discountType 活动策略
 * @param {*} price 价格
 * @returns 返回计算后的价格
 */
function priceCalculate(discountType, price) {
    // 满100减30
    if (discountType === 'minus100_30') {
    
        return price - Math.floor(price / 100) * 30;
    }
    // 满200减80
    else if (discountType === 'minus200_80') {

        return price - Math.floor(price / 200) * 80;

    // 8折
    } else if (discountType === 'percent80') {
        return price * 0.8;
    }
}
