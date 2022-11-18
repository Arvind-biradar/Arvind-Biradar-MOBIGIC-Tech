


import axios from "axios";
import {  useNavigate } from "react-router-dom";
import { useState } from "react";
import React from "react";
import "../components/3.css";
//import { signUpUser }from "../schemas/SignUpCustomerYuup"
import { useFormik } from "formik";
import Swal from "sweetalert2";
import "../components/login.css";


const initialValues = {

  file: ""
}

export default function UserDetails() {
  return (
    <div>
      <CustomerTable />
    </div>
  );
}

function CustomerTable() {
  const [uidPic, setadharcardimage] = useState("");
  const navigate=useNavigate();
    const handleFileInput=e=>{
    setadharcardimage(e.target.files[0])
}

 


  const { values, errors, touched, handleChange, handleBlur, handleSubmit } = useFormik({

    initialValues: initialValues,
    validationSchema: "",
    onSubmit: async (value) => {  
        console.log("SignUp Customer...done");
        console.log("User :  "+sessionStorage.getItem("id"));
        if(uidPic===""||uidPic===null){
      Swal.fire({
        position: "center",
        title: "Please Upload Image",
        timer: 1500,
      });
    return}
      console.log(value);
      const fd=new FormData();
  
    fd.append("file",uidPic) ;
    fd.append("userid",sessionStorage.getItem("id"));
   

    const url = `http://localhost:8080/fileupload`;
    await axios.post(url, fd)
    .then(resp=>{
      console.log("Arvindddddddd......................................................");
      console.log(resp.data.userid);
      Swal.fire({
            position: "center",
            icon: "success",
            title: "Registered Successfully",
            showConfirmButton: false,
            timer: 1500,
          });
      navigate("/login")
    })
    .catch(error=>{
      Swal.fire({
            position: "center",
            icon: "error",
            title: error.response.data,
            showConfirmButton: false,
            timer: 1500,
          });
    });
  
       

    }

  
  });
  
  return (
    <div className="container mt-5">
      <div className="title">User File Upload</div>
      
      <form onSubmit={handleSubmit}>
        <div className="user-details">
         
          <div className="input-box">
             <span className="details">Upload File</span>
            <input
              type="file"
              style={{width:"420px"}}
              className="form-control"
              placeholder="Upload Aadhar Card"
              id="formFileSm"
              name="uidPic"
              accept=".jpg,.png,.jpeg"
              onChange={handleFileInput}
            
            />
          </div>
        </div>
       
        <div className="button">
        
          <input type="submit" className="bg-success bg-gradient" value="Submit" />
        </div>
      </form>
    </div>
  );
}