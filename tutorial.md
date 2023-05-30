# Tutorial

### Página Home
Esta é a página inicial do website, nela conterá (futuramente) imagens do
nosso restaurante, promoções e muito mais!

### Página Cardápio (Visualização do Usuário)
Nela será possível ver todos os pratos disponíveis no nosso restaurante,
tendo nome, descrição, preço e tipo.

### Página de Gerenciamento de Cardápio (Visualização do Funcionário)
O funcionário terá a opção de inserir, visualizar, apagar e editar os pratos
que estarão disponivéis para visualização no website.

Nele constará campos que deverão ser preechidos por completo e submetidos, 
e após será redirecionado para url (localhost:8080/listar-pratos.jsp) já 
estará disponível para visualização na lista de gerenciamento de
cardápio. 

Essa página ainda não está clicável no site, o acesso dela é no url
(localhost:8080/CardapioEdit.jsp)

Para a criação de tabela no h2, segue o script:
CREATE TABLE CARDAPIO( ID BIGINT AUTO_INCREMENT PRIMARY KEY,
NOME VARCHAR,
TIPO VARCHAR,
DESCRICAO VARCHAR,
PRECO VARCHAR,
IMAGE VARCHAR(255))

### Página Reserva (Visualização de Usuário)
Nela será possível o usuário realizar sua reserva, tendo a opção de selecionar
data, horário, quantidade pessoas, ambiente e observações. Também (futuramente), 
caso não tenha data e horário disponível o cliente poderá entrar na lista de
espera.

### Página de Gerenciamento de Reservas 
O funcionário visualizará todas as reservas solicitadas pelos clientes, e terá
a opção de confirmar ou cancelar a reserva (futuramente).

No momento a página não está clicável, o acesso dela é no url (localhost:8080/listar-reservas)
Para a criação de tabela no h2, segue o script:
CREATE TABLE RESERVAS (ID BIGINT AUTO_INCREMENT PRIMARY KEY,
DATA VARCHAR,
HORA VARCHAR,
QNTPESSOAS VARCHAR,
AMBIENTE VARCHAR,
OBS VARCHAR,
STATUS VARCHAR,
NOME VARCHAR,
EMAIL VARCHAR,
CLIENTEID BIGINT,
FOREIGN KEY (CLIENTEID) REFERENCES CLIENTE (ID));
)

### Página Cadastro 
Onde o usuário irá se cadastrar, para poder realizar reservas, onde deverá 
inserir os dados e terminar cadastro.
CREATE TABLE CLIENTE(
ID BIGINT AUTO_INCREMENT PRIMARY KEY, 
NAME VARCHAR, 
LASTNAME VARCHAR, 
CPF VARCHAR, 
EMAIL VARCHAR,
PASSWORD VARCHAR
)

###Pagina Login (futuramente)
Onde o usuário irá se logar após o cadastro. 
