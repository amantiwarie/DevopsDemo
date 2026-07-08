# Currency Converter (Spring MVC + JSP)

A simple INR → (USD/EUR/GBP) currency converter, built for testing a Jenkins CI/CD pipeline
deploying to Wildfly behind Apache.

## Stack
- Java 11
- Spring MVC 5.3.x (annotation-based config, **no web.xml / no XML bean config**)
- JSP + JSTL for views
- Maven (packaged as WAR)

## Project structure
```
src/main/java/com/yiron/currencyconverter/
  config/
    AppInitializer.java   -> replaces web.xml
    WebConfig.java         -> replaces dispatcher-servlet.xml
  controller/
    CurrencyController.java

src/main/webapp/
  WEB-INF/views/index.jsp
  resources/css/style.css
```

## Build locally
```bash
mvn clean package
```
This produces `target/currency-converter.war`.

## Deploy to Wildfly
Copy the WAR to Wildfly's deployments folder:
```bash
cp target/currency-converter.war $WILDFLY_HOME/standalone/deployments/
```
Wildfly auto-deploys it. Once deployed, it's reachable at:
```
http://<server>:8080/currency-converter/
```
(Apache will later reverse-proxy this to port 80.)

## Extending
Add more currencies by adding entries to the `RATES_FROM_INR` map in `CurrencyController.java`.
