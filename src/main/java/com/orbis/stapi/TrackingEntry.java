package com.orbis.stapi;

/**
 * User: Daniil Sosonkin
 * Date: 10/4/2019 9:40 AM
 */
public class TrackingEntry
    {
        private long timestamp;
        private long delta;
        private String tag;
        private String name;
        private String group;

        public long getTimestamp()
            {
                return timestamp;
            }

        public void setTimestamp(long timestamp)
            {
                this.timestamp = timestamp;
            }

        public long getDelta()
            {
                return delta;
            }

        public void setDelta(long delta)
            {
                this.delta = delta;
            }

        public String getTag()
            {
                return tag;
            }

        public void setTag(String tag)
            {
                this.tag = tag;
            }

        public String getName()
            {
                return name;
            }

        public void setName(String name)
            {
                this.name = name;
            }

        public String getGroup()
            {
                return group;
            }

        public void setGroup(String group)
            {
                this.group = group;
            }
    }
