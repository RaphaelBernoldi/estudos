int led100pcTps = 2;
int sinalTps = 2;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
    pinMode(led100pcTps, OUTPUT);
    pinMode(sinalTps, INPUT);
    
    
}

void loop() {
  // put your main code here, to run repeatedly: 
  //Serial.println("tps: ");
  float tensao = analogRead(sinalTps)*5.0/1023.0;
  Serial.println(tensao);

  if (tensao > 0.60){
    digitalWrite(led100pcTps, HIGH);
  }else{
      digitalWrite(led100pcTps, LOW);
  }
  
}
