package org.example;

import com.yahoo.config.model.ConfigModelContext;
import com.yahoo.config.model.builder.xml.ConfigModelBuilder;
import com.yahoo.config.model.builder.xml.ConfigModelId;
import com.yahoo.text.XML;
import org.w3c.dom.Element;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class EchoModelBuilder extends ConfigModelBuilder<EchoModel> {

    private static final Logger logger = Logger.getLogger("EchoModelBuilder");

    public EchoModelBuilder() {
        super(EchoModel.class);
        logger.info("===> EchoModelBuilder.constructor");
    }

    @Override
    public List<ConfigModelId> handlesElements() {
        logger.info("===> EchoModelBuilder.handlesElements");

        return Arrays.asList(ConfigModelId.fromName("echo"));
    }

    @Override
    public void doBuild(EchoModel configModel, Element spec, ConfigModelContext modelContext) {
        logger.info("===> EchoModelBuilder.doBuild");
        int port = Integer.parseInt(XML.getValue(XML.getChild(spec, "port")));
        configModel.addServer(new EchoServer(modelContext.getParentProducer(), port));
    }
}