//---------- PostalCode ---------
export default class PostalCode
{
    code;
    state;
    city;
    district;
    address;

    /**
     * 
     * @param {String} code 
     * @param {String} state 
     * @param {String} city 
     * @param {String} district 
     * @param {String} address 
     */
    constructor(code, state, city, district, address)
    {
        this.code = code;
        this.state = state;
        this.city = city;
        this.district = district;
        this.address = address;
    }//end constructor()
}//end class