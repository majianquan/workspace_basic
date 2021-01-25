const Publisher = (function() {
    const _subsMap = {}; // 存储订阅者
    return {
        /* 消息订阅 */
        subscribe(type, cb) {
            if (_subsMap[type]) {
                if (!_subsMap[type].includes(cb)) _subsMap[type].push(cb);
            } else _subsMap[type] = [cb];
        },
        /* 消息退订 */
        unsubscribe(type, cb) {
            if (!_subsMap[type] || !_subsMap[type].includes(cb)) return;
            const idx = _subsMap[type].indexOf(cb);
            _subsMap[type].splice(idx, 1);
        },
        /* 消息发布 */
        notify(type, ...payload) {
            if (!_subsMap[type]) return;
            _subsMap[type].forEach(cb => cb(...payload));
        }
    };
})();

Publisher.subscribe('运动鞋', message => console.log('152xxx' + message)); // 订阅运动鞋
Publisher.subscribe('运动鞋', message => console.log('138yyy' + message));
Publisher.subscribe('帆布鞋', message => console.log('139zzz' + message)); // 订阅帆布鞋

Publisher.notify('运动鞋', ' 运动鞋到货了 ~'); // 打电话通知买家运动鞋消息
Publisher.notify('帆布鞋', ' 帆布鞋售罄了 T.T'); // 打电话通知买家帆布鞋消息
