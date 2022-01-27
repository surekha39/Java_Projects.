class EmpInfo{
	static int id;
	static String name;
	public static void main(String[] args) {

	System.out.println(id+" "+name);
	}
	public void display() {
		// TODO Auto-generated method stub
		
	}
}

public class constructorDemo {

public static void main(String[] args) {

	EmpInfo emp1=new EmpInfo();
	EmpInfo emp2=new EmpInfo();

	emp1.display();
	emp2.display();
	}
}

//parameterized constructor
class Std{
	int id;
	String name;

	Std(int i,String n)
	{
	id=i;
	name=n;
	}

	void display() {
	System.out.println(id+" "+name);
	}

 
public static void main(String[] args) {

	Std std1=new Std(2,"Alex");
	Std std2=new Std(10,"Annie");
	std1.display();
	std2.display();
		}
}


