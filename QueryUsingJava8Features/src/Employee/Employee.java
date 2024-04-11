package Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}

	// main method

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// Q1 How many Males and Females

		Map<String, Long> maleFemale = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(maleFemale);

		// Q2 all Department names

		Map<String, Long> departmentName = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		System.out.println(departmentName);

		employeeList.stream().distinct().forEach(System.out::println);

		// Q3 Average Age of Male Female Employees

		Map<String, Double> avgAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

		System.out.println(avgAge);

		// Q4 Highest paid Employee

		List<Employee> salary = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.collect(Collectors.toList());

		System.out.println("salary : " + salary);

//		Optional<Employee> maxSalary = employeeList.stream()
//				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
//
//		System.out.println("Max Salary : " + maxSalary);

//		Q5 name of Employee who have joined after 2015

		List<String> joinedAfter2015 = employeeList.stream().filter(join -> join.getYearOfJoining() > 2015)
				.map(Employee::getName).collect(Collectors.toList());

		System.out.println("Emp Joined After 2015 : " + joinedAfter2015);

//		Q6 count the number of Employee in Each Department

		Map<String, Long> noOfEmpInEachDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));

		System.out.println("No Of Employee in Each Department : " + noOfEmpInEachDepartment);

//		Q7 Average Salary of Each Department

		Map<String, Double> avgSalaryOfEachDepartment = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("Average Salary of Each Department : " + avgSalaryOfEachDepartment);

//		Q8 get Details of Youngest Male Employee in Product Development department.

		Optional<Employee> youngestMaleEmployee = employeeList.stream()
				.filter(gender -> gender.getGender() == "Male" && gender.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Employee::getAge));

		System.out.println("Youngest Male Employee : " + youngestMaleEmployee);

//		Q9 Who has more experience

		Optional<Employee> maxExmperience = employeeList.stream()
				.min(Comparator.comparingInt(Employee::getYearOfJoining));

		System.out.println("Max Experience : " + maxExmperience);

//		Q10 How many Male & Female in sales and marketing department.

		Map<String, Long> maleAndFemale = employeeList.stream().filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println("maleAndFemale : " + maleAndFemale);

//		Q11 What is the Average Salary of Male and Female Employee

		Map<String, Double> avgSalary = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("Avg Salary of Male & Female Employee : " + avgSalary);

//		Q12 List of Employees in Each Department

		Map<String, List<Employee>> collect = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		for (Map.Entry<String, List<Employee>> entry : collect.entrySet()) {
			System.out.println("-----------------------------");
			System.out.println("Employee in " + entry.getKey());
			System.out.println("-----------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}

//		Q13 Average Salary and Total Salary of a Company

		DoubleSummaryStatistics salaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println("Avg Salary : " + salaryStatistics.getAverage());
		System.out.println("Total Salary : " + salaryStatistics.getSum());

	}

}
