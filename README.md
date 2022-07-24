# Email Client Emulator
EmailClient is a JAVA Spring Application solution for interacting with EmailServer Application using CLI like engine.
# How it works

Use the shell of the application to interact with already existing instance of EmailServer.
```
EMAIL-EMULATOR:>send-email --from lior@gmail.com --to lior@comapny.com -M hello lior

```
The above invokes The REST endpoint exposed by EmailServer.

Supported vendors:
* Gmail
* Walla
* Yahoo

# Usage
Under resources/backend.properties file set the IP and port for the backend server and start the client.
if client is running on same host as server with default configurations there is no need to change the file.
