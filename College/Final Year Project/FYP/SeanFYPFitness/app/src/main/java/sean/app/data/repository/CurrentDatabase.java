package sean.app.data.repository;


import sean.app.data.model.Admin;
import sean.app.data.model.PublicUser;

public class CurrentDatabase {

    private static PublicUser currentPublicUser;
    private static Admin currentAdmin;

    public static PublicUser getCurrentPublicUser() {
        return currentPublicUser;
    }

    public static void setCurrentPublicUser(PublicUser currentPublicUser) {
        CurrentDatabase.currentPublicUser = currentPublicUser;
    }

    public static Admin getCurrentAdmin() {
        return currentAdmin;
    }

    public static void setCurrentAdmin(Admin currentAdmin) {
        CurrentDatabase.currentAdmin = currentAdmin;
    }
}