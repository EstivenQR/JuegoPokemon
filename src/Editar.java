
import java.sql.ResultSet; // proporciona varios métodos para obtener los datos de columna correspondientes a un fila.
import java.sql.SQLException; //  proporcionan información acerca de los errores y avisos que se producen mientras se está accediendo a un origen de datos.
import java.sql.Statement; // sirve para procesar una sentencia SQL estática y obtener los resultados producidos por ella. 
import javax.swing.JOptionPane;
import javax.swing.JTable; // es una clase utilizada en Swing (biblioteca gráfica) para generar ventanas sobre las cuales añadir distintos objetos con los que podrá interactuar o no el usuario. 
import javax.swing.JTextField; // campos donde el usuario puede ingresar información que se le solicite
import javax.swing.table.DefaultTableModel; // El componente DefaultTableModel sirve para manupular un TableModel de manera fácil.
import java.sql.*; // Es un conjunto de clases que nos permite acceder a diversos gestores de bases de datos

public class Editar {

    public void MostarParqueos(JTable TablaParqueo) {

        String Busc = "select * from parqueos"; // "Select " Para mostrar la tabla 
        Statement st;
        Conexion objconexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Cedula");
        modelo.addColumn("Horas");
        modelo.addColumn("Monto");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Placa");
        modelo.addColumn("Telefono");
        TablaParqueo.setModel(modelo);
        String[] Datos = new String[8];

        try {
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

            }//fin de ciclo while

            TablaParqueo.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

    }

    public void SeleccionParqueos(JTable TablaParqueo, JTextField TxtNombre, JTextField TxtApellidos, JTextField TxtCedula, JTextField TxtHoras, JTextField TxtMonto, JTextField TxtUbicacion, JTextField TxtPlaca, JTextField TxtTelefono) {

        try {
            int fila = TablaParqueo.getSelectedRow();
            if (fila >= 0) {

                TxtNombre.setText(TablaParqueo.getValueAt(fila, 0).toString());
                TxtApellidos.setText(TablaParqueo.getValueAt(fila, 1).toString());
                TxtCedula.setText(TablaParqueo.getValueAt(fila, 2).toString());
                TxtHoras.setText(TablaParqueo.getValueAt(fila, 3).toString());
                TxtMonto.setText(TablaParqueo.getValueAt(fila, 4).toString());
                TxtUbicacion.setText(TablaParqueo.getValueAt(fila, 5).toString());
                TxtPlaca.setText(TablaParqueo.getValueAt(fila, 6).toString());
                TxtTelefono.setText(TablaParqueo.getValueAt(fila, 7).toString());

            } else {
                JOptionPane.showMessageDialog(null, "Parqueo no seleccionado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la seleccion");
        }
    }

    public void ModificarParqueo(JTextField TxtNombre, JTextField TxtApellidos, JTextField TxtCedula, JTextField TxtHoras, JTextField TxtMonto, JTextField TxtUbicacion, JTextField TxtPlaca, JTextField TxtTelefono) {
        Conexion con = new Conexion();
        Connection cn = Conexion.getConnection();
        try {
                                                        // hacemos uso del update par actualizar la BD
            PreparedStatement ps = cn.prepareStatement("UPDATE Parqueos Set Nombre='" + TxtNombre.getText() + " ',parqueos.Apellidos='" + TxtApellidos.getText() + " ',parqueos.Horas='" + TxtHoras.getText() + " ',parqueos.Monto='" + TxtMonto.getText() + " ',parqueos.Ubicación='" + TxtUbicacion.getText() + " ',parqueos.Placa='" + TxtPlaca.getText() + " ',parqueos.Telefono='" + TxtTelefono.getText() + " ' where parqueos.Cedula='" + TxtCedula.getText() + "'");
            int indice = ps.executeUpdate();
            if (indice > 0) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Selecione un ususario");
            }
        } catch (SQLException e) {
            System.out.println(e);

        }

    }

    public void BuscarVehiculo(JTextField Txtbuscar, JTextField TxtNombre, JTextField TxtApellidos, JTextField TxtCedula, JTextField TxtHoras, JTextField TxtMonto, JTextField TxtUbicacion, JTextField TxtPlaca, JTextField TxtTelefono) {

        String Consulta = "select Nombre,Apellidos,Cedula,Horas,Monto,Ubicación,Placa,Telefono From parqueos Where parqueos.Cedula=(?) ";

        Conexion conexion = new Conexion();

        try {
            java.sql.CallableStatement cs = conexion.getConnection().prepareCall(Consulta); // La interfaz CallableStatement permite la utilización de sentencias SQL para llamar a procedimientos almacenados. 

            cs.setString(1, Txtbuscar.getText());
            cs.execute();

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Vehiculo encontrado");
                TxtNombre.setText(rs.getString("Nombre"));
                TxtApellidos.setText(rs.getString("Apellidos"));
                TxtCedula.setText(rs.getString("Cedula"));
                TxtHoras.setText(rs.getString("Horas"));
                TxtMonto.setText(rs.getString("Monto"));
                TxtUbicacion.setText(rs.getString("Ubicación"));
                TxtPlaca.setText(rs.getString("Placa"));
                TxtTelefono.setText(rs.getString("Telefono"));

            } else {
                JOptionPane.showMessageDialog(null, "Vehiculo no encotrado");
                TxtNombre.setText(rs.getString(" "));
                TxtApellidos.setText(rs.getString(" "));
                TxtCedula.setText(rs.getString(" "));
                TxtHoras.setText(rs.getString(" "));
                TxtMonto.setText(rs.getString(" "));
                TxtUbicacion.setText(rs.getString(" "));
                TxtPlaca.setText(rs.getString(" "));
                TxtTelefono.setText(rs.getString(" "));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar");

        }

    }

    public void eliminar(JTextField TxtCedula) {
        Conexion con = new Conexion();
        Connection cn = Conexion.getConnection();

        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM Parqueos Where Parqueos.Cedula='" + TxtCedula.getText() + "'"); // Aqui usamos DELETE para borrar en la BD
            int indice = ps.executeUpdate();
            if (indice > 0) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        } catch (SQLException e) {
            System.out.println(e);

        }

    }
}
