//---------- Imports ---------
const express = require("express");
const cors = require("cors");


//---------- Imports ---------
const ActAtividades = require("./actions/ActAtividades");


//---------- Configs ---------
const app = express();
const port = 3000;
app.use(cors());
app.use(express.json());


//--------- REST API -----------
app.get("/", (req, res) => {
    res.status(200).json({
        status: 200,
        message: "Tarefa II"
    });
});

app.post("/atividades/:pag", (req, res) => {
    const content = ActAtividades(req.params.pag);

    res.status(content.status).json(content);
});


//--------- listen -----------
app.listen(port, () => {
    console.log(`Example app listening on port http://localhost:${port}`)
});