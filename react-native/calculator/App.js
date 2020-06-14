import React, { Component } from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
} from 'react-native';

import {
  Header, 
  LearnMoreLinks,
  Colors,
  DebugInstructions,  
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';


export default class App extends Component {

  render(){
    return(
      <View style={styles.container}>
        <Text style={styles.welcome}>welcome</Text>
        <Text style={styles.instruction}>App.js</Text>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF' 
  },  
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instruction: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5
  }
});
