package com.orbis.stapi;

import java.io.*;
import javax.ws.rs.core.*;
import org.apache.logging.log4j.*;
import org.glassfish.jersey.grizzly2.httpserver.*;
import org.glassfish.jersey.jackson.*;
import org.glassfish.jersey.server.*;

public class Server extends ResourceConfig
    {
        private static Server instance;
        private final Settings settings;

        public static void main(String[] args) throws IOException
            {
                System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");

                var logger = LogManager.getLogger(Server.class);
                var settings = new Settings();
                var config = "settings.json";

                for (int i = 0; i < args.length; i++)
                    switch (args[i])
                        {
                            case "-config":
                            case "-c":
                                config = args[++i];
                                break;
                        }

                var configFile = new File(config);
                if (configFile.exists())
                    settings = MyObjectMapperProvider.mapper.readValue(configFile, Settings.class);

                instance = new Server(settings);
                var baseUri = UriBuilder.fromUri("http://0.0.0.0/").port(settings.getPort()).build();
                var server = GrizzlyHttpServerFactory.createHttpServer(baseUri, instance, true);

                Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
                logger.info("StaPi listening on {}", settings.getPort());
            }

        private Server(Settings settings)
            {
                super(EndpointTest.class, EndpointTracking.class, MySecurityFilter.class, MyObjectMapperProvider.class, MyExceptionPrinter.class, JacksonFeature.class);
                this.settings = settings;
            }

        public static Server getInstance()
            {
                return instance;
            }

        public Settings getSettings()
            {
                return settings;
            }
    }
