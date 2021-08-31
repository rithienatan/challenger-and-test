//---------- imports ----------
const express = require('express');


//---------- configure variables -----------
const app = express();


//---------- configure routes ----------
app.get('/', (req, res) => {
    res.send('Hello World!');
});

app.listen(3000, () => {
    console.log('Server listening on http://localhost:3000');
});