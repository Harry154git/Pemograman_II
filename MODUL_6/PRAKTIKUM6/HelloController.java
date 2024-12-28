package PRAKTIKUM6;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HelloController {
    @FXML
    private TableView<Mahasiswa> tableView;
    @FXML
    private TableColumn<Mahasiswa, String> nimid;
    @FXML
    private TableColumn<Mahasiswa, String> namaid;

    private ObservableList<Mahasiswa> mahasiswaList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        initMahasiswaData();
        nimid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNim()));
        namaid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNama()));

        tableView.setItems(mahasiswaList);
    }

    private void initMahasiswaData() {

        Mahasiswa m1 = new Mahasiswa();
        m1.setId(1);
        m1.setNama("Johnson");
        m1.setNim("123");
        mahasiswaList.add(m1);

        Mahasiswa m2 = new Mahasiswa();
        m2.setId(2);
        m2.setNama("marry Jane");
        m2.setNim("12456");
        mahasiswaList.add(m2);

        Mahasiswa m3 = new Mahasiswa();
        m3.setId(3);
        m3.setNama("Agus salim");
        m3.setNim("125345");
        mahasiswaList.add(m3);

        Mahasiswa m4 = new Mahasiswa();
        m4.setId(4);
        m4.setNama("laura");
        m4.setNim("1265864");
        mahasiswaList.add(m4);

        Mahasiswa m5 = new Mahasiswa();
        m5.setId(5);
        m5.setNama("Budiono");
        m5.setNim("127346");
        mahasiswaList.add(m5);

        Mahasiswa m6 = new Mahasiswa();
        m6.setId(6);
        m6.setNama("Dinda");
        m6.setNim("1283463");
        mahasiswaList.add(m6);

        Mahasiswa m7 = new Mahasiswa();
        m7.setId(7);
        m7.setNama("Rara");
        m7.setNim("12973563");
        mahasiswaList.add(m7);

        Mahasiswa m8 = new Mahasiswa();
        m8.setId(8);
        m8.setNama("Yas");
        m8.setNim("1302352");
        mahasiswaList.add(m8);

        Mahasiswa m9 = new Mahasiswa();
        m9.setId(9);
        m9.setNama("Joko");
        m9.setNim("13112512");
        mahasiswaList.add(m9);

        Mahasiswa m10 = new Mahasiswa();
        m10.setId(10);
        m10.setNama("Andre");
        m10.setNim("132124");
        mahasiswaList.add(m10);
    }
}