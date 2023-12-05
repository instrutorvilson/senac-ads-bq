import { useEffect, useState } from "react"

export default function Consulta(){
    const[produtos, setProdutos] = useState([])
    function consultar(){
        fetch('http://localhost:8080/produtos')
        .then(data => data.json())
        .then(response => setProdutos(response))
    }

    useEffect( ()=>{consultar()},[])

    return(
        <div>
            <h1>Consulta de produtos</h1>
            {
                produtos.map(prod => <p>{prod.descricao}</p>)
            }
        </div>
    )
}