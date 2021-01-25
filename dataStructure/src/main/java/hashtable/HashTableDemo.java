package hashtable;

// 演示散列表
public class HashTableDemo {
}

class HashTable {
	private int size;
	private EmployeeLinkedList[] empLinkedListArray;

	public HashTable(int size) {
		this.size = size;
		empLinkedListArray = new EmployeeLinkedList[size];
		// 初始化链表
		for (int i = 0; i < this.size; i++) {
			empLinkedListArray[i] = new EmployeeLinkedList();
		}
	}
	// 增加雇员
	public void add(Employee emp){
		int empHashNO = hashFun(emp.id);
		empLinkedListArray[empHashNO].add(emp);
	}
	// 删除雇员
	public void delete(Employee emp) {
		int empHashNO = hashFun(emp.id);
		empLinkedListArray[empHashNO].delete(emp);
	}
	// 更新雇员
	public void update(Employee emp) {
		int empHashNO = hashFun(emp.id);
		empLinkedListArray[empHashNO].update(emp);
	}
	// 遍历所有雇员
	public void list() {
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i].list(i);
		}
	}
	// 编写散列函数,取模法
	public int hashFun(int id) {
		return id % size;
	}
}

class Employee {
	public int id;
	public String name;
	public Employee next;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

// 创建EmployeeLinkedList
class EmployeeLinkedList {
	// 头指针,指向第一个雇员
	public Employee head;

	// 增加雇员
	public void add(Employee emp) {
		// 如果是添加第一个雇员
		if (head != null) {
			head = emp;
			return;
		}
		// 创建一个指针找到链表最后一个元素
		Employee curEmp = head;
		while (true) {
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		curEmp.next = emp;
	}

	// 遍历链表的雇员信息
	public void list(int i) {
		if (head == null) {
			System.out.println("当前链表为空");
			return;
		}
		System.out.println("当前链表的信息为:");
		Employee curEmp = head;
		while (true) {
			System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}

	}

	// 删除雇员
	public void delete(Employee emp) {
		if (head == null) {
			System.out.println("当前链表为空...");
			return;
		}
		if (head.id == emp.id) {
			head = null;
			return;
		}
		Employee curEmp = head;
		Employee preEmp = null;
		while (true) {
			if (curEmp.id == emp.id) {
				preEmp.next = curEmp.next;
				break;
			}
			preEmp = curEmp;
			curEmp = curEmp.next;
		}
	}
	// 查找雇员

	// 更新雇员
	public void update(Employee emp) {
		if(head == null) {
			System.out.println("当前链表为空...");
			return;
		}
		if(head.id == emp.id) {
			head.name = emp.name;
			return;
		}
		Employee curEmp = head;

		while (true) {
			if (curEmp.id == emp.id) {
				curEmp.name = emp.name;
				break;
			}
			curEmp = curEmp.next;
		}
	}
}