package com.zwen.passbook.constant;

/**
 *
 * <h1>Constants</h1>
 * 6-3
 */
public class Constants {
    /** Kafka Topic*/
    public static final String TEMPLATE_TOPIC = "merchants-template";

    /** Token file directory */
    public static final String TOKEN_DIR = "/tmp/token";

    /** Used token SUFFIX */
    public static final String USED_TOKEN_SUFFIX = "_";

    /** Redis key of number of users */
    public static final String USE_COUNT_REDIS_KEY = "imooc-user-count";

    /**
     * <h2>User HBase Table</h2>
     */
    public class UserTable {
        /** User Hbase Table name*/
        public static final String TABLE_NAME = "pb:user";

        /** Column Family */
        public static final String FAMILY_B = "b";

        /** User name */
        public static final String NAME = "name";

        /** User age */
        public static final String AGE = "age";

        /** User gender */
        public static final String SEX = "sex";

        /** Extra info column family */
        public static final String FAMILY_O = "o";

        /** Phone number */
        public static final String PHONE = "phone";

        /** Address */
        public static final String ADDRESS = "address";
    }

    /**
     * <h2>PassTemplate HBase Table</h2>
     *
     */
    public class PassTemplateTable {

        /** PassTemplate Hbase table name */
        public static final String TABLE_NAME = "pb:passtemplate";

        /** Basic info column family*/
        public static final String Family_B = "b";

        /** Merchant id */
        public static final String ID = "id";

        /** Title */
        public static final String TITLE = "title";

        /** Summary */
        public static final String SUMMARY = "summary";

        /** Description */
        public static final String DESC = "desc";

        /** has token */
        public static final String HAS_TOKEN = "has_token";

        /** backgroudn color */
        public static final String BACKGROUND = "background";

        /** Requirements column family*/
        public static final String FAMILY_C = "c";

        /** Max number of available templates for one kind */
        public static final String LIMIT = "limit";

        /** Templates start time */
        public static final String START = "start";

        /** templates end time */
        public static final String END = "end";

    }

    /**
     * <h2>Pass HBase Table</h2>
     */
    public class PassTable {

        /** Pass HBass table name */
        public static final String TABLE_NAME = "pb:pass";

        /** Info column family */
        public static final String FAMILY_I = "i";

        /** User Id. This template belongs to which user */
        public static final String USER_ID = "user_id";

        /** Template ID */
        public static final String TEMPLATE_ID = "template_id";

        /** Template token */
        public static final String TOKEN = "token";

        /** Template assigned date */
        public static final String ASSIGNED_DATE = "assigned_date";

        /** Used Date */
        public static final String CON_DATE = "con_date";
    }

    /**
     * <h2>Feedback Hbase Table</h2>
     */
    public class Feedback {
        /** Feedback HBase Table name */
        public static final String TABLE_NAME = "pb:feedback";

        /** Info column family */
        public static final String FAMILY_I = "i";

        /** User Id */
        public static final String USER_ID = "user_id";

        /** Comment type */
        public static final String TYPE = "type";

        /** PassTemplate Rokey, it it is an app comment. it will be -1 */
        public static final String TEMPLATE_ID = "template_id";

        /** Comment */
        public static final String COMMENT = "comment";
    }
}
