public class Cliente {

    //atributos del cliente
    private int idCliente;
    private String nombre, apellidoP, apellidoM, email, telefono, direccion,usuario, contrasena;

 

    //solo mostrar datos especificos del cliente:
    public String obtenerDatosCliente() {
        return nombre + " " + apellidoP + " " + apellidoM + " | " + email + " | " + telefono;
    }

    //Modificar perfil cliente
    public void actualizarPerfil(String nuevoTelefono, String nuevaDireccion, String nuevousaurio, String nuevaContrasena) {
        this.telefono = nuevoTelefono;
        this.direccion = nuevaDireccion;
        this.usuario=nuevousaurio;
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

    


}
