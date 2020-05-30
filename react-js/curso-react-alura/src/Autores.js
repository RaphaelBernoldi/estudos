import React, { Fragment, Component } from 'react';
import Header from './header';
import TabelaAutores from './TabelaAutores';
import Formulario from './Formulario';
import PopUp from './PopUp';

class Autores extends Component{

    state = {
        autores: [
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

    removeAutor = index =>{
        const { autores } = this.state;
      
        this.setState(
          {
            autores : autores.filter((autor, posAtual) => {
              return posAtual !== index;
            }),
          }
        );
        PopUp.exibeMensagem('success', "Autor removido com sucesso");
      
      }
      
      escutadorDeSubmit = autor => {
              this.setState({
                autores: [...this.state.autores, autor],
              });
              PopUp.exibeMensagem('success', "Autor adicionado com sucesso");
      }
      
      render(){
        return (
          <Fragment>
            <Header />
            <div className="container mb-10">
              <TabelaAutores listaAutores = { this.state.autores } removeAutor = { this.removeAutor } />
              <Formulario escutadorDeSubmit={this.escutadorDeSubmit} />
            </div>
          </Fragment>
        );
      }
        
      }
export default Autores;