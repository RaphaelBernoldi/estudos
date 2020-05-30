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
   const linhas = props.listaAutores.map((autor, index) => {
        return(
            <tr key={ autor.id }>
                <td>{ autor.nome }</td>
                <td>{ autor.livro }</td>
                <td>{ autor.preco }</td>
                <td>
                    <button onClick={() => { props.removeAutor( autor.id ) } } className="waves-effect waves-light indigo lighten-2 btn" >Remover</button>
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

class TabelaAutores extends Component {



    render() {
        const { listaAutores, removeAutor } = this.props;

        return(
            <table className="centered highlight">
                <TableHead />
                <TableBody listaAutores = { listaAutores }  removeAutor ={ removeAutor } />
            </table>
        );
    }
}
export default TabelaAutores;