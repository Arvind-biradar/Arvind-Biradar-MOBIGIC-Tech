import * as Yup from 'yup'



export const  YupLogin =Yup.object({

    email :Yup.string().email(" must be valid email").required("    please fill this field"),
  
     password :Yup.string().min(6,"  length must be 6 character").max(20).required("    please fill this field"),
    

})