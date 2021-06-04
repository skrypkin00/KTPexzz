import java.awt.geom.Rectangle2D;

/**
* Этот класс является подклассом FractalGenerator. Он используется для вычисления
* Фрактал Мандельброта.
*/

public class Mandelbrot extends FractalGenerator
{
    /**
* Константа для числа максимальных итераций.
*/
    public static final int MAX_ITERATIONS = 2000;
    
    /**
* Этот метод позволяет фрактальному генератору указать, какая часть
* комплексная плоскость является наиболее интересной для фрактала.
* Ему передается объект rectangle, и метод изменяет поля
* rectangle, чтобы показать правильный начальный диапазон для фрактала.
* Эта реализация устанавливает начальный диапазон в (-2 - 1.5 i) - (1 + 1.5 i)
* или x=-2, y=-1,5, ширина=высота=3.
*/
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    
    /**
* Этот метод реализует итерационную функцию для фрактала Мандельброта.
* Требуется два двойника для действительной и мнимой частей комплекса
* плоскость и возвращает количество итераций для соответствующего
* координация.
*/
    public int numIterations(double x, double y)
    {
        /** Начните с итераций в 0. */
        int iteration = 0;
        /** Инициализируйте zreal и zimaginary. */
        double zreal = 0;
        double zimaginary = 0;
        
        /**
* Вычислить Zn = Zn-1^2 + c, где значения представляют собой комплексные числа.
* по zreal и zimaginary, Z0=0, и c-это конкретная точка в
* фрактале, который мы показываем (задается x и y). Он повторяется
* до тех пор, пока Z^2 > 4 (абсолютное значение Z больше 2) или максимум
* достигнуто количество итераций.
*/
        while (iteration < MAX_ITERATIONS &&
               zreal * zreal + zimaginary * zimaginary < 4)
        {
            double zrealUpdated = zreal * zreal - zimaginary * zimaginary + x;
            double zimaginaryUpdated = 2 * zreal * zimaginary + y;
            zreal = zrealUpdated;
            zimaginary = zimaginaryUpdated;
            iteration += 1;
        }
        
        /**
* Если достигнуто максимальное число итераций, верните значение -1 в
* укажите, что точка не вышла за пределы границы.
*/
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }
        
        return iteration;
    }

    /**
* Возвращает имя фрактала
*/
    public String toString() {
        return "Mandelbrot";
    }
}
