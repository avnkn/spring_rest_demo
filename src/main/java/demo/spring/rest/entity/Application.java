package demo.spring.rest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "APPLICATION")
@XmlAccessorType(XmlAccessType.FIELD)
public class Application {
    @Id
    @Column(name = "ID")
    @JsonProperty("APPLICATION_ID")
    @XmlElement(name = "APPLICATION_ID")
    private int id;

    @Column(name = "CONTACT_ID")
    @JsonProperty("CONTACT_ID")
    @XmlElement(name = "CONTACT_ID")
    private int contactId;

    @Column(name = "DT_CREATED")
    @JsonProperty("DT_CREATED")
    @XmlElement(name = "DT_CREATED")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ", timezone = "GMT+03:00")
    private Date dtCreated;

    @Column(name = "PRODUCT_NAME")
    @JsonProperty("PRODUCT_NAME")
    @XmlElement(name = "PRODUCT_NAME")
    private String name;

}
