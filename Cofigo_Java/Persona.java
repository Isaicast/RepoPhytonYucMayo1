public class Persona {
    private int idCliente;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String email;
    private String telefono;
    private String direccion;

    public Persona(String apellidoM, String apellidoP, String direccion, String email,
                   int idCliente, String nombre, String telefono) {
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
        this.direccion = direccion;
        this.email = email;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void mostrarDetalles() {
        System.out.println("Cliente ID: " + idCliente + " | Nombre: " + nombre + " " + apellidoP + " " + apellidoM);
        System.out.println("Email: " + email + " | Tel: " + telefono + " | Dirección: " + direccion);
    }
}