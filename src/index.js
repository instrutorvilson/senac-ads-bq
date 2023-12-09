import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import{ createBrowserRouter, RouterProvider} from 'react-router-dom'
import Produto from './componentes/produto';
import Consulta from './componentes/consulta'
import EditaProduto from './componentes/editaProduto';

const rotas = createBrowserRouter([
  {
    path:"/",
    element: <App />,
    children:[
      { path:'/produto/cadastrar', element: <Produto />},
      { path:'/produto/consultar', element: <Consulta />},
      { path:'/produto/editar/:idProduto', element: <EditaProduto />}
    ]
  }
])
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={rotas}/>
  </React.StrictMode>
);


