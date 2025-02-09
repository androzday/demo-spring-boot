package com.routebus.demo_spring_boot.constant;

public interface URLS {
    String ROOT = "/api";
    String V1 = "/v1";

    interface DRIVER{
        public static final String MODULE = ROOT + V1 + "/driver";
        public static final String SAVE = "/save";
        public static final String FIND_ALL = "/find-all";
        public static final String FIND_ONE = "/find-one";
        public static final String DELETE = "/delete";
        public static final String UPDATE = "/update";
    }

    interface BUS{
        public static final String MODULE = ROOT + V1 + "/bus";
        public static final String SAVE = "/save";
        public static final String FIND_ALL = "/find-all";
        public static final String FIND_ONE = "/find-one";
        public static final String DELETE = "/delete";
        public static final String UPDATE = "/update";
    }

    interface BUS_ROUTE{
        public static final String MODULE = ROOT + V1 + "/bus-route";
        public static final String SAVE = "/save";
        public static final String FIND_ALL = "/find-all";
        public static final String FIND_ONE = "/find-one";
        public static final String DELETE = "/delete";
        public static final String UPDATE = "/update";
    }

    interface ROUTE{
        public static final String MODULE = ROOT + V1 + "/route";
        public static final String SAVE = "/save";
        public static final String FIND_ALL = "/find-all";
        public static final String FIND_ONE = "/find-one";
        public static final String DELETE = "/delete";
        public static final String UPDATE = "/update";
    }

}
