
// 

import axios from "axios"
import { Carousel } from "react-bootstrap"
import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"


export default function UserDetails(){
    const { id } = useParams()
    const [data, setData] = useState(null)

    useEffect(() => {
        axios.get('http://localhost:8080/api/apartments/' + id)
            .then(resp => {
                setData(resp.data)
            })
    }, [id])

    return (
        <>
            <div className="container mt-5">
                <div className="row">
                    <div className="col-sm-5 offset-1">
                        <h5>Apartment Details</h5>
                        <div className="card" style={{ width: '28rem' }}>
                            {/* <Carousel>
                                <Carousel.Item>
                                    <img
                                        className="d-block w-100"
                                        src={'http://localhost:8080/' + data?.photo1} height={300}
                                        alt="First slide"
                                    />
                                </Carousel.Item>
                                <Carousel.Item>
                                    <img
                                        className="d-block w-100"
                                        src={'http://localhost:8080/' + data?.photo2} height={300}
                                        alt="Second slide"
                                    />
                                </Carousel.Item>

                                <Carousel.Item>
                                    <img
                                        className="d-block w-100"
                                        src={'http://localhost:8080/' + data?.photo3} height={300}
                                        alt="Third slide"
                                    />
                                </Carousel.Item>
                                <Carousel.Item>
                                    <img
                                        className="d-block w-100"
                                        src={'http://localhost:8080/' + data?.photo4} height={300}
                                        alt="Fourth slide"
                                    />
                                </Carousel.Item>
                            </Carousel> */}
                            <div className="card-body">
                                <h5 className="card-title">{data?.name}</h5>
                                <h6>{data?.address}, {data?.city} {data?.district}</h6>
                            </div>
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">₹ {data?.rent}/month</li>
                                <li className="list-group-item">For {data?.gender} only</li>
                                <li className="list-group-item">{data?.furnishtype}</li>
                                <li className="list-group-item">{data?.flattype}</li>
                                <li className="list-group-item">Space available  :  {data?.totalbeds - data?.bookings}</li>
                            </ul>
                            <div className="card-body">
                               
                            </div>
                        </div>

                    </div>
                   
                </div>
            </div>
        </>
    )
}