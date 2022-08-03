package ProjectManagement;

import controller.LoginController;
import model.Login;

public class App {
    

    public static void main(String[] args) {
        Login login = new Login();
        LoginController log = new LoginController();
        
        String name = "co";
        String pass = "macaco123";
        
        if (!log.logConfirm(name, pass).isEmpty()){
            System.out.println("Deu boa kkk");
        } else {
            System.out.println("Numdeu");
    }
    }
}
