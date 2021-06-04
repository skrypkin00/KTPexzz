public class Point3d extends Point2d{
	private double c;
	// Конструктор инициализации
	Point3d(double a, double b, double c){
		super(a, b); //для получения доступа к координатам
		this.c=c;
	}
	// Конструктор по умолчанию
	Point3d(){
		this(0.0, 0.0, 0.0);
	}
	// Вывод c
	public double getc(){
		return c;
	}
	//сравнение двух объектов
	public boolean sravn(Point3d o){
		return ((this.getX()==o.getX()) && (this.getY()==o.getY()) && (this.c==o.c)) ? true:false;
	}
	//вычисление расстояния между точками а и b
	public double distanceTo(Point3d o){
		return Math.ceil(Math.sqrt(Math.pow((o.getX()-this.getX()), 2)+Math.pow((o.getY()-this.getY()), 2)+Math.pow((o.c-this.c), 2))*100)/100;
	}
	//ввод c
	public void setc(double c)
	{
		this.c=c;
	}
}
