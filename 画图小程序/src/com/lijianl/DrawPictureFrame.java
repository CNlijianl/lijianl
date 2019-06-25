package com.lijianl;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class DrawPictureFrame extends JFrame implements FrameGetShape {

    BufferedImage image = new BufferedImage(570, 390, BufferedImage.TYPE_INT_BGR);
    Graphics gs = image.getGraphics();
    Graphics2D g = (Graphics2D) gs;
    DrawPictureCanvas canvas = new DrawPictureCanvas();
    Color foreColor = Color.BLACK;
    Color backgroundColor = Color.WHITE;

    private JToolBar toolBar;
    private JButton eraserButton;
    private JToggleButton strokeButton1;
    private JToggleButton strokeButton2;
    private JToggleButton strokeButton3;
    private JButton backgroundButton;
    private JButton foregroundButton;
    private JButton clearButton;
    private JButton saveButton;
    private JButton shapeButton;

    int x = -1;
    int y = -1;
    boolean rubber = false;

    boolean drawShape = false;
    Shapes shape;

    private JMenuItem strokeMenuItem1;
    private JMenuItem strokeMenuItem2;
    private JMenuItem strokeMenuItem3;
    private JMenuItem clearMenuItem;
    private JMenuItem foregroundMenuItem;
    private JMenuItem backgroundMenuItem;
    private JMenuItem eraserMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem savaMenuItem;

    private String shuiyin = "";
    private JMenuItem shuiyinMenuItem;

    public DrawPictureFrame() {
        setResizable(false);
        setTitle("画图小程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int x = Toolkit.getDefaultToolkit().getScreenSize().width;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height;
        setBounds((x - 574) / 2, (y - 460) / 2, 574, 460);


        init();
        addListener();

    }

    private void addListener() {
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (x > 0 && y > 0) {
                    if (rubber) {
                        g.setColor(backgroundColor);
                        g.fillRect(x, y, 10, 10);
                    } else {
                        g.drawLine(x, y, e.getX(), e.getY());
                    }
                }
                x = e.getX();
                y = e.getY();
                canvas.repaint();

            }

        });
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                x = -1;
                y = -1;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (drawShape) {
                    switch (shape.getType()) {
                        case Shapes.YUAN:
                            int yuanX = e.getX() - shape.getWidth() / 2;
                            int yuanY = e.getY() - shape.getHeigth() / 2;
                            Ellipse2D yuan = new Ellipse2D.Double(yuanX, yuanY, shape.getWidth(), shape.getHeigth());
                            g.draw(yuan);
                            break;
                        case Shapes.FANG:
                            int fangX = e.getX()-shape.getWidth()/2;
                            int fangY = e.getY()-shape.getHeigth()/2;
                            Rectangle2D fang = new Rectangle2D.Double(fangX,fangY,shape.getWidth(),shape.getHeigth());
                            g.draw(fang);
                            break;
                    }
                    canvas.repaint();
                }

            }
        });

        strokeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasicStroke basicStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
                g.setStroke(basicStroke);
            }
        });
        strokeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasicStroke basicStroke = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
                g.setStroke(basicStroke);
            }
        });
        strokeButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasicStroke basicStroke = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
                g.setStroke(basicStroke);
            }
        });
        backgroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color bgcolor = JColorChooser.showDialog(DrawPictureFrame.this, "选择颜色对话框", Color.CYAN);
                if (bgcolor != null) {
                    backgroundColor = bgcolor;
                }
                backgroundButton.setBackground(backgroundColor);
                g.setColor(backgroundColor);
                g.fillRect(0, 0, 570, 390);
                g.setColor(foreColor);
                canvas.repaint();
            }
        });
        foregroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color frcolor = JColorChooser.showDialog(DrawPictureFrame.this, "选择颜色对话框", Color.CYAN);
                if (frcolor != null) {
                    foreColor = frcolor;
                }
                foregroundButton.setBackground(foreColor);
                g.setColor(foreColor);

            }
        });
        eraserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (eraserButton.getText().equals("橡皮")) {
                    rubber = true;
                    eraserButton.setText("画图");
                } else {
                    rubber = false;
                    eraserButton.setText("橡皮");
                    g.setColor(foreColor);
                }

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setColor(backgroundColor);
                g.fillRect(0, 0, 570, 390);
                g.setColor(foreColor);
                canvas.repaint();

            }
        });
        shapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeWindow shapeWindow = new ShapeWindow(DrawPictureFrame.this);
                int shapeButtonWidth = shapeButton.getWidth();
                int shapeWindowWidth = shapeWindow.getWidth();
                int shapeButtonX = shapeButton.getX();
                int shapeButtonY = shapeButton.getY();

                int shapeWindowX = getX() + shapeButtonX - (shapeWindowWidth - shapeButtonWidth) / 2;
                int shapeWindowY = getY() + shapeButtonY + 80;
                shapeWindow.setLocation(shapeWindowX, shapeWindowY);
                shapeWindow.setVisible(true);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWatermark();
                DrawImageUtil.saveImage(DrawPictureFrame.this,image);

            }
        });
        shuiyinMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shuiyin = JOptionPane.showInputDialog(DrawPictureFrame.this,"你想添加什么水印");
            }
        });

    }

    private void addWatermark(){
        if(!"".equals(shuiyin.trim())){
            g.rotate(Math.toRadians(-30));
            Font font = new Font("楷体",Font.BOLD,72);
            g.setFont(font);
            g.setColor(Color.GRAY);
            AlphaComposite alphaComposite = AlphaComposite.SrcOver.derive(0.4f);
            g.setComposite(alphaComposite);
            g.drawString(shuiyin,150,500);
            canvas.repaint();
            g.rotate(Math.toRadians(30));
            alphaComposite = AlphaComposite.SrcOver.derive(1f);
            g.setComposite(alphaComposite);
            g.setColor(foreColor);
        }
    }

    private void init() {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, 570, 390);
        g.setColor(foreColor);
        canvas.setImage(image);
        getContentPane().add(canvas);

        toolBar = new JToolBar();
        getContentPane().add(toolBar, BorderLayout.NORTH);

        saveButton = new JButton("保存");
        toolBar.add(saveButton);
        toolBar.addSeparator();

        strokeButton1 = new JToggleButton("细线");
        strokeButton1.setSelected(true);
        toolBar.add(strokeButton1);

        strokeButton2 = new JToggleButton("粗线");
        toolBar.add(strokeButton2);

        strokeButton3 = new JToggleButton("较粗");
        toolBar.add(strokeButton3);

        ButtonGroup strokeGroup = new ButtonGroup();
        strokeGroup.add(strokeButton1);
        strokeGroup.add(strokeButton2);
        strokeGroup.add(strokeButton3);
        toolBar.addSeparator();

        backgroundButton = new JButton("背景颜色");
        toolBar.add(backgroundButton);
        foregroundButton = new JButton("前景颜色");
        toolBar.add(foregroundButton);
        shapeButton = new JButton("图形");
        toolBar.add(shapeButton);
        clearButton = new JButton("清除");
        toolBar.add(clearButton);
        eraserButton = new JButton("橡皮");
        toolBar.add(eraserButton);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu systemMenu = new JMenu("系统");
        menuBar.add(systemMenu);
        shuiyinMenuItem = new JMenuItem("水印");
        systemMenu.add(shuiyinMenuItem);

        savaMenuItem = new JMenuItem("保存");
        systemMenu.add(savaMenuItem);
        systemMenu.addSeparator();
        exitMenuItem = new JMenuItem("退出");
        systemMenu.add(exitMenuItem);

        JMenu strokeMenu = new JMenu("线型");
        menuBar.add(strokeMenu);
        strokeMenuItem1 = new JMenuItem("细线");
        strokeMenu.add(strokeMenuItem1);
        strokeMenuItem2 = new JMenuItem("粗线");
        strokeMenu.add(strokeMenuItem2);
        strokeMenuItem3 = new JMenuItem("较粗");
        strokeMenu.add(strokeMenuItem3);

        JMenu colorMenu = new JMenu("颜色");
        menuBar.add(colorMenu);
        foregroundMenuItem = new JMenuItem("前景色");
        colorMenu.add(foregroundMenuItem);
        backgroundMenuItem = new JMenuItem("背景色");
        colorMenu.add(backgroundMenuItem);

        JMenu editMenu = new JMenu("编辑");
        menuBar.add(editMenu);
        clearMenuItem = new JMenuItem("清除");
        editMenu.add(clearMenuItem);
        eraserMenuItem = new JMenuItem("橡皮");
        editMenu.add(eraserMenuItem);



    }

    public static void main(String[] args) {
        DrawPictureFrame frame = new DrawPictureFrame();
        frame.setVisible(true);

    }

    @Override
    public void getShape(Shapes shapes) {
        this.shape = shapes;
        drawShape = true;
    }
}
