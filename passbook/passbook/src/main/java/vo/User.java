package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>User Object</h1>
 * 6-6
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /** User id */
    private Long id;

    /** Basic user info column family b */
    private BaseInfo baseInfo;

    /** Other user info column family o */
    private OtherInfo otherInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BaseInfo {

        private String name;
        private Integer age;
        private String sex;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherInfo {
        private String phone;
        private String address;
    }
}
