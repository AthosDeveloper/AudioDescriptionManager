#Aviso importante: A api só aceita json como content-type e deve ser colocado dentro do header 
#key content-type, value mediatype.jsonApplication
#além de deixar a api mais leve, não há riscos de haver algum erro de interpretação no momento da requisição.
#Uma api para gerenciar o pagamento de qualquer empresa que faz consultoria de audiodescrição.
#noto que há uma falta de serviços como esses e resolvi começar a implementar um para ajudar empresas autônomas a ter um melhor gerenciamento do processo de pagamento e assim insentivando a cultura e divercidade.
#a proposta dessa api é poder gerenciar: 
#1 o valor total dos projetos que se baseiam no seguinte requisito: 
#se for filme, é calculado o valor de 70 reais vezes a duração total em minutos.
#Se for imagem, é calculado 60 reais para cada imagem.
#na minha api tem  o nome do projeto, descrição, valor por minuto, duração eo tipo do projeto e um valor total.

#ele também deve gerenciar os usuários da aplicação que agora que penso melhor poderia ter outro nome como funcionario por exemplo. 
#ele terá um nome, cargo, tem uma relação many to one com projeto, pois pode haver vários usuários trabalhando nele ao mesmo tempo. Ele também terá a porcentagem que vai receber dependendo do seu cargo: 
locutor e editor de audio e vídeo: 10 por cento do total
Consultor: 30 por cento do total.
Roteirista: 50 por cento.
#inicialmente a api deveria contersegurança com BIcript, mas acabou por ter alguns atrasos em sua implementação 
#Irei implementar muito em breve.
#ela posteriormente também terá algumas das validações que não terminei de concluir como avalidação do tipo do projeto 
#também não realizei os testes, algo que farei assim que possível