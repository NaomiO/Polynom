package myMath;
import java.awt.Color;  
import java.util.ArrayList;
import java.util.List;
import myMath.Monom;
import myMath.Polynom;
import myMath.Polynom_able;
import myMath.cont_function;
import myMath.function;

import javax.swing.JFrame;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.ZoneGraphique;
import fr.julien.graphique.axes.AxeX;
import fr.julien.graphique.axes.AxeY;
import fr.julien.graphique.axes.OptionAxe;
import fr.julien.graphique.element.fonction.Fonction;
import fr.julien.graphique.element.forme.Polygone;
import fr.julien.graphique.element.point.Point;
import fr.julien.graphique.element.quadrillage.Quadrillage;

public class Graph_view {

	private static ArrayList<Point> pList;

	public static void main(String[] args) {

		String func = new String ("0.2*X^4+(0-1.5)*X^3+3*X^2+(0-X)+(0-5)");
		Polynom p = new Polynom ("0.2*x^4-1.5*x^3+3*x^2-1*x-5");
		System.out.println(p.toString());
		extremePoints(p,func,-2.0,6.0);

	}
	public static void extremePoints(Polynom p, String func, double x1, double x2) {
		
		pList = new ArrayList<Point>();
		Polynom p1 = new Polynom (p);
		Polynom_able der =  p1.derivative();
		double start = x1;
		double end = x2;
		double eps = 0.0001;
		while(start <= end) {
			if (der.f(start) * der.f(start + eps) <= 0) 
				pList.add(new Point(start, p1.f(start)));
			start += eps;
			}
		graph_print(func,pList,x1,x2);
		}
	
	



	public static void graph_print(String str, ArrayList<Point>pList, double x1, double x2) {
		JFrame f = new JFrame();		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OptionAxe optionsAxes = new OptionAxe(Color.BLACK, true, -1, 1, true, true);
		Graphique.getInstance().initGraphique(new AxeX(-4, 8, optionsAxes), new AxeY(-7, 10, optionsAxes));
//		Graphique.getInstance().ajouterElement(new Point('A', 2, 2));// crer un point 
		Graphique.getInstance().ajouterElement(new Fonction((str)));
		char a = 'a';
		
		for (int i = 0 ; i < pList.size(); i++, a++) {
			
			Graphique.getInstance().ajouterElement(new Point(a, pList.get(i).getAbscisse(),pList.get(i).getOrdonnee()));
		}
		List<Point> points = new ArrayList<Point>();
		
		Graphique.getInstance().ajouterElement(new Polygone(points));
		Graphique.getInstance().ajouterElement(new Quadrillage(0.5, 0.5));
		f.add(new ZoneGraphique());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}


}  

