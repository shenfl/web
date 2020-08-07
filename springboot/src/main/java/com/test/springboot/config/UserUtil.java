package com.test.springboot.config;

/**
 * @author shenfl
 */
public enum UserUtil {
    ;

    private static final ThreadLocal<User> THREAD_LOCAL = new ThreadLocal<>();

    public static Long currentUserId() {
        return currentUser().getUserId();
    }

    public static User currentUser() {
        return THREAD_LOCAL.get();
    }

    public static Long currentDealerCode() {
        return currentUser().getDealerCode();
    }

    /**
     */
    public static void setUser(User employee) {
        THREAD_LOCAL.set(employee);
    }

    /**
     * 是否包含用户信息
     */
    public static boolean containsUser() {
        return THREAD_LOCAL.get() != null;
    }

    public static void clear() {
        THREAD_LOCAL.remove();
    }

    public static class User {

        private Long dealerCode;
        private Long userId;
        private String username;
        private String phone;

        public Long getDealerCode() {
            return dealerCode;
        }

        public void setDealerCode(Long dealerCode) {
            this.dealerCode = dealerCode;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}