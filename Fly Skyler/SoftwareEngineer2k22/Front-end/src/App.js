//----------- Import libs ----------
import React, {useState} from 'react';
import axios from 'axios';


//----------- Import Middleware ----------
import PostalCode from './Middleware/PostalCode';


//----------- Components ----------
import Header from './Components/Header/Header';
import PostalCodeDisplay from './Components/PostalCodeDisplay/PostalCodeDisplay';


//----------- Style Imports ----------
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Table from 'react-bootstrap/Table';
import Alert from 'react-bootstrap/Alert';
import Spinner from 'react-bootstrap/Spinner';


//----------- Custom Style Imports ----------
import './App.css';
 

//----------- Function App ----------
/**
 * App page
 * 
 * @returns {JSX}
 */
export default function App() 
{
  const [userText, setUserText] = useState("");
  
  const [displayInfo, setDisplayInfo] = useState(false);
  const [postalCode, setPostalCode] = useState(new PostalCode());
  const [errorMessage, setErrorMessage] = useState("");

  const [isLoading, setIsLoading] = useState(false);
  const [isAdded, setIsAdded] = useState(false);
  const [alertType, setAlertType] = useState("");
  const [alertMessage, setAlertMessage] = useState("");
  
  /**
   * Search for postal code
   * 
   * @param {String} input 
   */
  const searchPostalCode = async (input) => {
    if(input !== "" && input !== null)
    {
      const url = `https://ws.apicep.com/cep/${input}.json`;

      try
      {
        const res = await axios.get(url);
        const data = res.data;

        if(res.status === 200 && data.status === 200)
        {
          const newdata = new PostalCode(
            data.code,
            data.state,
            data.city,
            data.district,
            data.address
          );
          setPostalCode(newdata);
          setDisplayInfo(true);
        }
        else
        {
          setErrorMessage(data.message);
          setDisplayInfo(false);
        }//end if
      }
      catch(e)
      {
        const data = e.response.data;

        setErrorMessage(data.message);
        setDisplayInfo(false);
      }//end try/catch
    }
    else
    {
      setErrorMessage("Empty input");
      setDisplayInfo(false);
    }//end if
  };

  /**
   * Add postal code to database
   */
  const addPostalCode = async () => {
    setIsLoading(true);
    
    try 
    {
      const url = `https://skyler-postalcode-api.web.app/postalcode/insert`;

      const res = await axios.post(url, postalCode);
      const data = res.data;

      if(res.status === 201)
      {
        setIsLoading(false);

        setAlertType("success");
        setAlertMessage(data.message);

        setIsAdded(true);
        await setTimeout(() => setIsAdded(false), 3000);
      }//end if
    }
    catch(error)
    { 
      setIsLoading(false);
      const data = error.response.data;

      if(data.status === 409)
      {
        setAlertType("warning");
        setAlertMessage(data.message);        
      }
      else
      {
        setAlertType("danger");
        setAlertMessage(data.message);
      }//end if

      setIsAdded(true);
    }//end if
  };

  return (
    <>
      <Header />

      <main>
        <section className="search-postalcode">
          <Form validated className="search-form">
            <FloatingLabel
              controlId="cepInput"
              label="Digite o Código Postal"
            >
              <Form.Control
                className="search-input"
                type="text"
                placeholder="00000-000"
                inputMode='numeric'
                minLength={2}
                maxLength={9}
                value={userText}
                onChange={(e) => setUserText(e.target.value)} 
              />
            </FloatingLabel>
            <Button variant="info" onClick={() => searchPostalCode(userText)}>Pesquisar</Button>
          </Form>

          {displayInfo ? 
          <Container fluid className="info-table">
            <Table striped hover>
              <thead>
                <tr>
                  <th>Code</th>
                  <th>State</th>
                  <th>City</th>
                  <th>District</th>
                  <th>Address</th>
                </tr>
              </thead>
              
              <tbody>
                <tr>
                  <td>{postalCode.code}</td>
                  <td>{postalCode.state}</td>
                  <td>{postalCode.city}</td>
                  <td>{postalCode.district}</td>
                  <td>{postalCode.address}</td>
                </tr>
              </tbody>
            </Table>

            <Container fluid className="info-buttonContainer">
              {isAdded ? <Alert className="info-alert" variant={alertType}>{alertMessage}</Alert> : null}
              <Button className="info-addbutton" variant="info" onClick={() => addPostalCode()}>
                {isLoading ? <Spinner size="sm" animation="border"/> : "Adicionar"}
              </Button>
            </Container>
          </Container> : 
          <p className="errorMessage">{errorMessage}</p>}
        </section>

        <PostalCodeDisplay />
      </main>
    </>
  );
}//end App()
