int pinVelocidade = 3;
int pinLa = 5;
int pinLb = 6;
int vel = 0;
int pressaoAdm = 5;


void setup() {
  pinMode(pinVelocidade, OUTPUT); 
  pinMode(pinLa, OUTPUT); 
  pinMode(pinLb, OUTPUT); 
  pinMode(pressaoAdm, OUTPUT);


}

void loop() {
  Serial.begin(9600); // Inicia a comunicacao serial
  vel = 150;
  analogWrite(pinVelocidade, vel);
  digitalWrite(pinLa, LOW); 
  digitalWrite(pinLb, HIGH);

  float tensao = analogRead(pressaoAdm);
  Serial.println(tensao);
}
