export default function CardProduto({ produto }) {
    function excluir(){
        fetch(`http://localhost:8080/produtos/${produto.id}`,
        {
            method:'DELETE'
        }
        )
        .then(data => alert('Produto excluido com sucesso'))
        .catch((error)=> alert(error))
    }
    return (
        <div className="col-sm-3 m-4">
            <h1>produto: {produto.id} </h1>
            <p>Descrição: {produto.descricao}</p>
            <p>Estoque: {produto.estoque}</p>
            <p>Valor R$: {produto.valorUnitario}</p>
            <p>Categoria: {produto.categoria?.descricao}</p>
            <div className="d-flex justify-content-between">
                <button className="btn btn-primary">Editar</button>
                <button 
                   className="btn btn-danger"
                   onClick={excluir}
                   >Excluir</button>
            </div>
        </div>

    )
}