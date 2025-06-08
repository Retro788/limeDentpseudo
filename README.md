Documentación del Proyecto limeDent
Resumen General:
LimeDent es una aplicación de gestión para clínicas dentales que permite a los profesionales dentales gestionar los registros de los pacientes, rastrear servicios, ofertas y citas, y generar cotizaciones en PDF. Sigue la arquitectura Modelo-Vista-Controlador (MVC), separando la lógica de la aplicación, la interfaz de usuario y la gestión de datos en secciones distintas. Esto lo hace modular y fácil de mantener.

Funcionalidades:
Registro y Login de Usuario:

Permite a diferentes tipos de usuarios acceder (Administrador, Paciente, Dentista).

Después de iniciar sesión, los usuarios pueden acceder a las funciones específicas para su rol.

Gestión de Pacientes:

Agregar, modificar o eliminar información de pacientes.

Ver los detalles de los pacientes, como nombre, teléfono, correo electrónico, y antecedentes médicos.

Los pacientes pueden revisar sus citas previas y tratamientos realizados.

Prácticas y Tratamientos:

Registrar detalles de tratamientos (servicios como resinas, brackets, endodoncias).

Relacionar los tratamientos con pacientes específicos.

Citas (Agenda):

Programar citas con los pacientes.

Modificar citas existentes.

Ver un calendario con las citas programadas.

Publicaciones:

Crear, editar y eliminar publicaciones para la clínica.

Los pacientes y dentistas pueden leer publicaciones relacionadas con servicios o noticias.

Reseñas:

Los pacientes pueden calificar los servicios y dejar comentarios.

Dentistas y otros miembros del personal pueden leer las reseñas.

Estructura del Proyecto:
bash
Copiar
Editar
limeDent-main/
│
├── src/
│   ├── app/              # Punto de entrada principal de la aplicación
│   │   └── Start.java    # Inicia la aplicación
│   ├── controller/       # Capa Controladora del MVC
│   │   ├── LoginController.java   # Maneja la funcionalidad de inicio de sesión
│   │   └── UserController.java    # Maneja las acciones del usuario
│   ├── dao/              # Capa de Acceso a Datos (maneja las interacciones con la BD)
│   │   └── UserDAO.java  # Maneja la obtención y almacenamiento de datos de usuarios
│   ├── model/            # Capa Modelo (Entidades como Usuario, Paciente)
│   │   ├── User.java     # Representa una entidad de usuario
│   │   └── Patient.java  # Representa una entidad de paciente
│   ├── view/             # Capa Vista (Componentes de la interfaz gráfica)
│   │   └── LoginPanel.java # Interfaz gráfica para el login
│   ├── config.properties # Configuración de la base de datos
│   └── utils/            # Clases auxiliares (por ejemplo, conexiones a BD, helpers)
├── lib/                  # Bibliotecas externas (por ejemplo, controlador JDBC de MySQL)
└── resources/            # Recursos como imágenes
    └── logo.png
Integración:
Integración con la Base de Datos:

LimeDent utiliza MySQL como base de datos. La conexión a la base de datos se maneja en model.Database.java.

La base de datos almacena datos de usuarios, registros de pacientes y otros datos relevantes.

Se usa JDBC (Java Database Connectivity) para interactuar con la base de datos MySQL.

Componentes de la Interfaz de Usuario (UI):

Se utiliza la librería Swing para construir la interfaz gráfica.

Componentes clave como JPanel, JButton, JTextField se utilizan para mostrar datos y recopilar entradas del usuario.

Lógica de Negocio:

Los Controladores en controller/ manejan las acciones del usuario y las interacciones entre la vista y el modelo.

Ejemplo: LoginController.java verifica las credenciales del usuario y asegura el flujo de navegación correcto.

Explicación del Código y Flujo:
1. Conexión con la Base de Datos:
La conexión con la base de datos se gestiona en model.Database.java.

El método connect() de la clase establece la conexión con la base de datos MySQL utilizando las credenciales del archivo config.properties.

2. Inicio de Sesión de Usuario:
El LoginController.java gestiona el proceso de inicio de sesión:

Valida el nombre de usuario y la contraseña introducidos.

Obtiene la contraseña hasheada correspondiente desde la base de datos.

La compara con la contraseña introducida (después de ser hasheada).

Si las credenciales son válidas, el usuario es redirigido al menú principal (por ejemplo, registros de pacientes, tratamientos, etc.).

3. Agregar/Modificar un Paciente:
En model.Patient.java, definimos los atributos del paciente (nombre, número de teléfono, etc.).

La clase UserDAO.java proporciona métodos para almacenar y recuperar datos de pacientes desde la base de datos.

La clase PatientController.java maneja la adición, modificación y eliminación de información del paciente.

4. Generación de Cotizaciones en PDF:
LimeDent ofrece la funcionalidad de generar cotizaciones en PDF utilizando los datos del paciente y los detalles de los tratamientos.

Se podría utilizar una librería como JasperReports para diseñar la plantilla y generar un documento PDF que puede ser guardado o impreso.

Desglose Detallado de Funcionalidades:
Registro de Usuario (RFIP):
Selección de Tipo de Usuario (RFIP1):

