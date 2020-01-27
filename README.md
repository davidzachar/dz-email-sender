# dz-email-sender

Easy application for sending email using [SendGrid](https://sendgrid.com) and deployed to [Heroku](https://heroku.com)

## Configuration

Change the following in src/main/resources/application.properties to reflect your configuration
```text
spring.sendgrid.api-key=ENC(6n2knRCOiXdstm0PDu3sBfvG6yPX9LDmKzUIKEQQV4HnGFv7hFiKnQMPKJbNn0t/IXvddVBeoUG+NLdsM7Ex9+pXe+Jnd01o7KRfQK4s+TQ=)
spring.security.user.name=ENC(bum86o+TJA/p24Oa9/1PBA==)
spring.security.user.password=ENC(KDvnn3fWWlsJJiTiCmtkD8oiPuvhkXZ4hqX8JKONU6k=)
```

Current configuration is encoded using jasypt encryptor with password stored in enviroment property trough Heroku config named ENC_PASS.

Description of values:
sprint.sendgrid.api-key - api-key to use genereted within your [SendGrid](https://sendgrid.com) account
sprint.security.user.name - user for Basic Auth to access REST API of this application
spring.security.user.password - password for Basic Auth to access RES API of this application

## Usage

When the app is running you need to do POST call: <your-host>/send
Using the Basic Auth with username and password configured in sprint.security.user.name and spring.security.user.password.

Here is the example object to send:
```json
{
	"from": "example@test.com",
	"to":"some@test.com",
	"subject" : "Test Subject",
	"body" : "Test Body"
}
```
