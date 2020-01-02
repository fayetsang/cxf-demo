import java.io.StringWriter;

import javax.xml.stream.XMLOutputFactory;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test() throws Exception {
        EndpointReference targetEPR =
                new EndpointReference(
                        "http://localhost:8080/axis2-RawXMLINOutMessageReceiver/services/SpringAwareService");

        try {
            OMFactory factory = OMAbstractFactory.getOMFactory();
            OMNamespace omNs = factory.createOMNamespace(
                    "http://springExample.org/example1", "example1");

            OMElement method = factory.createOMElement("getValue", omNs);
            OMElement value = factory.createOMElement("Text", omNs);
            value.addChild(factory.createOMText(value, "Some String "));
            method.addChild(value);

            ServiceClient serviceClient = new ServiceClient();

            Options options = new Options();
            serviceClient.setOptions(options);
            options.setTo(targetEPR);

            //Blocking invocation
            OMElement result = serviceClient.sendReceive(method);

            StringWriter writer = new StringWriter();
            result.serialize(XMLOutputFactory.newInstance()
                    .createXMLStreamWriter(writer));
            writer.flush();

            System.out.println("Response: " + writer.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
