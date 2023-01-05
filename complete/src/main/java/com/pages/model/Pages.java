package com.pages.model;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pages")
public class Pages {
    @XmlElement(name = "page")
    private List<Page> pageListField;

    public List<Page> getPageListField() {
        return pageListField;
    }

    public void setPageList(List<Page> pageList) {
        this.pageListField = pageList;
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
