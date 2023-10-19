package cervantes.tiendaLibros.vista;

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

    private DefaultTableModel tablaModeloLibros;


    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarForma();

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

    private void createUIComponents() {
        // TODO: place custom component creation code here

        this.tablaModeloLibros = new DefaultTableModel(0,5);
        String[] cabeceros = {"Id","Libros","Autor","Precio","Exixtencia"};
        this.tablaModeloLibros.setColumnIdentifiers(cabeceros);
        //istanciar el objeto Jtable
        this.tablaLibros = new JTable(tablaModeloLibros);
    }
}
