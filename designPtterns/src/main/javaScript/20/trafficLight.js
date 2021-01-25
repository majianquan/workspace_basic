const trafficLight = (function(){
    let state = '红灯'

    return {
        // 设置交通灯颜色
        setState: function(target) {
             if (target === '红灯') {
                state = '红灯'
                console.log('交通灯颜色变为 红色，行人通行 & 车辆等待')
            } else if (target === '黄灯') {
                state = '黄灯'
                console.log('交通灯颜色变为 黄色，行人等待 & 车辆等待')
            } else if (target === '绿灯') {
                state = '绿灯'
                console.log('交通灯颜色变为 绿色，行人等待 & 车辆通行')
            } else {
                console.error('交通灯还有这颜色？')
            }
        },
        // 获取交通等状态
        getState() {
            return state
        }
    }
})();