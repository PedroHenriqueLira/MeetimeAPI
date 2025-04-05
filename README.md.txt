

1.  **Pré-requisitos:**
    * Certifique-se de ter o **Git** instalado em sua máquina. Você precisará dele para clonar o repositório.
    * Tenha o **Java Development Kit (JDK)** instalado. Recomenda-se uma versão compatível com o seu projeto Spring Boot (geralmente a versão 11 ou superior). Verifique sua versão com `java -version` no terminal.
    * Tenha o **Maven** ou **Gradle** instalado, dependendo do gerenciador de dependências do projeto.

2.  **Clone o Repositório do GitHub:**
    Abra seu terminal ou prompt de comando e navegue até o diretório onde você deseja salvar o projeto. Use o comando `git clone` seguido da URL do seu repositório no GitHub.

    Exemplo:
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    ```
    (Substitua `https://github.com/seu-usuario/seu-repositorio.git` pela URL real do seu repositório).

3.  **Navegue até o Diretório do Projeto Clonado:**
    Após a clonagem, utilize o comando `cd` para entrar na pasta do projeto que foi criada.

    Exemplo:
    ```bash
    cd seu-repositorio
    ```
    (Substitua `seu-repositorio` pelo nome da pasta do seu projeto).

4.  **Execute o Comando para Iniciar a Aplicação:**

    * **Com Maven:**
        Execute o seguinte comando no terminal:
        ```bash
        ./mvnw spring-boot:run
        ```
        (Em alguns sistemas, pode ser necessário usar `mvn spring-boot:run` sem o `./`). Este comando cuidará do download das dependências e da execução da aplicação.

    * **Com Gradle:**
        Execute o seguinte comando:
        ```bash
        ./gradlew bootRun
        ```
        Assim como no Maven, o Gradle irá baixar as dependências e iniciar a aplicação.

5.  **Aguarde a Inicialização:**
    O Spring Boot iniciará o servidor web embutido (geralmente Tomcat). Acompanhe os logs no seu terminal para verificar o progresso da inicialização e a porta em que a aplicação estará disponível (o padrão é 8080).

6.  **Acesse a Aplicação:**
    Abra seu navegador web e vá para o endereço padrão (se não houver configuração diferente):
    ```
    http://localhost:9090
    ```
    Agora você pode começar a interagir com os endpoints da sua API, como descrito anteriormente neste README.

**Observações:**

* A primeira execução dos comandos de build (Maven ou Gradle) pode demorar um pouco mais, pois as dependências precisam ser baixadas. As execuções seguintes serão mais rápidas.
* Se você encontrar problemas, os logs no terminal geralmente fornecem informações valiosas para identificar a causa. Verifique se todas as dependências foram baixadas corretamente e se não há conflitos de porta.
* Para desenvolvimento, manter o terminal com a aplicação rodando aberto permite monitorar logs e eventuais erros em tempo real.

Com este guia completo, você estará pronto para clonar seu repositório e iniciar sua aplicação Spring Boot para integração com o HubSpot!

---

## OAuth 🔐

### 1. **Conexão com HubSpot**
**Método**: `GET`
**Endpoint**: `/connect-hubspot`
**Descrição**: Redireciona o usuário para a página de autorização do HubSpot.

**Exemplo**:

GET http://localhost:9090/connect-hubspot

---

### 2. **Obter URL de Autorização**
**Método**: `GET`
**Endpoint**: `/oauth/authorization-url`
**Descrição**: Retorna a URL de autorização do HubSpot sem redirecionar.

**Exemplo**:

GET http://localhost:9090/oauth/authorization-url

---

### 3. **Callback de Autorização**
**Método**: `GET`
**Endpoint**: `/oauth/callback`
**Descrição**: Endpoint que o HubSpot chama após autorização bem-sucedida.

**Exemplo**:

GET http://localhost:9090/oauth/callback?code=seu_codigo_aqui

---

## Contact 📇

### 1. **Criar Contato**
**Método**: `POST`
**Endpoint**: `/create-contact`
**Descrição**: Cria um novo contato no HubSpot.

**Exemplo de Requisição**:

POST http://localhost:9090/create-contact Content-Type: application/json Authorization: Bearer seu_token_aqui

{ "properties": { "firstname": "Nome", "lastname": "Sobrenome", "email": "email@exemplo.com", "phone": "(11) 99999-9999" } }

---

### 2. **Listar Contatos**
**Método**: `GET`
**Endpoint**: `/get-contacts`
**Descrição**: Obtém a lista de contatos do HubSpot.

**Exemplo de Requisição**:

GET http://localhost:9090/get-contacts Authorization: Bearer seu_token_aqui

---

## Webhook 📡

### 1. **Receber Webhook de Criação de Contato (lista)**
**Método**: `POST`
**Endpoint**: `/webhook/contact-creation`
**Descrição**: Recebe notificações do HubSpot quando um contato é criado (formato lista).

**Exemplo de Requisição**:

POST http://localhost:9090/webhook/contact-creation Content-Type: application/json

[ { "appId": 10184300, "eventId": "100", "subscriptionId": "3396913", "portalId": "49617379", "occurredAt": 1743469383618, "subscriptionType": "contact.creation", "attemptNumber": 0, "objectId": "123", "changeSource": "CRM", "changeFlag": "NEW" } ]



---

### 2. **Receber Webhook de Criação de Contato (objeto único)**
**Método**: `POST`
**Endpoint**: `/webhook/contact-creation-local`
**Descrição**: Recebe notificações do HubSpot quando um contato é criado (formato objeto único).

**Exemplo de Requisição**:

POST http://localhost:9090/webhook/contact-creation-local Content-Type: application/json

{ "appId": 10184300, "eventId": "100", "subscriptionId": "3396913", "portalId": "49617379", "occurredAt": 1743469383618, "subscriptionType": "contact.creation", "attemptNumber": 0, "objectId": "123", "changeSource": "CRM", "changeFlag": "NEW" }

---

## 🚀 **Testando e Integrando**

Após configurar esses endpoints no seu **Postman**, você pode realizar testes integrados para:
1. **Autenticação e autorização do HubSpot**.
2. **Criar e listar contatos** na API do HubSpot.
3. **Receber webhooks** quando um contato for criado.

Certifique-se de usar o **Access Token** gerado durante o fluxo OAuth para acessar os endpoints de criação e listagem de contatos.