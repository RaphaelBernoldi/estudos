import React, { Fragment, Component } from 'react';
import Header from './header';
import TabelaAutores from './TabelaAutores';
import Formulario from './Formulario';
import PopUp from './PopUp';
import ApiService from './ApiService';

class Autores extends Component{

    state = {
        autores: [],
    }

    removeAutor = id =>{
        const { autores } = this.state;
      
        this.setState(
          {
            autores : autores.filter((autor) => {
              return autor.id !== id;
            }),
          }
        );
        ApiService.removeAutor(id);
        PopUp.exibeMensagem('success', "Autor removido com sucesso");
      
      }
      
      escutadorDeSubmit = autor => {
          ApiService
            .criaAutor(JSON.stringify(autor))
            .then(res => {
                this.setState({
                    autores: [...this.state.autores, res.data],
                  });
                  PopUp.exibeMensagem('success', "Autor adicionado com sucesso");
            });
             
      }


      componentDidMount(){
          ApiService
            .listaAutores()
            .then(res => {
                this.setState({autores : [...this.state.autores, ...res.data]});
            });
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