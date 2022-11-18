import { Link } from "react-router-dom";
export default function UserDetails(){
    const user=sessionStorage.getItem("uname");
    return(    
        
       
        <>
        <br></br>
        <br></br>
        <br></br>
            <div className="container mt-5">


            <button style={{marginRight:"22px"}}>
          <Link className="nav-link active" aria-current="page" to="/upload">Upload File</Link>
          </button>


     
           <button style={{marginRight:"22px"}}>
          <Link className="nav-link active" aria-current="page" to="/list">List File</Link>
          </button>
         
           
            <h3>Welcome....</h3>
            <h2>Hellow : {user} </h2>
            </div>
        </>
    )
}
