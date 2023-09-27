
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Registro extends Conexion {

    public void Registar(JTextField TxtNombre, JTextField TxtApellidos, JTextField TxtCedula, JComboBox ComboHoras, JTextField TxtMonto, JTextField TxtUbicacion, JTextField TxtPlaca, JTextField TxtTelefono) {
        Conexion con = new Conexion();
        Parqueo emp = new Parqueo();

        emp.setNombre(TxtNombre.getText());
        emp.setApellidos(TxtApellidos.getText());
        emp.setCedula(Integer.parseInt(TxtCedula.getText()));
        emp.setHoras(Integer.parseInt(ComboHoras.getSelectedItem().toString()));
        emp.setMonto(Double.parseDouble(TxtMonto.getText()));
        emp.setUbicación(TxtUbicacion.getText());
        emp.setPlaca(TxtPlaca.getText());
        emp.setTelefono(Integer.parseInt(TxtTelefono.getText()));

        String Usuarios = "INSERT INTO parqueos(Nombre,Apellidos,Cedula,Horas,Monto,Ubicación,Placa,Telefono) VALUES(?,?,?,?,?,?,?,?)";
        try {

            CallableStatement cs = con.getConnection().prepareCall(Usuarios); // La interfaz CallableStatement permite la utilización de 
            cs.setString(1, emp.getNombre());                                // sentencias SQL para llamar a procedimientos almacenados.
            cs.setString(2, emp.getApellidos());
            cs.setInt(3, emp.getCedula());
            cs.setInt(4, emp.getHoras());
            cs.setDouble(5, emp.getMonto());
            cs.setString(6, emp.getUbicación());
            cs.setString(7, emp.getPlaca());
            cs.setInt(8, emp.getTelefono());
            cs.execute();

            JOptionPane.showMessageDialog(null, "Cliente agregado");

            JOptionPane.showMessageDialog(null, "FACTURA PARQUEO\n\n"
                    + "Cliente: " + emp.getNombre() + " " + emp.getApellidos() + "\n"
                    + "Cedula: " + emp.getCedula() + "\n"
                    + "Horas: " + emp.getHoras() + "\n"
                    + "Ubicación: " + emp.getUbicación() + "\n"
                    + "Placa: " + emp.getPlaca() + "\n"
                    + "Telefono: " + emp.getTelefono() + "\n"
                    + "Monto: " + emp.getMonto());

        } catch (Exception e) {
            System.out.println(e);

        }
    }

}
