import java.util.Scanner;


class Student{

	private String name,roll;

	Student(String roll,String name){
		this.name=name;
		this.roll=roll;
	}

	public String getName(){
		return this.name;
	}

	public String getRoll(){
		return this.roll;
	}

}

class List{

	private int p,q;
	Student student[];
	List(int numSt){
		student=new Student[numSt];
		p=0;
	}

	public void addStudent(String name,String roll){
		student[p]=new Student(name,roll);
		p++;
	}

	public void print(int n){
		for(int i=0;i<n;i++)
				System.out.println(student[i].getRoll() +" "+student[i].getName());
	}	

}

class Main{

	public static void main(String []args){

	 Scanner s=new Scanner(System.in);

	 	int n=s.nextInt();
	 	String roll,name;

	 	List list=new List(n);

		for(int i=0;i<n;i++){
			roll=s.next();
			name=s.next();

			list.addStudent(roll,name);
		}

		list.print(n);

	}
}


