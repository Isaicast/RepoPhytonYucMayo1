import java.util.ArrayList;

public class Venta {
    private int idVenta; // (Private) uso de Encapsulaiento
    private Cliente cliente;
    private int idVendedor;
    

    private ArrayList<Producto> productos; //Aqui hay una Relación con la Clase Productos (Agregación)
    private ArrayList<Integer> cantidades; 
    private double total;
    
    public Venta(int idVenta, Cliente cliente, int idVendedor) {
        this.idVenta = idVenta;
        this.cliente = cliente;
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
        System.out.println("Venta ID: " + idVenta + " | Cliente ID: " + cliente.getIdCliente()+ " | Vendedor ID: " + idVendedor);
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("- " + productos.get(i).getMarca() + " x" + cantidades.get(i));
        }
        System.out.println("Total: $" + total);
    }

    public void consultarHistorial() {
        //System.out.println("Consulta de historial no implementada (simulación).");        
        System.out.println("Historial de la venta ID: " + idVenta);
        System.out.println("Cliente: " + cliente.getNombre() + " (ID: " + cliente.getIdCliente() + ")");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-10s %-25s %-10s %-10s %-10s\n", "ID Producto", "Producto", "Precio", "Cantidad", "Subtotal");

        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            int cantidad = cantidades.get(i);
            double precio = p.obtenerPrecio();
            double subtotal = precio * cantidad;

            String nombreProducto = p.getNombre();
            if (nombreProducto.length() > 25) {
                nombreProducto = nombreProducto.substring(0, 25) + "...";
            }

            System.out.printf("%-10d %-25s $%-9.2f %-10d $%-9.2f\n",
                    p.getIdProducto(), nombreProducto, precio, cantidad, subtotal);
        }

        System.out.println("------------------------------------------------------");
        System.out.printf("TOTAL: $%.2f\n", total);
            
    }

    // Getters y setters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int obtenerIdCliente() { //solo el ID de Cliente
        return cliente.getIdCliente();
    }

     public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    
   
}
