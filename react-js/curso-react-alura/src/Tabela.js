import React, { Component } from 'react';

const TableHead = () => {
    return (
        <thead>
            <tr>
                <th>Autores</th>
                <th>Livros</th>
                <th>Preços</th>
                <th>Remover</th>
            </tr>
        </thead>
    );
}

const TableBody = props => {
   const linhas = props.lista.map((autor, index) => {
        return(
            <tr key={index}>
                <td>{ autor.nome }</td>
                <td>{ autor.livro }</td>
                <td>{ autor.preco }</td>
                <td>
                    <button>Remover</button>
                </td>
            </tr>
        );
   });

   return(
       <tbody>
           {linhas}
       </tbody>
   );


}

class Tabela extends Component {



    render() {
        const { listaAutores } = this.props;

        return(
            <table>
                <TableHead />
                <TableBody lista = { listaAutores }/>
            </table>
        );
    }
}
export default Tabela;