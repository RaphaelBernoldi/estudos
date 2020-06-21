import React, { Component } from 'react';
import {
  View, StyleSheet
} from 'react-native';

import Button from './src/component/Button';
import Display from './src/component/Display';


export default class App extends Component {

  state = {
    displayValue: '0',
    n1: 0,
    n2: 0,
    operacao: ''
  }

  addDigit = n => {
    if( this.state.displayValue === '0'){
      this.setState({displayValue: n, n1: n})
      

    }else {

      if(this.state.operacao === ''){
        this.setState({displayValue: this.state.displayValue + n
                     , n1: this.state.displayValue + n})

      }else {
        if(this.state.n2 === 0){
          this.setState({displayValue: n ,n2: n})

        } else {
          this.setState({displayValue: this.state.displayValue + n
                       , n2: this.state.displayValue + n})
        }
        
      }
      
    }
  }

  calcula = () => {

    if(this.state.operacao != '' && this.state.n1 != '0' && this.state.n2 != '0'){

      var n1 = Number(this.state.n1);
      var n2 = Number(this.state.n2);

      if(this.state.operacao === '+'){
        const resultado = n1 + n2
        this.setState({displayValue: resultado
                    , n1: resultado
                    , n2: 0})
      }
      if(this.state.operacao === '-'){
        const resultado = n1 - n2
        this.setState({displayValue: resultado
                    , n1: resultado
                    , n2: 0})
      }
      if(this.state.operacao === '*'){
        const resultado = n1 * n2
        this.setState({displayValue: resultado
                    , n1:  resultado
                    , n2: 0})
      }
      if(this.state.operacao === '/'){
        const resultado = n1 / n2
        this.setState({displayValue: resultado
                     , n1: resultado
                     , n2: 0})
      }
    }
  }

  addOperation = op => {

    if( this.state.displayValue !== '0'){

      if(!!this.state.operacao){
        this.setState({ operacao: op })
        this.calcula()

      } else {
        this.setState({ operacao: op })
      }
      
    }
  }

  clear = () => {
    this.setState({displayValue: '0'
                 , n1: 0
                 , n2: 0
                 , operacao: ''})
  }

  render(){
    return(
      <View style={styles.container}>
        <Display value={this.state.displayValue}></Display>
        <View style={styles.buttons}>
          <Button label='AC' triple onClick={this.clear}/>
          <Button label='/' operation onClick={this.addOperation}/>
          <Button label='7' onClick={this.addDigit} />
          <Button label='8' onClick={this.addDigit} />
          <Button label='9' onClick={this.addDigit}/>
          <Button label='*' operation onClick={this.addOperation}/>
          <Button label='4' onClick={this.addDigit} />
          <Button label='5' onClick={this.addDigit}/>
          <Button label='6' onClick={this.addDigit}/>
          <Button label='-' operation onClick={this.addOperation} />
          <Button label='1' onClick={this.addDigit}/>
          <Button label='2' onClick={this.addDigit}/>
          <Button label='3' onClick={this.addDigit}/>
          <Button label='+' operation onClick={this.addOperation}/>
          <Button label='0' double onClick={this.addDigit}/>
          <Button label='.' onClick={this.addDigit} />
          <Button label='=' operation onClick={this.calcula}/>
        </View>
        
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1
  },  
  buttons: {
    flexDirection: 'row',
    flexWrap: 'wrap'

  }
});
