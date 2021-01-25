package proxy.static_proxy;

public class TeacherDaoProxy implements ITeacherDao{
	private TeacherDao teacherDao;

	public TeacherDaoProxy(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public void teach() {
		System.out.println("开始代理....");
		teacherDao.teach();
		System.out.println("结束代理....");
	}
}
