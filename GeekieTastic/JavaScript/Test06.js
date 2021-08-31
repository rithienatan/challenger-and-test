const set = new Set();
const w = { x: 0, y: 0 };

set.add({ x: 0, y: 0 });
set.add(w);

w.z = 0;

console.log(set.has({ x: 0, y: 0 }), set.has(w));