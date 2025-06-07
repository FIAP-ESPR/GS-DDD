# Documentação de Instalação e Execução da API de Dados Meteorológicos (Oracle)

Esta documentação detalha os passos necessários para configurar, instalar e executar a API de Dados Meteorológicos utilizando o Oracle Database. Certifique-se de que todos os pré-requisitos estão satisfeitos antes de prosseguir.

## 1. Pré-requisitos

Para executar esta API, você precisará dos seguintes softwares instalados e configurados em seu ambiente:

### 1.1. Java Development Kit (JDK) 17 ou superior

A API foi desenvolvida utilizando Java 17. Certifique-se de que você tem o JDK 17 ou uma versão mais recente instalada e configurada corretamente em seu sistema. Você pode verificar a versão do Java abrindo um terminal ou prompt de comando e executando:

```bash
java -version
```

Se o Java não estiver instalado ou a versão for inferior a 17, você pode fazer o download e a instalação a partir do site oficial da Oracle ou usar um gerenciador de pacotes como `apt` (para sistemas baseados em Debian/Ubuntu) ou `brew` (para macOS).

### 1.2. Apache Maven 3.6.3 ou superior

O Maven é utilizado para gerenciar as dependências do projeto e para construir a aplicação. Verifique a versão do Maven com o seguinte comando:

```bash
mvn -version
```

Caso precise instalar ou atualizar o Maven, consulte a documentação oficial do Apache Maven.

### 1.3. Oracle Database

Você precisará de uma instância do Oracle Database em execução (por exemplo, Oracle Database Express Edition - XE, Standard Edition ou Enterprise Edition). Certifique-se de que o banco de dados está acessível a partir da sua máquina e que você tem as credenciais necessárias para criar um usuário e um esquema.

**Detalhes da Conexão (configurados em `src/main/resources/application.properties`):

*   **URL do Banco de Dados**: `jdbc:oracle:thin:@//oracle.fiap.com:1521/orcl` (Este é o exemplo fornecido. Adapte para a sua URL de conexão.)
*   **Usuário**: `RM552965`
*   **Senha**: `180303`

**Importante: Solução de Problemas de Conexão - `java.net.UnknownHostException`**

O erro `java.net.UnknownHostException: Este host não é conhecido (oracle.fiap.com)` indica que o hostname `oracle.fiap.com` não pôde ser resolvido para um endereço IP ou que o servidor não está acessível a partir da sua máquina. Este é um problema de rede e não um erro no código da aplicação. Para resolver isso, siga os passos:

1.  **Verifique a Conectividade de Rede**: Certifique-se de que sua máquina tem acesso à rede onde o servidor Oracle está localizado. Pode ser um problema de firewall, VPN, proxy ou configurações de rede local que estão bloqueando a conexão.
2.  **Verifique o Hostname/IP**: Confirme se `oracle.fiap.com` é o hostname correto do seu servidor Oracle. Se for um ambiente local ou de teste, pode ser necessário usar `localhost` ou o endereço IP direto do servidor Oracle em vez do hostname. Por exemplo, se o IP do seu servidor Oracle for `192.168.1.100`, a URL seria `jdbc:oracle:thin:@//192.168.1.100:1521/orcl`.
3.  **Teste a Conexão Fora da Aplicação**: Tente conectar-se ao banco de dados Oracle usando uma ferramenta externa (como SQL Developer, SQL*Plus ou o comando `tnsping` no seu terminal) para verificar se o problema é na aplicação ou na conectividade geral do seu ambiente. Por exemplo, no prompt de comando, você pode tentar:
    ```bash
    ping oracle.fiap.com
    ```
    ou, se tiver o cliente Oracle instalado:
    ```bash
    tnsping orcl
    ```
    (assumindo que 'orcl' é o nome do serviço configurado no seu `tnsnames.ora`)
4.  **Verifique o Status do Serviço Oracle**: Certifique-se de que o serviço do Oracle Database está em execução no servidor `oracle.fiap.com` e que o listener está ativo e escutando na porta 1521.

