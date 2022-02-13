# Instrucciones test práctico

***

## Ejecución

Para ejecutar la aplicación y poder probarla se ha instalado swagger, y así disponer de una interfaz que sea más amigable. 
La URL de ejecución del proyecto es la siguiente: http://localhost:8080 

***


## Base de datos

Se ha creado una base de datos H2 en fichero para que almacene todos los datos de nuestra aplicación.

Datos:

- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:file:./resources/db/db_h2
- User Name: iobuilders
- Password: iobuilder$

### Datos de prueba en base de datos

Se han creado distintos datos de prueba en la base de datos para que esta no este vacía y tener facilidad a la hora de probar la aplicación, los datos y las tablas son las siguientes:

#### ACTIVITYTYPES
Tabla maestra que contiene los tipos de actividad a realizar en la aplicación.

| IDACTIVITYTYPE | NAME     |
|----------------|----------|
| 1              | Deposit  |
| 2              | Withdraw |

#### USERS
Tabla que contiene los usuarios registrados en la aplicación. Datos de prueba:

| IDUSER | NAME   | LASTNAME | PASSWORD | EMAIL                 | CREATION_DATE            |
|--------|--------|----------|----------|-----------------------|--------------------------|
| 1      | Walter | Bates    | P@ssw0rd | walter.bates@test.com | 2022-02-13 11:22:42.391  |
| 2      | John   | Doe      | P@ssw0rd | john.doe@test.com     | 2022-02-13 11:23:12.246  |

#### WALLETACCOUNTS
Tabla que contiene los cuentas wallet de cada uno de los usuarios. Datos de prueba:

| IDWALLETACCOUNT | NAME                | IDUSER | CREATION_DATE            |
|-----------------|---------------------|--------|--------------------------|
| 1               | Walter Bates Wallet | 1      | 2022-02-13 11:24:04.278  |
| 2               | John Doe Wallet     | 2      | 2022-02-13 11:24:26.005  |

#### WALLETACTIVITY
Tabla que detalla la actividad de cada una de las cuentas de wallet. Datos de prueba:

| IDWALLETACTIVITY | DESCRIPTION          | QUANTITY | IDWALLETACTIVITY | IDWALLETACCOUNT | CREATION_DATE            |
|------------------|----------------------|----------|------------------|-----------------|--------------------------|
| 1                | Deposit 5 in wallet  | 5.0      | 1                | 1               | 2022-02-13 11:25:40.454  |
| 2                | Deposit 5 in wallet  | 5.0      | 1                | 2               | 2022-02-13 11:25:47.656  |


