# cxf-demo
include JAXWS, JAXRS, axis2, xfire simple example

1. cxf-server-JAXWS
访问：http://localhost:2333/userService?wsdl
client端实现在cxf-client

2. cxf-server-JAXWS-spring
(1).启动server端遇到的问题:
    <!--NoClassDefFoundError: javax/xml/bind/JAXBException-->
    <!--java.lang.NoClassDefFoundError: javax/xml/ws/Endpoint-->
    <dependency>
        <groupId>com.sun.xml.ws</groupId>
        <artifactId>jaxws-rt</artifactId>
        <version>2.3.2</version>
    </dependency>

    <!-- Could not initialize class org.apache.cxf.attachment.AttachmentUtil -->
    一开始使用的cxf版本是3.2.6，升级cxf的版本到3.3.x，同时也解决了上面的问题。

(2).访问wsdl的路径： http://localhost:8080/cxf-server-JAXWS-spring/ws/us?wsdl((
(3).Available SOAP services： http://localhost:8080/cxf-server-JAXWS-spring/ws
client端实现在cxf-client

3. cxf-server-JAXRS

4. cxf-server-JAXRS-spring
java.lang.ClassCastException: class org.apache.cxf.transport.servlet.CXFServlet cannot be cast to class javax.servlet.Servlet
解决方法：添加依赖
<dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-rt-transports-http-jetty</artifactId>
    <version>${cxf.version}</version>
    <exclusions>
        <exclusion>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
        </exclusion>
    </exclusions>
</dependency>

5. xfire
访问：http://localhost:8080/xfire/test/userSerivce

6. axis2
神问题1：File &quot;/axis2-web/listSingleService.jsp&quot; not found
神问题2：An error occurred at line: 89 in the jsp file: /axis2-web/listSingleService.jsp
注意包冲突问题，注意WEB-INF/services/<项目名>/META-INF/services.xml
http://localhost:8080/axis2-RPCMessageReceiver/services/UserService?wsdl
http://localhost:8080/axis2-RawXMLINOutMessageReceiver/services/SpringAwareService?wsdl

