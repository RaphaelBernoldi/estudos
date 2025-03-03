from langchain.chains.llm import LLMChain
from langchain.chains.sequential import SimpleSequentialChain
from langchain_core.prompts import ChatPromptTemplate
from langchain_openai import ChatOpenAI
import os
from langchain.globals import set_debug

from dotenv import load_dotenv

set_debug('true')
load_dotenv()

llm = ChatOpenAI(api_key=os.getenv('OPENAI_API_KEY')
               , model='gpt-3.5-turbo'
               , temperature=0.5
               , max_tokens=100)



modelo_cidade = ChatPromptTemplate.from_template(
    "Sugira uma cidade dado meu interesse por {interesse}, a sua saída deve ser SOMENTE o nome da cidade"
)

modelo_restaurantes = ChatPromptTemplate.from_template(
    "Sugira restaurantes populares entre locais em {cidade}"
)

modelo_cultural = ChatPromptTemplate.from_template(
    "Sugira atividades e locais culturais em {cidade}"
)

cadeia_cidade = modelo_cidade | llm
cadeia_restaurante = modelo_restaurantes | llm
cadeia_cultural = modelo_cultural | llm


pipeline = cadeia_cidade | cadeia_restaurante | cadeia_cultural

response = pipeline.invoke('praias')


print(response.content)
