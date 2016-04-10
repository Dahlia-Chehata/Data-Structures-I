package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import java.awt.Point;
import java.util.Comparator;
import java.util.Arrays;

     class myComparator implements Comparator<Point> {

    		@Override
    		public int compare(Point o1, Point o2) {
    			// TODO Auto-generated method stub
    			
    			
    			
    			return o2.y-o1.y;
    			
    			
    		}
     }
public class Polynomial_Solver implements IPolynomialSolver {
     
	Singly_linkedlists A ;
	Singly_linkedlists B ;
	Singly_linkedlists C;
	Singly_linkedlists R =new Singly_linkedlists();
     Point[] array;
    
     
    	
	@Override
	public void setPolynomial(char poly, int[][] terms) throws RuntimeException {
		// TODO Auto-generated method stub
		
		Singly_linkedlists the_list= new Singly_linkedlists();
		
		array=new Point [terms.length];
		
		for (int i=0;i<terms.length;i++){
		   if (terms[i][1]<0)
			   throw new RuntimeException();
		
			array[i]=new Point (terms[i][0],terms[i][1]);
				
		}
		myComparator c = new myComparator();
         Arrays.sort(array,0,array.length,c);
		
	    for (int i=0;i<array.length;i++){
		      SLNode temp=new SLNode(array[i].x,array[i].y) ;
	    	  the_list.add(temp);
	    }
	    
	    switch (poly){
		case'A': A=the_list;break;
		case'B': B=the_list;break;
		case'C': C=the_list;break;
		default :throw new RuntimeException();
		}
	    
	}

	@Override
	public String print(char poly) {
		// TODO Auto-generated method stub
		
		String message = new String();
        
		switch (poly) {
        case 'A':
            if (A.isEmpty())
                return null;  //throw exception
            for (int i = 0; i < A.size(); i++) {
            	 
                if (A.get(i).equals(1))
                    message += "+";
                else if (A.get(i).equals(-1))
                    message += "-";
                else
                    message += A.get(i);
                if (!A.get_exp(i).equals(0)) {
                    if (A.get_exp(i).equals(1))
                        message += "x";
                    else
                        message += "x^" + A.get_exp(i);
                }
            }
            break;
        case 'B':
            if (B.isEmpty())
                return null;
            for (int i = 0; i < B.size(); i++) {
                if (B.get(i).equals(1))
                    message += "+";
                else if (B.get(i).equals(-1))
                    message += "-";
                else
                    message += B.get(i);
                if (!B.get_exp(i).equals(0)) {
                    if (B.get_exp(i).equals(1))
                        message += "x";
                    else
                        message += "x^" + B.get_exp(i);
                }
            }
            break;
        case 'C':
            if (C.isEmpty())
                return null;
            for (int i = 0; i < C.size(); i++) {
                if (C.get(i).equals(1))
                    message += "+";
                else if (C.get(i).equals(-1))
                    message += "-";
                else
                    message += C.get(i);
                if (!C.get_exp(i).equals(0)) {
                    if (C.get_exp(i).equals(1))
                        message += "x";
                    else
                        message += "x^" + C.get_exp(i);
                }
            }
            break;
        case 'R':
            if (R.isEmpty())
               return null;
            for (int i = 0; i < R.size(); i++) {
                if (R.get(i).equals(1))
                    message += "+";
                else if (R.get(i).equals(-1))
                    message += "-";
                else
                    message += R.get(i);
                if (!R.get_exp(i).equals(0)) {
                    if (R.get_exp(i).equals(1))
                        message += "x";
                    else
                        message += "x^" + R.get_exp(i);
                }
            }
            break;
 
        
		default:throw new RuntimeException();
		}
        return message;
		
	}

	@Override
	public void clearPolynomial(char poly) {
		// TODO Auto-generated method stub
		 switch (poly) {
	        case 'A': A.clear();break;
	        case 'B': B.clear();break;
	        case 'C': C.clear(); break;
	        case 'R': R.clear();break;
	       
	        default:
	            throw new RuntimeException("invalid input or operation");
	 
	        }
	}

