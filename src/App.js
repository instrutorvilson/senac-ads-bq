import {Link, Outlet} from 'react-router-dom'

function App() {
  return (
    <div className="container">
        <nav>
           <Link to='/produto/cadastrar'>Cadastro</Link> &nbsp;&nbsp;
           <Link to='/produto/consultar'>Consulta</Link>
        </nav>
        <main>
           <Outlet />
        </main>
    </div>
  );
}

export default App;
