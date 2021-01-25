const priceCalculate = (function() {
    const DiscountMap = {
        // 满100减30
        minus100_30: function(price) {
            return price - Math.floor(price / 100) * 30;
        },
        // 满200减80
        minus200_80: function(price) {
            return price - Math.floor(price / 200) * 80;
        },
        // 8折
        percent80: function(price) {
            return price * 0.8;
        }
    };
    return {
        // 计算价格
        priceCalc: function(discountType, price) {
            return DiscountMap[discountType] && DiscountMap[discountType](price);
        },
        // 添加策略方法
        addStrategy: function(discountType, fn) {
            if (DiscountMap[discountType]) return;
            DiscountMap[discountType] = fn;
        }
    };
})();
