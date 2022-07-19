package Principal;

import Vistas.*;
import Modelo.*;

public class Main {

    public static void main(String[] args) {
        //1.Creamos la instancia de la vista
        Login login = new Login();
        //
        login.setVisible(true);
        //2.
        Conexion conexion = new Conexion();
        conexion.getConnection();

    }

}
