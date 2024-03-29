package com.mycompany.hr.ws;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;

@Endpoint                                                                                
public class HolidayEndpoint {

  private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";

  private XPath startDateExpression;

  private XPath endDateExpression;

  private XPath nameExpression;


  public HolidayEndpoint()                      
      throws JDOMException {

    Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);

    startDateExpression = XPath.newInstance("//hr:StartDate");
    startDateExpression.addNamespace(namespace);

    endDateExpression = XPath.newInstance("//hr:EndDate");
    endDateExpression.addNamespace(namespace);

    nameExpression = XPath.newInstance("concat(//hr:FirstName,' ',//hr:LastName)");
    nameExpression.addNamespace(namespace);
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")                  
  public void handleHolidayRequest(@RequestPayload org.jdom2.Element holidayRequest)               
      throws Exception {
	  
	  System.out.println("handleHolidayRequest");
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    Date startDate = dateFormat.parse(startDateExpression.valueOf(holidayRequest));
//    Date endDate = dateFormat.parse(endDateExpression.valueOf(holidayRequest));
//    String name = nameExpression.valueOf(holidayRequest);

  }

}