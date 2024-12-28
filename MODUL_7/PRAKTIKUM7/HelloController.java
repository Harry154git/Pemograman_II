package PRAKTIKUM7;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    // Pelanggan Tabel
    @FXML private TableView<Pelanggan> tablePelanggan;
    @FXML private TableColumn<Pelanggan, Integer> colPelanggan_id;
    @FXML private TableColumn<Pelanggan, String> colPelangganNama;
    @FXML private TableColumn<Pelanggan, String> colPelangganEmail;
    @FXML private TableColumn<Pelanggan, String> colPelangganTelepon;
    @FXML private TextField pelanggan_idtextfieldid;
    @FXML private TextField namatextfieldid;
    @FXML private TextField emailtextfieldid;
    @FXML private TextField telepontextfileid;

    private ObservableList<Pelanggan> pelangganData = FXCollections.observableArrayList();

    // Buku Tabel
    @FXML private TableView<Buku> tableBuku;
    @FXML private TableColumn<Buku, Integer> colBuku_Id;
    @FXML private TableColumn<Buku, String> colJudul;
    @FXML private TableColumn<Buku, String> colPenulis;
    @FXML private TableColumn<Buku, Double> colHarga;
    @FXML private TableColumn<Buku, Integer> colStok;
    @FXML private TextField Bukuidtextfieldid;
    @FXML private TextField Judultextfieldid;
    @FXML private TextField Penulistextfieldid;
    @FXML private TextField Hargatextfieldid;
    @FXML private TextField Stoktextfieldid;

    private ObservableList<Buku> BukuData = FXCollections.observableArrayList();

    // Penjualan Tabel
    @FXML private TableView<Penjualan> tablePenjualan;
    @FXML private TableColumn<Penjualan, Integer> colPenjualanId;
    @FXML private TableColumn<Penjualan, Integer> colPenjualanJumlah;
    @FXML private TableColumn<Penjualan, Double> colPenjualanTotalharga;
    @FXML private TableColumn<Penjualan, String> colPenjualanTanggal;
    @FXML private TableColumn<Penjualan, Integer> colPenjualanPelangganId;
    @FXML private TableColumn<Penjualan, Integer> colPenjualanBukuId;
    @FXML private TextField PenjualanIdtextfieldid;
    @FXML private TextField PenjualanJumlahtextfieldid;
    @FXML private TextField PenjualanTotalhargatextfieldid;
    @FXML private TextField PenjualanTanggaltextfieldid;
    @FXML private TextField PelangganIdtextfieldid;
    @FXML private TextField BukuIdtextfieldid;

    private ObservableList<Penjualan> penjualanData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Inialisasi kolom untuk tabel Pelanggan
        colPelanggan_id.setCellValueFactory(new PropertyValueFactory<>("pelanggan_id"));
        colPelangganNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colPelangganEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPelangganTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        tablePelanggan.setItems(pelangganData);

        // Inialisasi kolom untuk tabel Buku
        colBuku_Id.setCellValueFactory(new PropertyValueFactory<>("buku_id"));
        colJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
        colPenulis.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok"));
        tableBuku.setItems(BukuData);

        // Inialisasi kolom untuk tabel Penjualan
        colPenjualanId.setCellValueFactory(new PropertyValueFactory<>("penjualan_id"));
        colPenjualanJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colPenjualanTotalharga.setCellValueFactory(new PropertyValueFactory<>("total_harga"));
        colPenjualanTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colPenjualanPelangganId.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getPenjualanPelanggan_Id()).asObject());
        colPenjualanBukuId.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getPenjualanBuku_Id()).asObject());

        tablePelanggan.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                populatePelangganFields(newValue);
            }
        });

        tableBuku.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                populateBukuFields(newValue);
            }
        });

        tablePenjualan.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                populatePenjualanFields(newValue);
            }
        });

        loadData();

    }

    private void loadData() {
        try (Connection connection = mysqlconnector.connectConnector()) {
            String query = "SELECT * FROM pelanggan";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            pelangganData = FXCollections.observableArrayList();

            while (rs.next()) {
                Pelanggan pel = new Pelanggan(
                        rs.getInt("pelanggan_id"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("telepon")
                );
                pelangganData.add(pel);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = mysqlconnector.connectConnector()) {
            String query = "SELECT * FROM buku";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            BukuData = FXCollections.observableArrayList();

            while (rs.next()) {
                Buku buk = new Buku(
                        rs.getInt("buku_id"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getDouble("harga"),
                        rs.getInt("stok")
                );
                BukuData.add(buk);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = mysqlconnector.connectConnector()) {
            String query = "SELECT * FROM penjualan";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            penjualanData = FXCollections.observableArrayList();

            while (rs.next()) {
                Penjualan pen = new Penjualan(
                        rs.getInt("penjualan_id"),
                        rs.getInt("jumlah"),
                        rs.getDouble("total_harga"),
                        rs.getString("tanggal"),
                        rs.getInt("pelanggan_id"),
                        rs.getInt("buku_id")
                );
                penjualanData.add(pen);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        tablePelanggan.setItems(pelangganData);
        tableBuku.setItems(BukuData);
        tablePenjualan.setItems(penjualanData);
    }

    // CRUD Pelanggan

    private void populatePelangganFields(Pelanggan pelanggan) {
        pelanggan_idtextfieldid.setText(String.valueOf(pelanggan.getPelanggan_id()));
        namatextfieldid.setText(pelanggan.getNama());
        emailtextfieldid.setText(pelanggan.getEmail());
        telepontextfileid.setText(pelanggan.getTelepon());
    }

    @FXML
    public void addPelanggan(ActionEvent event) {
        String pelangganIdkalimat = pelanggan_idtextfieldid.getText();
        String nama = namatextfieldid.getText();
        String email = emailtextfieldid.getText();
        String telepon = telepontextfileid.getText();

        if (!pelangganIdkalimat.matches("\\d+") || Integer.parseInt(pelangganIdkalimat) < 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan id pelanggan hanya angka dan tidak boleh negatif.");
            alert.showAndWait();
            return;
        }

        if (!nama.matches("[a-zA-Z\\s]+")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan nama hanya kalimat dan tidak boleh angka.");
            alert.showAndWait();
            return;
        }

        int pelanggan_id = Integer.parseInt(pelangganIdkalimat);

        try (Connection connection = mysqlconnector.connectConnector()) {
            String query = "INSERT INTO pelanggan (pelanggan_id, nama, email, telepon) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, pelanggan_id);
            stmt.setString(2, nama);
            stmt.setString(3, email);
            stmt.setString(4, telepon);
            stmt.executeUpdate();

            pelangganData.add(new Pelanggan(pelanggan_id, nama, email, telepon));
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "kolom berhasil ditambahkan");
            alert.showAndWait();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void editPelanggan(ActionEvent event) {
        Pelanggan selected = tablePelanggan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String pelangganIdkalimat = pelanggan_idtextfieldid.getText();
            String nama = namatextfieldid.getText();
            String email = emailtextfieldid.getText();
            String telepon = telepontextfileid.getText();

            if (!pelangganIdkalimat.matches("\\d+") || Integer.parseInt(pelangganIdkalimat) < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan id pelanggan hanya angka dan tidak boleh negatif.");
                alert.showAndWait();
                return;
            }

            if (!nama.matches("[a-zA-Z\\s]+")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan nama hanya kalimat dan tidak boleh angka.");
                alert.showAndWait();
                return;
            }

            int pelanggan_id = Integer.parseInt(pelangganIdkalimat);

            if (pelanggan_id != selected.getPelanggan_id()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "mohon pilih id yang sesuai dengan yang dipilih.");
                alert.showAndWait();
                return;
            }

            try (Connection connection = mysqlconnector.connectConnector()) {
                String query = "UPDATE pelanggan SET pelanggan_id = ?, nama = ?, email = ?, telepon = ? WHERE pelanggan_id = ?";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, pelanggan_id);
                stmt.setString(2, nama);
                stmt.setString(3, email);
                stmt.setString(4, telepon);

                stmt.executeUpdate();

                selected.setPelanggan_id(pelanggan_id);
                selected.setNama(nama);
                selected.setEmail(email);
                selected.setTelepon(telepon);
                tablePelanggan.refresh();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "kolom berhasil diedit");
                alert.showAndWait();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "mohon pilih kolom pelanggan untuk diedit.");
            alert.showAndWait();
        }
    }

    @FXML
    public void deletePelanggan(ActionEvent event) {
        Pelanggan selected = tablePelanggan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try (Connection connection = mysqlconnector.connectConnector()) {
                String check = "SELECT COUNT(*) FROM penjualan WHERE pelanggan_id = ?";
                PreparedStatement checkStmt = connection.prepareStatement(check);
                checkStmt.setInt(1, selected.getPelanggan_id());
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "error saat menghapus kolom, id_pelanggan dipakai di tabel penjualan.");
                    alert.showAndWait();
                    return;
                }

                String delete = "DELETE FROM pelanggan WHERE pelanggan_id = ?";
                PreparedStatement deleteStmt = connection.prepareStatement(delete);
                deleteStmt.setInt(1, selected.getPelanggan_id());
                deleteStmt.executeUpdate();

                pelangganData.remove(selected);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "kolom berhasil dihapus");
                alert.showAndWait();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING, "error didatabase yang menyebabkan kegagalan mehapus.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "mohon pilih kolom pelanggan untuk dihapus.");
            alert.showAndWait();
        }
    }

    // CRUD Buku

    private void populateBukuFields(Buku buku) {
        Bukuidtextfieldid.setText(String.valueOf(buku.getBuku_id()));
        Judultextfieldid.setText(buku.getJudul());
        Penulistextfieldid.setText(buku.getPenulis());
        Hargatextfieldid.setText(String.valueOf(buku.getHarga()));
        Stoktextfieldid.setText(String.valueOf(buku.getStok()));
    }

    @FXML
    public void addBuku(ActionEvent event) {
        String bukuIdkalimat = Bukuidtextfieldid.getText();
        String judul = Judultextfieldid.getText();
        String penulis = Penulistextfieldid.getText();
        String hargakalimat = Hargatextfieldid.getText();
        String stokkalimat = Stoktextfieldid.getText();

        if (!bukuIdkalimat.matches("\\d+") || Integer.parseInt(bukuIdkalimat) < 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Buku ID berupa angka dan positif.");
            alert.showAndWait();
            return;
        }

        if (!judul.matches("[a-zA-Z\\s]+")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Judul berupa huruf.");
            alert.showAndWait();
            return;
        }

        if (!penulis.matches("[a-zA-Z\\s]+")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Penulis berupa huruf.");
            alert.showAndWait();
            return;
        }

        if (!hargakalimat.matches("\\d+(\\.\\d+)?") || Double.parseDouble(hargakalimat) < 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Harga berupa angka dan positif.");
            alert.showAndWait();
            return;
        }

        if (!stokkalimat.matches("\\d+") || Integer.parseInt(stokkalimat) < 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Stok berupa angka dan positif.");
            alert.showAndWait();
            return;
        }

        int buku_id = Integer.parseInt(bukuIdkalimat);
        double harga = Double.parseDouble(hargakalimat);
        int stok = Integer.parseInt(stokkalimat);
        Buku newBuku = new Buku(buku_id, judul, penulis, harga, stok);

        try (Connection connection = mysqlconnector.connectConnector()) {
            String query = "INSERT INTO buku (buku_id, judul, penulis, harga, stok) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, buku_id);
            stmt.setString(2, judul);
            stmt.setString(3, penulis);
            stmt.setDouble(4, harga);
            stmt.setInt(5, stok);
            stmt.executeUpdate();

            BukuData.add(newBuku);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "kolom Buku berhasil ditambahkan.");
            alert.showAndWait();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Terjadi error saat menambahkan buku dari database.");
            alert.showAndWait();
        }
    }

    @FXML
    public void editBuku(ActionEvent event) {
        Buku selected = tableBuku.getSelectionModel().getSelectedItem();

        if (selected != null) {
            String bukuIdkalimat = Bukuidtextfieldid.getText();
            String judul = Judultextfieldid.getText();
            String penulis = Penulistextfieldid.getText();
            String hargakalimat = Hargatextfieldid.getText();
            String stokkalimat = Stoktextfieldid.getText();

            if (!bukuIdkalimat.matches("\\d+") || Integer.parseInt(bukuIdkalimat) < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Buku ID berupa angka dan positif.");
                alert.showAndWait();
                return;
            }

            int buku_id = Integer.parseInt(bukuIdkalimat);

            if (buku_id != selected.getBuku_id()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Buku ID yang sama dengan yang dipilih.");
                alert.showAndWait();
                return;
            }

            if (!judul.matches("[a-zA-Z\\s]+")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Judul berupa huruf.");
                alert.showAndWait();
                return;
            }

            if (!penulis.matches("[a-zA-Z\\s]+")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Penulis berupa huruf.");
                alert.showAndWait();
                return;
            }

            if (!hargakalimat.matches("\\d+(\\.\\d+)?") || Double.parseDouble(hargakalimat) < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Harga berupa angka dan positif.");
                alert.showAndWait();
                return;
            }

            if (!stokkalimat.matches("\\d+") || Integer.parseInt(stokkalimat) < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "mohon masukkan Stok berupa angka dan positif.");
                alert.showAndWait();
                return;
            }


            double harga = Double.parseDouble(hargakalimat);
            int stok = Integer.parseInt(stokkalimat);

            try (Connection connection = mysqlconnector.connectConnector()) {
                String query = "UPDATE buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, judul);
                stmt.setString(2, penulis);
                stmt.setDouble(3, harga);
                stmt.setInt(4, stok);
                stmt.setInt(5, buku_id);
                stmt.executeUpdate();

                selected.setJudul(judul);
                selected.setPenulis(penulis);
                selected.setHarga(harga);
                selected.setStok(stok);
                tableBuku.refresh();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "kolom Buku berhasil diedit.");
                alert.showAndWait();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Terjadi kesalahan saat memperbarui buku dari database.");
                alert.showAndWait();
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING, "Mohon pilih kolom buku untuk diedit.");
            alert.showAndWait();
        }
    }

    @FXML
    public void deleteBuku(ActionEvent event) {
        Buku selected = tableBuku.getSelectionModel().getSelectedItem();

        if (selected != null) {
            try (Connection connection = mysqlconnector.connectConnector()) {
                String check = "SELECT COUNT(*) FROM penjualan WHERE buku_id = ?";
                PreparedStatement checkStmt = connection.prepareStatement(check);
                checkStmt.setInt(1, selected.getBuku_id());
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Buku ini terhubung ke tabel penjualan dan tidak dapat dihapus.");
                    alert.showAndWait();
                    return;
                }

                String deleteQuery = "DELETE FROM buku WHERE buku_id = ?";
                PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
                deleteStmt.setInt(1, selected.getBuku_id());
                deleteStmt.executeUpdate();

                BukuData.remove(selected);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "kolom Buku berhasil dihapus.");
                alert.showAndWait();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Terjadi kesalahan saat menghapus buku karena data base.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Mohon pilih kolom buku untuk dihapus.");
            alert.showAndWait();
        }
    }

    // CRUD Penjualan

    private void populatePenjualanFields(Penjualan penjualan) {
        PenjualanIdtextfieldid.setText(String.valueOf(penjualan.getPenjualan_id()));
        PenjualanJumlahtextfieldid.setText(String.valueOf(penjualan.getJumlah()));
        PenjualanTotalhargatextfieldid.setText(String.valueOf(penjualan.getTotal_harga()));
        PenjualanTanggaltextfieldid.setText(penjualan.getTanggal());
        PelangganIdtextfieldid.setText(String.valueOf(penjualan.getPenjualanPelanggan_Id()));
        BukuIdtextfieldid.setText(String.valueOf(penjualan.getPenjualanBuku_Id()));
    }

    @FXML
    public void addPenjualan(ActionEvent event) {
        int penjualan_id = Integer.parseInt(PenjualanIdtextfieldid.getText());
        int jumlah = Integer.parseInt(PenjualanJumlahtextfieldid.getText());
        double totalHarga = Double.parseDouble(PenjualanTotalhargatextfieldid.getText());
        String tanggal = PenjualanTanggaltextfieldid.getText();
        int pelanggan_id = Integer.parseInt(PelangganIdtextfieldid.getText());
        int buku_id = Integer.parseInt(BukuIdtextfieldid.getText());
        Penjualan newPenjualan = new Penjualan(penjualan_id, jumlah, totalHarga, tanggal, pelanggan_id, buku_id);

        try (Connection connection = mysqlconnector.connectConnector()) {
            String query = "INSERT INTO penjualan (penjualan_id, jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, penjualan_id);
            stmt.setInt(2, jumlah);
            stmt.setDouble(3, totalHarga);
            stmt.setString(4, tanggal);
            stmt.setInt(5, pelanggan_id);
            stmt.setInt(6, buku_id);
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        penjualanData.add(newPenjualan);
    }

    @FXML
    public void editPenjualan(ActionEvent event) {
        Penjualan selected = tablePenjualan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            int penjualan_id = Integer.parseInt(PenjualanIdtextfieldid.getText());
            int jumlah = Integer.parseInt(PenjualanJumlahtextfieldid.getText());
            double totalHarga = Double.parseDouble(PenjualanTotalhargatextfieldid.getText());
            String tanggal = PenjualanTanggaltextfieldid.getText();
            int pelanggan_id = Integer.parseInt(PelangganIdtextfieldid.getText());
            int buku_id = Integer.parseInt(BukuIdtextfieldid.getText());

            try (Connection connection = mysqlconnector.connectConnector()) {
                String query = "UPDATE penjualan SET total_harga = ?, jumlah = ?, tanggal = ?, pelanggan_id = ?, buku_id = ? WHERE penjualan_id = ?";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, penjualan_id);
                stmt.setDouble(2, totalHarga);
                stmt.setInt(3, jumlah);
                stmt.setString(4, tanggal);
                stmt.setInt(5, pelanggan_id);
                stmt.setInt(6, buku_id);
                stmt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            selected.setPenjualan_id(penjualan_id);
            selected.setJumlah(jumlah);
            selected.setTotal_harga(totalHarga);
            selected.setTanggal(tanggal);
            selected.setPenjualanPelanggan_Id(pelanggan_id);
            selected.setPenjualanBuku_Id(buku_id);
            tablePenjualan.refresh();
        }
    }

    @FXML
    public void deletePenjualan(ActionEvent event) {
        Penjualan selected = tablePenjualan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try (Connection connection = mysqlconnector.connectConnector()) {
                String query = "DELETE FROM penjualan WHERE penjualan_id = ?";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, selected.getPenjualan_id());
                stmt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            penjualanData.remove(selected);
        }
    }
}