
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable; // La JTable controla cómo se presentan los datos, siendo el TableModel quien controla los datos en sí mismos
import javax.swing.JTextField; // permite al operador del programa ingresar una cadena de caracteres por teclado
import javax.swing.table.DefaultTableModel; // sirve para manupular un TableModel de manera fácil.


public class Buscar {

    public void MostarParqueos(JTable Tabla) {

        String Busc = "select * from parqueos";
        Statement st;
        Conexion objconexion = new Conexion();

        DefaultTableModel modelo = new DefaultTableModel(); // << Construye un DefaultTableModel 
                                                            // e inicializa la tabla pasando datos 
        modelo.addColumn("Nombre");                         // y columnNames al método setDataVector.
        modelo.addColumn("Apellidos");
        modelo.addColumn("Cedula");
        modelo.addColumn("Horas");
        modelo.addColumn("Monto");
        modelo.addColumn("Ubicación");
        modelo.addColumn("Placa");
        modelo.addColumn("Telefono");
        Tabla.setModel(modelo); // Asigna el modelo de datos al objeto JTable. 
        String[] Datos = new String[8];

        try { //createStatement() se utiliza para crear un objeto que modela a una sentencia SQL.
            st = objconexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(Busc);

            while (rs.next()) {
                Datos[0] = rs.getString(1);
                Datos[1] = rs.getString(2);
                Datos[2] = rs.getString(3);
                Datos[3] = rs.getString(4);
                Datos[4] = rs.getString(5);
                Datos[5] = rs.getString(6);
                Datos[6] = rs.getString(7);
                Datos[7] = rs.getString(8);
                modelo.addRow(Datos);

            }//fin del while

            Tabla.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

    }

    public void BuscarCed(JTextField CedBusc, JTextField NomResult, JTextField ApellResult, JTextField CedResult, JTextField HorasResult, JTextField SalResult, JTextField UbicResult, JTextField PlacaResult, JTextField TelfResult) {

        String Consulta = "select Nombre,Apellidos,Cedula,Horas,Monto,Ubicación,Placa,Telefono From Parqueos Where Parqueos.Cedula=(?) ";

        Conexion conexion = new Conexion();

        try {
            CallableStatement cs = conexion.getConnection().prepareCall(Consulta); //  CallableStatement permite la utilización de sentencias SQL para llamar a procedimientos almacenados.

            cs.setString(1, CedBusc.getText());
            cs.execute();

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Vehiculo encontrado");
                NomResult.setText(rs.getString("Nombre"));
                ApellResult.setText(rs.getString("Apellidos"));
                CedResult.setText(rs.getString("Cedula"));
                HorasResult.setText(rs.getString("Horas"));
                SalResult.setText(rs.getString("Monto"));
                UbicResult.setText(rs.getString("Ubicación"));
                PlacaResult.setText(rs.getString("Placa"));
                TelfResult.setText(rs.getString("Telefono"));

            } else {
                JOptionPane.showMessageDialog(null, "Vehiculo no encotrado");
                NomResult.setText(rs.getString(" "));
                ApellResult.setText(rs.getString(" "));
                CedResult.setText(rs.getString(" "));
                HorasResult.setText(rs.getString(" "));
                SalResult.setText(rs.getString(" "));
                UbicResult.setText(rs.getString(" "));
                PlacaResult.setText(rs.getString(" "));
                TelfResult.setText(rs.getString(" "));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");

        }

    }

    public void SeleccionParqueos(JTable tabla, JTextField NomResult, JTextField ApellResult, JTextField CedResult, JTextField HorasResult, JTextField SalResult, JTextField UbicResult, JTextField PlacaResult, JTextField TelefonoResult) {

        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {

                NomResult.setText(tabla.getValueAt(fila, 0).toString());
                ApellResult.setText(tabla.getValueAt(fila, 1).toString());
                CedResult.setText(tabla.getValueAt(fila, 2).toString());
                HorasResult.setText(tabla.getValueAt(fila, 3).toString());
                SalResult.setText(tabla.getValueAt(fila, 4).toString());
                UbicResult.setText(tabla.getValueAt(fila, 5).toString());
                PlacaResult.setText(tabla.getValueAt(fila, 6).toString());
                TelefonoResult.setText(tabla.getValueAt(fila, 7).toString());

            } else {
                JOptionPane.showMessageDialog(null, "Empleado no seleccionado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la seleccion");
        }
    }


}
