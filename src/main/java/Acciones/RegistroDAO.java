package Acciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class RegistroDAO {

    private static final String DB_URL = "jdbc:mysql://35.222.147.13:3306/PAE";
    private static final String USER = "root";
    private static final String PASSWORD = "842963";

    public int RegistrarInst(String Nombre, String Dep, String Ciudad, int Numero, String tel, String correo) throws ClassNotFoundException, SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql1 = "INSERT INTO Instituciones(NombreInstitución, Departamento, Municipio, NumeroEstudiantes, TeléfonoContacto, CorreoInstitucional) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, Nombre);
            ps.setString(2, Dep);
            ps.setString(3, Ciudad);
            ps.setInt(4, Numero);
            ps.setString(5, tel);
            ps.setString(6, correo);

            int affectedRows = ps.executeUpdate();
            int generatedId = -1;

            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                }
            }

            JOptionPane.showMessageDialog(null, "Datos agregados a la base de datos. ID generado: " + generatedId);

            return generatedId;
        }
    }

    public void Editar(int id, String dep, String ciudad, int numero, String tel, String correo) throws ClassNotFoundException, SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String selectSql = "SELECT * FROM Instituciones WHERE ID = ?";
            PreparedStatement selectPs = con.prepareStatement(selectSql);
            selectPs.setInt(1, id);
            ResultSet resultSet = selectPs.executeQuery();

            if (resultSet.next()) {
                String updateSql = "UPDATE Instituciones SET NumeroEstudiantes = ?, TeléfonoContacto = ?, CorreoInstitucional = ? WHERE ID = ?";
                PreparedStatement updatePs = con.prepareStatement(updateSql);
                updatePs.setInt(1, numero);
                updatePs.setString(2, tel);
                updatePs.setString(3, correo);
                updatePs.setInt(4, id);
                updatePs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos de la institución actualizadas.");

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna institución con el ID proporcionado.");
            }

            resultSet.close();
            selectPs.close();
        }
    }

    public int RegistrarProv(String Nombre, String Dep, String Ciudad, int Numero, String tel, String producto) throws ClassNotFoundException, SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql1 = "INSERT INTO Proveedores(Proveedor, Departamento, Municipio, NoProductos, Teléfono, Producto) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, Nombre);
            ps.setString(2, Dep);
            ps.setString(3, Ciudad);
            ps.setInt(4, Numero);
            ps.setString(5, tel);
            ps.setString(6, producto);

            int affectedRows = ps.executeUpdate();
            int generatedId = -1;

            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                }
            }

            JOptionPane.showMessageDialog(null, "Datos agregados a la base de datos. ID generado: " + generatedId);

            return generatedId;
        }
    }
    public int RegistrarOp(String Nombre, String Dep, String Ciudad, String Numero, String tel, String producto) throws ClassNotFoundException, SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql1 = "INSERT INTO Operaciones(Institución, Proveedor, FechaInicio, FechaFinal, Valor, Detalles) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, Nombre);
            ps.setString(2, Dep);
            ps.setString(3, Ciudad);
            ps.setString(4, Numero);
            ps.setString(5, tel);
            ps.setString(6, producto);

            int affectedRows = ps.executeUpdate();
            int generatedId = -1;

            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                }
            }

            JOptionPane.showMessageDialog(null, "Datos agregados a la base de datos. ID generado: " + generatedId);

            return generatedId;
        }
    }
}
