package com.example.fxmljavafxlaba;

import java.sql.Timestamp;
import java.util.Objects;

public class Domain {
    private final Integer id;
    private final String webName;
    private final String domainName;
    private final String ip;
    private final Timestamp dateReg;
    private final String countryReg;
    private final Integer personId;

    public Domain(Integer id, String webName, String domainName, String ip, Timestamp dateReg,
                  String countryReg, Integer personId) {
        this.id = id;
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.dateReg = dateReg;
        this.countryReg = countryReg;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public String getWebName() {
        return webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getIp() {
        return ip;
    }

    public Timestamp getDateReg() {
        return dateReg;
    }

    public String getCountryReg() {
        return countryReg;
    }

    public Integer getPersonId() {
        return personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain domain = (Domain) o;
        return Objects.equals(id, domain.id) && Objects.equals(webName, domain.webName) && Objects.equals(domainName, domain.domainName) && Objects.equals(ip, domain.ip) && Objects.equals(dateReg, domain.dateReg) && Objects.equals(countryReg, domain.countryReg) && Objects.equals(personId, domain.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, webName, domainName, ip, dateReg, countryReg, personId);
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id=" + id +
                ", webname='" + webName + '\'' +
                ", domainname='" + domainName + '\'' +
                ", ip='" + ip + '\'' +
                ", datereg=" + dateReg +
                ", countryreg='" + countryReg + '\'' +
                ", personid=" + personId +
                '}';
    }
}
