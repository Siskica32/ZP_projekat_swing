package Security;

import Bean.CertificateWrapper;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64Encoder;

public class FileUtil {

    public void exportCertificate(Certificate cert, String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            byte[] buffer = cert.getEncoded();
            FileOutputStream output = new FileOutputStream(file);
            Base64Encoder encoder = new Base64Encoder();
            output.write("-----BEGIN CERTIFICATE-----".getBytes());
            encoder.encode(buffer, 0, buffer.length, output);
            output.write("-----END CERTIFICATE-----".getBytes());
            output.close();
        } catch (Exception ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exportKeyStore(String path, String password, CertificateWrapper cw) {
        try {
            if(!cw.isIsSign()) 
                return;
            
            File file = new File(path);
            if (file.exists()) 
                file.delete();
            FileOutputStream output = new FileOutputStream(file);

            KeyStore keyStore = KeyStore.getInstance("pkcs12");
            keyStore.load(null,null);
            
            Certificate[] certChain = new Certificate[1];	
            certChain[0] = cw.getCertificate();
            keyStore.setKeyEntry("key", cw.getPrivateKey(), "".toCharArray(), certChain);
            
            keyStore.store(output, password.toCharArray());  
            output.close();
            
        } catch (Exception ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CertificateWrapper importKeyStore(String path, String password) {
        try {
            File file = new File(path);
            if (!file.exists()) 
                return null;
            
            KeyStore keyStore = KeyStore.getInstance("pkcs12");
            FileInputStream input = new FileInputStream(path);
            keyStore.load(input, password.toCharArray());
                              
            Certificate certificate = keyStore.getCertificate("key");
            PublicKey publicKey = certificate.getPublicKey();
            PrivateKey privateKey = (PrivateKey)keyStore.getKey("key", "".toCharArray());
            KeyPair keyPair = new KeyPair(publicKey, privateKey);
            
            
            InputStream in = new ByteArrayInputStream(certificate.getEncoded());
            BouncyCastleProvider provider = new BouncyCastleProvider();
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X509", provider);
            X509Certificate x509cert = (X509Certificate) certificateFactory.generateCertificate(in);
      
            CertificateWrapper cw = new CertificateWrapper(keyPair);
            cw.setSerialNumber(x509cert.getSerialNumber());
            
            System.out.println(cw.getSerialNumber());
            
            return cw;
        } catch (Exception ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
