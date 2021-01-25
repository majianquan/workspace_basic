var askLeave = function(duration) {
    if (duration <= 0.5) {
        console.log('小组领导经过一番心理斗争：批准了');
    } else if (duration <= 1) {
        console.log('部门领导经过一番心理斗争：批准了');
    } else if (duration <= 2) {
        console.log('总经理经过一番心理斗争：批准了');
    } else {
        console.log('总经理：不准请这么长的假');
    }
};

askLeave(1)