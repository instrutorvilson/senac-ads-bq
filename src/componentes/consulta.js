import { useEffect, useState } from "react"
import CardProduto from "./cardProduto"

export default function Consulta(){
    const[produtos, setProdutos] = useState([])
    function consultar(){
        fetch('http://localhost:8080/produtos')
        .then(data => data.json())
        .then(response => setProdutos(response))
    }

    useEffect( ()=>{consultar()},[])

    return(
        <div className="d-flex flex-wrap  ">
            <h1>Consulta de produtos</h1>
            {
                produtos.map(prod => <CardProduto produto={prod}/>)
            }
        </div>
    )
}