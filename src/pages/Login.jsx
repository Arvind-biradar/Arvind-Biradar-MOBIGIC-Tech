import { useState } from "react";
import "../components/login.css";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";
import { useFormik } from "formik";
import { YupLogin } from "../schemas/loginYup";
import axios from "axios";
import { useDispatch } from "react-redux";
export default function Login() {

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
  const dispatch=useDispatch()
  const navigate =useNavigate();
  const checkUser = async (email,password) => {
    let user = { username: email, password: password };
    await axios.post("http://localhost:8080/customers/validate", user)
    .then(resp=>{
      
        sessionStorage.setItem("uname",resp.data.username)
        sessionStorage.setItem("role",resp.data.role)
        sessionStorage.setItem("userid",resp.data.userid)
        sessionStorage.setItem("id",resp.data.id)
        dispatch({type:'IsLoggedIn'})
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Welcome "+resp.data.username,
          showConfirmButton: false,
          timer: 1500,
      });
      navigate('/MyInfo')
    })
    .catch(error=>{
      console.log("AAA"+ JSON.stringify(error));
      Swal.fire({
          icon: "error",
          text : "Oops...",
          title : "UnValid User"          
        });   
    })    
  };

  const { values, errors, touched, handleChange, handleBlur, handleSubmit } =
  useFormik({

    initialValues: initialValues,
    validationSchema: YupLogin,
    onSubmit: (value) => {
    
      
      checkUser(value.email,value.password);
  
    }


  });
  
  return (
    <div>
      
      <div className="center">
        <h5 className="p-3 text-center bg-info rounded-top bg-gradient text-white">Login</h5>
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

