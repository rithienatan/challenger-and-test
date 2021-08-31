function separate(first, ...rest) { 
    return { first, rest };
 }
 console.log(separate(1, 2, 3, 4, 5));
console.log(separate());