/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const chunkededArray = [];
    
    for (let i = 0; i < arr.length; i += size) {
        chunkededArray.push(arr.slice(i, i + size));
    }
    
    return chunkededArray;
};
