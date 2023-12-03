package biodata;

import dao.BiodataDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class BiodataButtonSimpanActionListener implements ActionListener {
    private BiodataFrame biodataFrame;
    private BiodataDao biodataDao;

    public BiodataButtonSimpanActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.biodataFrame.getName();
        String alamat = this.biodataFrame.getAlamat();
        String no_telp = this.biodataFrame.getNoTelp();
        String jenis_kelamin = this.biodataFrame.getJenisKelamin();
        if (nama.isEmpty()) {
            this.biodataFrame.showAlert("Text field tidak boleh Kosong");
        } else {
            Biodata biodata = new Biodata();
            biodata.setId(UUID.randomUUID().toString());
            biodata.setNama(nama);
            biodata.setAlamat(alamat);
            biodata.setJenis_kelamin(jenis_kelamin);
            biodata.setNo_telp(no_telp);

            this.biodataFrame.addBiodata(biodata);
            this.biodataDao.insert(biodata);
        }
    }
}
