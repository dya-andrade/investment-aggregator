# investment-aggregator
API de agregador de investimentos, criada com Kotlin, Ktor, MongoDB e Clean Architecture

* Caso já tenha o MongoDB instalado na máquina e queira usar o container via Docker:

```shell
sudo service mongod stop
```

```shell
cd docker
docker-compose up -d
```

* Caso queira usar o MongoDB instalado no host:

```shell
sudo service mongod start
```

* Criar as credenciais de acesso, user e password:

```shell
# Conecte-se ao MongoDB com o cliente mongo
mongo --host 127.0.0.1 --port 27017 --authenticationDatabase admin

# Dentro do shell mongo, crie o banco de dados e usuário
use investments
db.createUser({
  user: "dya",
  pwd: "dyaandrade",
  roles: [{ role: "readWrite", db: "investments" }]
})
```

*  Para tornar o script auxiliar do Gradlew executável

```shell
chmod +x ./gradlew
```

* Para construir o projeto, use o seguinte comando:

```shell
./gradlew build
```

* Para executar o projeto, use o seguinte comando:

```shell
./gradlew run
```