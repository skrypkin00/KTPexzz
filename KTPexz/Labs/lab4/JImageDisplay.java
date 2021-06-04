import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

/**
 * Этот класс позволяет нам отображать наши фракталы.
* Он происходит от javax.swing.JComponent.
 */
class JImageDisplay extends JComponent
{
    /**
* Экземпляр буферизованного изображения.
* Управляет изображением, содержимое которого мы можем записать.
*/
    private BufferedImage displayImage;
    
   /**
* Конструктор принимает целочисленные значения ширины и высоты и инициализирует
* его объект BufferedImage должен быть новым изображением с такой шириной и высотой
* типа изображения TYPE_INT_RGB.
*/
    public JImageDisplay(int width, int height) {
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        /**
* Вызовите метод setPreferredSize() родительского класса
* с заданной шириной и высотой.
*/
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);
        
    }
    /**
* Реализация суперкласса paintComponent(g) называется так, чтобы границы и
* объекты рисовались правильно. Затем изображение втягивается в компонент.
*/
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(displayImage, 0, 0, getWidth(), getHeight(), null);
    }
    /**
* Устанавливает все пиксели в данных изображения в черный цвет.
*/
    public void clearImage()
    {
        Graphics g = displayImage.getGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
    }
    /**
* Устанавливает пиксель в определенный цвет.
*/
    public void drawPixel(int x, int y, int rgbColor)
    {
        displayImage.setRGB(x, y, rgbColor);
    }
}
