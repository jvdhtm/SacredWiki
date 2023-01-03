package com.pages.model;


import java.io.File;
import java.util.List;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pages")
public class Pages {
    @XmlElementWrapper(name = "pageList")
    @XmlElement(name = "page")
    private List<Page> pageList;

    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }

    public static Pages fromXml(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Pages.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Pages) jaxbUnmarshaller.unmarshal(file);
    }

    public void toXml(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Pages.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(this, file);
    }
}