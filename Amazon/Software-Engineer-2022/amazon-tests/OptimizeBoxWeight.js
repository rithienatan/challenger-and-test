/**
 * Optimize box method
 * 
 * @param {Array} arr
 * 
 * @returns {Array}
 */
function OptimizeBoxWeight(arr)
{
    arr.sort((a, b) => a-b);

    let box = [arr[0]];

    return(box);
}//end OptimizeBoxWeight()


//----------- Run ----------
let init = performance.now();
const answer = OptimizeBoxWeight([3, 7, 5, 6, 2]);
let end = performance.now();

console.log (`Execution time: ${end - init}`);
answer.forEach((element) => { console.log(element); });