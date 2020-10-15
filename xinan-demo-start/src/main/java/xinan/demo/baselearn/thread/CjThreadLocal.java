package xinan.demo.baselearn.thread;

import lombok.Data;

/**
 * @author xinan
 * @date 2020/04/22
 */
public class CjThreadLocal {

    public static ThreadLocal<Session> session = ThreadLocal.<Session>withInitial(() -> new Session());

    @Data
    public static class Session {
        private String id;
        private String user;
        private String status;
    }

    public String getUser() {
        return session.get().getUser();
    }

    public String getStatus() {
        return session.get().getStatus();
    }

    public void setStatus(String status) {
        session.get().setStatus(status);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            CjThreadLocal handler = new CjThreadLocal();
            handler.getStatus();
            handler.getUser();
            handler.setStatus("close");
            handler.getStatus();
        }).start();
    }
}
