package cervantes.tiendaLibros.vista;

import cervantes.tiendaLibros.modelo.Libro;
import cervantes.tiendaLibros.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class LibroForm  extends JFrame {

    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JScrollPane tabla;
    private JTextField LibroTexto;
    private JTextField textField1;
    private JTextField precioTexto;
    private JTextField ExistenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;

    private DefaultTableModel tablaModeloLibros;


    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarForma();

        agregarButton.addActionListener(e -> agregarLibro());
    }

    private void iniciarForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla  = toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth()/2);
        int y = (tamanioPantalla.height - getHeight()/2);
        setLocation(x,y);


    }

    private void agregarLibro(){
        //Leer valores del formulario
        if (LibroTexto.getText().equals("")){
            mostrarMensaje("Proporciona el nombre del libro ");
            LibroTexto.requestFocusInWindow();
            return;
        }
        var nombreLibro = LibroTexto.getText();
        var autor = textField1.getText();
        var precio = Double.parseDouble(precioTexto.getText());
        var existencia = Integer.parseInt(ExistenciasTexto.getText());
        //crear el objeto Libro
        var libro = new Libro(null,nombreLibro,autor,precio,existencia);
        //libro.setNombrelibro(nombreLibro);
        //libro.setAutor(autor);
        //libro.setPrecio(precio);
        //libro.setExistencias(existencia);
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se agrego el libro...");
        limpiarFormulario();
        listarLibros();

    }

    private void limpiarFormulario(){
        LibroTexto.setText("");
        textField1.setText("");
        precioTexto.setText("");
        ExistenciasTexto.setText("");

    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        this.tablaModeloLibros = new DefaultTableModel(0,5);
        String[] cabeceros = {"Id","Libros","Autor","Precio","Existencia"};
        this.tablaModeloLibros.setColumnIdentifiers(cabeceros);
        //Instanciar el objeto Jtable
        this.tablaLibros = new JTable(tablaModeloLibros);
        listarLibros();

    }

    private void listarLibros(){
        //limpira la tabla
        tablaModeloLibros.setRowCount(0);
        //obtener los libros
        var libros = libroServicio.listarLibros();
        libros.forEach((libro) -> {
            Object[] renglonLibro = {
                    libro.getIdLibro(),
                    libro.getNombrelibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
            this.tablaModeloLibros.addRow(renglonLibro);

        });
    }


}

