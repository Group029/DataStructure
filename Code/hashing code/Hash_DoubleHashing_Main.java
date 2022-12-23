package for_DSA;

import java.util.Scanner;

class Hash_DoubleHashing{
	Record table[];
	
	public Hash_DoubleHashing()
	{
		table = new Record[10];
		for(int i=0;i<10;i++)
		{
			table[i] = new Record();
			table[i].status = type_of_record.EMPTY;
		}
			
		
		for(int i=0;i<10;i++)
			System.out.print(table[i].status);
	}
	public Hash_DoubleHashing(int size)
	{
		table = new Record[size];
		for(int i=0;i<size;i++)
			table[i].status = type_of_record.EMPTY;
	}
	
	public void insert(Employee emprec)
	{
		int i, location, h,h1;
		
		int key = emprec.getEmpno();	/*Extract key from the record*/
		h = hash(key);				
		
		location = h;	
		h1 = hash1(key);

		for( i=1; i<=9; i++ )
		{
			if(table[location].status == type_of_record.EMPTY || table[location].status == type_of_record.DELETED)
			{
				table[location].info = emprec;
				table[location].status = type_of_record.OCCUPIED;	
				System.out.print("Record inserted\n\n");
				return;
			}
			if(table[location].info.getEmpno() == key)
			{
				System.out.print("Duplicate key\n\n");
				return;
			}
			location = (h+i*h1)%10;				
		}
		System.out.print("Record can't be inserted : Table overFlow\n\n");
	}
	int search(int key)
	{
		int i, h, location;
	    h = hash(key);				

		location = h;
		for( i=1; i<=9; i++ )
		{
			if( table[location].status == type_of_record.EMPTY  ) 
				return -1;
			if( table[location].info.getEmpno() == key)
				return location;
			location = ( h + i ) % 10;								
		}
		return -1;
	}
	public void del(int key)
	{
		int location = search(key);
		if(location == -1)
			System.out.print("Key not found\n");
		else
			table[location].status = type_of_record.DELETED;
	}/*End of del()*/
	public int hash(int key) 
	{
		return (key%10);	
	}
	
	public int hash1(int key)
	{
		return (7-key%7);
	}
	public void display()
	{
		int i;
		for(i=0; i<10; i++)
		{
			System.out.print("   "+i );
			if(table[i].status== type_of_record.OCCUPIED) 
			{
				System.out.print("Occupied "+table[i].info.getEmpno()+"  " +table[i].info.getEname());
				
				System.out.print("   "+ table[i].info.age);
			}
			else if(table[i].status== type_of_record.DELETED)
				System.out.print("Deleted\n");
			else
				System.out.print("Empty\n");
	}
  }
}

public class Hash_DoubleHashing_Main {

	public static void main(String[] args) {
		Employee e;
		int eno,age;
		String name;
		float s;
		int i;
		Scanner sc=new Scanner(System.in);
		Hash_DoubleHashing hl = new Hash_DoubleHashing();
		for(i=0;i<5;i++)
		{
			System.out.println("\n Enter empno name salary age of employee: ");
			eno=sc.nextInt();
			name = sc.next();
			age=sc.nextInt();
			s=sc.nextFloat();
			e = new Employee(eno,name,s,age);
			hl.insert(e);
		}
		hl.display();
		System.out.println("search for key ="+hl.search(9889));
		
		hl.del(9889);
		hl.display();
		hl.insert(new Employee(9889,"Palu",56000f,56));
		System.out.println("\n\n");
		hl.display();
        sc.close();
	}

}
