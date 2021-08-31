const fruits = ['Apple', 'Banana', 'Mango'];
const foods = { fruits };
const { fruits: [fruit], vegetables: {} } = foods;
console.log(fruit, vegetables);