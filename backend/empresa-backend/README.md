# Api Rest Crud Empresa

## Requirimientos
- Apache Maven 3.8.6
- Spring boot 2.7.1
- Java 11
- MariaDB 10.8.3 
-> configurar contrasena con 123456



## Corriendo App en spring-boot
### Compilar proyecto springboot

<div>
<p style = 'text-align:center;'>
<img src="https://raw.githubusercontent.com/EdgarJonathan123/Prueba-Bytes/main/imagenes/PackageMaven.png" alt="JuveYell" >
</p>
</div>

### Correr jar se ejecutara por default en el puerto 8080 
<div>
<p style = 'text-align:center;'>
<img src="https://raw.githubusercontent.com/EdgarJonathan123/Prueba-Bytes/main/imagenes/runJarMaven.png" alt="JuveYell" >
</p>
</div>

## Probando Api rest mediante Postman


### Create 
POST - http:localhost:8080/api/empresa
<div>
<p style = 'text-align:center;'>
<img src="https://raw.githubusercontent.com/EdgarJonathan123/Prueba-Bytes/main/imagenes/create.png" alt="JuveYell" >
</p>
</div>

### Read
GET - http:localhost:8080/api/empresa
<div>
<p style = 'text-align:center;'>
<img src="https://raw.githubusercontent.com/EdgarJonathan123/Prueba-Bytes/main/imagenes/read.png" alt="JuveYell" >
</p>
</div>
GET - http:localhost:8080/api/empresa/Id
<div>
<p style = 'text-align:center;'>
<img src="https://raw.githubusercontent.com/EdgarJonathan123/Prueba-Bytes/main/imagenes/getById.png" alt="JuveYell" >
</p>
</div>

### Update
PUT - http:localhost:8080/api/empresa
<div>
<p style = 'text-align:center;'>
<img src="https://raw.githubusercontent.com/EdgarJonathan123/Prueba-Bytes/main/imagenes/update.png" alt="JuveYell" >
</p>
</div>

### Update
DELETE - http:localhost:8080/api/empresa
<div>
<p style = 'text-align:center;'>
<img src="https://raw.githubusercontent.com/EdgarJonathan123/Prueba-Bytes/main/imagenes/delete.png" alt="JuveYell" >
</p>
</div>

## Consulta Datos maria db
Consultamos los datos ingresados al dbms y asi verificamos la persistencia de datos.
<div>
<p style = 'text-align:center;'>
<img src="https://raw.githubusercontent.com/EdgarJonathan123/Prueba-Bytes/main/imagenes/baseDatos.png" alt="JuveYell" >
</p>
</div>