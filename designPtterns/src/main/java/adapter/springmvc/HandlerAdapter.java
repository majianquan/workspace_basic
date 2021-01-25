package adapter.springmvc;

public interface HandlerAdapter {
	public boolean supports(Object handler);
	public void handle(Object handler);
}

// 多种适配器类


class SimpleHandleAdapter implements HandlerAdapter {

	@Override
	public boolean supports(Object handler) {
		return (handler instanceof SimpleController);
	}

	@Override
	public void handle(Object handler) {
		((SimpleController) handler).doSimplerHandler();
	}
}


class HttpHandlerAdapter implements HandlerAdapter {

	public void handle(Object handler) {
		((HttpController) handler).doHttpHandler();
	}

	public boolean supports(Object handler) {
		return (handler instanceof HttpController);
	}

}

class AnnotationHandlerAdapter implements HandlerAdapter {

	public void handle(Object handler) {
		((AnnotationController) handler).doAnnotationHandler();
	}

	public boolean supports(Object handler) {

		return (handler instanceof AnnotationController);
	}

}