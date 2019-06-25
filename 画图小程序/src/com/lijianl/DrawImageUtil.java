package com.lijianl;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class DrawImageUtil {
    public DrawImageUtil() {
    }

    public static void saveImage(JFrame frame, BufferedImage saveImage) {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("保存图片");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", new String[]{"jpg"});
        jfc.setFileFilter(filter);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
        String fileName = sdf.format(new Date());
        FileSystemView view = FileSystemView.getFileSystemView();
        File filePath = view.getHomeDirectory();
        File saveFile = new File(filePath, fileName + ".jpg");
        jfc.setSelectedFile(saveFile);
        int flag = jfc.showSaveDialog((Component)null);
        if (flag == 0) {
            try {
                ImageIO.write(saveImage, "jpg", saveFile);
            } catch (IOException var11) {
                var11.printStackTrace();
                JOptionPane.showMessageDialog(frame, "文件无法保存！", "错误", 64);
            }
        }

    }
}
