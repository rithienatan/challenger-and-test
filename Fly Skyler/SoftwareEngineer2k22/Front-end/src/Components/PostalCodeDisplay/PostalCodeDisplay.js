//----------- Import libs ----------
import React, { useEffect, useState } from 'react';
import axios from 'axios';


//----------- Import Middleware ----------
import PostalCode from '../../Middleware/PostalCode';


//----------- Style Imports ----------
import Table from 'react-bootstrap/Table';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown';
import Spinner from 'react-bootstrap/Spinner';
import Alert from 'react-bootstrap/Alert';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Button from 'react-bootstrap/Button';


//----------- Custom Style Imports ----------
import './PostalCodeDisplay.css';


//----------- Function PostalCodeDisplay ----------
/**
 * PostalCodeDisplay component
 * 
 * @returns {JSX}
 */
export default function PostalCodeDisplay() 
{
    const [content, setContent] = useState([]);

    const [isLoading, setIsLoading] = useState(false);

    const [enableEdits, setEnableEdits] = useState(false);
    const [code, setCode] = useState("");
    const [state, setState] = useState("");
    const [city, setCity] = useState("");
    const [district, setDistrict] = useState("");
    const [address, setAddress] = useState("");

    const [isAct, setIsAct] = useState(false);
    const [alertType, setAlertType] = useState("");
    const [alertMessage, setAlertMessage] = useState("");

    /**
     * Get all postalcode
     */
    const getContent = async () => {
        try 
        {
            const url = `https://skyler-postalcode-api.web.app/postalcode/getall`;

            const res = await axios.get(url);
            const data = res.data;

            if(res.status === 200)
            { setContent(data.content); }
        }
        catch(error)
        { console.error(error); }//end try/catch
    };

    /**
     * Gatilho para update content
     */
    const toUpdate = (postalcode) => {
        setCode(postalcode.code);
        setState(postalcode.state);
        setCity(postalcode.city);
        setDistrict(postalcode.district);
        setAddress(postalcode.address);
        
        setEnableEdits(!enableEdits);
    };

    /**
     * Update content
     */
    const updateContent = async () => {
        setIsLoading(true);

        try
        {
            const url = `https://skyler-postalcode-api.web.app/postalcode/update/${code}`;
            const postal = new PostalCode(
                code,
                state,
                city,
                district,
                address
            );

            const res = await axios.put(url, postal);
            const data = res.data;

            if(res.status === 200)
            {
                setAlertType("success");
                setAlertMessage(data.message);

                setIsAct(true);
                await setTimeout(() => {
                    setEnableEdits(!enableEdits); 
                    setIsAct(false); 
                }, 3000);
            }
            else
            {
                setAlertType("success");
                setAlertMessage(data.message);
                
                setIsAct(true);
                await setTimeout(() => {
                    setEnableEdits(!enableEdits);
                    setIsAct(false);
                }, 3000);
            }//end if
        }
        catch(e)
        {
            const data = e.response.data;

            setAlertType("danger");
            setAlertMessage(data.message);

            setIsAct(true);
            await setTimeout(() => {
                setEnableEdits(!enableEdits); 
                setIsAct(false); 
            }, 3000);
        }//end try/catch

        setIsLoading(false);
    };

    /**
     * Delete content
     * 
     * @param {String} code 
     */
    const deleteContent = async (code) => {
        setIsLoading(true);

        try
        {
            const url = `https://skyler-postalcode-api.web.app/postalcode/delete/${code}`;

            const res = await axios.delete(url);
            const data = res.data;

            if(res.status === 200)
            {
                setAlertType("success");
                setAlertMessage(`${data.content} ${data.message}`);
            }
            else
            {
                setAlertType("warning");
                setAlertMessage(`${data.content} ${data.message}`);
            }//end if

            setIsAct(true)
            await setTimeout(() => setIsAct(false), 3000)
        }
        catch(e)
        {
            console.error(e);

            setIsAct(true);
            await setTimeout(() => setIsAct(false), 3000);
        }//end try/catch

        setIsLoading(false);
    };

    useEffect(() => {
        getContent()
    }, [content]);

    return (
        <section className="show-postalcode">
            {enableEdits ? 
            <Container fluid className="form-update">
                <Form>
                    <FloatingLabel controlId="codeInput" label="Código Postal">
                        <Form.Control
                            className="input-postalcode"
                            type="text"            
                            placeholder="00000-000"
                            inputMode='numeric'
                            maxLength={9}
                            value={code} 
                            onChange={(e) => setCode(e.target.value)}
                        />
                    </FloatingLabel>

                    <FloatingLabel controlId="stateInput" label="Estado">
                        <Form.Control
                            className="input-postalcode"
                            type="text"            
                            placeholder="MG"
                            value={state} 
                            onChange={(e) => setState(e.target.value)}
                        />
                    </FloatingLabel>

                    <FloatingLabel controlId="cityInput" label="Cidade">
                        <Form.Control
                            className="input-postalcode"
                            type="text"
                            value={city} 
                            onChange={(e) => setCity(e.target.value)}
                        />
                    </FloatingLabel>

                    <FloatingLabel controlId="districtInput" label="Distrito">
                        <Form.Control
                            className="input-postalcode"
                            type="text"
                            value={district} 
                            onChange={(e) => setDistrict(e.target.value)}
                        />
                    </FloatingLabel>

                    <FloatingLabel controlId="addressInput" label="Endereço">
                        <Form.Control
                            className="input-postalcode"
                            type="text"
                            value={address} 
                            onChange={(e) => setAddress(e.target.value)}
                        />
                    </FloatingLabel>
                </Form>

                <Button variant="info" onClick={() => updateContent()}>
                    {isLoading ? <Spinner size="sm" animation="border"/> : "Update"}
                </Button>
            </Container>
            : null}
            
            {isAct ? <Alert className="show-alert" variant={alertType}>{alertMessage}</Alert> : null}

            <Table className="show-table" striped hover>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>State</th>
                        <th>City</th>
                        <th>District</th>
                        <th>Address</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                
                <tbody>
                    {content.map((element) => {
                        return (
                            <tr key={element.code}>
                                <td>{element.code}</td>
                                <td>{element.state}</td>
                                <td>{element.city}</td>
                                <td>{element.district}</td>
                                <td>{element.address}</td>
                                <td>
                                    <DropdownButton variant="info" title="Act">
                                        <Dropdown.Item 
                                            eventKey={`${element.code}-1`}
                                            onClick={() => toUpdate(element)}
                                        >
                                            Alterar
                                        </Dropdown.Item>
                                        <Dropdown.Item
                                            onClick={() => deleteContent(element.code)} 
                                            eventKey={`${element.code}-2`}
                                        >
                                            Deletar
                                        </Dropdown.Item>
                                    </DropdownButton>
                                </td>
                            </tr>
                        );
                    })}
                </tbody>
            </Table>
        </section>
    );
}//end PostalCodeDisplay()
