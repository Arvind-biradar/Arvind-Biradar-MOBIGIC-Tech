import Navbar from "./components/Navbar";

import { BrowserRouter, Route, Routes } from "react-router-dom";

import Login from "./pages/Login";
import AllList from "./pages/AllList" 
import RegisterationDone from './pages/RegisterationDone'
import MyInfo from "./pages/MyInfo";
import CustomerRegister from "./pages/CustomerRegister";
import List from "./pages/List";
import UploadFile from "./pages/UploadFile"


export default function App() {
  return (
    //style={{width:"100vw"}}
   <div >
    
     <BrowserRouter>
     <Navbar/>  
        { <Routes>
          <Route element={<List/>} path="/list" />
          <Route element={<UploadFile/>} path="/upload" />
          <Route element={<Login/>} path="/login" />
          <Route element={<AllList/>} path="/alllist" />
          <Route element={<MyInfo/>} path="/myinfo" />
          <Route element={<CustomerRegister/>} path="/cregister" />
          <Route element={<RegisterationDone/>} path="/registerdone" />
      </Routes>
       }
     </BrowserRouter>    
   </div>
  );
}