Você pode ajustar esses valores no arquivo `application.properties` conforme a sua configuração do Oracle Database.

## 2. Configuração do Banco de Dados Oracle

Antes de executar a aplicação, você precisa criar o usuário e o esquema no seu Oracle Database. Conecte-se ao seu banco de dados Oracle como um usuário com privilégios de `SYSDBA` ou `SYSTEM` e execute os seguintes comandos SQL para criar o usuário e conceder as permissões necessárias:

```sql
CREATE USER RM552965 IDENTIFIED BY 180303;
GRANT CONNECT, RESOURCE TO RM552965;
GRANT CREATE VIEW, CREATE SEQUENCE, CREATE TABLE, CREATE PROCEDURE TO RM552965;
ALTER USER RM552965 QUOTA UNLIMITED ON users;
```

Após criar o usuário, você precisará executar o script de criação das tabelas e sequências. O arquivo `src/main/resources/schema-oracle.sql` contém todas as definições necessárias. Conecte-se ao Oracle Database como `RM552965` e execute o conteúdo deste arquivo.

**Exemplo de execução do script via SQL*Plus ou SQL Developer:**

1.  Abra o SQL*Plus ou SQL Developer.
2.  Conecte-se como `RM552965`.
3.  Execute o conteúdo do arquivo `src/main/resources/schema-oracle.sql`.

## 3. Configuração do Projeto no VS Code

Para importar e trabalhar com o projeto no VS Code, siga os passos abaixo:

1.  **Clone ou Baixe o Projeto**: Se você recebeu o projeto como um arquivo ZIP, descompacte-o em um diretório de sua escolha. Se estiver usando um repositório Git, clone-o.

2.  **Abra o VS Code**: Inicie o Visual Studio Code.

3.  **Abrir Pasta**: No VS Code, vá em `File > Open Folder...` (ou `Arquivo > Abrir Pasta...`) e selecione o diretório raiz do projeto (`weather-api`).

4.  **Extensões Java**: O VS Code deve reconhecer automaticamente que é um projeto Java e sugerir a instalação de extensões recomendadas (como o Extension Pack for Java). Certifique-se de que estas extensões estão instaladas para obter suporte completo a Java, Maven e Spring Boot.

5.  **Reconstruir o Projeto (Maven)**: Abra o terminal integrado do VS Code (`Terminal > New Terminal` ou `Ctrl+Shift+` `). Navegue até o diretório raiz do projeto (se já não estiver lá) e execute o comando Maven para limpar e construir o projeto:

    ```bash
    mvn clean install
    ```

    Este comando irá baixar todas as dependências necessárias e compilar o código-fonte, gerando o arquivo `.jar` executável na pasta `target/`.

## 4. Executando a Aplicação

Após a configuração do banco de dados e a construção bem-sucedida do projeto, você pode iniciar a aplicação Spring Boot. No terminal integrado do VS Code, execute o seguinte comando a partir do diretório raiz do projeto:

```bash
java -jar target/weather-api-0.0.1-SNAPSHOT.jar
```

Se tudo estiver configurado corretamente, você verá logs no terminal indicando que a aplicação Spring Boot foi iniciada com sucesso na porta 8080 (ou na porta configurada em `application.properties`).

## 5. Testando a API (Swagger UI)

Com a aplicação em execução, você pode acessar a interface do Swagger UI para testar os endpoints da API. Abra seu navegador web e navegue para:

```
http://localhost:8080/swagger-ui.html
```

Você verá a documentação interativa da API, onde poderá explorar os endpoints, visualizar os modelos de dados e enviar requisições para testar a funcionalidade da API. Utilize os endpoints para `GET` dados meteorológicos fornecendo latitude e longitude.

---

**Autores:**

*   Vinicius Silva - RM553240
*   Victor Didoff - RM552965
*   Matheus Zottis - RM94119


