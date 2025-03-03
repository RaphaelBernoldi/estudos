from langchain_core.prompts import ChatPromptTemplate, PromptTemplate
from langchain_openai import ChatOpenAI
import os
from langchain.globals import set_debug

from dotenv import load_dotenv
from pydantic.v1.main import BaseModel
from pydantic.v1.fields import Field
from langchain_core.output_parsers import JsonOutputParser, StrOutputParser

set_debug('true')
load_dotenv()

class Destino(BaseModel):
    cidade:str = Field("cidade a visitar")
    motivo:str = Field("motivo pelo qual é interessante visitar")

parseador = JsonOutputParser(pydantic_object=Destino)

llm = ChatOpenAI(api_key=os.getenv('OPENAI_API_KEY')
               , model='gpt-3.5-turbo'
               , temperature=0.5
               , max_tokens=100)


modelo_cidade = PromptTemplate(
    template="""Sugira uma cidade dado meu interesse por {interesse}.
    {formatacao_de_saida}
    """,
    input_variables=["interesse"],
    partial_variables={"formatacao_de_saida": parseador.get_format_instructions()},
)

modelo_restaurantes = ChatPromptTemplate.from_template(
    "Sugira restaurantes populares entre locais em {cidade}"

)

modelo_cultural = ChatPromptTemplate.from_template(
    "Sugira atividades e locais culturais em {cidade}"
)

cadeia_cidade = modelo_cidade | llm
cadeia_restaurante = modelo_restaurantes | llm |  StrOutputParser()
cadeia_cultural = modelo_cultural | llm | StrOutputParser()


pipeline = cadeia_cidade | cadeia_restaurante | cadeia_cultural

response = pipeline.invoke('praias')


print(response)
