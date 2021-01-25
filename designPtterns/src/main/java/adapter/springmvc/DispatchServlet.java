package adapter.springmvc;

import java.util.ArrayList;
import java.util.List;

public class DispatchServlet {
	public static List<HandlerAdapter> handlerAdapterList = new ArrayList<>();
	public DispatchServlet() {
		handlerAdapterList.add(new HttpHandlerAdapter());
		handlerAdapterList.add(new AnnotationHandlerAdapter());
		handlerAdapterList.add(new SimpleHandleAdapter());
	}

	public static void main(String[] args) {
		new DispatchServlet().doDispatch();
	}

	private void doDispatch() {
		// 此处模拟SpringMVC从request取handler的对象，
		// 适配器可以获取到希望的Controller
		HttpController controller = new HttpController();
		// AnnotationController controller = new AnnotationController();
		//SimpleController controller = new SimpleController();
		HandlerAdapter handler = getHandler(controller);
		// 通过适配器执行对应的controller对应方法
		handler.handle(controller);
	}

	private HandlerAdapter getHandler(HttpController controller) {
		//遍历：根据得到的controller(handler), 返回对应适配器
		for (HandlerAdapter adapter : handlerAdapterList) {
			if(adapter.supports(controller)) {
				return adapter;
			}
		}
		return null;
	}
}
