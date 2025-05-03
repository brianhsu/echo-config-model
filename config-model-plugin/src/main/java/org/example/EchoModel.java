package org.example;

import com.yahoo.config.model.ConfigModel;
import com.yahoo.config.model.ConfigModelContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EchoModel extends ConfigModel {

    private static final Logger logger = Logger.getLogger("EchoModel");
    private final List<EchoServer> servers = new ArrayList<EchoServer>();

    public EchoModel(ConfigModelContext modelContext) {
        super(modelContext);
        logger.info("===> EchoModel.constructor");
    }

    public void addServer(EchoServer server) {
        servers.add(server);
    }

    public int numServers() {
        return servers.size();
    }
}