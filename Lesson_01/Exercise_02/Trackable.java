package Lesson_01.Exercise_02;

import java.util.UUID;

public interface Trackable {
    void track(String activity);

    default void trackLogin(String userId) {
        track(buildEntry("Login", userId));
    }

    default void trackLogout(String userId) {
        track(buildEntry("Logout", userId));
    }

    static String sessionId() {
        return UUID.randomUUID().toString();
    }

    private String buildEntry(String type, String detail) {
        return type + ":" + detail;
    }
}
