import java.util.ArrayList;

public class Cliente {

    //atributos del cliente
    private int idCliente;
    private String nombre, apellidoP, apellidoM, email, telefono, direccion,usuario, contrasena;
    private final ArrayList<Venta> ventas; //Relacion de agregacion con Ventas 1:N

 

    //solo mostrar datos especificos del cliente:
    public String obtenerDatosCliente() {
        return nombre + " " + apellidoP + " " + apellidoM + " | " + email + " | " + telefono;
    }

    //Modificar perfil cliente
    public void actualizarPerfil(String nuevoTelefono, String nuevaDireccion, String nuevoUsuario, String nuevaContrasena) {
        this.telefono = nuevoTelefono;        
        this.direccion = nuevaDireccion;
        this.usuario = nuevoUsuario;                    
        this.contrasena=nuevaContrasena;
        
    }


    //metodo para consultar los detalles del cliente
    public void mostrarDetalles() {
        System.out.println("Cliente ID: " + idCliente + " | Nombre: " + nombre + " " + apellidoP + " " + apellidoM);
        System.out.println("Email: " + email + " | Tel: " + telefono + " | Dirección: " + direccion);
        System.out.println("Usuario: " + usuario + " | Contraseña: " + contrasena);
    }


    //Constructor de la clase
    public Cliente(String apellidoM, String apellidoP, String contrasena, String direccion, String email, int idCliente, String nombre, String telefono, String usuario) {
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.email = email;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
        this.ventas = new ArrayList<>(); //Atributo para relacionar el cliente con las ventas realizadas
    }
    
    
    //MEtodos setters y getters
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
    //Para actualizar el email se haga uso del metodo set siguiente:
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

    


}
