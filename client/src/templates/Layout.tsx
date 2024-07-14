import { Outlet } from "react-router-dom";
import Header from "../components/Header";


export function LayoutTemplate(){

    return(
        <>
            <Header/>
            <Outlet/>
        </>
    )

}