import validador from 'validator';

class FormValidator {

    constructor(validacoes){
        this.validacoes = validacoes;

    }

    valido(){
        const validacao = {};

        this.validacoes.map(regra => {
            validacao[regra.campo] = {isInvalid: false, mensagem: ''};
        });
        return {isValid: true, ...validacao};
    }

    valida(state){
        
        console.log('state:' + JSON.stringify( state));
        let validacao = this.valido();


        this.validacoes.forEach(regra => {
            const campoValor = state[regra.campo.toString()];
            const args = regra.args  || [];
            const metodoValidacao = typeof regra.metodo === 'string' ? validador[regra.metodo] : regra.metodo

            if(metodoValidacao(campoValor, ...args, state) !== regra.validoQuando){

                validacao[regra.campo] = {
                    isInvalid: true,
                    mensagem: regra.mensagem
                }
                validacao.isValid = false;
            }
        });

    return validacao;

    }
}
export default FormValidator;