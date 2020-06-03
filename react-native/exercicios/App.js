import React, {Component} from 'react';
import { View, Text, StyleSheet } from 'react-native';
import Simples from './src/componentes/Simples';
import ParImpar from './src/componentes/ParImpar';

class App extends Component{

  render(){
    return(
        <View style={styles.comtainer}>
          <Text style={styles.f20}>App Função!</Text>
          <Simples texto="Flexivel"/>
          <ParImpar numero={11} />
        </View>
        )
  }
}

const styles = StyleSheet.create({
  comtainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  f20: {
    fontSize: 40,
  }
});
export default App;
