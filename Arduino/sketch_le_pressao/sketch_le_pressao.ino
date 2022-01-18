
int pressaoAdm = 5;

lvoid setup() {
  Serial.begin(9600);
  pinMode(pressaoAdm, OUTPUT);
}

void loop() {
  float tensao = analogRead(pressaoAdm);
  Serial.println(tensao);
}
