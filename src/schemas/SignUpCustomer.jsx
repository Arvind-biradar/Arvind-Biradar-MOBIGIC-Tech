import * as Yup from 'yup'



export const  signUpUser =Yup.object({

    name :Yup.string().min(2).max(15).matches(
        /^([A-Za-z\u00C0-\u00D6\u00D8-\u00f6\u00f8-\u00ff\s]*)$/gi,
            '  Name can only contain Latin letters.'
        ).required("     please fill this field"),
    email :Yup.string().email().required("    please fill this field"),
    gender :Yup.string().required("    Gender Not selected"),
    contactno :Yup.number()
    .required()
    .min(7000000000, '  Enter valid 10 Digit Number')
    .max(9999999999, '  Enter valid 10 digit Number')
    .label("   this"),
     password :Yup.string().min(6).max(20).required("  please fill this field"),
     uidPic :Yup.string().required("   please upload in this  field"),
     address :Yup.string().required("   please fill this field"),
     uid :Yup.number().integer()
     .required("     please fill this field").
     min(100000000000, '  Enter valid 12 Digit Number')
     .max(999999999999, '  Enter valid 12 digit Number')
     .label("   this"),
     question :Yup.string().required("  please select in this field"),
     answer :Yup.string().required("  please filll this field"),

})