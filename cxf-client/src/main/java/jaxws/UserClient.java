package jaxws;

import jaxws.domain.User;
import jaxws.service.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserClient {
    public static void main(String[] args) throws Exception {

//================================ 方式一：ClientFactoryBean =============================================

        JaxWsClientFactoryBean clientFactoryBean = new JaxWsClientFactoryBean();

        // cxf-server-JAXWS
//        clientFactoryBean.setAddress("http://localhost:2333/userService");

        //cxf-server-JAXWS-spring
        clientFactoryBean.setAddress("http://localhost:8080/cxf-server-JAXWS-spring/ws/us/userService");

        clientFactoryBean.setServiceClass(UserService.class);
        Client client = clientFactoryBean.create();

        Object[] invoke = client.invoke("sayHi", "xiaoming");
        System.out.println(invoke[0]);

        User user = new User();
        user.setName("xiaoming");
        Object[] cars = client.invoke("getPriceByUser", user);
        System.out.println(cars[0].toString());


//================================ 方式二：SOAP ==============================================
/*


        // WebService服务的地址
        URL url = new URL("http://localhost:8080/cxf-server-JAXWS-spring/ws/us/userService");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //是否具有输入参数
        conn.setDoInput(true);
        //是否输出输入参数
        conn.setDoOutput(true);
        //发POST请求
        conn.setRequestMethod("POST");
        //设置请求头（注意一定是xml格式）
        conn.setRequestProperty("content-type", "text/xml;charset=utf-8");

        // 构造请求体，符合SOAP规范（最重要的）
        String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q0=\"http://service.jaxws/\" "
                + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "<soapenv:Body>"
                + "<q0:sayHi>"
                + "<arg0>xiaoming</arg0>"
                + "</q0:sayHi>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";
        System.out.println(requestBody);

        //获得一个输出流
        OutputStream out = conn.getOutputStream();
        out.write(requestBody.getBytes());

        //获得服务端响应状态码
        int code = conn.getResponseCode();
        StringBuffer sb = new StringBuffer();
        if(code == 200){
            //获得一个输入流，读取服务端响应的数据
            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            int len = 0;

            while((len = is.read(b)) != -1){
                String s = new String(b,0,len,"utf-8");
                sb.append(s);
            }
            is.close();
        }

        out.close();
        System.out.println("服务端响应数据为："+sb.toString());

*/

    }
}
