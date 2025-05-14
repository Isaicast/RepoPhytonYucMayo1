public class Producto {
    private int idProducto;
    private double precio;
    private String categoria;
    private String marca;
    private int stock;
    private String nombre;
    private boolean activo;
    

    // Constructor
    public Producto(int idProducto, double precio, String categoria, String marca, int stock, String nombre) {
        this.idProducto = idProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.marca = marca;
        this.stock = stock;
        this.nombre=nombre;
        this.activo=true;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public int getStock() {
        return stock;
    }

   

    // Métodos setters
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

  

    // Método para mostrar los detalles del producto
    public void mostrarDetalles() {
        System.out.println("ID: " + idProducto);
        System.out.println("Precio: $" + precio);
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Marca: " + marca);
        System.out.println("Stock: " + stock);
        System.out.println("Estatus: " + (activo ? "Activo":"Desactivado"));
        System.out.println("---------------------------");
    }

    // Método para actualizar el stock
    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
        System.out.println("Stock actualizado. Nuevo stock: " + this.stock);
    }

    // Método simulado para registrar el producto
    public void registrarProducto() {
        System.out.println("Producto registrado correctamente.");
    }

    // Método para obtener el precio
    public double obtenerPrecio() {
        return this.precio;
    }

    //Método para desactivar el producto
    public void desactivarProducto(){
        this.activo=false;
        System.out.println("Producto desactivado.");
    }

 
}