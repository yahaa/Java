package p1;

public class Course {
 private String courseName;
 private String []students;
 private int numberOfStudents;
 private int sizeOfCourse;
 
 
 public Course(String courseName,int sizeOfCourse){       //  build class
	 this.sizeOfCourse=sizeOfCourse;
	 students=new String[sizeOfCourse];
	 this.courseName=courseName;
	 this.numberOfStudents=0;
 }
 
 public String getCourseName(){           //    getCourseName
	 return courseName;
 }
 
 public void addStudents(String student){      //addStudents
	 if(numberOfStudents==sizeOfCourse){
		 System.out.println("the course if full can't add "+student+ "to this course");
	 }
	 else{
	 students[numberOfStudents]=student;
	 numberOfStudents++;
	 }
 }
 
 public void dropStudent(String student){      //dropStudent
	 int i;
	 for(i=0;i<numberOfStudents;i++){
		 if(students[i]==student)break;
	 }
	 if(i>=0&&i<numberOfStudents){
		 for(int j=i;j<numberOfStudents-1;j++){
			 students[j]=students[j+1];
		 }
		 numberOfStudents--;
	 }
	 else System.out.println(student+" is not in the course ");
 }
 
 
 public String[]getStudent(){        //get the students in this course
	 return students;
 }
 
 public int getNumberOfStudent(){         //get the total number of the course
	 return numberOfStudents;
 }
 
 //get the size of course
 public int getTheSizeOfCourse(){
	 return sizeOfCourse;
 }
}
