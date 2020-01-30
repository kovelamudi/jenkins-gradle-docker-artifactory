package com.orbis.stapi;

import java.util.*;

public class Settings
    {
        private int port = 80;
        private Set<String> keys;
        private String influxHostname;
        private String influxUsername;
        private String influxPassword;

        public String getInfluxHostname()
            {
                return influxHostname;
            }

        public void setInfluxHostname(String influxHostname)
            {
                this.influxHostname = influxHostname;
            }

        public String getInfluxUsername()
            {
                return influxUsername;
            }

        public void setInfluxUsername(String influxUsername)
            {
                this.influxUsername = influxUsername;
            }

        public String getInfluxPassword()
            {
                return influxPassword;
            }

        public void setInfluxPassword(String influxPassword)
            {
                this.influxPassword = influxPassword;
            }

        public String getInfluxDatabase()
            {
                return influxDatabase;
            }

        public void setInfluxDatabase(String influxDatabase)
            {
                this.influxDatabase = influxDatabase;
            }

        private String influxDatabase;

        public int getPort()
            {
                return port;
            }

        public void setPort(int port)
            {
                this.port = port;
            }

        public Set<String> getKeys()
            {
                return keys;
            }

        public void setKeys(Set<String> keys)
            {
                this.keys = keys;
            }
    }
