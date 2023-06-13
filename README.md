<h1> REST API project Internet Banking </h1>
<span>Spring boot REST API project template using jpa (Springboot REST API whch connects H2 database).</span>

<h2>Project description </h2>
<p>Java backend test for Banco Santander, APIs were implemented with the following functionalities: Register a client, Retrieve all registered clients, Withdraw an amount that subtracts from the client's balance considering an administration fee, Deposit an amount that increases the balance of a specific client, and Query transaction history by date.</p>

<h2>Setup</h2>

## 📚 Setup
<h2>As urls da api:</h2><br />

Cadastrar um cliente > http://localhost:8080/customer <br />
Listar Clientes > http://localhost:8080/customers <br />

<i>Obs: Abaixo Exemplo de urls já com os atributos preenchidos para facilitar o teste</i><br />
Sacar > http://localhost:8080/transactions/withdraw/1?valor=320 <br />
depositar > http://localhost:8080/transactions/deposit/2?valor=500 <br />
historico > http://localhost:8080/transactions/historic?data=07/06/2023

