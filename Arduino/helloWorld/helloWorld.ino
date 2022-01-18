int ledPin = 2;
int cont = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(ledPin, OUTPUT);
    Serial.begin(9600); // Inicia a comunicacao serial

}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(ledPin, HIGH);
  cont = cont +1;
  Serial.println(cont); // Imprime SUL
  delay(1000);
  cont =0;
}
