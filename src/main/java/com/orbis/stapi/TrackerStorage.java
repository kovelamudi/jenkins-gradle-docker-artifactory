package com.orbis.stapi;

import java.util.concurrent.*;
import okhttp3.*;
import org.apache.logging.log4j.*;
import org.influxdb.*;
import org.influxdb.dto.*;

/**
 * User: Daniil Sosonkin
 * Date: 10/4/2019 2:07 PM
 */
public class TrackerStorage extends Thread
    {
        private static final TrackerStorage instance = new TrackerStorage();
        private final TrackingEntry terminator = new TrackingEntry();
        private final BlockingQueue<TrackingEntry> queue = new LinkedBlockingQueue<>();
        private final Logger logger = LogManager.getLogger(getClass());

        public static TrackerStorage getInstance()
            {
                return instance;
            }

        private TrackerStorage()
            {
                start();
            }

        public static void terminate()
            {
                TrackerStorage tracker = getInstance();
                tracker.queue.add(tracker.terminator);
            }

        public void add(TrackingEntry entry)
            {
                queue.add(entry);
            }

        @Override
        public void run()
            {
                while (true)
                    try {
                        TrackingEntry entry = queue.take();
                        if (entry == terminator)
                            break;

                        addEntry(entry);
                    } catch (Throwable e) {
                        logger.error("Couldn't save the entry", e);
                    }
            }

        private void addEntry(TrackingEntry entry)
            {
                OkHttpClient.Builder client = new OkHttpClient().newBuilder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(10, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS);

                Settings settings = Server.getInstance().getSettings();
                String hostname = settings.getInfluxHostname();
                String username = settings.getInfluxUsername();
                String password = settings.getInfluxPassword();
                String database = settings.getInfluxDatabase();

                if (hostname == null)
                    return;

                InfluxDB influx = InfluxDBFactory.connect(hostname, username, password, client);
                influx.setDatabase(database);
                influx.write(
                        Point.measurement(entry.getName())
                                .time(entry.getTimestamp(), TimeUnit.MILLISECONDS)
                                .addField("delta", entry.getDelta())
                                .addField("tag", entry.getTag())
                                .addField("group", entry.getGroup())
                                .build()
                );
            }
    }
