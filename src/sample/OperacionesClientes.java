package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OperacionesClientes {

    Connection connection;

    public OperacionesClientes(Connection conn) {
        this.connection = conn;
    }

    //metodo consultar id
    public Cliente getCliente(int id) {

        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";

        String query = "SELECT clienteid, nombre, apellidos, direccion " +
                "FROM cliente " +
                "WHERE clienteID = " + id;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                clienteId = rs.getInt("clienteid");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                direccion = rs.getString("direccion");
            }

            //System.out.println(clienteId + ", " + nombre + " " + apellidos + ", " + direccion);

            return new Cliente(clienteId, nombre, apellidos, direccion);
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());

            return null;
        }
    }
    //Lista por id
    public ArrayList gar(int aef) {
        ArrayList dfkgj = new ArrayList();
        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";

        String query = "SELECT clienteid, nombre, apellidos, direccion " +
                "FROM cliente " +
                "WHERE clienteid = " + aef ;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                clienteId = rs.getInt("clienteid");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                direccion = rs.getString("direccion");
                dfkgj.add(new Cliente(clienteId, nombre, apellidos, direccion));
            }

            //System.out.println(clienteId + ", " + nombre + " " + apellidos + ", " + direccion);

            return dfkgj;
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());

            return null;
        }
    }
    //Lista por apellido
    public ArrayList fes(String hrgf) {
        ArrayList vfd = new ArrayList();
        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";

        String query = "SELECT clienteid, nombre, apellidos, direccion " +
                "FROM cliente " +
                "WHERE apellidos = " +"'"+hrgf+"'";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                clienteId = rs.getInt("clienteid");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                direccion = rs.getString("direccion");
                vfd.add(new Cliente(clienteId, nombre, apellidos, direccion));
            }

            //System.out.println(clienteId + ", " + nombre + " " + apellidos + ", " + direccion);

            return vfd;
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());

            return null;
        }
    }

    //metodo consultar apellido
    public Cliente getCliente(String apellido) {

        int clienteId = 0;
        String nombre = "", apellidos = "", direccion = "";

        String query = "SELECT clienteid, nombre, apellidos, direccion " +
                "FROM cliente " +
                "WHERE apellidos = " + "'"+apellidos+"'";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                clienteId = rs.getInt("clienteid");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                direccion = rs.getString("direccion");
            }

            //System.out.println(clienteId + ", " + nombre + " " + apellidos + ", " + direccion);

            return new Cliente(clienteId, nombre, apellidos, direccion);
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());

            return null;
        }
    }
    //modificar cliente metodo
    public int modificarCliente(int id,String nom,String ape,String direc) {
        int clienteId;
        String nombre, apellidos, direccion;

        String query = "update cliente set nombre = '"+nom+"', apellidos= '"+ape+"', direccion='"+direc+"' where clienteID = " + id;

        int numRegs = 0;
        try {
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);

            System.out.println("Cantidad de registros afectados: " + numRegs);
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }

        return numRegs;
    }
    //metodo borrar
    public int deleteCliente(int id) {
        int clienteId;
        String nombre, apellidos, direccion;

        String query = "delete from cliente where clienteID = " + id;

        int numRegs = 0;
        try {
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);

            System.out.println("Cantidad de registros afectados: " + numRegs);
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }

        return numRegs;
    }
    //metodo consultar
    public int consultar(int id){
        int clienteId=0;
        String query = "SELECT clienteID " +
                "FROM cliente " +
                "WHERE clienteID = " + id;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                clienteId = rs.getInt("clienteid");

            }
            return 1;
            //System.out.println(clienteId + ", " + nombre + " " + apellidos + ", " + direccion);


        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());

            return 0;
        }

    }
    //  metodo agregar clientes
    public int insertCliente(String nombre, String apellidos, String direccion) {
        String query = "insert into cliente(nombre, apellidos, direccion) " +
                "values ('"+ nombre + "', '" + apellidos + "', '" + direccion + "')";

               /*  insert into cliente(nombre, apellidos, direccion
                values ('Jorge', 'Estrada', 'Lázaro Cárdenas 123')  */

        int numRegs = 0;
        try {
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);

            System.out.println("Cantidad de registros afectados: " + numRegs);

        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }

        return numRegs;
    }
}