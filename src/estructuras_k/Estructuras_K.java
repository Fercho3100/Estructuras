package estructuras_k;

import Bienvenida.login;

public class Estructuras_K {

    public static void main(String[] args) {

        login login = new login();

        while (!login.getIsValid()) {
            login.setVisible(true);

        }

    }
}
