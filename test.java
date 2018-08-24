import java.util.Scanner;

class Assignment{

	private String id;
	private int marks;

	Assignment(String id,int marks){
		this.id=id;
		this.marks=marks;
	}

	public String getId(){
		return this.id;
	}

	public String geMarks(){
		return this.marks;
	}
}

class Student{

	private String name,roll;
	private Assignment[] assign;
	private int index=0;

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

	public int getIndex(){
		return this.index;
	}

	public void setIndex(int idx){
		this.index=idx;
	}

	public Assignment[] getArray(){
		return this.assign;
	}

	public void assignArraySize(int k){
		this.assign=new Assignment[k];
	}
}

class List{

	private int p,q;
	Student student[];

	List(int numSt){
		student=new Student[numSt];
		p=0;
	}

	public void addStudent(String name,String roll,int k){
		student[p]=new Student(name,roll);
		student[p].assignArraySize(k);
		p++;
	}


	public void selectionSort(int n)
	{
		int i,j;

		for(i=0;i<n-1;i++)
		{
			int iMin=i;

			for(j=i+1;j<n;j++)
			{
				if(student[j].getRoll().compareTo(student[iMin].getRoll() ) < 0)
					iMin=j;
			}

			if(iMin!=i){
				Student temp=student[i];
				student[i]=student[iMin];
				student[iMin]=temp;
			}
		}
	}

	public Student findByRoll(int n,String roll){
		Student temp=null;
		for(int i=0;i<n;i++){
			if(a[i].roll.compareTo(roll) == 0){
				temp=a[i];
			}
		}

		return temp;
	}

	public void assignMarks(String roll,int marks,int n){
		Student temp=findByRoll(n,roll);
		Assignment[] arr=temp.getArray();
		arr[temp.getIndex()]=new Assignment(roll,marks);
		temp.setIndex(temp.getIndex()++);
		
	}


	public void print(int n){
		for(int i=0;i<n;i++){
			System.out.print(student[i].getRoll()+" "+student[i].getName());
			int sum=0;
			Assignemt[] arr=student[i].getArray();

			for(int j=0;j<k;j++){
				if(arr[j]==null)
					break;

				sum+=arr[j].marks;

				if(j==0){
					System.out.print(" "+arr[j].getMarks()+" "+arr[j].getId());
				}

				System.out.print(" + "+arr[j].getMarks()+" "+arr[j].getId());
			}

			System.out.print(" = "+sum);
			System.out.println("");	
		}
	}	

}

class Main{

	public static void main(String []args){

	 Scanner s=new Scanner(System.in);
	 int t=s.nextInt();

	 while(t-- > 0){

	 	int n=s.nextInt();
	 	int k=s.nextInt();
	 	String roll,name;
	 	List list=new List(n);


		for(int i=0;i<n;i++){
			roll=s.next();
			name=s.next();

			list.addStudent(roll,name,k);
		}

		list.selectionSort(n);

		for(int i=0;i<k;i++){
			
			String id=s.next();
			int num=s.nextInt();

			for(int j=0;j<num;j++)
			{
				String roll=s.next();
				int marks=s.nextInt();
				list.assignMarks(roll,marks,n);
			}

		}

		list.print(n);
	 }

	}
}


