# xarls-utilidades  [![Latest release](https://img.shields.io/badge/release-1.6.1-blue)]() #

----------

Realiza diversas funciones de utilidad para incorporar a aplicaciones en Java, a través de diversas clases.

## Class: entradaTeclado ##

`Package: xarlsr.com`

[![Latest release](https://img.shields.io/badge/dependencies:-Apache_Commons_Lang_3.12.0-green)](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3)

### Métodos: ###
- `leeCadena()`: Devuelve una cadena (`String`) leída por teclado.
- `leeCadena(int longitud)`: Devuelve una cadena leída por teclado, con la longitud máxima indicada en el parámetro `longitud`.
- `leeCaracter()`: Devuelve un carácter introducido por teclado.
- `leeEntero()`: Devuelve un entero leído por teclado, previa comprobación de que se trata de un número entero (`int`).
- `leeEntero(int longitud)`: Devuelve un entero leído por teclado, de la longitud máxima indicada en el parámetro longitud.
- `leeDoble()`: Devuelve un número real (`double`) leído por teclado, previa comprobación de que es una entrada numérica.
- `borrarPantalla()`: Limpia el terminal. Solo solo se ha testeado en Windows.
- `pulseIntro()`: Solicita la pulsación de la tecla `INTRO` para continuar.
