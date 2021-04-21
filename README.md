# CAMEL-16532
Camel CXF: Trying to start already registered endpoint, will unregister existing one
1) Run DemoApplication to startup the tomcat and camel context
2) Do a POST request to http://127.0.0.1:9900/cxf/manuel with following payload. Response should be HTTP 200 (response body=FIRST)
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><n2:invoke xmlns:n2="http://cxf.component.camel.apache.org/">test</n2:invoke></soap:Body></soap:Envelope>

3) Do GET request to http://localhost:9900/route/start to start camel route with a CXF endpoint that is already registered. HTTP 500 is expected. This will unregister the existing endpoint (unexpected behavior)
4) Do POST request from step 2. Now a HTTP 404 is returned (the endpoint has been unregistered :()
5) Do GET request from step 3 to start the route again. This time it will succeeed HTTP 200. The second route is started and the previously running route is gone. (response body=SECOND)
6) do POST request from step 2) and get HTTP 200 response
