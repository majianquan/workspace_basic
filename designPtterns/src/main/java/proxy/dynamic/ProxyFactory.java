package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	// 维护一个目标对象
	private Object target;

	public ProxyFactory(Object object) {
		this.target = object;
	}
	// 给目标对象生成一个代理对象
	/*	public static Object newProxyInstance(ClassLoader loader,
										  Class<?>[] interfaces,
										  InvocationHandler h)
		1. ClassLoader loader 	 指定当前目标对象使用的类加载器
		2. Class<?>[] interfaces 目标对象实现的接口类型,使用泛型方式确认类型
		3. InvocationHandler h   事情处理,执行目标对象的方法是,会触发事情处理器的方法
								 ,会把当前的执行的目标对象方法作为参数传入
	*/
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("jdk代理开始...");

				// 反射机制调用目标对象的方法
				Object returnVal = method.invoke(target, args);
				return returnVal;
			}
		});
	}
}
