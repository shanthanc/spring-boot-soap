package com.shanthan.ibowebservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext appContext) {
        MessageDispatcherServlet dispatcherServlet = new MessageDispatcherServlet();
        dispatcherServlet.setApplicationContext(appContext);
        dispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(dispatcherServlet, "/ws/*");
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema iboSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ibosPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.shanthanc.com/ibo");
        wsdl11Definition.setSchema(iboSchema);

        return wsdl11Definition;
    }

    @Bean
    public XsdSchema iboSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/ibo.xsd"));
    }
}
