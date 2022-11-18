
    
  
import axios from "axios"
import { Carousel } from "react-bootstrap"
import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"


export default function UserDetails(){
    const { id } = useParams()
    const [data, setData] = useState(null)

    useEffect(() => {
        axios.get('http://localhost:8080/fileupload' + id)
            .then(resp => {
                console.log()
                setData(resp.data);
            })
    }, [id])

    return (
        <>
            <div className="container mt-5">
                <div className="row">
                    <div className="col-sm-5 offset-1">
                        <h5>Apartment Details</h5>
                        <h1>File Name</h1>

                        <table>
                            <tr>FileName</tr>
                            <tr>unicode</tr>
                        <tr><button type={"submit"} value={"Delete"} style={{width:"60px"}}>Delete</button>
                        </tr>
                        
                        </table>
                        

                    </div>
                   
                </div>
            </div>
        </>
    )
}