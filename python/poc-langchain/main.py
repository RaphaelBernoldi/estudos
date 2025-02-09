from langchain_core.prompts import PromptTemplate
from langchain_openai import ChatOpenAI
import os
from dotenv import load_dotenv

load_dotenv()

prompt_helloword = 'Simule ser um corretor de imóveis e se apresente para um possível comprador, informe que recebeu o contato do cliente e se coloque a disposição, seja objetivo e pergunte se o cliente tem algo em vista e não se preocupe em agradar tanto'
prompt_template = PromptTemplate.from_template(prompt_helloword)
messages=[{"role": "user", "content": prompt_helloword}]



llm = ChatOpenAI(api_key=os.getenv('OPENAI_API_KEY')
               , model='gpt-3.5-turbo'
                 , temperature=0.5
                 , max_tokens=100)

response = llm.invoke(messages)

print(response.id)
print(response.additional_kwargs)
print(response.name)
print(response.content)