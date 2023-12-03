package biodata;

import dao.BiodataDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BiodataButtonHapusActionListener implements ActionListener {
    private BiodataFrame biodataFrame;
    private BiodataDao biodataDao;
    private List<Biodata> data;

    public BiodataButtonHapusActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = this.biodataFrame.getTable();
        int selected = table.getSelectedRow();
        String nama = (String) table.getValueAt(selected,0);
        Biodata biodata = this.biodataDao.findByName(nama);
        this.biodataFrame.removeData(selected);
        this.biodataDao.delete(biodata);
    }
}
