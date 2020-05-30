import React, { Component } from "react";

class Formulario extends Component {

    constructor(props){
        super(props);

        this.stateInicial = {
            nome: '',
            livro: '',
            preco: '',
        }
    
        this.state = this.stateInicial;
    }

    escutadorDeImput = event => {
        const { name, value} = event.target;

        this.setState({
            [name]: value,
        });
    }

    submitFormulario = () => {
        this.props.escutadorDeSubmit(this.state);
        this.setState(this.stateInicial);
    }


    
    render(){
        const {nome, livro, preco} = this.state;

        return(
            <form>

                <label forHtml="nome">Nome</label>
                <input
                    id="nome"
                    type="text"
                    name="nome"
                    value={nome} 
                    onChange = {this.escutadorDeImput}
                />

                <label forHtml="livro">Livro</label>
                <input
                    id="livro"
                    type="text"
                    name="livro"
                    value = {livro}
                    onChange = {this.escutadorDeImput}
                />


                <label forHtml="preco">Preço</label>
                <input
                    id="preco"
                    type="text"
                    name="preco"
                    value = {preco}
                    onChange = {this.escutadorDeImput}
                />


                <button onClick = {this.submitFormulario} type="button">Salvar
                </button>
            </form>
        )
    }
}
export default Formulario;