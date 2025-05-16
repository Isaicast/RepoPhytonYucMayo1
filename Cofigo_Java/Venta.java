import java.util.ArrayList;

public class Venta {
    private int idVenta; // (Private) uso de Encapsulaiento
    private int idCliente; // Dependencia indereca a Cliente a través del ID
    private int idVendedor;
    

    private ArrayList<Producto> productos; //Aqui hay una Relación con la Clase Productos (Agregación)
    private ArrayList<Integer> cantidades; 
    private double total;
    
    public Venta(int idVenta, int idCliente, int idVendedor) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
    }
    //Agregación, Producto sigue exisitendo si se elimna la clase Venta, solo se agrega a venta pero no se genera en esta clase
    public void agregarProducto(Producto p, int cantidad) { 
        productos.add(p);
        cantidades.add(cantidad);
        total += p.obtenerPrecio() * cantidad;
    }

    public void eliminarProducto(int index) {
        if (index >= 0 && index < productos.size()) {
            total -= productos.get(index).obtenerPrecio() * cantidades.get(index);
            productos.remove(index);
            cantidades.remove(index);
        }
    }

    public double calcularTotal() {
        return total;
    }

    public void mostrarDetalles() {
        System.out.println("Venta ID: " + idVenta + " | Cliente ID: " + idCliente + " | Vendedor ID: " + idVendedor);
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("- " + productos.get(i).getMarca() + " x" + cantidades.get(i));
        }
        System.out.println("Total: $" + total);
    }

    public void consultarHistorial() {
        System.out.println("Consulta de historial no implementada (simulación).");
    }

    // Getters y setters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(ArrayList<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
