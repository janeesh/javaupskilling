import Lesson_01.Exercise_02.Trackable;
import Lesson_01.Exercise_02.UserSession;

void main() {
    System.out.println("Session Tracking Interface");
    UserSession s = new UserSession("S-001");
    s.trackLogin("usr-42");
    s.trackLogout("usr-42");
    s.exportLog().forEach(System.out::println);
    System.out.println("SessionId: " + Trackable.sessionId());
}







