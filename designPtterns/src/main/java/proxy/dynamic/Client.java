package proxy.dynamic;

public class Client {
	public static void main(String[] args) {
		// 创建一个目标对象
		ITeacherDao teacherDao = new TeacherDao();

		// 给目标对象创建代理对象
		ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(teacherDao).getProxyInstance();

		// pattern.proxy.dynamic.TeacherDao@2503dbd3
		System.out.println(proxyInstance);

		// 通过代理对象, 调用目标对象的方法
		proxyInstance.teach();
	}
}
