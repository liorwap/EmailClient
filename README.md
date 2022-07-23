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

Note that this is in POC stage currently there is no support for using the Email Client Emulator 
in other host then EmailServer. 
