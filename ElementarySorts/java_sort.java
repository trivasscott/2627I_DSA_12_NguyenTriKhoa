import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
    public boolean isLessThan(Student other) {
        if (cgpa != other.cgpa) {
            return cgpa > other.cgpa;
        }
        if (fname != other.fname) {
            return fname.compareTo(other.fname) < 0;
        }
        return id < other.id;
    }
}

//Complete the code
public class java_sort
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
        int n = studentList.size();
        while (true) {
            boolean isSorted = true;
            for (int i = 0; i < n - 1; ++i) {
                if (studentList.get(i + 1).isLessThan(studentList.get(i))) {
                    isSorted = false;
                    Collections.swap(studentList, i, i + 1);
                }
            }
            if (isSorted) {
                break;
            }
        }
        
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}

		in.close();
	}
}



