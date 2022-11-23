//---------- Imports ----------
const atividades = require("../atividades.json");


//---------- Functions ----------
/**
 * Busca as atividades, ordena e trás de acordo com a paginação proposta
 * 
 * @param {Number} pagination 
 */
function ActAtividades(pagination)
{
    let answer = {
        "status": 500,
        "message": "Internal Error"
    };

    const pag = Number(pagination);
    const quantPags = Math.floor(atividades.length/5);

    if(pag !== NaN && pag > 0)
    {
        if(pag > quantPags)
        {
            answer = {
                "status": 204,
                "message": "No content"
            };
        }
        else
        {
            let list = [];

            for(let i = 1; i <= 5; i++)
            { list.push(atividades[i*pag]); }

            answer = {
                "status": 200,
                "message": "Success",
                "atividades": list,
                "página": pag
            };
        }//end if
    }//end if

    return(answer);
}//end ActAtividades()


//---------- Exports ----------
module.exports = ActAtividades;