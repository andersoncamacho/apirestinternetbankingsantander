Teste backend Java do Banco Santander, foi implementado API’s com as funcionalidades: Cadastrar um cliente, Retornar todos clientes cadastrados, Sacar um valor que subtrai o saldo do cliente contando uma taxa de administração , Deposita um valor que aumenta o saldo de um determinado cliente e Consulta o histórico de transações por data

Para testar api: Fazer o import do arquivo api_interntebanking_2023-06-07 que esta na raiz do projeto e importar no Insomnia ou postman.

<h2>As urls da api:</h2>
<i>Obs: Abaixo Exemplo de urls já com os atributos preenchidos para facilitar o teste</i>
Cadastrar um cliente > http://localhost:8080/customer <br />
Listar Clientes > http://localhost:8080/customers <br />
Sacar > http://localhost:8080/transactions/withdraw/1?valor=320 <br />
depositar > http://localhost:8080/transactions/deposit/2?valor=500 <br />
historico > http://localhost:8080/transactions/historic?data=07/06/2023

