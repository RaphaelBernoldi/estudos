import React, { Fragment, Component } from 'react';
import Header from './header';

class Livros extends Component {

    state = {
        livros: [
        {
          nome: 'Paulo',
          livro: 'React',
          preco: '1000'
        },
        {
          nome: 'Daniel',
          livro: 'Java',
          preco: '99'
        },
        {
          nome: 'Marcos',
          livro: 'Design',
          preco: '150'
        },
        {
          nome: 'Bruno',
          livro: 'DevOps',
          preco: '100'
        },
        {
          nome: 'Raphael',
          livro: 'Java',
          preco: '100'
        }
      ],
    }

    render(){
        return (
            <Fragment>
                <Header/>
                <h1>Página de Livros</h1>
            </Fragment> 
        );
    }
}

export default Livros;