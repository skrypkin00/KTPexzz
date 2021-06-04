import java.awt.geom.Rectangle2D;
public class Mendelbrot extends FractalGenerator{
    public static final int M_IT = 2000;
    public void getInitialRange(Rectangle2D.Double range){
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    public int numIterations(double x, double y){
        int it=0;
        double zreal = 0;
        double zim = 0;
        while (it < M_IT && zreal*zreal+zim*zim < 4){
            double zrealNew = zreal * zreal - zim * zim +x;
            double zimNew = 2 * zreal * zim + y;
            zreal = zrealNew;
            zim = zimNew;
            it+=1;
        }
        if (it == M_IT)
            return -1;
        return it;
    }
}
