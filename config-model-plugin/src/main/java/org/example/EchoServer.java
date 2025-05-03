package org.example;

import com.yahoo.config.model.producer.AnyConfigProducer;
import com.yahoo.config.model.producer.TreeConfigProducer;
import com.yahoo.echo.EchoConfig;

public class EchoServer extends AnyConfigProducer implements EchoConfig.Producer {

    private final int port;

    public EchoServer(TreeConfigProducer parent, int port) {
        super(parent, "server");
        this.port = port;
    }

    public void getConfig(EchoConfig.Builder builder) {
        builder.port(port);
    }
}