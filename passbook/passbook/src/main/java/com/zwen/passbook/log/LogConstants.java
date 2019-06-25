package com.zwen.passbook.log;

/**
 * <h1>Log constants</h1>
 * 6-5
 */
public class LogConstants {

    /**
     * <h2>User action name</h2>
     */
    public class ActionName {

        /** User checking pass template info */
        public static final String USER_PASS_INFO = "UserPassInfo";

        /** User checking used pass template info */
        public static final String USER_USERD_PASS_INFO = "UserUsedPassInfo";

        /** User use pass template */
        public static final String USER_USE_PASS = "UserUsePass";

        /** User retrieve inventory */
        public static final String INVENTORY_INFO = "InventoryInfo";

        /** User gain pass template */
        public static final String GAIN_PASS_TEMPLATE = "GainPassTemplate";

        /** User create feedback */
        public static final String CREATE_FEEDBACK = "CreateFeedback";

        /** User retrieve feedback */
        public static final String GET_FEEDBACK = "GetFeedback";
    }
}
