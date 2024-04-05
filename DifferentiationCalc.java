import java.util.ArrayList;
import java.util.Scanner;

public class DifferentiationCalc {
	
    public static void main(String[] args) {
        
    	try {
    		
			//Initialisation
			Scanner scanner = new Scanner(System.in);
			char[] eq = scanner.nextLine().replaceAll(" ", "").toCharArray();
			scanner.close();
			ArrayList<String> components = new ArrayList<String>();
			ArrayList<Integer> coefficients = new ArrayList<Integer>();
			ArrayList<Integer> exponents = new ArrayList<Integer>();
			String newEq = "";
			
			//Splitting into components
			String comp = "";
			for (char i : eq) {
				
				if (i == '+') {
					
					components.add(comp);
					comp = "";
					
				} else if (i == '-') {
					
					components.add(comp);
					comp = "-";
					
				} else {
					
					comp = comp + i;
					
				}
				
			}
			components.add(comp);
			if (components.get(0).isEmpty()) {components.remove(0);}
			
			//Splitting into coefficients and exponents
			for (String i : components) {
				
				if (!i.contains("x")) {
					
					coefficients.add(Integer.parseInt(i));
					exponents.add(0);
					
				} else if (!i.contains("^")) {
					
					coefficients.add(Integer.parseInt(i.substring(0, i.length() - 1)));
					exponents.add(1);
					
				} else {

					coefficients.add(Integer.parseInt(i.split("x")[0]));
					exponents.add(Integer.parseInt(i.split("x")[1].substring(1)));
					
				}
				
			}
			
			//Differentiation
			for (int i = 0; i < components.size(); i++) {
				
				coefficients.set(i, coefficients.get(i) * exponents.get(i));
				exponents.set(i, exponents.get(i) - 1);
				
			}
			
			//Printing
			for (int i = 0; i < coefficients.size(); i++) {
				
				//Adding '+' sign
				String newNum;
				if (coefficients.get(i) > 0) {
					
					newNum = "+" + coefficients.get(i);
					
				} else {
					
					newNum = coefficients.get(i) + "";
					
				}
				
				//Adding
				if (coefficients.get(i) == 0) {} else if (exponents.get(i) == 0) {
					
					newEq += newNum;
					
				} else if (exponents.get(i) == 1) {
					
					newEq += newNum + "x";
					
				} else {
					
					newEq += newNum + "x^" + exponents.get(i);
					
				}
				
			}
			System.out.println(newEq);
			
		} catch (Exception e) {
			
			System.out.println("Invalid equation format");
			
		}
    	
    }

}
