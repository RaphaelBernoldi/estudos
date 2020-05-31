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
      
        ApiService
            .removeAutor(id)
            .then(res => ApiService.trataErros(res))
            .then(res => {
                if(res.message === 'deleted'){
                    this.setState(
                        {
                          autores : autores.filter((autor) => {
                            return autor.id !== id;
                          }),
                        }
                      );
                      PopUp.exibeMensagem('success', "Autor removido com sucesso");
                }
            }).catch(res => PopUp.exibeMensagem('error', "Falha ao remover autor"));
        
      
      }
      
      escutadorDeSubmit = autor => {
          ApiService
            .criaAutor(JSON.stringify(autor))
            .then(res => ApiService.trataErros(res))
            .then(res => {
                if(res.message === 'success'){
                    this.setState({
                        autores: [...this.state.autores, res.data],
                      });
                      PopUp.exibeMensagem('success', "Autor adicionado com sucesso");
                }
                
            })
            .catch(res => PopUp.exibeMensagem('error', "Falha ao criar autor"));
             
      }


      componentDidMount(){
          ApiService
            .listaAutores()
            .then(res => ApiService.trataErros(res))
            .then(res => {
                if(res.message === 'success'){
                    this.setState({autores : [...this.state.autores, ...res.data]});
                }
                
            })
            .catch(res => PopUp.exibeMensagem('error', "Falha ao listar autor"));
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