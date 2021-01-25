import * as Validates from './validates.js';
/**
 *
 * @param {*} key 通用验证规则的方法名
 * @param {*} msg 报错的表单验证的提示信息。
 */
export const formValidateGene = (key, msg) => (rule, value, cb) => {
    if (Validates[key](value)) {
        cb();
    } else {
        cb(new Error(msg));
    }
};
