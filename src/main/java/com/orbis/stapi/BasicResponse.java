package com.orbis.stapi;

/**
 * User: Daniil Sosonkin
 * Date: 9/5/2018 11:01 AM
 */
public final class BasicResponse
    {
        public static BasicResponse Failure() {
            return Builder().setSuccess(false);
        }
        public static BasicResponse Success() {
            return Builder().setSuccess(true);
        }
        private long timestamp = System.currentTimeMillis();
        private Boolean success;
        private Object contents;

        public static BasicResponse Builder()
            {
                return new BasicResponse();
            }

        private BasicResponse()
            { }

        public boolean isSuccess()
            {
                return success;
            }

        public BasicResponse setSuccess(boolean success)
            {
                this.success = success;
                return this;
            }

        public Object getContents()
            {
                return contents;
            }

        public BasicResponse setContents(Object contents)
            {
                this.contents = contents;
                return this;
            }

        public long getTimestamp()
            {
                return timestamp;
            }
    }
