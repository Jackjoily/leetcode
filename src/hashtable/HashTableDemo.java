package hashtable;

import java.util.Scanner;

public class HashTableDemo {

	public static void main(String[] args) {

		// 创建一个hash表
		HashTab hashTab = new HashTab(7);
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("add :添加雇员");
			System.out.println("list :显示雇员");
			System.out.println("find :查找雇员");
			System.out.println("del :删除雇员");
			System.out.println("exit :退出系统");
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("请输入Id");
				int id = scanner.nextInt();
				System.out.println("请输入名字");
				String name = scanner.next();
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("请输入Id");
				id = scanner.nextInt();
				hashTab.find(id);
				break;
			case "del":
				System.out.println("请输入Id");
				id = scanner.nextInt();
				hashTab.delEmp(id);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
				break;
			default:
				break;
			}
		}

	}

}

//创建HashTable
class HashTab {
	private EmpLinkedList[] empLinkedLists;
	private int size;

	// 构造器
	public HashTab(int size) {
		// 初始化
		this.size = size;
		empLinkedLists = new EmpLinkedList[size];
		for (int i = 0; i < size; i++) {
			empLinkedLists[i] = new EmpLinkedList();
		}
	}

	// 添加雇员

	public void add(Emp emp) {
		// 根据员工的id，得到员工应该添加的员工列表
		int empListNo = hashFun(emp.id);
		empLinkedLists[empListNo].add(emp);
	}

	// 遍历所有的链表

	public void list() {
		for (int i = 0; i < size; i++) {
			empLinkedLists[i].list(i);
			// 分别初始化每一个链表
		}
	}

	public int hashFun(int id) {
		return id % size;
	}

	public Emp find(int id) {
		int num = id % size;
		System.out.println(empLinkedLists[num].findEmpById(id));
		return empLinkedLists[num].findEmpById(id);
	}

	public void delEmp(int id) {
		int num = id % size;
		empLinkedLists[num].delEmpById(id);
	}

}

class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}

}

//创建EmployeeLinkedList

class EmpLinkedList {
	// 头指针，执行第一个Emp,因此我们这个链表的head是直接指向第一个雇员的
	private Emp head;

	// 添加员工
	// 假定添加员工，id是自增长的，即id的分配总是从小到大
	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}
		// 如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
		Emp curEmp = head;
		while (true) {
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;// 后移
		}
		curEmp.next = emp;
	}

	// 遍历链表的员工信息
	public void list(int no) {
		if (head == null) {
			System.out.println("第" + (no + 1) + "条链表为空");
			return;
		}
		System.out.println("第" + (no + 1) + "条链表为");
		Emp curEmp = head;// 辅助指针
		while (true) {
			System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		System.out.println();
	}

	public void delEmpById(int id) {
		if (head == null) {
			System.out.println("链表为空");
			return ;
		}
		Emp curEmp = head;
		if (curEmp.id == id) {
			head = head.next;
		} else {
			while (curEmp.next != null) {
				if (curEmp.next.id == id) {
					curEmp.next = curEmp.next.next;
				}
			}
		}
		System.out.println("删除成功");
	}

	public Emp findEmpById(int id) {
		if (head == null) {
			System.out.println("链表为空");
			return null;
		}
		Emp curEmp = head;
		while (true) {
			if (curEmp.id == id) {
				break;
			}
			if (curEmp.next == null) {
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;
		}
		return curEmp;
	}

}
