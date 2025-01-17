import { useEffect, useState } from "react"
import { api } from "../service/api"

export function useFetch<T = unknown>(url: string,token?:string){ 
    const [data,setData] = useState<T>()
    const [error,setError] = useState<unknown>()
    const [isFetching,setIsFetching] = useState<boolean>(true)

    useEffect(()=>{
        const headers: Record<string, string> = {
            'Content-Type': 'application/json',
        };
        if (token) {
            headers['Authorization'] = token;
        }
        api.get(url).then((response)=>{
            setData(response.data)
        }).catch(error=>{
            setError(error)
        }).finally(()=>{
            setIsFetching(false)
        })
    },[url])

    return {data,error,isFetching}
}