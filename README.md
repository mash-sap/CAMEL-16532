# CAMEL-16532
Camel CXF: Trying to start already registered endpoint, will unregister existing one
1) Run DemoApplication to startup the tomcat and camel context
2) Do a POST request to http://127.0.0.1:9900/cxf/manuel with following payload. Response should be HTTP 200 (response body comes from Route1: FIRST)<br>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><n2:invoke xmlns:n2="http://cxf.component.camel.apache.org/">test</n2:invoke></soap:Body></soap:Envelope>

3) Do GET request to http://localhost:9900/route/start to start Route2 with a CXF endpoint that is already registered. HTTP 500 is expected. This will unregister the existing endpoint from Route1 (unexpected behavior)
4) Do POST request from step 2. Now a HTTP 404 is returned (the endpoint has been unregistered :()
5) Do GET request from step 3 to start the Route2 again. This time it will succeeed HTTP 200. Route2 is started
6) Do POST request from step 2) and get HTTP 200 response (response body comes from Route2: SECOND)


<br>
Expected behavior: After step3, step4 should still succeed and return HTTP 200 with response from Route1 (FIRST)



<br><br><br>
Add following VM args on startup to connect via java/bin/jconsole<br>
-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9913 -Dcom.sun.management.jmxremote.ssl=false -Djava.rmi.server.hostname=localhost -Dcom.sun.management.jmxremote.authenticate=false
<br><br>
With the proposed change in pull-request https://github.com/apache/camel/pull/5454, the failed start in step 2) will leave an dangling mbean as described in https://issues.apache.org/jira/browse/CAMEL-10914. However the original problem of 10914 (start/stop causing danling mbeans) stays fixed.