from langchain.chains.llm import LLMChain
from langchain.chains.sequential import SimpleSequentialChain
from langchain_core.prompts import ChatPromptTemplate
from langchain_openai import ChatOpenAI
from langchain.prompts import PromptTemplate
import os
from dotenv import load_dotenv

load_dotenv()

llm = ChatOpenAI(api_key=os.getenv('OPENAI_API_KEY')
               , model='gpt-3.5-turbo'
               , temperature=0.5
               , max_tokens=100)


modelo_cidade = ChatPromptTemplate.from_template(
    "Sugira uma cidade dado meu interesse por {interesse}"
)

modelo_restaurantes = ChatPromptTemplate.from_template(
    "Sugira restaurantes populares entre locais em {cidade}"
)

modelo_cultural = ChatPromptTemplate.from_template(
    "Sugira atividades e locais culturais em {cidade}"
)

pipeline = modelo_cidade | llm | modelo_restaurantes | llm | modelo_cultural | llm
#cadeia_restaurante = LLMChain(prompt=modelo_restaurantes, llm=llm)
#cadeia_cultural = LLMChain(prompt=modelo_cultural, llm=llm)

SimpleSequentialChain(chain=[pipeline])

def sugerir(interesse):
    return pipeline.invoke(interesse)

response = sugerir("praia")
print(response.content)
