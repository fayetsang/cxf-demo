import java.io.StringWriter;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.junit.Test;


public class ClientTest {

    @Test
    public void test() throws Exception {
        EndpointReference targetEPR = new EndpointReference("http://localhost:8080/axis2-RPCMessageReceiver/services/UserService");
        RPCServiceClient sender = new RPCServiceClient();
        Options options = sender.getOptions();
        options.setTimeOutInMilliSeconds(2*20000L);//超时时间20s
        options.setTo(targetEPR);

        QName qname = new QName("http://service.axis2", "sayHi");
        String str = "xiaoming";
        Object[] param = new Object[]{str};
        Class<?>[] types = new Class[]{String.class};  //这是针对返值类型的
        /**
         * RPCServiceClient类的invokeBlocking方法调用了WebService中的方法。
         * invokeBlocking方法有三个参数
         * 第一个参数的类型是QName对象，表示要调用的方法名；
         * 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；
         * 第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。
         *
         * 当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}。
         */
        Object[] response = sender.invokeBlocking(qname, param, types);
        System.out.println(response[0]);

    }

}
