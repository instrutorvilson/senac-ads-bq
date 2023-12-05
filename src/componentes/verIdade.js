import { useState } from 'react'
export default function VerIdade() {
    /**hook */
    const[nome, setNome] = useState('maria')
    const[idade, setIdade] = useState(10)
    const[resultado, setResultado] = useState('menor')

    function verificar(){
        if(idade < 18)
          setResultado('menor')
        else
         setResultado('maior')  
    }
    return (
        <div className="container">
            <h1 className="text-center mt-4">Novo contato</h1>
            <label className="form-label">Informe nome</label>
            <input 
                className="form-control" 
                type="text"
                placeholder="informe nome"
                value={nome}
                onChange={(txt)=>setNome(txt.target.value)}
            />
            <label className="form-label">Informe idade</label>
            <input 
                className="form-control" 
                type="number"
                placeholder="informe nome"
                value={idade}
                onChange={(txt)=>setIdade(txt.target.value)}
            />
            <button 
               className="btn btn-primary mt-2"
               onClick={verificar}
               >Gravar</button>
            <p className='mt-4'>Vc é : {resultado}</p>
        </div>
    )
}