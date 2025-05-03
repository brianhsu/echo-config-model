FROM vespaengine/vespa

ADD config-model-plugin/target/echo-config-model-1.0-SNAPSHOT-deploy.jar /opt/vespa/lib/jars/config-models/
ADD config-model-plugin/echomodel.xml /opt/vespa/conf/configserver-app/config-models/
ADD echo.rnc /opt/vespa/share/vespa/schema/version/8.x/schema/
ADD services.rnc /opt/vespa/share/vespa/schema/version/8.x/schema/
