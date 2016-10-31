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
## Buscar Alumnos por Criterios
```
http://www.opensv.tk:8080/WebService/MiServicio/consAlum/{nomb}/{apel}/{grad}/{espe}
```
En esta parte se pueden hacer búsquedas parciales, por ejemplo
```
http://www.opensv.tk:8080/WebService/MiServicio/consAlum/j/p/2/i
```
El resultado devolverá los alumnos que contenga en su nombre la letra j, en su apellido p, en su grado el 2 y en su especialidad i

## Consultar Alumno por Código de Docente
```
http://www.opensv.tk:8080/WebService/MiServicio/consAlumByDoce/{codi}
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

## Consultar Empleado por Nombre de Usuario
```
http://www.opensv.tk:8080/WebService/MiServicio/consEmpl/{usua}
```
## Consultar Empleado por Código de Empleado
```
http://www.opensv.tk:8080/WebService/MiServicio/consEmplByCodi/{codi}
```
## Buscar Empleado por Criterios
```
http://www.opensv.tk:8080/WebService/MiServicio/consEmpl/{nomb}/{apel}
```
### El parámetro nomb y apel
En esta parte se pueden hacer búsquedas parciales, por ejemplo
```
http://www.opensv.tk:8080/WebService/MiServicio/consEmpl/j/a
```
El resultado sería los empleados que contengan "j" en su nombre ó "a" en su apellido
