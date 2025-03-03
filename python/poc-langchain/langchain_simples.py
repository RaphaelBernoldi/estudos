from langchain_openai import ChatOpenAI
from langchain.prompts import PromptTemplate
import os
from dotenv import load_dotenv

load_dotenv()

llm = ChatOpenAI(api_key=os.getenv('OPENAI_API_KEY')
               , model='gpt-3.5-turbo'
               , temperature=0.5
               , max_tokens=100)


numero_de_dias = 7
numero_de_criancas = 2
atividade = "praia"

modelo_do_prompt = PromptTemplate.from_template(
    "Crie um roteiro de viagem de {dias} dias, para uma família com {criancas} crianças, que gostam de {atividade}."
)

prompt = modelo_do_prompt.format(dias=numero_de_dias,
                        criancas=numero_de_criancas,
                        atividade=atividade)


response = llm.invoke(prompt)

print(response.content)
