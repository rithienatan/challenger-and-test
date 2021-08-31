let name = 'a';
let obj1 = { value: 'b' };
let obj2 = { value: 'c' };
let obj3 = obj2;

function process(name, obj1, obj2)
{
    name = 'x';
    obj1 = obj2;
    obj2.value = 'y';
}

process(name, obj1, obj2);

console.log(name);
console.log(obj1.value);
console.log(obj2.value);
console.log(obj3.value);