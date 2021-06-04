import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO.*;
import java.awt.image.*;

/**
* Этот класс позволяет исследовать различные части фрактала с помощью
* создание и отображение графического интерфейса Swing и обработка событий, вызванных различными
* взаимодействие с пользователями.
*/
public class FractalExplorer
{
    /** Целочисленный размер дисплея-это ширина и высота дисплея в пикселях. **/
    private int displaySize;
    
    /**
* Ссылка JImageDisplay для обновления отображения из различных методов, как
* вычисляется фрактал.
*/
    private JImageDisplay display;
    
    /**
* Объект FractalGenerator, использующий ссылку на базовый класс для отображения
* другие типы фракталов в будущем.
*/
    private FractalGenerator fractal;
    
    /**
* Объект Rectangle2D.Double, который определяет диапазон комплекса
* то, что мы сейчас показываем.
*/
    private Rectangle2D.Double range;
    
    /**
* Конструктор, который принимает размер отображения, сохраняет его и
* инициализирует объекты диапазона и фрактального генератора.
*/
    public FractalExplorer(int size) {
        /** Хранит размер дисплея **/
        displaySize = size;
        
        /** Инициализирует фрактал-генератор и объекты диапазона. **/
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);
    
    }
    /**
* Этот метод инициализирует графический интерфейс Swing с помощью JFrame, содержащего объект
* JImageDisplay и кнопку для сброса дисплея.
*/
    public void createAndShowGUI()
    {
        /** Установите фрейм для использования java.awt.BorderLayout для его содержимого. **/
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal Explorer");
        
        /**
* Добавьте объект отображения изображения в BorderLayout.ЦЕНТР
* положение.
*/
        frame.add(display, BorderLayout.CENTER);
        
        /** Создайте кнопку сброса. */
        JButton resetButton = new JButton("Reset");
        
        /** Экземпляр ResetHandler на кнопке reset. */
        ButtonHandler handler = new ButtonHandler();
        resetButton.addActionListener(handler);
        
        /** Добавьте кнопку сброса в BorderLayout.SOUTH позиция. */
        frame.add(resetButton, BorderLayout.SOUTH);
        
        /** Экземпляр MouseHandler на компоненте fractal-display. */
        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);
        
        /** Установите операцию закрытия кадра по умолчанию в положение "выход". */
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /** Создайте combobox. */
        JComboBox comboBox = new JComboBox();
        
        /** Добавление элементов в combobox */
        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new BurningShip());
        
        /** Экземпляр FractalHandler на кнопке reset. */
        ButtonHandler fractalChooser = new ButtonHandler();
        comboBox.addActionListener(fractalChooser);
        
        /** Создать панель для размещения компонентов верхней панели */
        JPanel topPanel = new JPanel();
        JLabel label = new JLabel("Fractal:");
        topPanel.add(label);
        topPanel.add(comboBox);
        frame.add(topPanel, BorderLayout.NORTH);
        
        /** Создать панель для размещения компонентов верхней панели */

        JButton saveButton = new JButton("Save");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(saveButton);
        bottomPanel.add(resetButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        /** Экземпляр SaveHandler на кнопке reset. */
        ButtonHandler saveHandler = new ButtonHandler();
        saveButton.addActionListener(saveHandler);

        /**
* Выложите содержимое фрейма, сделайте его видимым и
* запретите изменение размера окна.
*/
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    /**
* Частный вспомогательный метод отображения фрактала. Этот метод зацикливается
* через каждый пиксель на дисплее и вычисляет количество
* итераций для соответствующих координат во фрактале
* область отображения. Если число итераций равно -1, установите цвет пикселя
* к черному. В противном случае выберите значение, основанное на количестве итераций.
* Обновите дисплей цветом для каждого пикселя и перекрасьте его.
* JImageDisplay, когда все пиксели были нарисованы.
*/
    private void drawFractal()
    {
        /** Цикл через каждый пиксель на дисплее */
        for (int x=0; x<displaySize; x++){
            for (int y=0; y<displaySize; y++){
                
                /**
* Найти соответствующие координаты xCoord и yCoord
* в области отображения фрактала.
*/
                double xCoord = fractal.getCoord(
                    range.x, range.x + range.width, displaySize, x);
                double yCoord = fractal.getCoord(
                    range.y, range.y + range.height, displaySize, y);
                
                /**
* Вычислите количество итераций для координат в области
отображения фрактала.
*/
                int iteration = fractal.numIterations(xCoord, yCoord);
                
                /** Если число итераций равно -1, установите пиксель черным. */
                if (iteration == -1) {
                    display.drawPixel(x, y, 0);
                }
                else {
                    /**
* В противном случае выберите значение оттенка на основе числа
* итераций.
*/
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                
                    /** Обновите дисплей цветом для каждого пикселя. */
                    display.drawPixel(x, y, rgbColor);
                }
                
            }
        }
        /**
         * Когда все пиксели будут нарисованы, перекрасьте JImageDisplay в соответствующий цвет.
* текущее содержание его изображения.
*/ 
         
        display.repaint();
    }
    /**
* Внутренний класс для обработки событий ActionListener с помощью кнопок.
*/
     private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (e.getSource() instanceof JComboBox) {
                JComboBox mySource = (JComboBox) e.getSource();
                fractal = (FractalGenerator) mySource.getSelectedItem();
                fractal.getInitialRange(range);
                drawFractal();
            }

            else if (command.equals("Reset")) {
                fractal.getInitialRange(range);
                drawFractal();
            }

            else if (command.equals("Save")) {
                
                JFileChooser myFileChooser = new JFileChooser();
                FileFilter extensionFilter = new FileNameExtensionFilter(
                    "PNG Images", "png");
                
                myFileChooser.setFileFilter(extensionFilter);
                myFileChooser.setAcceptAllFileFilterUsed(false);

                int userSelection = myFileChooser.showSaveDialog(display);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    java.io.File file = myFileChooser.getSelectedFile();
                    String file_name = file.toString();

                    try {
                        BufferedImage displayImage = display.getImage();
                        javax.imageio.ImageIO.write(displayImage, "png", file);
                    }

                    catch (Exception exception) {
                        JOptionPane.showMessageDialog(
                            display, exception.getMessage(),
                            "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    private class ResetHandler implements ActionListener
    {
        /**
* Обработчик сбрасывает диапазон до начального диапазона, заданного генератором
*, а затем рисует фрактал.
*/
        public void actionPerformed(ActionEvent e)
        {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }
    /**
* Внутренний класс для обработки событий MouseListener с дисплея.
*/
    private class MouseHandler extends MouseAdapter
    {
        /**
* Когда обработчик получает событие щелчка мыши, он отображает пиксельные координаты
щелчка в область фрактала, который обрабатывается.
* отображается, а затем вызывает recenterAndZoomRange генератора()
* метод с координатами, которые были нажаты, и шкалой 0,5.
*/
        @Override
        public void mouseClicked(MouseEvent e)
        {
            /** Get x coordinate of display area of mouse click. */
            int x = e.getX();
            double xCoord = fractal.getCoord(
                range.x, range.x + range.width, displaySize, x);
            
            /** Get y coordinate of display area of mouse click. */
            int y = e.getY();
            double yCoord = fractal.getCoord(
                range.y, range.y + range.height, displaySize, y);
            
            /**
* * Вызовите метод recenter и Zoom Range() генератора с помощью
* координаты, которые были нажаты, и масштаб 0,5.
*/
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            
            /**
* Перерисуйте фрактал после
изменения отображаемой области.
*/
            drawFractal();
        }
    }
    
    /**
* Статический метод main() для запуска FractalExplorer. Инициализирует новый
* * Экземпляр Fractal Explorer с размером дисплея 600, вызовы
* createAndShowGUI() на объекте explorer, а затем вызывает
* drawFractal() в проводнике, чтобы увидеть начальный вид.
*/
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}
