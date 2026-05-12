package Lesson_01.Exercise_02;

import java.util.ArrayList;
import java.util.List;

public class UserSession implements Trackable, Exportable {
    private final List<String> entries = new ArrayList<>();

    public UserSession(String s) {
        System.out.println("Session: " + s);
    }

    @Override
    public List<String> exportLog() {
        return new ArrayList<>(entries);
    }

    @Override
    public void track(String activity) {
        entries.add(activity);
    }
}