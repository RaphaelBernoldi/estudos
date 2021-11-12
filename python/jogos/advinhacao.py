print("*********************************")
print("Bem vindo ao jogo de Adivinhação!")
print("*********************************")

numero_secreto = 42

chute = int(input("Digite o seu número: "))
print("Você digitou: ", chute)

if chute == numero_secreto:
    print("Você acertou")
else:
    print("Você errou!")