	@Override
	public float evaluatePolynomial(char poly, float value) throws RuntimeException {
		// TODO Auto-generated method stub
		
		float result = 0;
        switch (poly) {
        case 'A':
        	if (!A.isEmpty())
            {for (int i = 0; i < A.size; i++) {
            	Point point = new Point((int) A.get(i),(int) A.get_exp(i));
                result += point.getX() * Math.pow(value, point.getY());
            }}
        	else 
        		throw new RuntimeException ();
            break;
        case 'B':
        	if (!B.isEmpty()){
            for (int i = 0; i < B.size(); i++) {
                Point point = new Point((int) B.get(i),(int) B.get_exp(i));
                result += point.getX() * Math.pow(value, point.getY());
            }}
            
            else 
        		throw new RuntimeException ();

            	break;
        case 'C':
        	if (!C.isEmpty()){
            for (int i = 0; i < C.size(); i++) {
            	Point point = new Point((int) C.get(i),(int) C.get_exp(i));
                result += point.getX() * Math.pow(value, point.getY());
            }}
        	else 
        		throw new RuntimeException ();
            break;
        default:
            throw new RuntimeException("invalid input or operation");
        }
 
        return result;
		
	}
	public int [][] determine_polyadd(char poly1, char poly2){
		 int arr[][];
		
		 clearPolynomial('R');
	        if (poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A') {
	            int a = 0;
	            int b = 0;
	            
	            boolean finishedA = false;
	            boolean finishedB = false;
	 
	            while (!finishedA && !finishedB) {
	                if ((int) A.get_exp(a) > (int) A.get_exp(b)) {
	                    
	                	R.addexp(A.get_exp(a));
	                    R.add(A.get(a));
	                    a++;
	                } else if ((int) A.get_exp(a) < (int) A.get_exp(b)) {
	                    R.addexp(B.get_exp(b));
	                    R.add(B.get(b));
	                    b++;
	                } else {
	                    R.addexp(A.get_exp(a));
	                    R.add((double) A.get(a) + (double) B.get(b));
	                    a++;
	                    b++;
	                }
	                if (a == A.size()) 
	                	finishedA = true;
	                
	                if (b == B.size()) 
	                    finishedB = true;
	                
	            }
	            
	            
	            
	            if (finishedA) {
	                for (int i = b; i < B.size(); i++) {
	                    R.addexp(B.get_exp(i));
	                    R.add(B.get(i));
	                }
	            } else {
	                for (int i = a; i < A.size(); i++) {
	                    R.addexp(A.get_exp(i));
	                    R.add(A.get(i));
	                }
	            }
	            arr = new int[R.size()][2];
	            for (int i = 0; i < R.size(); i++) {
	                arr[i][0] = (int) R.get(i);
	                arr[i][1] = (int) R.get_exp(i);
	            }
	            return arr;
	        }
	 
	        if (poly1 == 'A' && poly2 == 'A' ) {
	            int a = 0;
	            boolean finishedA = false;
	            while (!finishedA) {
	                R.addexp(A.get_exp(a));
	                R.add((double) A.get(a) * 2);
	                a++;
	                
	                if (a==A.size)
	                	finishedA=true;
	            }
	 
	                 arr = new int[R.size()][2];
	                for (int i = 0; i < R.size(); i++) {
	                    arr[i][0] = (int) R.get(i);
	                    arr[i][1] = (int) R.get_exp(i);
	                }
	                return arr;
	              
	            }
	            if (poly1 == 'B' && poly2 == 'B' ) {
		            int b = 0;
		            boolean finishedB = false;
		            while (!finishedB) {
		                R.addexp(B.get_exp(b));
		                R.add((double) B.get(b) * 2);
		                b++;
		                if (b==B.size)
		                	finishedB=true;
		            }
		 
		                 arr = new int[R.size()][2];
		                for (int i = 0; i < R.size(); i++) {
		                    arr[i][0] = (int) R.get(i);
		                    arr[i][1] = (int) R.get_exp(i);
		                }
		                return arr;
		            }
	           return null;
	            
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		int [][]add;
		 if (poly1=='A'&&poly2=='B'||poly1=='B'&&poly2=='A')
	        add=determine_polyadd('A','B');
		 else if (poly1=='A'&&poly2=='C'||poly1=='C'&&poly2=='A')
		        add=determine_polyadd('A','C');
		 else if (poly1=='B'&&poly2=='C'||poly1=='C'&&poly2=='B')
		        add=determine_polyadd('B','C');
		 else if (poly1=='A'&&poly2=='A')
			 add=determine_polyadd('A','A');
		 else if(poly1=='B'&&poly2=='B')
			 add=determine_polyadd('B','B');
		 else if(poly1=='C'&&poly2=='C')
			 add=determine_polyadd('C','C');
		 else
			 throw new RuntimeException("invalid input or operationbbbbb");
		 
		return add;
		
		
	}
	public int [][] determine_polysub(char poly1, char poly2){
		int[][] arr;
		
		clearPolynomial('R');
        if (poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A') {
            int a = 0;
            int b = 0;
            boolean finishedA = false;
            boolean finishedB = false;
            while (!finishedA && !finishedB) {
                if ((int) A.get_exp(a) > (int) A.get_exp(b)) {
                    R.addexp(A.get_exp(a));
                    R.add(A.get(a));
                    a++;
                } else if ((int) A.get_exp(a) < (int) A.get_exp(b)) {
                    R.addexp(B.get_exp(b));
                    R.add(B.get(b));
                    b++;
                } else {
                    R.addexp(A.get_exp(a));
                    R.add((double) A.get(a) - (double) B.get(b));
                    a++;
                    b++;
                }
                if (a == A.size()) {
                    finishedB = true;
                }
                if (b == B.size()) {
                    finishedA = true;
                }
            }
            if (finishedA) {
                for (int i = b; i < B.size(); i++) {
                    R.addexp(B.get_exp(i));
                    R.add(B.get(i));
                }
            } else {
                for (int i = a; i < A.size(); i++) {
                    R.addexp(A.get_exp(i));
                    R.add(A.get(i));
                }
            }
             arr = new int[R.size()][2];
            for (int i = 0; i < R.size(); i++) {
                arr[i][0] = (int) R.get(i);
                arr[i][1] = (int) R.get_exp(i);
            }
            return arr;
        }
		
		
		return null;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		int [][]sub;
		 if (poly1=='A'&&poly2=='B'||poly1=='B'&&poly2=='A')
	        sub=determine_polysub('A','B');
		 else if (poly1=='A'&&poly2=='C'||poly1=='C'&&poly2=='A')
		        sub=determine_polysub('A','C');
		 else if (poly1=='B'&&poly2=='C'||poly1=='C'&&poly2=='B')
		        sub=determine_polysub('B','C');
		 else if(poly1=='A'&&poly2=='A'||poly1=='B'&&poly2=='B'||poly1=='C'&&poly2=='C')
		 {
			 sub =new int [1][2];
			 sub[0][1]=0;
			 sub[1][1]=0;
			 
		 }
		 else
	        throw new RuntimeException("invalid input or operation");
		 
		return sub;
		
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		
		 clearPolynomial('R');
		 
	        double[] array = new double[10000000];
	 
	        if (poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A') {
	            
	            for (int a = 0; a < A.size(); a++) {
	                for (int b = 0; b < B.size(); b++) {
	                    array[(int) A.get_exp(a) + (int) A.get_exp(b)] = (double) A.get(a) * (double) B.get(b);
	                }
	                int[][] array1 = new int[R.size()][2];
	                for (int i = (int) A.get_exp(0) + (int) B.get_exp(0); i >= 0; i++) {
	                    array1[i][0] = (int) R.get(i);
	                    array1[i][1] = (int) R.get(i);
	                }
	                return array1;
	            }
	        } else if (poly1 == 'A' && poly2 == 'C' || poly1 == 'C' && poly2 == 'A') {
	            int a;
	            int c;
	            for (a = 0; a < A.size(); a++) {
	                for (c = 0; c < B.size(); c++) {
	                    array[(int) A.get_exp(a) + (int) A.get_exp(c)] = (double) A.get(a) * (double) B.get(c);
	                }
	                int[][] array1 = new int[R.size()][2];
	                for (int i = (int) A.get_exp(0) + (int) B.get_exp(0); i >= 0; i++) {
	                    array1[i][0] = (int) R.get(i);
	                    array1[i][1] = (int) R.get_exp(i);
	                }
	                return array1;
	            }
	        } else if (poly1 == 'B' && poly2 == 'C' || poly1 == 'C' && poly2 == 'B') {
	            int b;
	            int c;
	            for (b = 0; b < A.size(); b++) {
	                for (c = 0; c < B.size(); c++) {
	                    array[(int) A.get_exp(b) + (int) A.get_exp(c)] = (double) A.get(b) * (double) B.get(c);
	                }
	                int[][] array1 = new int[R.size()][2];
	                for (int i = (int) A.get_exp(0) + (int) B.get_exp(0); i >= 0; i++) {
	                    array1[i][0] = (int) R.get(i);
	                    array1[i][1] = (int) R.get_exp(i);
	                }
	                return array1;
	            }
	        }
	        throw new RuntimeException("invalid input or operation");
	    }
	}


