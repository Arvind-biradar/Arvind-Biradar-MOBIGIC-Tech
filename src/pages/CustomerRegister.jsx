import { useState } from "react";
import "../components/login.css";
import "../pages/Errors.css"; 
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";
import { useFormik } from "formik";
import axios from "axios";
import { YupLogin } from "../schemas/loginYup";


export default function CustomerRegister() {

  return (
    <div>
      <LoginTable />
    </div>
  );
}
const initialValues = {

  email: "",
  password: "",

}

function LoginTable() {

  const navigate =useNavigate();


  const { values, errors, touched, handleChange, handleBlur, handleSubmit } =
  useFormik({

    initialValues: initialValues,
    validationSchema: YupLogin,
    onSubmit: async(value) => {
   

    // console.log("SignUp Customer...done");
 
    // console.log(value);
    let user = { username: value.email, password: value.password };
    await axios.post("http://localhost:8080/customers", user)
    .then(resp=>{
      console.log("Successs......Arvindddddddd......................................................");
    Swal.fire({
          position: "center",
          icon: "success",
          title: "Registered Successfully",
          showConfirmButton: false,
          timer: 1500,
        });
        navigate("/alllist")
  })
  .catch(error=>{
    console.log("Errrorrr    Arvindddddddd......................................................");
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
    <div>
      
      <div className="center">
        <h5 className="p-3 text-center bg-info rounded-top bg-gradient text-white">Registeration</h5>
        <form onSubmit={handleSubmit}>
          <div className="txt_field">
            <input
              name="email"
              type="email"
              value={values.email}
              onChange={handleChange}
              onBlur={handleBlur}
         
            />
            <label>Email Id
            {errors.email && touched.email ? (<span className="errors">{errors.email}
              </span>) : null}
            </label>
          </div>
          <div className="txt_field">
            <input
              name="password"
              type="password"
              value={values.password}
              onChange={handleChange}
              onBlur={handleBlur}
            />
            
            <label>Password
            {errors.password && touched.password ? (<span className="errors">{errors.password}
              </span>) : null}
            </label>
          </div>
          <br/>
          <input
            type="submit"
            value="Login"
          />          
        </form>
      </div>
    </div>
  );
}