Al comenzar el registro, el usuario debe elegir su rol (Practicante, Paciente o Docente).

Visualización y Validación del Formulario (RFIP02-RFIP09):

Dependiendo del tipo de usuario, se mostrará un formulario personalizado para completar.

El formulario es validado para asegurar que todos los campos obligatorios estén completos antes de enviarlo.

Guardar en la Base de Datos (RFIP12):

Después de la validación, los datos del usuario se guardan en la base de datos.

Confirmación y Manejo de Errores (RFIP10-RFIP13):

Si todo va bien, se muestra un mensaje de éxito. Si hay campos faltantes, se muestra un mensaje de error.

Tecnologías Clave Utilizadas:
Java Swing:

Utilizado para construir la interfaz gráfica de usuario (GUI). Swing es parte de las Java Foundation Classes (JFC) y proporciona un conjunto rico de componentes de UI.

Base de Datos MySQL:

Usada para almacenar los datos de usuarios, registros de pacientes y más.

La base de datos se accede mediante JDBC (Java Database Connectivity).

JDBC:

Proporciona una API estándar para conectar y ejecutar consultas SQL en bases de datos relacionales desde Java.

Características de Java 8:

El proyecto utiliza características de Java 8 como expresiones lambda, streams e interfaces funcionales para simplificar el código.

Patrón de Diseño Modelo-Vista-Controlador (MVC):

Modelo representa los datos (Usuario, Paciente, etc.).

Vista es la interfaz de usuario (componentes Swing).

Controlador maneja la entrada del usuario, actualiza el modelo y pasa datos entre el modelo y la vista.

Interacción del Usuario Paso a Paso:
Pantalla de Login:

El usuario ingresa su nombre de usuario y contraseña.

La aplicación verifica las credenciales mediante LoginController.

Si son válidas, el usuario es redirigido al menú principal (por ejemplo, registros de pacientes, tratamientos, etc.).

Gestión de Pacientes:

El usuario puede agregar, ver o actualizar información de pacientes utilizando PatientController.

Todos los cambios se reflejan en la base de datos.

Programación de Citas:

El usuario puede establecer o modificar citas usando la sección de agenda de la aplicación. Las citas se almacenan en la base de datos MySQL.

Creación de Publicaciones:

El administrador o personal autorizado puede crear publicaciones relacionadas con los servicios, horarios de la clínica, etc. Estas se guardan en la base de datos y pueden ser leídas por los usuarios.

Conclusión:
Este proyecto LimeDent demuestra un sistema completamente funcional de gestión para clínicas dentales que maneja información de pacientes, citas, tratamientos, publicaciones y reseñas. Utiliza el patrón de diseño Modelo-Vista-Controlador (MVC), Java Swing para la UI, y MySQL para el almacenamiento de datos. El código está estructurado de una manera que facilita la expansión con nuevas funcionalidades como nuevos roles de usuario, diferentes tipos de tratamientos y reportes avanzados.

Para los estudiantes que busquen entender este proyecto, los conceptos clave en los que enfocarse incluyen la arquitectura Modelo-Vista-Controlador, la conectividad con la base de datos mediante JDBC, el diseño de la interfaz gráfica con Swing, y las operaciones CRUD básicas.
Instrucciones de compilación y ejecución:

1. Asegúrese de tener Java 8 o superior instalado y un servidor MySQL en funcionamiento.
2. Edite el archivo `src/config.properties` con su usuario, contraseña y URL de la base de datos.
3. Ejecute el script `setup.sql` en su servidor MySQL para crear las tablas necesarias.
   Este script también inserta algunos datos de ejemplo (usuarios, pacientes y
   servicios) para que pueda probar el sistema inmediatamente.
4. Compile la aplicación ejecutando:
   ```bash
   find src -name "*.java" > sources.list
   javac -d build -cp "libs/*:libs/Swing/*" @sources.list
   ```
   En sistemas Windows puede usar:
   ```cmd
   dir /b /s src\*.java > sources.list
   javac -d build -cp "libs/*;libs/Swing/*" @sources.list
   ```
5. Cree el archivo JAR:
   ```bash
   echo "Main-Class: app.Start" > MANIFEST.MF
   jar cfm LimeDent.jar MANIFEST.MF -C build . -C src config.properties
   ```
6. Ejecute la aplicación con:
   ```bash
   java -cp "libs/*:libs/Swing/*:LimeDent.jar" app.Start
   ```

Tenga en cuenta que la interfaz utiliza Swing, por lo que debe ejecutarse en un entorno gráfico.

Si al crear su rama GitHub muestra "The head ref may contain hidden characters", renombre su rama usando solo caracteres ASCII para evitar el problema.

### Registro de un paciente

1. En la pantalla principal presione **"Agregar nuevo paciente"** para abrir el formulario.
2. Complete los campos requeridos (nombre, CURP, teléfono, etc.).
3. Una vez listos los datos, haga clic en el botón **"Guardar"** ubicado en la esquina inferior derecha del formulario.
4. Se mostrará una notificación confirmando que el paciente fue añadido con éxito.
