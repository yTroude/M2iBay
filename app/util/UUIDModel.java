package util;

import org.hibernate.annotations.GenericGenerator;
import play.db.jpa.GenericModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UUIDModel extends GenericModel {
    @Id
    @GenericGenerator(name="UUID", strategy = "utils.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(name="uuid", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    public String uuid;
}
