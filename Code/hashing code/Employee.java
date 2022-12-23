package for_DSA;

class Employee {
	int empno;
	String ename;
	float sal;
	int age;
	public Employee(int empno, String ename, float sal, int age) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.age = age;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
