# WebService
Este WebServices es únicamente para propósitos demostrativos

## Ubicación
El WebService lo van a encontrar en el sitio: http://www.opensv.tk/

## WebService Login
```
http://www.opensv.tk:8080/WebService/MiServicio/consLogi/{usuario}/{contraseñaSHA256}
```
Pueden usar esta herramienta para convertirlas http://passwordsgenerator.net/sha256-hash-generator/

## Consultar Alumno por Carnet
```
http://www.opensv.tk:8080/WebService/MiServicio/consAlum/{carn}
```

## Buscar Usuarios por Criterios
```
http://www.opensv.tk:8080/WebService/MiServicio/consUsua/{nomb}/{apel}/{tipo}
```
### El parámetro tipo
Para los tipos se utilizan los siguiente:
* alum
* doceTecn 
* doceAcad
* emplAdmi
* emplRece

### El parámetro nomb y apel
En esta parte se pueden hacer búsquedas parciales, por ejemplo
```
http://www.opensv.tk:8080/WebService/MiServicio/consUsua/j/a/alum
```
El resultado sería los usuarios alumnos que contengan "j" en su nombre ó "a" en su apellido

## Buscar Usuario por Nombre de Usuario
```
http://www.opensv.tk:8080/WebService/MiServicio/consUsua/{usua}
```
