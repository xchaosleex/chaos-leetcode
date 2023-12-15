/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStrSimple = function (haystack, needle) {
    // 如果needle为空字符串，则返回0
    if (needle === "") return 0;
    // 获取两个字符串的长度
    const n = haystack.length;
    const m = needle.length;
    // 遍历haystack
    for (let i = 0; i <= n - m; i++) {
        // 对于haystack中的每个子串，检查它是否与needle相等
        let j;
        for (j = 0; j < m; j++) {
            // 一旦发现不匹配的字符，跳出内部循环
            if (haystack[i + j] !== needle[j]) break;
        }
        // 如果完整地遍历了needle，则找到了匹配的子串
        if (j === m) return i;
    }
    // 如果没有找到匹配的子串，返回-1
    return -1;
};

/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStrKmp = function (haystack, needle) {
    if (needle === "") return 0;
    // 构建部分匹配表 (Partial Match Table)
    const lps = computeLPSArray(needle);
    let i = 0; // haystack 的索引
    let j = 0; // needle 的索引
    while (i < haystack.length) {
        if (needle[j] === haystack[i]) {
            i++;
            j++;
        }
        if (j === needle.length) {
            return i - j; // 找到匹配，返回索引
        }
        // 不匹配时，根据部分匹配表移动j的位置
        else if (i < haystack.length && needle[j] !== haystack[i]) {
            if (j !== 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
    }
    return -1; // 未找到匹配
};

// 计算部分匹配表（Longest Prefix Suffix）
function computeLPSArray(needle) {
    const lps = new Array(needle.length).fill(0);
    let length = 0; // 最长相同前后缀的长度
    let i = 1; // 当前位置的索引
    while (i < needle.length) {
        if (needle[i] === needle[length]) {
            // 如果当前字符与LPS的下一个字符匹配
            length++;
            lps[i] = length; // 在LPS数组中记录下当前LPS长度
            i++;
        } else {
            // 如果不匹配
            if (length !== 0) {
                // 如果length不为0，说明之前有匹配的，我们回溯到上一个可能的LPS
                length = lps[length - 1];
                // 注意这里不增加i，我们会在下一个循环中尝试新的LPS长度
            } else {
                // 如果length为0，说明我们不能回溯，所以当前位置的LPS就是0
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}


console.log(strStrSimple("leetcode", "code"))
console.log(strStrKmp("leetcode", "code"))