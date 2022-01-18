/*******************************************************************************
* Sensor de Efeito Hall : Identificando Polos (v1.0)
*
* Impressao do polo identificado na porta serial.
*  
* Copyright 2020 RoboCore.
* Escrito por Matheus Cassioli (10/08/2019).
* Atualizado por Giovanni de Castro (15/01/2020).
* 
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version (<https://www.gnu.org/licenses/>).
*******************************************************************************/

int cont =0;
const int PINO_SENSOR = 4; // Pino 4 conectado ao sensor
int leitura_sensor; // Variavel que armazena o estado da saida do sensor

void setup(){
  pinMode(PINO_SENSOR, INPUT); // Pino conectado ao sensor configurado como entrada
  Serial.begin(9600); // Inicia a comunicacao serial
}

void loop(){
  leitura_sensor = digitalRead(PINO_SENSOR); // Le a saida do sensor e armazena na variavel
  cont = cont +1;
  Serial.println(cont);
  if (leitura_sensor == HIGH){ // Se o sensor estiver em nivel alto
    Serial.println("NORTE"); // Imprime NORTE
  } else { // Se o sensor estivel em nivel baixo
    Serial.println("SUL"); // Imprime SUL
  }
  delay(500); // Tempo para atualizacao de informacoes
}
