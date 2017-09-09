package com.example.hp.hotelbooking;

/**
 * Created by kunai on 8/9/17.
 */

public class Info {

        String id, name, ref,openStatus;

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public String getOpenStatus() {return openStatus; }
    public String getName() {
            return name;
        }
        public String getId() {
            return id;
        }
        public String getRef() {
            return ref;
        }
    }

