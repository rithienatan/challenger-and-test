/*---------- Imports ----------*/
import axios from "axios";


/*---------- Exports ----------*/
/**
 * Get Star Wars ships from SWAPI
 * 
 * @return { array } ships
 */
export async function StarWarsShips()
{
    let ships = [];

    let page = 1;
    let key = 0;

    while(page != null)
    {
        await axios.get(`https://swapi.dev/api/starships/?page=${page}`).then(response => {
            response.data.results.map((object) => {
                let MGLT = 0;
                if(object.MGLT !== "unknown")
                { MGLT = parseInt(object.MGLT); }

                let consumablesString = object.consumables.split(' ');
                let resourceTime = 0;
                if(object.consumables !== "unknown")
                {
                    if(consumablesString[1].includes('day') == true)
                    { resourceTime = parseInt(consumablesString[0]) * 24; }
                    else if(consumablesString[1].includes('week') == true)
                    { resourceTime = parseInt(consumablesString[0]) * 168; }
                    else if(consumablesString[1].includes('month') == true)
                    { resourceTime = parseInt(consumablesString[0]) * 730; }
                    else if(consumablesString[1].includes('year') == true)
                    { resourceTime = parseInt(consumablesString[0]) * 8760; }
                    else
                    { resourceTime = 0; }
                }//end if

                ships.push({
                    'key': key,
                    'name': object.name,
                    'model': object.model,
                    'consumables': resourceTime,
                    'MGLT': MGLT
                });

                key = key + 1;
            });

            if(response.data.next != null)
            { page = page + 1; }
            else
            { page = null; }
        });
    }//end while
    
    return ships;
}//end StarWarsShips()