import Cadastro from './componentes/cadastro';
import Consulta from './componentes/consulta';
import Lista from './componentes/lista';
import Pai from './componentes/pai';
import Produto from './componentes/produto';
import VerIdade from './componentes/verIdade';

function App() {
  return (
    <div className="container">
       { /*<Cadastro />  
        <Lista />
        <VerIdade /> 
        <Pai />  
        */  } 
        <Produto />
        <Consulta />
    </div>
  );
}

export default App;
