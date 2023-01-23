# CAMEL-18965
Camel CXF: OnCompletionHandler not called anymore.
This application provides an endpoint (http://127.0.0.1:9900/cxf/myendpoint). In Camel we will set a non-XML payload which will cause the message to fail (SOAP fault). We have set an onCompletionHandler which will just do a System.out. Since Camel 3.11.1, this handler will not be invoked anymore.
 
 Reproduce
 
1) Run DemoApplication to startup the tomcat and camel context
2) Do a GET request to http://127.0.0.1:9900/cxf/myendpoint with following payload. Response should be HTTP 500<br>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><n2:invoke xmlns:n2="http://cxf.component.camel.apache.org/">test</n2:invoke></soap:Body></soap:Envelope>

3) Check the console output to see onCompletion Processor was called. Find in the console following printout: <br>######################################## processor called ####################################
4) Update the pom.xml and update from Camel 3.11.0 to 3.11.1, reimport the libraries and restart the application
5) Re-execute the GET request --> OnCompletionProcessor is not called anymore (no System.out)
