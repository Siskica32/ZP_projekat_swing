package Bean;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.cert.X509Certificate;
import java.util.Date;

public class CertificateWrapper {
    
    private KeyPair keyPair;
    private X509Certificate certificate;
    
    private int keySize;
    private Date startDate; 
    private Date expiryDate;
    private BigInteger serialNumber;
    private String cn;
    private String ou;
    private String o;
    private String l;
    private String st;
    private String c;
    private Boolean basicConstraint;
    private Boolean basicConstraintIsCritical;
    private String alternativeName;
    private Boolean alternativeNameIsCritical;
    private int keyUsage;
    private Boolean keyUsageIsCritical;
    private String path;
    
    public CertificateWrapper(){
        
    }

    public CertificateWrapper(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public X509Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(X509Certificate certificate) {
        this.certificate = certificate;
    }

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public BigInteger getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(BigInteger serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getOu() {
        return ou;
    }

    public void setOu(String ou) {
        this.ou = ou;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public Boolean getBasicConstraint() {
        return basicConstraint;
    }

    public void setBasicConstraint(Boolean basicConstraint) {
        this.basicConstraint = basicConstraint;
    }

    public Boolean getBasicConstraintIsCritical() {
        return basicConstraintIsCritical;
    }

    public void setBasicConstraintIsCritical(Boolean basicConstraintIsCritical) {
        this.basicConstraintIsCritical = basicConstraintIsCritical;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public Boolean getAlternativeNameIsCritical() {
        return alternativeNameIsCritical;
    }

    public void setAlternativeNameIsCritical(Boolean alternativeNameIsCritical) {
        this.alternativeNameIsCritical = alternativeNameIsCritical;
    }

    public int getKeyUsage() {
        return keyUsage;
    }

    public void setKeyUsage(int keyUsage) {
        this.keyUsage = keyUsage;
    }

    public Boolean getKeyUsageIsCritical() {
        return keyUsageIsCritical;
    }

    public void setKeyUsageIsCritical(Boolean keyUsageIsCritical) {
        this.keyUsageIsCritical = keyUsageIsCritical;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
 
}
