import java.util.ArrayList;

public class Cliente extends Persona {
    private String usuario;
    private String contrasena;
    private final ArrayList<Venta> ventas; //Relacion de agregacion con Ventas 1:N
    

    //Constructor de la clase
    public Cliente(String apellidoM, String apellidoP, String contrasena, String direccion, String email,
                   int idCliente, String nombre, String telefono, String usuario) {
        super(apellidoM, apellidoP, direccion, email, idCliente, nombre, telefono);
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.ventas = new ArrayList<>(); //Atributo para relacionar el cliente con las ventas realizadas
    }

    public String obtenerDatosCliente() {
        return getNombre() + " " + getApellidoP() + " " + getApellidoM() + " | " + getEmail() + " | " + getTelefono();
    }
    //Modificar perfil cliente
    public void actualizarPerfil(String nuevoTelefono, String nuevaDireccion, String nuevoUsuario, String nuevaContrasena) {
        setTelefono(nuevoTelefono);
        setDireccion(nuevaDireccion);
        this.usuario = nuevoUsuario;
        this.contrasena = nuevaContrasena;
    }

    //metodo para consultar los detalles del cliente
    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Usuario: " + usuario + " | Contraseña: " + contrasena);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    //Metodos para agregar clientes a ventas Metodo relacion activa de 1 a muchos con venta
    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    //METODOS PARA CONSULTAR LAS VENTAS DE UN CLINETE
    public ArrayList<Venta> getHistorialVentas() {
    return ventas;
    }



}