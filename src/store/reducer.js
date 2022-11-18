const initialState={
    IsLoggedIn:sessionStorage.getItem("userid")!==null,
    Username: sessionStorage.getItem("uname")===null ?"":sessionStorage.getItem("uname"),
    Password: sessionStorage.getItem("password")===null ? "":sessionStorage.getItem("password")
}
console.log("REAUSDCER UNS");

const reducer=(state=initialState,action)=>{
    switch(action.type)
    {
        case 'IsLoggedIn':
            return {
                IsLoggedIn:true,
                Username:sessionStorage.getItem("uname"),
                Password:sessionStorage.getItem("password")
            } 
        case 'LogOut':
            sessionStorage.clear()
            return {IsLoggedIn:false,Username:'',Password:''}
        default:
            return state
    }
}

export default reducer;