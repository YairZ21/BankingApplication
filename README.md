# Aplicación Bancaria Profesional

¡Bienvenido a **BankingApplication**! Una solución sencilla, segura y modular para la gestión de cuentas bancarias en consola. Diseñada para brindar confianza y una experiencia de usuario profesional.

---

## 🚀 Descripción

**BankingApplication** es una aplicación desarrollada en Java que permite a tus clientes realizar operaciones básicas de banca: consultar saldo, depósitos, retiros y conversiones de moneda. Cada acción genera un recibo detallado con fecha y hora, ofreciendo transparencia y trazabilidad.

---

## ⭐ Características Principales

- **Modular y Legible**  
  El código está organizado en clases (`BankAccount`, `BankingApplication`) y métodos específicos, facilitando mantenimiento y ampliaciones.

- **Consulta de Saldo Bajo Demanda**  
  El saldo sólo se muestra cuando el usuario lo solicita, respetando la privacidad y evitando información innecesaria.

- **Depósitos y Retiros con Recibo**  
  Cada transacción genera un recibo con:
  - Fecha y hora de la operación.
  - Monto depositado o retirado.
  - Saldo actualizado.

- **Conversión de Moneda**  
  Opción para convertir el saldo entre **colones costarricenses (CRC)** y **dólares estadounidenses (USD)**, usando una tasa configurable.

- **Interfaz amigable y profesional**  
  Mensajes formales, validación de entradas y pausa visual tras cada operación para mejorar la experiencia.

---

## 📋 Requisitos

- **Java SE 8** o superior
- **JDK** instalado y configurado en tu `PATH`

---

## 🔧 Instalación y Ejecución

1. Clona el repositorio o descarga el código fuente.
2. Navega al directorio raíz del proyecto:
   ```bash
   cd BankingApplication
   ```
3. Compila las clases Java:
   ```bash
   javac BankingApplication.java
   ```
4. Ejecuta la aplicación:
   ```bash
   java BankingApplication
   ```

¡Listo! Ahora podrás interactuar con tu aplicación bancaria desde la consola.

---

## 🎯 Uso

Al iniciar, verás un menú con las siguientes opciones:

1. **Consultar saldo** – Muestra el saldo disponible.
2. **Retirar fondos** – Solicita un monto y realiza el retiro, generando un recibo.
3. **Depositar fondos** – Solicita un monto y realiza el depósito, generando un recibo.
4. **Conversión de moneda** – Convierte tu saldo entre CRC y USD.
9. **Salir** – Finaliza la sesión.

Cada transacción imprime un recibo con detalles y el programa espera 3 segundos antes de volver al menú.

---

## ⚙️ Configuración

- **Tasa de cambio**: modifica la constante `EXCHANGE_RATE` en `BankAccount.java` para ajustar la conversión.
- **Duración de la pausa**: ajusta `PAUSE_SECONDS` en `BankingApplication.java`.

---

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Puedes:

1. Abrir **issues** para reportar errores o sugerir mejoras.
2. Enviar **pull requests** con nuevas funcionalidades o refactorizaciones.

---

## 📄 Licencia

Este proyecto está bajo la **Licencia MIT**. Consulta el archivo `LICENSE` para más detalles.

---

## 📬 Contacto

**Desarrollador:** Yair Zuñiga Rodriguez 
**Correo:** yairandrezunig3@gmail.com




