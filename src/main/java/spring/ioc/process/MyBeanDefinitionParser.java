package spring.ioc.process;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MyBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        Object source = parserContext.extractSource(element);
        XmlReaderContext readerContext = parserContext.getReaderContext();
        NodeList childNodes = element.getChildNodes();
        return null;
    }
}
