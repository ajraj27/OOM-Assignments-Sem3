import java.util.Scanner;

class Ta{

	private String name,roll;

	Ta(String roll,String name){
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

class Student{

	private String name,roll;
	private int index=-1;

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
}

class List{

	private int p,q;
	Student student[];
	Ta ta[];
	List(int numTa,int numSt){
		student=new Student[numSt];
		ta=new Ta[numTa];
		p=0;
		q=0;
	}

	public void addStudent(String name,String roll){
		student[p]=new Student(name,roll);
		p++;
	}

	public void addTa(String name,String roll){
		ta[q]=new Ta(name,roll);
		q++;
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

	public void allotment(int n,int numTa,int k){
		int num=0;
		int j;

		for(int i=0;i<numTa-1;i++){

			if(num<n){
				for(j=num;j<k+num;j++){
					if(j<n)
						student[j].setIndex(i);
					else
						break;

				}

			num=j;

			}

			else
				break;

			
	 	}

	 	for(j=num;j<n;j++)
	 		student[j].setIndex(numTa-1);
	
	}

	public void print(int n,int numTa){
		int idx=0;
		for(int i=0;i<n;i++){
			if(student[i].getIndex()!=-1){
				idx=student[i].getIndex();
				System.out.println(student[i].getRoll() +" "+student[i].getName()+" "+ta[idx].getRoll()+" "+ta[idx].getName());
			}

	 	}

	 	String temp="";
	 	for(int i=0;i<n;i++){
			idx=student[i].getIndex();
			if(temp!=ta[idx].getName()){
				System.out.println(ta[idx].getRoll() + " " + ta[idx].getName());
				temp=ta[idx].getName();
			}

		System.out.println(student[i].getRoll() + " " + student[i].getName());

		}

		for(int i=idx+1;i<numTa;i++){
			System.out.println(ta[i].getRoll() + " " + ta[i].getName());
		}
	}	

}

class Main{

	public static void main(String []args){

	 Scanner s=new Scanner(System.in);
	 int t=s.nextInt();

	 while(t-- > 0){

	 	int numTa=s.nextInt();
	 	int n=s.nextInt();
	 	int k=s.nextInt();
	 	String roll,name;
	 	List list=new List(numTa,n);

	 	for(int i=0;i<numTa;i++){
			roll=s.next();
			name=s.next();

			list.addTa(roll,name);
		}

		for(int i=0;i<n;i++){
			roll=s.next();
			name=s.next();

			list.addStudent(roll,name);
		}

		list.selectionSort(n);
		list.allotment(n,numTa,k);
		list.print(n,numTa);
	 }

	}
}


