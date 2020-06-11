import React, { Component } from 'react';

import { createDrawerNavigator } from '@react-navigation/drawer';
import { NavigationContainer } from '@react-navigation/native';

import ParImpar from './componentes/ParImpar';
import Inverter, { MegaSena } from './componentes/Multi';
import Simples from './componentes/Simples';


const Drawer = createDrawerNavigator();

const megaSenaScreen = () => <MegaSena numero={8} />
const inverterScreen = () => <Inverter texto='React Nativo!'/>
const parImpar = () => <ParImpar numero={30}/>
const simples = () => <Simples texto='Texto simples'/>


export default class Menu extends Component {
    

    render(){
        return (
            <NavigationContainer>
              <Drawer.Navigator initialRouteName="Home">
                <Drawer.Screen name="Mega Sena" component={megaSenaScreen} />
                <Drawer.Screen name="Inverter" component={inverterScreen} />
                <Drawer.Screen name="Par & Impar" component={parImpar} />
                <Drawer.Screen name="Simples" component={simples} />
              </Drawer.Navigator>
            </NavigationContainer>
          );
    }
}




/*
export default createDrawerNavigator({
    MegaSena: {
        screen: () => {return (<MegaSena numero={8} />)},
        navigationOptions: { title: 'Mega Sena'}
    },
    Inverter: {
        screen: () => <Inverter texto='React Nativo!'/>,
        navigationOptions: { title: 'Inverter'}
    },
    ParImpar: {
        screen: () => <ParImpar numero={30}></ParImpar>,
        navigationOptions: {title: 'Par & Impar'}
    },
    Simples: {
        screen: () => <Simples texto='Texto simples'/>
    }

}, { drawerWidth: 300} ) 
*/