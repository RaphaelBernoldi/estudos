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
                    <button onClick={() => { props.removeAutor(index) } } className="waves-effect waves-light indigo lighten-2 btn" >Remover</button>
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
        const { listaAutores, removeAutor } = this.props;

        return(
            <table className="centered highlight">
                <TableHead />
                <TableBody lista = { listaAutores }  removeAutor ={ removeAutor } />
            </table>
        );
    }
}
export default Tabela;