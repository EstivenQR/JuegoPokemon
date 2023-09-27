
import javax.swing.JOptionPane;
import java.io.*;

public class Sujerencias {



    public static void agregar() {
        FileWriter Empleados = null;
        try {

            String Nombre= JOptionPane.showInputDialog(null, "Digite la Nombre");
            String Comentario = JOptionPane.showInputDialog(null, "Digite el Comentario:");

            Empleados = new FileWriter("Empleados.txt", true);
            Empleados.write("*"+Nombre + "= " + Comentario+ "\n");

            JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar" + ex);

        } finally {
            try {
                Empleados.close();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error en el archivo" + ex);

            }
        }

    }
}
