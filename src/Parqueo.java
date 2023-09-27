
public class Parqueo extends Persona {

    double Monto;
    String Ubicación;
    String Placa;
    int Telefono;
   

    public Parqueo() {
    }

    public Parqueo(double Monto, String Ubicación, String Placa, int Telefono) {
        this.Monto = Monto;
        this.Ubicación = Ubicación;
        this.Placa = Placa;
        this.Telefono = Telefono;
    }

    public Parqueo(double Monto, String Ubicación, String Placa, int Telefono, String Nombre, String Apellidos, int Cedula, int Horas) {
        super(Nombre, Apellidos, Cedula, Horas);
        this.Monto = Monto;
        this.Ubicación = Ubicación;
        this.Placa = Placa;
        this.Telefono = Telefono;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public String getUbicación() {
        return Ubicación;
    }

    public void setUbicación(String Ubicación) {
        this.Ubicación = Ubicación;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public int getHoras() {
        return Horas;
    }

    public void setHoras(int Horas) {
        this.Horas = Horas;
    }




}
