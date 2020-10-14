package br.com.fiap.fiapstock.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("propriedade")
public class CloudConfigProperties {

    private String remoteFile;

    public String getRemoteFile() {
        return remoteFile;
    }

    public void setRemoteFile(String remoteFile) {
        this.remoteFile = remoteFile;
    }
}
